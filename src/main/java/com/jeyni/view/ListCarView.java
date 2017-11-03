package com.jeyni.view;

import java.util.ArrayList;
import java.util.List;

import com.jeyni.bean.Car;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListCarView {

	List<CarView> carViewList;

	public ListCarView() {
		carViewList = new ArrayList<>();
	}

	public List<CarView> fromCarList(List<Car> listCar) {
		for (Car car : listCar) {
			CarView carView = new CarView();
			carViewList.add(carView.fromCar(car));
		}
		return carViewList;
	}

}
