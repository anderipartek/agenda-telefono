package test;



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.interfaces.IDAOAmigo;

public class TestDAOAmigo {
    static ConnectionFactory factory=null;
    static IDAOAmigo dao;
    static ArrayList<Amigo> amigos;
    Amigo a=null;
    Amigo a1=null;		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory=ConnectionFactory.getInstance();
		dao=factory.getDAOAmigo();
		amigos=new ArrayList<Amigo>();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao=null;
		factory=null;
	}

	@Before
	public void setUp() throws Exception {
		a=new Amigo();
		
		
	}

	@After
	public void tearDown() throws Exception {
		amigos=null;
	}
    
	
	@Test
	public void testInsertarAmigo() {
		int id=dao.insertarAmigo(a);
		assertTrue("Se ha insertado amigo", id != -1);
	}


	@Test
	public void testUpdate() {
		int id=dao.insertarAmigo(a);
		try {
			a1=new Amigo(id,"Pablo","Motos","Bidebarri",48991,"Algeciras","Levante",999999999,999999999,"Sin anotaciones");
			int idU=dao.update(a1, id);
			assertTrue("Se ha modificado amigo", idU != -1);
			//System.out.println(a1.toString());
		} catch (AmigoException e) {
			e.getMessage();
		} 
		
		
	}

	@Test
	public void testGetAll() {
		amigos=dao.getAll();
		assertTrue("Obtenidos todos los amigos de la BD",amigos.size()>0);
		
	}

	@Test
	public void testObtenerAmigoByID() {
		int id=dao.insertarAmigo(a);
		a1=dao.obtenerAmigoByID(id);
		assertTrue("testObtenerAmigoById correcto",a1!=null);
	}

	@Test
	public void testObtenerAmigoByNombre() {
		int id=dao.insertarAmigo(a);
		a1=dao.obtenerAmigoByNombre(a.getNombre());
		assertTrue("testObtenerAmigoByNombre correcto",a1!=null);
	}

}
