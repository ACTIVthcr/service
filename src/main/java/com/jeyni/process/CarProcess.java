package com.jeyni.process;

import java.util.List;

import com.jeyni.bean.Car;
import com.jeyni.service.CarService;

public class CarProcess {

	public static String create(Car car) {
		return CarService.create(car);
	}
	
}
