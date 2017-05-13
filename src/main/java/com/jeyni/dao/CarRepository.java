package com.jeyni.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyni.bean.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
    Car find(String id);

}
