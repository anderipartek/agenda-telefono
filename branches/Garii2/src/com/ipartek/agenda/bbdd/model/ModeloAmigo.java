package com.ipartek.agenda.bbdd.model;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IAmigable;

public class ModeloAmigo implements IAmigable {

	final int ID_PRUEBA = 1;
	static ConnectionFactory factoria;
	static IAmigable daoAmigo;


	public ModeloAmigo() {
		daoAmigo = factoria.getInstance().getDAOAmigo();
		
	}



	public ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getAll();
			return listaAmigos;
	}


	public boolean update(Amigo a, int id) {
		boolean result = daoAmigo.update(a, id);
		return result;
	}

	
	
	@Override
	public boolean delete(int idAmigo) {
		boolean result = false;
		result = daoAmigo.delete(idAmigo);
		
		return result;
	}

	
	
	@Override
	public int insertAmigo(Amigo a) {
		boolean result = false;
		int insertado = -1;
		insertado = daoAmigo.insertAmigo(a);
		
		return insertado;
	}

	@Override
	public Amigo getByNombre(String nombre) {
		Amigo a = null;
		a = daoAmigo.getByNombre(nombre);
				
		return a;
	}

	@Override
	public Amigo getById(int id) {
		Amigo a = null;
		a = daoAmigo.getById(id);
		return a;
	}
}
