package com.jeyni.dao;

import org.hibernate.query.Query;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jeyni.bean.Car;

public class CarDaoService {

	private CarDaoService() {
	}

	private static final Logger LOGGER = Logger.getLogger(CarDaoService.class);

	private static final String SqlQuery = "from Car where idNumber = :idNumber";

	private static final String idNumberString = "idNumber";

	public static String create(Car car) {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		car.setIdNumber(UUID.randomUUID().toString());
		session.save(car);
		trans.commit();
		session.close();
		LOGGER.info("idNumber created: " + car.getIdNumber());
		return car.getIdNumber();
	}

	public static Car read(String idNumber) {
		final List<Car> list = new LinkedList<>();
		Session session = HibernateUtils.getSession();
		Query<?> query = session.createQuery(SqlQuery);
		query.setParameter(idNumberString, idNumber);
		for (final Object o : query.list()) {
			list.add((Car) o);
		}
		if (list.size() > 1) {
			throw new IllegalStateException("not unique id");
		}
		session.close();
		LOGGER.info("car read: " + list.get(0).toString());
		return list.get(0);
	}

	public static List<Car> read() {
		final List<Car> list = new LinkedList<>();
		Session session = HibernateUtils.getSession();
		Query<?> query = session.createQuery("from Car");
		for (final Object o : query.list()) {
			list.add((Car) o);
		}
		session.close();
		LOGGER.info("cars read: " + list.toString());
		return list;
	}

	public static void update(String idNumber, Car car) {
		Car carToUpdate = CarDaoService.read(idNumber);
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		carToUpdate.setIdNumber(car.getIdNumber());
		carToUpdate.setName(car.getName());
		carToUpdate.setOwnerName(car.getOwnerName());
		carToUpdate.setSeatNumber(car.getSeatNumber());
		session.merge(carToUpdate);
		trans.commit();
		session.close();
		LOGGER.info("car updated: " + carToUpdate);
	}

	public static void delete(String idNumber) {
		Session session = HibernateUtils.getSession();
		Car car = CarDaoService.read(idNumber);
		Transaction trans = session.beginTransaction();
		session.delete(car);
		trans.commit();
		LOGGER.info("Car with idNumber: " + car.getIdNumber() + " is deleted");
		session.close();
	}

}
