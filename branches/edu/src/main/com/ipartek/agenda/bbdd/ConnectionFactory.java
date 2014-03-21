package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ipartek.agenda.interfaces.IAmigable;
/**
 * 
 * @author Eduardo Monterrubio
 *Clase que define el patron factoria a la conexion de la BD Agenda
 */
public class ConnectionFactory {
	private static Connection conn = null;

	private static final String DB_NAME = "agenda"; //nombre base de datos
	static final String URL_CONEXION = "jdbc:mysql://localhost:3306/" + DB_NAME ; //String conexion
	static final String DRIVER = "com.mysql.jdbc.Driver"; //Driver 
	static final String USER = "root"; //user
	static final String PASS = "root";//password

	private static ConnectionFactory connectionFactory = null;

	/**
	 * Constructor privado para poder crear patron Singleton
	 */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtener una instancia de la clase, siguiendo el patron singleton
	 * 
	 * @return conexion a la bbdd
	 */
	public static ConnectionFactory getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

	/**
	 * Obtener conexion a la BBDD
	 * 
	 * @return conexion abierta
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection(URL_CONEXION, USER, PASS);
		}
		return conn;
	}

	/**
	 * Cerrar conexion
	 * 
	 * @return
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}

	}

	/**
	 * Obtener el DAO para manipular Amigos, soporta todas las operaciones CRUD
	 * 
	 * @return
	 */
	public IAmigable getDAOAmigo() {
		return new DAOAmigo();
	}



}
