package com.ipartek.agenda.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.ipartek.agenda.exceptions.AmigoException;

import junit.framework.TestCase;

/**
 * Clase de Tests para probar el alumno.
 * 
 * @author Patricia Navascu�s Vega
 * @version 1.0
 * @see com.ipartek.pruebas.bean.Alumno
 */
public class TestAmigo extends TestCase {

	/**
	 * Ejemplo Amigo amigoTest.
	 */
	private Amigo amigoTest;

	/**
	 * Ejemplo Amigo manola.
	 */
	private Amigo manola;

	private int telefonoFijo = 944444444;
	private int telefonoMovil = 622222222;
	private int codigoPostal = 45677;
	private int idPrueba = 1;

	/**
	 * Constructor de la clase TestAlumno.
	 * 
	 * @param name
	 */
	public TestAmigo(String name) {
		super(name);
	}

	/**
	 * Crea objetos para usar.El m�todo setUp() se ejecutara justo ANTES de la
	 * ejecuci�n de cada uno de los metodos test.
	 * @throws Exception
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		manola=new Amigo();
		manola.setNombre("manolita");
		manola.setApellido("gisa");
	
	}

	/**
	 * El m�todo tearDown() se ejecuta justo despu�s de la ejecuci�n de cada uno
	 * de los test.
	 */
	@Override
	protected void tearDown() throws Exception {
		manola=null;
	}

	/**
	 * Testea el constructor vac�o de la clase Alumno.
	 */
	public void tetsAlumno() {

		new Amigo();
		assertTrue("El constructor vac�o a funcionado correctamente.", true);

	}

	/**
	 * Test para el Constructor con todos los parametros menos el id.
	 */
	public void testAlumnoParameters() {

		try {
			manola = new Amigo("manola", "Gisasola", codigoPostal, 
					telefonoMovil, "Bilbao", "Mazustegi", 
					telefonoFijo, "Bizkaia", "Pruebitas");   
			
			assertTrue("El constructor con parametros funciona correctamente.",
					true);
		} catch (AmigoException e) {
			fail("No deber�a haberse producido la siguiente excepci�n"
					+ " [" + e.getMensajeError() + ", "
					+ e.getCodigoError() + "]");
			e.printStackTrace();
		}

		
	}

	/**
	 * Test para el constructor con Parametros incluido el id.
	 */
	public void testAlumnoParameters2() {

		try {
			manola = new Amigo(1, "manola", "Gisasola", codigoPostal,
					 telefonoMovil, "Bilbao", "Mazustegi", 
					 telefonoFijo, "Bizkaia", "Pruebitas");
			assertTrue("El constructor con parametros funciona correctamente.",
					true);
		} catch (AmigoException e) {
			fail("No deber�a haberse producido la siguiente excepci�n"
					+ " [" + e.getMensajeError() + ", "
					+ e.getCodigoError() + "]");
			e.printStackTrace();
		}

	}

	/**
	 * Test de getNombre.
	 */
	public void testGetNombre() {

		assertEquals("No se capitaliza el nombre del alumno",
				"Manolita", manola.getNombre());
	}

	/**
	 * Test de getApellido.
	 */
	public void testGetApellido() {

		assertEquals("No se capitaliza el nombre del alumno", 
				"Gisa", manola.getApellido());
	}

	/**
	 * Test de setNombre.
	 */
	public void testSetNombre() {
		// Comprobacionde que se puede settear el nombre
		try {
			
			manola.setNombre("manolo");
			manola.setNombre("Manolo");
			manola.setNombre("abc");
			assertTrue("SetNombre funciona correctamente", true);
		} catch (AmigoException e) {
			fail("No funciona el setnombre");
		}

		// Comprobar que lance la excepci�n esperada
		try {
			manola.setNombre("123");
			fail("No funciona el setNombre, "
					+ "deber�a haber lanzado una excepci�n.");
		} catch (AmigoException e) {
			assertTrue("Ha fallado correctamente", true);
			assertEquals("No es el c�digo de excepcion adecuado..",
					AmigoException.COD_ERROR_NOMBRE, e.getCodigoError());
			assertEquals("No el mensaje de excepcion adecuado.", 
					AmigoException.MSG_ERROR_NOMBRE, e.getMensajeError());
		}
	}

	/**
	 * 
	 * Test de setTelefonoFijo.
	 */
	public void testSetTelefonoFijo() {
		// Caso correcto.
		try {
			manola.setFijo(800000000);
			assertTrue("Funcionamiento correcto de setTelefonoFijo", true);
		} catch (AmigoException e) {
			fail("Deber�a haber funcionado correctamente setTelefonoFijo");
		}
		// Caso incorrecto. Longitud de telefono incorrecta.
		try {
			manola.setFijo(80000000);
			fail("no deber�a haber cambiado el telefono fijo."
					+ " Longitud incorrecta.");
		} catch (AmigoException e) {
			assertTrue("Excepcion lazada correctamente", true);
			assertEquals("No es el c�digo de error adecuado.",
					AmigoException.COD_ERROR_FIJO, e.getCodigoError());
			assertEquals("No es el mensaje de error adecuado."
					, AmigoException.MSG_ERROR_FIJO, e.getMensajeError());
		}

	}

	/**
	 * Test de setTelefonoMovil.
	 */

	public void testTelefonoMovil() {
		// Caso correcto.
		try {
			manola.setMovil(600000000);
			assertTrue("Funcionamiento correcto de setTelefonoMovil", true);
		} catch (AmigoException e) {
			fail("Deber�a haber funcionado correctamente setTelefonoMovil");
		}
		// Caso incorrecto. Digito inicial incorrecto.
		try {
			manola.setMovil(500000000);
			fail("No deber�a haber cambiado el tel�fono m�vil. Digito inicial incorrecto.");
		} catch (AmigoException e) {
			assertTrue("Excepion lanzada correctamente", true);
			assertEquals("No es el c�digo de error adecuado",
					AmigoException.COD_ERROR_MOVIL, e.getCodigoError());
			assertEquals("No es el mensaje de error adecuado",
					AmigoException.MSG_ERROR_MOVIL, e.getMensajeError());
		}
	}

}
