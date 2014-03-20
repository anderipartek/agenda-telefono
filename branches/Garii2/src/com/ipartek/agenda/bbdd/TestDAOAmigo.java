package com.ipartek.agenda.bbdd;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.ipartek.agenda.bean.Amigo;



public class TestDAOAmigo extends TestCase {

	DAOAmigo dao;
	Amigo a;
	int aID; //ID del Amigo insetardo en el setUp()
	ArrayList<Amigo> lista;
	
	protected void setUp() throws Exception {
		super.setUp();
		dao = new DAOAmigo();
		lista = new ArrayList<Amigo>();
		a = new Amigo();
		aID = dao.insertAmigo(a);
		if (aID==-1){
			fail ("Fallo insertando Amigo " + a.toString() );
		}	
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		assertTrue(dao.delete(aID));
		a = null;
		dao = null;
	}
	

	
	public void testGetAll() {
		lista = dao.getAll();		
		assertTrue("Deberia haber almenos un amigo ", lista.size() >=1);
		//Comprobar el ultimo Amigo insertado sea el del SetUp
		int ultimo = lista.size()-1;
		assertEquals(a.getNombre(),lista.get(ultimo).getNombre());
		assertEquals(a.getApellido(),lista.get(ultimo).getApellido());

	}

	public void testGetByNombre() {
		
		Amigo b = dao.getByNombre(a.getNombre());		
		assertEquals(aID, b.getId());
	}

	public void testGetById() {
		
		Amigo b = dao.getById(aID);
		assertEquals(aID, b.getId());
	}

	public void testDelete() {		
		assertFalse("No podemos borrar un usuario posterior al ultimo",dao.delete(aID+1));		
	}

	public void testUpdate(){
		a.setNombre("Gari");
		a.setApellido("Elorrieta");
		a.setCalle("Forua");
		a.setCp(48450);
		a.setLocalidad("Etxebarri");
		a.setProvincia("Bizkaia");
		a.setMovil(646209335);
		a.setFijo(944456658);
		a.setAnotaciones("ssadasdasdasd");		
		
		assertTrue(dao.update(a, aID));
		Amigo b = dao.getById(aID);
		assertEquals(a.getNombre(),b.getNombre());
		assertEquals(a.getApellido(),b.getApellido());
		assertEquals(a.getCp(),b.getCp());
		assertEquals(a.getProvincia(),b.getProvincia());
		assertEquals(a.getMovil(),b.getMovil());
		assertEquals(a.getFijo(),b.getFijo());
		assertEquals(a.getAnotaciones(),b.getAnotaciones());
		
		
	}

}
