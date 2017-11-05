package com.jeyni.controller;

import java.net.HttpURLConnection;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotBlank;

import com.google.gson.Gson;
import com.jeyni.bean.Car;
import com.jeyni.dao.CarDaoService;
import com.jeyni.process.CarProcess;
import com.jeyni.view.CarView;
import com.jeyni.view.ListCarView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/car")
@Api(value = "/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController {

	private static final Logger LOGGER = Logger.getLogger(CarController.class);
	
	@POST
	@Path("/create")
	@ApiOperation(value = "create a car")
	@ApiResponses(value = { @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "car created"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "internal error") })
	public Response carCreate(
			@ApiParam(value = "The JSON object which describe a car", required = true) @NotNull Car car) {
		Gson gson = new Gson();
		LOGGER.info(car.toString());
		try {
			CarDaoService.create(car);
		} catch (Exception e) {
			LOGGER.error(e);
			return Response.status(500).entity(gson.toJson("Unable to create car")).build();
		}
		return Response.status(200).entity(gson.toJson(car.getIdNumber())).build();
	}

	@GET
	@Path("/get/{idNumber}")
	public Response carGet(@NotBlank @PathParam("idNumber") String idNumber) {
		Gson gson = new Gson();
		CarView carView = new CarView();
		Car car = null;
		try {
			LOGGER.info("ID NUMBER RECEIVED: " + idNumber);
			car = CarDaoService.read(idNumber).get(0);
		} catch (Exception e) {
			LOGGER.error(e);
			return Response.status(400).entity(gson.toJson("no car found")).build();
		}
		return Response.status(200).entity(gson.toJson(carView.fromCar(car))).build();
	}

	@DELETE
	@Path("/delete/{idNumber}")
	public Response carDelete(@NotBlank @PathParam("idNumber") String idNumber) {
		Gson gson = new Gson();
		String carIdDelete = null;
		try {
			LOGGER.info("ID NUMBER RECEIVED: " + idNumber);
			if (CarDaoService.delete(idNumber)) {
				carIdDelete = idNumber;
			} else {
				throw new Exception("No car found to delete");
			}
		} catch (Exception e) {
			LOGGER.error(e);
			return Response.status(400).entity(gson.toJson("no car found to delete")).build();
		}
		return Response.status(200).entity(gson.toJson(carIdDelete)).build();
	}

	@GET
	@Path("/")
	public Response carsGet() {
		Gson gson = new Gson();
		ListCarView listCarView = new ListCarView();
		List<Car> listCar;
		try {
			listCar = CarDaoService.read();
		} catch (Exception e) {
			LOGGER.error(e);
			return Response.status(400).entity(gson.toJson("no cars found")).build();
		}
		return Response.status(200).entity(gson.toJson(listCarView.fromCarList(listCar))).build();
	}
	
	@PUT
	@Path("/update")
	@ApiOperation(value = "create a car", notes = "a note")
	@ApiResponses(value = { @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "car created"),
			@ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "internal error") })
	public Response carUpdate(
			@ApiParam(value = "The JSON object which describe a car", required = true) @NotNull Car car) {
		Gson gson = new Gson();
		LOGGER.info(car.toString());
		try {
			CarProcess.create(car);
		} catch (Exception e) {
			LOGGER.error(e);
			return Response.status(500).entity(gson.toJson("Unable to create car")).build();
		}
		return Response.status(200).entity(gson.toJson(car.getIdNumber())).build();
	}

}
