package com.ipartek.agenda.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Clase de utilidad para obtener la sesión de hibernate.
 * 
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			// Log exception!
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() throws HibernateException {
		if (sessionFactory.isClosed()) {
			return sessionFactory.openSession();
		}
		return sessionFactory.getCurrentSession();
	}
}
