package com.ipartek.agenda.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.excepciones.AmigoExcepcion;

/**
 * Test para modelo amigo.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class TestModeloAmigo {

	/**
	 * 
	 */
	static ModeloAmigo modelo;
	/**
	 * 
	 */
	static Amigo a;
	/**
	 * 
	 */
	static HashMap<Integer, Amigo> lista;

	/**
	 * se ejecuta al principio del test.
	 * 
	 * @throws Exception excepcion general
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		modelo = new ModeloAmigo();
		lista = new HashMap<Integer, Amigo>();
		a = new Amigo();
	}

	/**
	 * se ejecuta al final del test.
	 * 
	 * @throws Exception excepcion general
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Se ejecuta antes de cada test.
	 * 
	 * @throws Exception excepcion general
	 */
	@Before
	public final void setUp() throws Exception {
		if (a == null) {
			a = new Amigo();
		}
	}

	/**
	 * Se ejecuta después de cada test.
	 * 
	 * @throws Exception excepcion general
	 */
	@After
	public final void tearDown() throws Exception {
		a = null;
	}

	/**
	 * test de insertar amigo.
	 */
	@Test
	public final void testInsertAmigo() {
		int id = modelo.insertar(a);
		assertTrue("Se ha insertado el amigo", id > 0);
		assertEquals(id, a.getId());
		assertTrue(modelo.eliminar(id));
	}

	/**
	 * test de recoger todos los amigos.
	 */
	@Test
	public final void testGetAllAmigo() {
		int id = modelo.insertar(a);
		if (id > 0) {
			lista = modelo.recogerTodos();
			Amigo b = lista.get(lista.size());
			assertEquals("Se han recuperado todos los amigos de la BBDD",
					b.toString(), a.toString());
			assertTrue(modelo.eliminar(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}

	}

	/**
	 * test de modificar amigos.
	 */
	@Test
	public final void testUpdateAmigo() {
		try {
			int id = modelo.insertar(a);
			if (id > 0) {
				a.setApellido("fangoria");
				assertTrue("Actualizado el amigo", modelo.modificar(a, id));
				assertTrue(modelo.eliminar(id));
			} else {
				fail("No se ha insertado el alumno, testGetAllAmigo");
			}
		} catch (AmigoExcepcion ex) {
			fail("No se ha podido cambiar el apellido a [Fangoria]");
		}
	}

	/**
	 * test de recoger amigos por nombre.
	 */
	@Test
	public final void testGetAlumnoByName() {
		int id = modelo.insertar(a);
		if (id > 0) {
			Amigo b = modelo.recogerUno(a.getNombre());
			assertEquals("Recuperado amigo por nombre", b.toString(),
					a.toString());
			assertTrue(modelo.eliminar(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}
	}

}
