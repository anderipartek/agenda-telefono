package com.ipartek.agenda.listeners;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.database.ConnectionFactory;

/**
 * Application Lifecycle Listener implementation class InitListener.
 * 
 * Se encarga de inicializar y cerrar la conexion
 * 
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 */
public class InitListener implements ServletContextListener {


	/**
	 * Inicializamos la conexion.
	 * 
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 * @param sce ServletContextEvent
	 */
	@Override
	public final void contextInitialized(final ServletContextEvent sce) {
		try {
			ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cerramos la conexion.
	 * 
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 * @param sce ServletContextEvent
	 */
	@Override
	public final void contextDestroyed(final ServletContextEvent sce) {
		try {
			ConnectionFactory.getInstance().closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
