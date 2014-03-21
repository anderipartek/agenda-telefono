package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.ConnectionFactory;
import com.ipartek.agenda.database.DAOAmigo;

/**
 * 
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 */
public class TestModeloAmigo {

	static Amigo a;
	static DAOAmigo daoAmigo;
	static int idAmigo;
	
	/**
	 * Constructor.
	 */
	public TestModeloAmigo() {
	}

	/**
	 * Funcion que se ejecuta al principio de la clase.
	 * @throws Exception a capturar
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		a = new Amigo();
		a.setNombre("pepe");
		daoAmigo = (DAOAmigo) ConnectionFactory.getInstance().getDAOAmigo();
		
		idAmigo = daoAmigo.add(a);
		assertNotEquals(-1, idAmigo);
	}

	/**
	 * Funcion que se ejecuta al final de clase.
	 * @throws Exception a capturar
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoAmigo.delete(idAmigo);
		
		a = null;
		daoAmigo = null;
	}

	/**
	 * e ejecuta antes de cada test.
	 * @throws Exception a capturar
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Se ejecuta despues de cada test.
	 * @throws Exception a capturar
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test para el getAll().
	 */
	@Test
	public final void getAll() {
		ArrayList<Amigo> amigos = daoAmigo.getAll();
		assertTrue(amigos.size() > 0);
	}
	
	/**
	 * Test para el getByName().
	 */
	@Test
	public final void getByName() {
		ArrayList<Amigo> amigos = daoAmigo.getByName(a.getNombre());
		boolean encontrado = true;
		for (int i = 0; i < amigos.size(); i++) {
			boolean b = amigos.get(i).getNombre().equals(a.getNombre());
			if (!b) {
				encontrado = false;
			}
		}
		assertTrue(encontrado);
	}
	
	/**
	 * Test para getById().
	 */
	@Test
	public final void getById() {
		Amigo b = daoAmigo.getById(idAmigo);
		assertEquals(a.getNombre(), b.getNombre());
		assertEquals(a.getId(), b.getId());
	}
	
	/**
	 * Test para update().
	 */
	@Test
	public final void update() {
		a.setNombre("Nombre de prueba");
		a.setApellido("Miapellido");
		a.setCalle("Micalle");
		a.setCp(12345);
		a.setFijo(123456789);
		a.setLocalidad("Milocalidad");
		a.setMovil(123456789);
		a.setProvincia("Vizcaya");
		a.setAnotaciones("bla bla");
		
		assertTrue(daoAmigo.update(a));
		
	}
	

}
