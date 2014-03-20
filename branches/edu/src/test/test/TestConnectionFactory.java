package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.bbdd.ConnectionFactory;

import com.ipartek.agenda.interfaces.IAmigable;




public class TestConnectionFactory {
	static ConnectionFactory factory=null;
	Connection con;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = ConnectionFactory.getInstance();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		factory=null;
	}

	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void testGetInstance() {
		
		assertSame(factory,ConnectionFactory.getInstance() );
	}

	@Test
	public void testGetConnection() {
		try {
			con = factory.getConnection();
			assertNotNull(con);
		} catch (SQLException e) {
			fail("No se puede obtener conexion " + e.getMessage() );
		}	
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
	public void testGetDAOAmigo() {
		IAmigable daoAmigo = factory.getDAOAmigo();
		try {
			factory.getConnection();
			daoAmigo.getAll();
			factory.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
