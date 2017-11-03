package com.jeyni.main;

import org.apache.log4j.Logger;

import com.jeyni.bean.Car;
import com.jeyni.controller.CarApi;
import com.jeyni.dao.CarDaoService;

public class MainCar {

	private static final Logger LOGGER = Logger.getLogger(CarApi.class);

	private MainCar() {
	};

	public static void main(String[] args) {
		Car car = Car.builder().name("test1").ownerName("ownertest").build();
		String UUIDCar = CarDaoService.create(car);
		LOGGER.info(CarDaoService.read(UUIDCar));
		LOGGER.info(CarDaoService.read());
		LOGGER.info(CarDaoService.delete(UUIDCar));
	}

}
