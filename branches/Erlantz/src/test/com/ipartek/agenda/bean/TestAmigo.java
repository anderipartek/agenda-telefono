package com.ipartek.agenda.bean;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAmigo {

	static Amigo amigoTestVacio;
	static Amigo amigoTestParam;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		amigoTestVacio = new Amigo();
		amigoTestParam = new Amigo("Manola", "Gisasola", "669877555",
				"987654321", "La Parca", "Nisu", "Suni", 48970,
				"Aqui las anotaciones");
	}

	@After
	public void tearDown() throws Exception {
		amigoTestVacio = null;
		amigoTestParam = null;
	}

	@Test
	public void testContructorVacio() {
		assertEquals("ID = 0 constructor vacio", amigoTestVacio.getId(), 0);
		assertEquals("Nombre = Nombre constructor vacio",
				amigoTestVacio.getNombre(), "Nombre");
		assertEquals("Apellido = Apellido constructor vacio",
				amigoTestVacio.getApellido(), "Apellido");
		assertEquals("Calle = Calle constructor vacio",
				amigoTestVacio.getCalle(), "Calle");
		assertEquals("Provincia = Provincia constructor vacio",
				amigoTestVacio.getProvincia(), "Provincia");
		assertEquals("Localidad = Localidad constructor vacio",
				amigoTestVacio.getLocalidad(), "Localidad");
		assertEquals("CodigoPostal = 48900 constructor vacio",
				amigoTestVacio.getCodigoPostal(), 48900);
		assertEquals("Telefono Fijo = 999999999 constructor vacio",
				amigoTestVacio.getFTelefono(), "999999999");
		assertEquals("Telefono Movil = 666666666 constructor vacio",
				amigoTestVacio.getMTelefono(), "666666666");
		assertEquals("Anotaciones = Anotaciones constructor vacio",
				amigoTestVacio.getAnotaciones(), "Anotaciones");
	}

	@Test
	public void testConstructorParametros() {
		Amigo amigoTest = new Amigo("Manola", "Gisasola", "669877555",
				"987654321", "La Parca", "Nisu", "Suni", 48970,
				"Anotaciones del amigo aqui");
		assertEquals("[ID = 0] constructor vacio", amigoTest.getId(), 0);
		assertEquals("[Nombre = Manola] constructor con parametros",
				amigoTest.getNombre(), "Manola");
		assertEquals("[Apellido = Gisasola] constructor con parametros",
				amigoTest.getApellido(), "Gisasola");
		assertEquals("[Calle = La Parca] constructor con parametros",
				amigoTest.getCalle(), "La Parca");
		assertEquals("[Provincia = Nisu] constructor con parametros",
				amigoTest.getProvincia(), "Nisu");
		assertEquals("[Localidad = Suni] constructor con parametros",
				amigoTest.getLocalidad(), "Suni");
		assertEquals("[CodigoPostal = 48970] constructor con parametros",
				amigoTest.getCodigoPostal(), 48970);
		assertEquals("[Telefono Fijo = 987654321] constructor con parametros",
				amigoTest.getFTelefono(), "987654321");
		assertEquals("[Telefono Movil = 669877555] constructor con parametros",
				amigoTest.getMTelefono(), "669877555");
		assertEquals(
				"[Anotaciones = Anotaciones del amigo aqui] constructor con parametros",
				amigoTest.getAnotaciones(), "Anotaciones del amigo aqui");
	}

	@Test
	public void testSetters() {
		amigoTestParam.setId(5);
		amigoTestParam.setNombre("Manolito");
		amigoTestParam.setApellido("Gisa");
		amigoTestParam.setMTelefono("654987321");
		amigoTestParam.setFTelefono("977898789");
		amigoTestParam.setCalle("Parca");
		amigoTestParam.setProvincia("Sinu");
		amigoTestParam.setLocalidad("Nisu");
		amigoTestParam.setCodigoPostal(48971);
		amigoTestParam.setAnotaciones("Anotaciones del amigo aqui");
		assertEquals("[ID = 5]", 5, amigoTestParam.getId());
		assertEquals("[Nombre = Manolito] constructor con parametros",
				amigoTestParam.getNombre(), "Manolito");
		assertEquals("[Apellido = Gisa] constructor con parametros",
				amigoTestParam.getApellido(), "Gisa");
		assertEquals("[Telefono Movil = 654987321] constructor con parametros",
				amigoTestParam.getMTelefono(), "654987321");
		assertEquals("[Telefono Fijo = 977898789] constructor con parametros",
				amigoTestParam.getFTelefono(), "977898789");
		assertEquals("[Calle = Parca] constructor con parametros",
				amigoTestParam.getCalle(), "Parca");
		assertEquals("[Provincia = Sinu] constructor con parametros",
				amigoTestParam.getProvincia(), "Sinu");
		assertEquals("[Localidad = Nisu] constructor con parametros",
				amigoTestParam.getLocalidad(), "Nisu");
		assertEquals("[CodigoPostal = 48971] constructor con parametros",
				amigoTestParam.getCodigoPostal(), 48971);
		assertEquals(
				"[Anotaciones = Anotaciones del amigo aqui] constructor con parametros",
				amigoTestParam.getAnotaciones(), "Anotaciones del amigo aqui");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
