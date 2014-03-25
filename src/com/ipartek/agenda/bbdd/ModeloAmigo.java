package com.ipartek.agenda.bbdd;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.intefaces.IDAOAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bbdd.ConnectionFactory;

public class ModeloAmigo {
	
	static ConnectionFactory factoria;
	static IDAOAmigo daoAmigo;
	static ArrayList<Amigo> amigos; 
	
	public ModeloAmigo() {
		daoAmigo = factoria.getInstance().getDAOAmigo();
	}
	
	public int insert(Amigo a) {
		boolean result = false;
		int insertado = -1;
		insertado = daoAmigo.insertAmigo(a);		
		return insertado;
	}
	public ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getAll();
		return listaAmigos;
	}
	
	public boolean actualizar(Amigo a, int id) {
		boolean resultado = daoAmigo.update(a, id);
		boolean result=false;
		if (resultado== true){
			result=true;
		}
		else
			result= false;
		return result;
	}

	/*public ArrayList<Amigo> getAmigosByNombre(String nombre) {

		amigos=null;
		amigos=daoAmigo.obtenerAmigosByNombre(nombre);
		return amigos;
	}*/
	
	public Amigo getAmigoById(String id) {
		Amigo a = null;
		a = daoAmigo.getById(id);
		return a;
	}
}
