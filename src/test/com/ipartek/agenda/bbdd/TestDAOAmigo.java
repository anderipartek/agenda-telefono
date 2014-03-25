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
import com.ipartek.agenda.exception.AmigoException;

public class TestDAOAmigo {

	static DAOAmigo dao;
	static Amigo a;
	static HashMap<Integer, Amigo> lista;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = new DAOAmigo();
		lista = new HashMap<Integer, Amigo>();
		a = new Amigo();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		if (a == null) {
			a = new Amigo();
		}
	}

	@After
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testInsertAmigo() {
		int id = dao.insertAmigo(a);
		assertTrue("Se ha insertado el amigo", id > 0);
		assertEquals(id, a.getId());
		assertTrue(dao.delete(id));
	}

	@Test
	public void testGetAll() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			lista = dao.getAll();
			Amigo b = lista.get(lista.size());
			assertEquals("Se han recuperado todos los amigos de la BBDD", b.toString(), a.toString());
			assertTrue(dao.delete(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}
	}

	@Test
	public void testUpdate() {
		try {
			int id = dao.insertAmigo(a);
			if (id > 0) {
				a.setApellido("fangoria");
				assertTrue("Actualizado el amigo", dao.update(a, id));
				assertTrue(dao.delete(id));
			} else {
				fail("No se ha insertado el alumno, testGetAllAmigo");
			}
		} catch (AmigoException ex) {
			fail("No se ha podido cambiar el apellido a [Fangoria]");
		}
	}

	@Test
	public void testGetAlumnoByName() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			Amigo b = dao.getAmigoByName(a.getNombre());
			assertEquals("Recuperado amigo por nombre", b.toString(), a.toString());
			assertTrue(dao.delete(id));
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
			assertEquals("Recuperado amigo por nombre", b.toString(), a.toString());
			assertTrue(dao.delete(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}
	}
}