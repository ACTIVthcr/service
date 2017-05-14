package com.jeyni.main;

import org.apache.log4j.Logger;

import com.jeyni.bean.Car;
import com.jeyni.dao.CarDaoService;
import com.jeyni.rest.CarService;

public class MainCar {
    
    private static final Logger LOGGER = Logger.getLogger(CarService.class);

    private MainCar() {
    };
    
    public static void main(String[] args) {
	Car car = Car.builder().name("test1").ownerName("ownertest").build();
	String UUIDCar = CarDaoService.create(car);
	LOGGER.info(CarDaoService.read(UUIDCar));
	LOGGER.info(CarDaoService.delete(UUIDCar));
    }

}
