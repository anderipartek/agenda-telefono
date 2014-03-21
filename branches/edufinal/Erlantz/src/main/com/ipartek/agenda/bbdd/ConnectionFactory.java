package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ipartek.agenda.interfaces.IAmigable;

/**
 * Clase para realizar la conexión con la BBDD de Agenda.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public final class ConnectionFactory {

	/**
	 * atributo de conexion.
	 */
	private static Connection conn = null;
	/**
	 * nombre de la tabla.
	 */
	private static final String DB_NAME = "agenda";
	/**
	 * url de la conexion a la bbdd.
	 */
	static final String URL_CONEXION = "jdbc:mysql://localhost:3306/" + DB_NAME;
	/**
	 * driver para realizar dicha conexion.
	 */
	static final String DRIVER = "com.mysql.jdbc.Driver";
	/**
	 * usuario.
	 */
	static final String USER = "root";
	/**
	 * password.
	 */
	static final String PASS = "root";

	/**
	 * 
	 */
	private static ConnectionFactory connectionFactory = null;

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
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}

	/**
	 * Obtener conexion a la BBDD.
	 * 
	 * @return conexion abierta
	 * @throws SQLException Excepciones SQL
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
	 * @throws SQLException Excepciones SQL
	 */
	public void closeConnection() throws SQLException {
		if (conn != null) {
			conn.close();
			conn = null;
		}

	}

	/**
	 * Obtener el DAO para manipular Alumnos, soporta todas las operaciones
	 * CRUD.
	 * 
	 * @return DAOAmigo
	 */
	public IAmigable getDAOAmigo() {
		return new DAOAmigo();
	}

}