package com.jeyni.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private HibernateUtils() {
	}

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			throw new RuntimeException("Pb config: " + e.getMessage());
		}
	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
