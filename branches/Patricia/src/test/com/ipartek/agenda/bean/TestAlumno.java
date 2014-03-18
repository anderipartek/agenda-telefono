package com.ipartek.agenda.bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import junit.framework.TestCase;

/**
 * Clase de Tests para probar el alumno.
 * 
 * @author Patricia Navascu�s Vega
 * @version 1.0
 * @see com.ipartek.pruebas.bean.Alumno
 */
public class TestAlumno extends TestCase {

	/**
	 * Ejemplo Amigo amigoTest.
	 */
	private Amigo amigoTest;

	/**
	 * Ejemplo Amigo manola.
	 */
	private Amigo manola;

	int telefonoFijo = 944444444;
	int telefonoMovil = 62222222;
	int codigoPostal = 48007;

	/**
	 * Constructor de la clase TestAlumno.
	 * 
	 * @param name
	 */
	public TestAlumno(String name) {
		super(name);
	}

	/**
	 * Crea objetos para usar.El m�todo setUp() se ejecutara justo ANTES de la
	 * ejecuci�n de cada uno de los metodos test.
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		amigoTest = new Amigo();
		manola = new Amigo("manola", "gisasola", codigoPostal, telefonoMovil, "Bilbao", "Mazustegi", telefonoFijo, "Bizkaia",
				"anotaciones de ejemplo");

	}

	/**
	 * El m�todo tearDown() se ejecuta justo despu�s de la ejecuci�n de cada uno
	 * de los test.
	 */
	@Override
	protected void tearDown() throws Exception {
		amigoTest = null;
		manola = null;

	}

	/**
	 * Testea el constructor vac�o de la clase Alumno.
	 */
	public void tetsAlumno() {
		
			new Amigo();
			assertTrue("El constructor vac�o a funcionado correctamente.", true);
		
	}

	/**
	 * Test para el Constructor con parametros.
	 */
	public void testAlumnoParameters() {

		try {
			String fechas = new Date(1900, 1, 1).toString();
			try {
				//manola = new Alumno("11111111H", "manola", "gisasola", "Gutierrez", 33, Sexo.HOMBRE, "Bilbao", fechas, fechas, libro, "988888888",
				//		"677777777", "aaa@aaa.aaa");
			} catch (LibroException e) {

				fail("No funciona el constructor sin parametros de libro");
			}
			assertTrue("El constructor con parametros funciona correctamente.", true);
		} catch (AlumnoException e) {
			fail("No funciona el constructor con parametros");
		}
	}

	/**
	 * Test de getNombre
	 */
	public void testGetNombre() {

		assertEquals("No se capitaliza el nombre del alumno", "Manola", manola.getNombre());
	}

	/**
	 * Test de getApellido1
	 */
	public void testGetApellido1() {

		assertEquals("No se capitaliza el nombre del alumno", "Gisasola", manola.getApellido1());
	}

	/**
	 * Test de getApellido2
	 */
	public void testGetApellido2() {

		assertEquals("No se capitaliza el nombre del alumno", "Lopez", manola.getApellido2());
	}

	/**
	 * Test de setNombre
	 */
	public void testSetNombre() {
		// Comprobacionde que se puede settear el nombre
		try {
			manola.setNombre("manolo");
			manola.setNombre("Manolo");
			manola.setNombre("abc");
			assertTrue("SetNombre funciona correctamente", true);
		} catch (AlumnoException e) {
			fail("No funciona el setnombre");
		}

		// Comprobar que lance la excepci�n esperada
		try {
			manola.setNombre("123");
			fail("No funciona el setNombre, deber�a haber lanzado una excepci�n.");
		} catch (AlumnoException e) {
			assertTrue("Ha fallado correctamente", true);
			assertEquals("No es el c�digo de excepcion adecuado..", AlumnoException.COD_ERROR_NOMBRE, e.getCodigoError());
			assertEquals("No el mensaje de excepcion adecuado.", AlumnoException.MSG_ERROR_NOMBRE, e.getMensaje());
		}
	}

	/**
	 * Test de setEdad
	 * 
	 * @throws AlumnoException
	 */
	public void testSetEdad() {
		try {
			// Caso correctos.
			alumnoTest.setEdad(20);
			assertEquals("Set deber�a funcionar correctamente", 20, alumnoTest.getEdad());
		} catch (AlumnoException e) {
			fail(" No ha hecho correctamente la comprobaci�n de la edad");

		}
		// Casos incrrectos
		// Valor por encima del superior.
		try {

			alumnoTest.setEdad(123);
			fail("Edad no valida, error en la comprobaci�n de la edad.");
		} catch (AlumnoException e) {
			// Casos correctos.
			assertEquals("Codigo del error deberia ser correcto", AlumnoException.COD_ERROR_EDAD, e.COD_ERROR_EDAD);
			assertEquals("Mensaje del error deberia ser correcto", AlumnoException.MSG_ERROR_EDAD, e.MSG_ERROR_EDAD);

		}
		// Valor por debajo del limite inferior.
		try {
			alumnoTest.setEdad(15);
			fail("Edad no valida, error en la comprobaci�n de la edad.");
		} catch (AlumnoException e) {
			// Casos correctos.
			assertEquals("Codigo del error deberia ser correcto", AlumnoException.COD_ERROR_EDAD, e.COD_ERROR_EDAD);
			assertEquals("Mensaje del error deberia ser correcto", AlumnoException.MSG_ERROR_EDAD, e.MSG_ERROR_EDAD);

		}

	}

	/**
	 * Test de setDNI
	 */
	public void testSetDNI() {
		// Caso correcto de DNI, letra en mayuscula.
		try {
			manola.setDni("65209017S");
			assertTrue("Funcionamiento correcto de setDNI", true);
		} catch (AlumnoException e) {
			fail("No deber�a haberse producido una excepcion, dni modificado correctamente.");
		}
		// Caso correcto de DNI, letra en minuscula.
		try {
			manola.setDni("65209017s");
			assertEquals("Funcionamiento correcto de setDNI", "65209017S", manola.getDni());
		} catch (AlumnoException e) {
			fail("Letra del dni no se ha puesto en mayusculas.");
		}

	}

	/**
	 * Test de setEmail.
	 */
	public void testSetEmail() {
		// Caso correcto.
		try {
			manola.setEmail("manola@manola.com");
			assertTrue("Funcionamiento corecto.", true);
		} catch (AlumnoException e) {

			fail("Deber�a haber funcionado correctamente setEmail");
		}
		// Caso inicorrecto.Email vac�o.
		try {
			manola.setEmail("");
			fail("No deber�a dejar introducir un email vac�o");
		} catch (AlumnoException e) {
			assertTrue("Excepci�n lanzada correctamente", true);
			assertEquals("No es el c�digo de error adecuado.", AlumnoException.COD_ERROR_EMAIL, e.getCodigoError());
			assertEquals("No es el mensaje de error adecuado", AlumnoException.MSG_ERROR_EMAIL, e.getMensaje());

		}
		// Caso incorrecto. Email nulo.
		try {
			manola.setEmail(null);
			fail("No deber�a dejar introducir un email nulo.");
		} catch (AlumnoException e) {
			assertTrue("Excepci�n lanzada correctamente", true);
			assertEquals("No es el c�digo de error adecuado.", AlumnoException.COD_ERROR_EMAIL, e.getCodigoError());
			assertEquals("No es el mensaje de error adecuado", AlumnoException.MSG_ERROR_EMAIL, e.getMensaje());
		}
	}

	/**
	 * Test para comprobar setLibroCurso.
	 * 
	 * @throws LibroException
	 */
	public void testSetLibroCurso() throws LibroException {
		Libro libroNuevo = new Libro();

		manola.setLibroCurso(libroNuevo);
		assertTrue("Libro creado correctamente", true);

	}

	/**
	 * 
	 * Test de setTelefonoFijo.
	 */
	public void testSetTelefonoFijo() {
		// Caso correcto.
		try {
			manola.setTelefonoFijo("800000000");
			assertTrue("Funcionamiento correcto de setTelefonoFijo", true);
		} catch (AlumnoException e) {
			fail("Deber�a haber funcionado correctamente setTelefonoFijo");
		}
		// Caso incorrecto. Longitud de telefono incorrecta.
		try {
			manola.setTelefonoFijo("80000000");
			fail("no deber�a haber cambiado el telefono fijo. Longitud incorrecta.");
		} catch (AlumnoException e) {
			assertTrue("Excepcion lazada correctamente", true);
			assertEquals("No es el c�digo de error adecuado.", AlumnoException.COD_ERROR_TELEFONOFIJO, e.getCodigoError());
			assertEquals("No es el mensaje de error adecuado.", AlumnoException.MSG_ERROR_TELEFONOFIJO, e.getMensaje());
		}

	}

	/**
	 * Test de setTelefonoMovil.
	 */

	public void testTelefonoMovil() {
		// Caso correcto.
		try {
			manola.setTelefonoMovil("600000000");
			assertTrue("Funcionamiento correcto de setTelefonoMovil", true);
		} catch (AlumnoException e) {
			fail("Deber�a haber funcionado correctamente setTelefonoMovil");
		}
		// Caso incorrecto. Digito inicial incorrecto.
		try {
			manola.setTelefonoMovil("500000000");
			fail("No deber�a haber cambiado el tel�fono m�vil. Digito inicial incorrecto.");
		} catch (AlumnoException e) {
			assertTrue("Excepion lanzada correctamente", true);
			assertEquals("No es el c�digo de error adecuado", AlumnoException.COD_ERROR_TELEFONOMOVIL, e.getCodigoError());
			assertEquals("No es el mensaje de error adecuado", AlumnoException.MSG_ERROR_TELEFONOMOVIL, e.getMensaje());
		}
	}

}
