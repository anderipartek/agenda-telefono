package com.ipartek.agenda.bbdd;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.intefaces.IDAOAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bbdd.ConnectionFactory;


public class ModeloAmigo {
	
	static ConnectionFactory factoria;
	static IDAOAmigo daoAmigo;
	
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
	
}
