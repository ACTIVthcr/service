package com.jeyni.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.jeyni.bean.Car;
import com.jeyni.dao.CarDaoService;

@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarService {

    @POST
    @Path("/create")
    public Response carCreate(Car car) {
	System.out.println(car);
	CarDaoService carDao = new CarDaoService();
	carDao.create(car);
	return Response.status(200).entity(car.getId()).build();
    }
    
    @GET
    @Path("/get")
    public Response carGet() {
	Gson gson = new Gson();
	System.out.println("call rest car");
	Car car = Car.builder().id("1").name("carTest").ownerName("carOwnerTest").seatNumber(3).build();
	return Response.status(200).entity(gson.toJson(car)).build();
    }

}
