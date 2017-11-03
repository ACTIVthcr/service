package com.jeyni.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jeyni.view.CarView;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table
@Getter
@ToString
@Builder
public class Car {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	@Setter
	private String name;
	@Column
	@Setter
	private String ownerName;
	@Column
	@Setter
	private int seatNumber;
	@Column
	@Setter
	private String idNumber;

	public Car fromCarView(CarView carView) {
		return Car.builder().name(carView.getName()).ownerName(carView.getCarOwnerName())
				.seatNumber(carView.getNumberOfSeats()).idNumber(carView.getIdNumber()).build();
	}

}
