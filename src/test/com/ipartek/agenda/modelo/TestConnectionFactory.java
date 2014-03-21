package com.ipartek.agenda.modelo;

import java.sql.Connection;
import java.sql.SQLException;

import com.ipartek.agenda.interfaces.IDAOAmigo;

import junit.framework.TestCase;

public class TestConnectionFactory extends TestCase {

	private ConnectionFactory factory;
	private Connection con;

	public TestConnectionFactory(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = ConnectionFactory.getInstance();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetInstance() {
		factory = ConnectionFactory.getInstance();
		assertSame(factory, ConnectionFactory.getInstance());
	}

	public void testGetConnection() {
		try {
			con = factory.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			fail("No se puede obtener conexion " + e.getMessage());
		}
	}

	public void testCloseConnection() {
		try {
			factory.closeConnection();
			assertTrue(true);
		} catch (Exception e) {
			fail("No se puede cerrar conexion");
		}
	}

	public void testGetDAOAmigo() throws SQLException {
		IDAOAmigo daoAlumno = factory.getDAOAmigo();
		daoAlumno.getAll();

	}

}
