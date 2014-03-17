package com.ipartek.agenda.listeners;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ipartek.agenda.database.ConnectionFactory;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
