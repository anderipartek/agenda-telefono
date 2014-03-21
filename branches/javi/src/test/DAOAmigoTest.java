package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ipartek.agenda.bbdd.DAOAmigo;
import com.ipartek.agenda.bean.Amigo;

public class DAOAmigoTest {
	
	DAOAmigo daoamigo;
	Amigo amigo1;
	Amigo amigo2;
	Amigo amigo3;
	ArrayList<Amigo> listaAmigos;

	public DAOAmigoTest() {
		
	}
	
	@Before
	public void setUp(){
		//Inicializamos un daoAmigo para manejar los metodos DAO
		daoamigo = new DAOAmigo();
		//Inicializamos los Amigos
		amigo1 = new Amigo();
		amigo2 = new Amigo();
		amigo1.setNombre("Javi");
		amigo2.setNombre("Jose");
		//Inicializamos el arrayList
		listaAmigos = new ArrayList<Amigo>();
		
	}
	
	@After
	public void setDown(){
		
	}
	
	@Test
	public void testInsertar(){
		int insertado = daoamigo.insertarAmigo(amigo1);
		if(insertado > 0){
			listaAmigos = daoamigo.getAll();
			assertTrue(listaAmigos.size()>0);
		}
		
		
		
	}
	
	
	@Test
	public void getAlltest(){
		
		int insertado = daoamigo.insertarAmigo(amigo1);
		int ultimo = listaAmigos.size()-1;
		if(insertado >1){
			listaAmigos = daoamigo.getAll();
		}
		assertEquals("pepe", listaAmigos.get(1).getNombre());
	}

}

