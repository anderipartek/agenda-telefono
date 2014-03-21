package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

import com.ipartek.agenda.interfaces.IAmigable;

public class TestConnectionFactory extends TestCase {

	ConnectionFactory factory;
	Connection con;
	
	public TestConnectionFactory(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		factory = ConnectionFactory.getInstance();
	}

	protected void tearDown() throws Exception {
		super.tearDown();		
	}

	
	public void testGetInstance(){
		factory = ConnectionFactory.getInstance();
		assertSame(factory,ConnectionFactory.getInstance() );
	}
	
	public void testGetConnection(){
		try {
			con = factory.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			fail("No se puede obtener conexion " + e.getMessage() );
		}	
	}
	
	public void testCloseConnection(){
		try {
			factory.closeConnection();
			assertTrue(true);
		} catch (Exception e) {
			fail("No se puede obtener conexion");
		}	
	}
	
	public void testGetDAOAlumno() throws SQLException{
		
		IAmigable daoAlumno = factory.getDAOAmigo();
		factory.getConnection();
		daoAlumno.getAll();
		factory.closeConnection();
	}
	
}
