package com.jeyni.main;

import org.apache.log4j.Logger;

import com.jeyni.bean.Car;
import com.jeyni.controller.CarController;
import com.jeyni.dao.CarDaoService;

public class MainCar {

	private static final Logger LOGGER = Logger.getLogger(CarController.class);

	private MainCar() {
	};

	public static void main(String[] args) {
		LOGGER.info(CarDaoService.read());
//		CarDaoService.delete("bde62af4-d29e-474b-85db-7e0944c7ebef");
	}

}
