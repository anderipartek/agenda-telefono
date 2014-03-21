package com.ipartek.agenda.modelo;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IDAOAmigo;


public class ModeloAmigo  {

	static ConnectionFactory factoria;
	static IDAOAmigo daoAmigo;
	
	public ModeloAmigo(){
		daoAmigo = factoria.getInstance().getDAOAmigo();
	}
	public int insert(Amigo a) {
		boolean result = false;
		int insertado = -1;
		insertado = daoAmigo.insertarAmigo(a);		
		return insertado;
	}
	public ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getAll();
		return listaAmigos;
	
	}
	public boolean delete(int id) {
		boolean result = true;
		if (!daoAmigo.delete(id)) {
			result = false;
			
		}
		return result;
	}
}
