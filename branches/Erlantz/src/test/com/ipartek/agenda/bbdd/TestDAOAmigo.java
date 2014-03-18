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
		assertTrue(dao.deleteAmigo(id));
	}

	@Test
	public void testGetAllAmigo() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			lista = dao.getAllAmigo();
			Amigo b = lista.get(id);
			assertEquals("Se han recuperado todos los amigos de la BBDD",
					b.toString(), a.toString());
			assertTrue(dao.deleteAmigo(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}

	}

	@Test
	public void testUpdateAmigo() {
		int id = dao.insertAmigo(a);
		if (id > 0) {
			a.setApellido("Fangoria");
			assertTrue("Actualizado el amigo", dao.updateAmigo(a, id));
			assertTrue(dao.deleteAmigo(id));
		} else {
			fail("No se ha insertado el alumno, testGetAllAmigo");
		}
	}

	@Test
	public void testGetAlumnoByName() {
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
}
