package com.ipartek.agenda.bbdd;

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
 * Test para DAOAmigo.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class TestDAOAmigo {

	/**
	 * 
	 */
	static DAOAmigo dao;
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
		dao = new DAOAmigo();
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
	 * testeo de insertar.
	 */
	@Test
	public final void testInsertAmigo() {
		int id = dao.insertAmigo(a);
		assertTrue("Se ha insertado el amigo", id > 0);
		assertEquals(id, a.getId());
		assertTrue(dao.deleteAmigo(id));
	}

	/**
	 * testeo de recoger todos los amigos.
	 */
	@Test
	public final void testGetAllAmigo() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			lista = dao.getAllAmigo();
			Amigo b = lista.get(lista.size());
			assertEquals("Se han recuperado todos los amigos de la BBDD",
					b.toString(), a.toString());
			assertTrue(dao.deleteAmigo(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}

	}

	/**
	 * testeo de modificacion de amigo.
	 */
	@Test
	public final void testUpdateAmigo() {
		try {
			int id = dao.insertAmigo(a);
			if (id > 0) {
				a.setApellido("fangoria");
				assertTrue("Actualizado el amigo", dao.updateAmigo(a, id));
				assertTrue(dao.deleteAmigo(id));
			} else {
				fail("No se ha insertado el alumno, testGetAllAmigo");
			}
		} catch (AmigoExcepcion ex) {
			fail("No se ha podido cambiar el apellido a [Fangoria]");
		}
	}

	/**
	 * testeo de recoger amigo por nombre.
	 */
	@Test
	public final void testGetAlumnoByName() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			Amigo b = dao.getAmigoByName(a.getNombre());
			assertEquals("Recuperado amigo por nombre", b.toString(),
					a.toString());
			assertTrue(dao.deleteAmigo(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}
	}

	/**
	 * testeo de recoger todos los amigos por un nombre.
	 */
	@Test
	public final void testGetAllByName() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			lista = dao.getAllByName(a.getNombre());
			Amigo b = lista.get(lista.size());
			assertEquals("Recuperado amigo por nombre", b.toString(),
					a.toString());
			assertTrue(dao.deleteAmigo(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}
	}
}
