package com.jeyni.view;

import com.jeyni.bean.Car;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
public class CarView {

	@Setter
	private int numberOfSeats;
	@Setter
	private String carOwnerName;
	@Setter
	private String name;
	@Setter
	private String idNumber;

	public CarView fromCar(Car car) {
		return CarView.builder().numberOfSeats(car.getSeatNumber()).carOwnerName(car.getOwnerName()).name(car.getName())
				.idNumber(car.getIdNumber()).build();
	}

}
