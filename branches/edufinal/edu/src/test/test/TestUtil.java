package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.util.UtilAmigo;


public class TestUtil {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckStrings() {
		// null
		assertFalse("No testea bien el null", UtilAmigo.checkNombre(null));
		//longitud minima de 2
		assertTrue("longitud minima de 2", UtilAmigo.checkNombre("ABC"));
		assertFalse("no tiene longitud minima de 2", UtilAmigo.checkNombre("A"));
				
				
				
				
				
	}

	
	@Test
	public void testCheckCP() {
		
	   //longitud de 5 numeros
		assertFalse("no tiene longitud de 5", UtilAmigo.checkCP(1234566));
		
	}

	
	
	@Test
	public void testCheckMovil() {
		//longitud de 9 numeros
				assertFalse("no tiene longitud de 9", UtilAmigo.checkMovil(12345));
				assertTrue("Longitud de 9 numeros",UtilAmigo.checkMovil(666666666));
	}

	

}
