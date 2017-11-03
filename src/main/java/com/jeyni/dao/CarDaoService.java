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

	public static List<Car> read(String idNumber) {
		final List<Car> list = new LinkedList<>();
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		Query<Car> query = session.createQuery(SqlQuery);
		query.setParameter(idNumberString, idNumber);
		for (final Object o : query.list()) {
			list.add((Car) o);
		}
		session.close();
		LOGGER.info("car read: " + list.toString());
		return list;
	}

	public static List<Car> read() {
		final List<Car> list = new LinkedList<>();
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		Query<Car> query = session.createQuery("from Car");
		for (final Object o : query.list()) {
			list.add((Car) o);
		}
		session.close();
		LOGGER.info("cars read: " + list.toString());
		return list;
	}

	public static void update(String idNumber) {
		final List<Car> list = new LinkedList<>();
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		Query<Car> query = session.createQuery(SqlQuery);
		query.setParameter(idNumberString, idNumber);
		Transaction trans = session.beginTransaction();
		for (final Object o : query.list()) {
			list.add((Car) o);
			session.update((Car) o);
		}
		trans.commit();
		session.close();
		LOGGER.info("car updated: " + list.toString());
	}

	public static boolean delete(String idNumber) {
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		Query<Car> query = session.createQuery("delete Car where idNumber = :idNumber");
		query.setParameter(idNumberString, idNumber);
		Transaction trans = session.beginTransaction();
		boolean isDeleted = false;
		if (query.executeUpdate() > 0) {
			isDeleted = true;
			LOGGER.info("Car with idNumber: " + idNumber + " is deleted");
		}
		trans.commit();
		session.close();
		return isDeleted;
	}

}
