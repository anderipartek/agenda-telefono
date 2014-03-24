package com.ipartek.agenda.modelo;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exceptions.AmigoException;
import com.ipartek.agenda.interfaces.IDAOAmigo;

/**
 * Clase para testear el funcionamiento de DAOAmigo.
 * 
 * 
 * @author Patricia Navascués
 * @version 1.0
 * 
 */
public class TestDAOAmigo extends TestCase {
	private final static Logger LOG = Logger.getLogger(DAOAmigo.class);

	private Amigo a;
	private ArrayList<Amigo> lista;
	private IDAOAmigo daoAmigo;
	private int telefonoFijo = 944444444;
	private int telefonoMovil = 622222222;
	private int codigoPostal = 48007;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		PropertyConfigurator.configure("config/log4j.properties");
		ConnectionFactory.getInstance().getDAOAmigo().createTable();
		lista = new ArrayList<Amigo>();
		daoAmigo = ConnectionFactory.getInstance().getDAOAmigo();
		a = new Amigo("Patricia", "Navascues", codigoPostal, telefonoMovil, "Bilbao", "Bizkaia", telefonoFijo, "Mazustegi",
				"datos importantes del amigo");

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		a = null;

	}

	public void testOpenConnection() {
		try {
			ConnectionFactory.getInstance().getConnection();
			assertTrue("La conexion se ha establecido.", true);
		} catch (Exception e) {
			fail("No se puede establecer conexion");
		}
	}

	public void testCloseConnection() {
		try {
			ConnectionFactory.getInstance().closeConnection();
			assertTrue("La conexion se ha cerrado.", true);
		} catch (Exception e) {
			fail("No se puede Cerrar conexion");
		}
	}

	public void testCreateTable() {
		// assertTrue("La tabla alumno se ha creado con exito",
		// dao.createTable() );
		assertFalse("No deberia crear la tabla de nuevo", daoAmigo.createTable());
	}

	public void testInsertAmigo() {

		// insertar nuevo alumno
		int id = daoAmigo.insertAmigo(a);
		assertTrue("Se debería haber insertado un nuevo amigo", id > 0);
		// Recuperarlo por su ID
		// assertEquals(id, ((Amigo)daoAmigo.getByNombre(a.getNombre())));
		// borrarlo
		assertTrue(daoAmigo.delete(id));

	}

	public void testGetAll() {
		int id = daoAmigo.insertAmigo(a);
		lista = daoAmigo.getAll();
		assertTrue("Deberia existir al menos un alumno", 0 < lista.size());
		assertTrue(daoAmigo.delete(id));
	}

	public void testGetByName() {
		int id = daoAmigo.insertAmigo(a);
		Amigo b = daoAmigo.getById(a.getId());
		assertEquals(a.getNombre(), b.getNombre());
		assertTrue(daoAmigo.delete(id));
	}

	public void testGetById() {
		int id = daoAmigo.insertAmigo(a);
		Amigo b = daoAmigo.getById(id);
		assertEquals(b.getNombre(), a.getNombre());
		assertTrue(daoAmigo.delete(id));
	}

	public void testDelete() {
		int id = daoAmigo.insertAmigo(a);
		assertTrue(daoAmigo.delete(id));
	}

	public void testUpdate() {

		int id = daoAmigo.insertAmigo(a);

		try {
			Amigo a = new Amigo("Patricia", "Vega", 48006, 666666666, "Bilbao", "Indautxu", 888888888, "Bizkaia",
					"No tengo anotaciones para este amigo");
		} catch (AmigoException e) {
			LOG.error("Error al crear el nuevo amigo [" + e.getMensajeError() + ", " + e.getCodigoError() + "]");
			e.printStackTrace();
		}

		assertTrue(daoAmigo.update(a, id));
		Amigo b = daoAmigo.getById(id);
		assertEquals(b.getNombre(), a.getNombre());
		assertTrue(daoAmigo.delete(id));

	}

}
