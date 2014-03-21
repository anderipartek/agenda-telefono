package com.ipartek.agenda.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ipartek.agenda.database.interfaces.IDAOAmigo;

/**
 * 
 * @author Ibai Sainz-Aja Deparideu
 * @version 1.0
 */
public final class ConnectionFactory {

	private static Connection conn = null;
	static final String DB_NAME = "agenda";
	static final String URL_CONEXION = "jdbc:mysql://localhost:3306/" + DB_NAME + "?allowMultiQueries=true";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String USER = "root";
	static final String PASS = "root";

	private static ConnectionFactory factory = null;

	/**
	 * Constructor privado para poder crear patron Singleton.
	 */
	private ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtener una instancia de la clase, siguiendo el patron singleton.
	 * 
	 * @return conexion a la bbdd
	 */
	public static ConnectionFactory getInstance() {
		if (factory == null) {
			factory = new ConnectionFactory();
		}
		return factory;
	}

	/**
	 * Obtener conexion a la BBDD.
	 * 
	 * @return conexion abierta
	 * @throws SQLException exception de sql
	 */
	public Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection(URL_CONEXION, USER, PASS);
		}
		return conn;
	}

	/**
	 * Cerrar conexion.
	 * 
	 * @return
	 * @throws SQLException exception de sql
	 */
	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}

	}

	/**
	 * Obtener el DAO para manipular Alumnos,
	 *  soporta todas las operaciones CRUD.
	 * 
	 * @return DAOAmigo
	 */
	public IDAOAmigo getDAOAmigo() {
		return new DAOAmigo();
	}

}