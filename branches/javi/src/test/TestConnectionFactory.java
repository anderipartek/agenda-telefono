package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.ipartek.agenda.bbdd.ConnectionFactory;

public class TestConnectionFactory {
	
	ConnectionFactory connection;
	Connection con;

	public TestConnectionFactory() {
	}
	
	@Test
	public void comprueboTest(){
		assertTrue(true);
	}
	
	@Test
	public void testGetInstance(){
		connection = ConnectionFactory.getInstance();
		assertSame(connection,ConnectionFactory.getInstance());
	}
	
	@Test
	public void testGetConnection(){
		try{
		con = ConnectionFactory.getInstance().getConnection();
		assertNotNull(con);
		}catch(SQLException e){
			e.printStackTrace();
			fail("No se puede obtener conexion " + e.getMessage() );
		}
	}
	
	@Test
	public void testCloseConnection(){
		connection = ConnectionFactory.getInstance();
		try {
			connection.closeConnection();
			assertTrue(true);
		} catch (SQLException e) {
			fail("No se puede obtener conexion " + e.getMessage() );
			e.printStackTrace();
		}
		
	}
	
}
