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

public class TestConnectionFactory {

	static ConnectionFactory factory;
	static Connection con;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
		factory.closeConnection();
	}

	@Before
	public void setUp() throws Exception {
		factory = ConnectionFactory.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		//
	}

	@Test
	public void testGetConnection() {
		try {
			con = factory.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			fail("No se puede obtener conexion " + e.getMessage());
		}
	}

	@Test
	public void testGetInstance() {
		factory = ConnectionFactory.getInstance();
		assertSame(factory, ConnectionFactory.getInstance());
	}

	@Test
	public void testCloseConnection() {
		try {
			factory.closeConnection();
			assertTrue(true);
		} catch (Exception e) {
			fail("No se puede obtener conexion");
		}
	}

	@Test
	public void testGetDAOAmigo() throws SQLException {

		IAmigable daoAmigo = factory.getDAOAmigo();
		factory.getConnection();
		daoAmigo.getAll();
		factory.closeConnection();
	}

}
