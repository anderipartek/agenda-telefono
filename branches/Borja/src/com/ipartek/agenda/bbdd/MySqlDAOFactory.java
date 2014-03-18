package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlDAOFactory extends DAOFactory {
	
	private static Connection conn = null;
	public static final String DB_NAME = "agenda";
	static final String CONNECTION_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;
			//+ "?allowMultiQueries=true";
	static final String DRIVER = "com.mysql.jdbc.Driver";
	static final String USER = "root";
	static final String PASS = "";

	private static MySqlDAOFactory mysqldaofac;

	/**
	 * Constructor privado para poder crear patron Singleton
	 */
	public MySqlDAOFactory() {
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
	/*
	public static MySqlDAOFactory getInstance() {
		if (mysqldaofac  == null) {
			mysqldaofac = new MySqlDAOFactory ();
		}
		return mysqldaofac;
	}*/
	
	

	/**
	 * Obtener conexion a la BBDD
	 * 
	 * @return conexion abierta
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection(CONNECTION_URL, USER, PASS);
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
	
	public DAOAmigo getDAOAmigo() {
		    
		    return new DAOAmigo();
	}


}
