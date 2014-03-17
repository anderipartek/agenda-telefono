package test;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IAmigable;

public class TestDAOAmigo {
    static ConnectionFactory factory=null;
    static IAmigable dao;
    Amigo a,a1;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory=ConnectionFactory.getInstance();
		dao=factory.getDAOAmigo();
		dao.crearTabla();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao=null;
		factory=null;
	}

	@Before
	public void setUp() throws Exception {
		a=new Amigo();
		a1=new Amigo(12,"Pablo","Motos","Bidebarri",48991,"Algeciras","Levante",999999999,999999999,"Sin anotaciones"); 
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testInsertarAmigo() {
		int id=dao.insertarAmigo(a);
		assertTrue("Se ha insertado amigo", id != -1);
	}

	@Test
	public void testDelete() {
		int id=dao.insertarAmigo(a);
		int idB=dao.delete(id);
		assertTrue("Se ha borrado amigo", idB != -1);
	}

	@Test
	public void testUpdate() {
		int id=dao.insertarAmigo(a);
		int idU=dao.update(a1, id);
		assertTrue("Se ha modificado amigo", idU != -1);
		System.out.println(a1.toString());
		
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerAmigoByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtenerAmigoByNombre() {
		fail("Not yet implemented");
	}

}
