package com.jeyni.dao;

import com.jeyni.bean.Car;

public class CarDaoService {
    
    CarRepository carRepository;

    public String create(Car car) {
	return car.getId();
    }

    public Car read(String id) {
	return carRepository.find(id);
    }

    public Car update(Car car) {
	return null;
    }

    public void delete(Car car) {
	
    }

}
