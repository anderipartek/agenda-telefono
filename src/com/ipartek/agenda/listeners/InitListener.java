package com.ipartek.agenda.listeners;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.database.ConnectionFactory;
import com.ipartek.agenda.hibernate.HibernateUtil;

/**
 * Application Lifecycle Listener implementation class InitListener
 * 
 * Se encarga de inicializar y cerrar la conexion
 * 
 */
public class InitListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public InitListener() {
	}

	/**
	 * Inicializamos la conexion
	 * 
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {

		try {
			ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			HibernateUtil.getSession();
			// session.beginTransaction();
			// // saving objects to session
			// session.save(new Amigo());
			// session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PropertyConfigurator.configure("./config/log4j.properties");
	}

	/**
	 * Cerramos la conexion
	 * 
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			ConnectionFactory.getInstance().closeConnection();
			HibernateUtil.getSession().close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("no se pudo cerrar la conexion de hibernate");
		}
	}
}
