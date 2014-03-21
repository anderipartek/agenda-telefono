package com.ipartek.agenda.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.excepciones.AmigoExcepcion;

/**
 * Test de la clase bean AMIGO.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class TestAmigo {

	/**
	 * 
	 */
	static final int CP_PRUEBA = 4000000;
	/**
	 * 
	 */
	static Amigo amigoTestVacio;
	/**
	 * 
	 */
	static Amigo amigoTestParam;

	/**
	 * se ejecuta al principio del test.
	 * 
	 * @throws Exception excepcion general
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Se ejecuta antes de cada test.
	 * 
	 * @throws Exception excepcion general
	 */
	@Before
	public final void setUp() throws Exception {
		amigoTestVacio = new Amigo();
		amigoTestParam = new Amigo("Manola", "Gisasola", "669877555",
				"944654321", "La Parca", "Nisu", "Suni", 48970,
				"Aqui las anotaciones");
	}

	/**
	 * Se ejecuta después de cada test.
	 * 
	 * @throws Exception excepcion general
	 */
	@After
	public final void tearDown() throws Exception {
		amigoTestVacio = null;
		amigoTestParam = null;
	}

	/**
	 * test de constructor vacio.
	 */
	@Test
	public final void testContructorVacio() {
		assertEquals("ID = 0 constructor vacio", amigoTestVacio.getId(), 0);
		assertEquals("Nombre = Nombre constructor vacio",
				amigoTestVacio.getNombre(), "NOMBRE");
		assertEquals("Apellido = Apellido constructor vacio",
				amigoTestVacio.getApellido(), "APELLIDO");
		assertEquals("Calle = Calle constructor vacio",
				amigoTestVacio.getCalle(), "CALLE");
		assertEquals("Provincia = Provincia constructor vacio",
				amigoTestVacio.getProvincia(), "PROVINCIA");
		assertEquals("Localidad = Localidad constructor vacio",
				amigoTestVacio.getLocalidad(), "LOCALIDAD");
		assertEquals("CodigoPostal = 00000 constructor vacio",
				amigoTestVacio.getCodigoPostal(), 00000);
		assertEquals("Telefono Fijo = 999999999 constructor vacio",
				amigoTestVacio.getFTelefono(), "0");
		assertEquals("Telefono Movil = 666666666 constructor vacio",
				amigoTestVacio.getMTelefono(), "0");
		assertEquals("Anotaciones = Anotaciones constructor vacio",
				amigoTestVacio.getAnotaciones(), "ANOTACIONES");
	}

	/**
	 * test de constructor con parametros.
	 */
	@Test
	public final void testConstructorParametros() {
		try {
			Amigo amigoTest = new Amigo("Manola", "Gisasola", "669877555",
					"944654321", "La Parca", "Nisu", "Suni", 48970,
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
			assertEquals(
					"[Telefono Fijo = 944654321] constructor con parametros",
					amigoTest.getFTelefono(), "944654321");
			assertEquals(
					"[Telefono Movil = 669877555] constructor con parametros",
					amigoTest.getMTelefono(), "669877555");
			assertEquals("[Anotaciones = Anotaciones del amigo aqui] "
					+ "constructor con parametros", amigoTest.getAnotaciones(),
					"Anotaciones del amigo aqui");
		} catch (AmigoExcepcion ex) {
			if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_NOMBRE) {
				fail("Excepcion capturada por AmigoExcepcion ERROR NOMBRE ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_APELLIDO) {
				fail("Excepcion capturada por AmigoExcepcion ERROR APELLIDO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_TELEFONO) {
				fail("Excepcion capturada por AmigoExcepcion ERROR TELEFONO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_CP) {
				fail("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL ["
						+ ex.getMensajeError() + "]");
			}
		}
	}

	/**
	 * test de setters.
	 */
	@Test
	public final void testSetters() {
		try {
			amigoTestParam.setId(5);
			amigoTestParam.setNombre("Manolito");
			amigoTestParam.setApellido("Gisa");
			amigoTestParam.setMTelefono("654987321");
			amigoTestParam.setFTelefono("944898789");
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
			assertEquals(
					"[Telefono Movil = 654987321] constructor con parametros",
					amigoTestParam.getMTelefono(), "654987321");
			assertEquals(
					"[Telefono Fijo = 977898789] constructor con parametros",
					amigoTestParam.getFTelefono(), "944898789");
			assertEquals("[Calle = Parca] constructor con parametros",
					amigoTestParam.getCalle(), "Parca");
			assertEquals("[Provincia = Sinu] constructor con parametros",
					amigoTestParam.getProvincia(), "Sinu");
			assertEquals("[Localidad = Nisu] constructor con parametros",
					amigoTestParam.getLocalidad(), "Nisu");
			assertEquals("[CodigoPostal = 48971] constructor con parametros",
					amigoTestParam.getCodigoPostal(), 48971);
			assertEquals("[Anotaciones = Anotaciones del amigo aqui] "
					+ "constructor con parametros",
					amigoTestParam.getAnotaciones(),
					"Anotaciones del amigo aqui");
		} catch (AmigoExcepcion ex) {
			if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_NOMBRE) {
				fail("Excepcion capturada por AmigoExcepcion ERROR NOMBRE ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_APELLIDO) {
				fail("Excepcion capturada por AmigoExcepcion ERROR APELLIDO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_TELEFONO) {
				fail("Excepcion capturada por AmigoExcepcion ERROR TELEFONO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_CP) {
				fail("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL ["
						+ ex.getMensajeError() + "]");
			}
		}

	}

	/**
	 * test de excepciones con nombre.
	 * 
	 * @throws Exception excepcion general
	 */
	@Test(expected = AmigoExcepcion.class)
	public final void testSetNombreExcepcion() throws Exception {
		amigoTestParam.setNombre("a");
	}

	/**
	 * test de excepciones con apellido.
	 * 
	 * @throws Exception excepcion general
	 */
	@Test(expected = AmigoExcepcion.class)
	public final void testSetApellidoExcepcion() throws Exception {
		amigoTestParam.setApellido("a");
	}

	/**
	 * test de excepciones de telefono.
	 * 
	 * @throws Exception excepcion general
	 */
	@Test(expected = AmigoExcepcion.class)
	public final void testSetTelefonoMovilExcepcion() throws Exception {
		amigoTestParam.setMTelefono("00");
	}

	/**
	 * test de excepciones de telefono.
	 * 
	 * @throws Exception excepcion general
	 */
	@Test(expected = AmigoExcepcion.class)
	public final void testSetTelefonoFijoExcepcion() throws Exception {
		amigoTestParam.setFTelefono("0000000000");
	}

	/**
	 * test de excepciones de codigo postal.
	 * 
	 * @throws Exception excepcion general
	 */
	@Test(expected = AmigoExcepcion.class)
	public final void testSetCodigoPostalExcepcion() throws Exception {

		amigoTestParam.setCodigoPostal(CP_PRUEBA);
	}

	/**
	 * se ejecuta al final del test.
	 * 
	 * @throws Exception excepcion general
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
