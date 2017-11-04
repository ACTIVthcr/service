package com.jeyni.process;

import com.jeyni.bean.Car;
import com.jeyni.service.CarService;

public class CarProcess {

	public static String create(Car car) {
		return CarService.create(car);
	}
	
	public static Boolean delete(String idNumber) {
		return CarService.delete(idNumber);
	}
	
	public static void update(String idNumber, Car car) {
		CarService.update(idNumber, car);
	}
	
	public static Car readOne(String idNumber) {
		return CarService.read(idNumber).get(0);
	}
	
	public static void changeOwner(String idNumber, String ownerName) {
		Car car = CarService.read(idNumber).get(0);
		car.setOwnerName(ownerName);
		CarService.update(idNumber, car);
	}
	
}
