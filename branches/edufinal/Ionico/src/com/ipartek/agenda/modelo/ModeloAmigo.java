package com.ipartek.agenda.modelo;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.interfaces.IAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.DAOAmigo;


public class ModeloAmigo {
	
	static ConnectionFactory factoria;
	static IAmigo daoAmigo;
	
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
