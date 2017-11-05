package com.jeyni.service;

import java.util.List;

import com.jeyni.bean.Car;
import com.jeyni.dao.CarDaoService;

public class CarService {
	
	public static String create (Car car) {
		return CarDaoService.create(car);
	}
	
	public static Car read(String idNumber) {
		return CarDaoService.read(idNumber);
	}
	
	public static List<Car> read() {
		return CarDaoService.read();
	}
	
	public static void update(String idNumber, Car car) {
		CarDaoService.update(idNumber, car);
	}
	
	public static boolean delete(String idNumber) {
		return CarDaoService.delete(idNumber);
	}
	
}
