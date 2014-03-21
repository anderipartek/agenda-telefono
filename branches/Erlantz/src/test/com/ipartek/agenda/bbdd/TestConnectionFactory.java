package com.ipartek.agenda.bbdd;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.interfaces.IAmigable;

/**
 * Test de la clase ConnectionFactory.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class TestConnectionFactory {

	/**
	 * 
	 */
	static ConnectionFactory factory;
	/**
	 * 
	 */
	static Connection con;

	/**
	 * se ejecuta al principio del test.
	 * 
	 * @throws Exception excepcion general
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//
	}

	/**
	 * se ejecuta al final del test.
	 * 
	 * @throws Exception excepcion general
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
		factory.closeConnection();
	}

	/**
	 * Se ejecuta antes de cada test.
	 * 
	 * @throws Exception excepcion general
	 */
	@Before
	public final void setUp() throws Exception {
		factory = ConnectionFactory.getInstance();
	}

	/**
	 * Se ejecuta después de cada test.
	 * 
	 * @throws Exception excepcion general
	 */
	@After
	public final void tearDown() throws Exception {
		//
	}

	/**
	 * test para comprobar el metodo getConnection.
	 */
	@Test
	public final void testGetConnection() {
		try {
			con = factory.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			fail("No se puede obtener conexion " + e.getMessage());
		}
	}

	/**
	 * Test para comprobar el método getInstance.
	 */
	@Test
	public final void testGetInstance() {
		factory = ConnectionFactory.getInstance();
		assertSame(factory, ConnectionFactory.getInstance());
	}

	/**
	 * Test para comprobar el método closeConnection.
	 */
	@Test
	public final void testCloseConnection() {
		try {
			factory.closeConnection();
			assertTrue(true);
		} catch (Exception e) {
			fail("No se puede obtener conexion");
		}
	}

	/**
	 * Test para comprobar el método getDAOAmigo.
	 * 
	 * @throws SQLException excepcion SQL
	 */
	@Test
	public final void testGetDAOAmigo() throws SQLException {

		IAmigable daoAmigo = factory.getDAOAmigo();
		factory.getConnection();
		daoAmigo.getAllAmigo();
		factory.closeConnection();
	}

}
