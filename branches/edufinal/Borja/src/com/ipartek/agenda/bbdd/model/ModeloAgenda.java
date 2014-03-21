package com.ipartek.agenda.bbdd.model;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.interfaces.IDAOAmigo;
import com.ipartek.agenda.bbdd.interfaces.IModeloAgenda;
import com.ipartek.agenda.bean.Amigo;



public class ModeloAgenda implements IModeloAgenda {
	
	final int ID_PRUEBA = 1;
	static ConnectionFactory factoria;
	static IDAOAmigo daoAmigo;
	

	public ModeloAgenda() {
		
		daoAmigo = factoria.getInstance().getDAOAmigo();
		
	}

	@Override
	public Amigo getAmigoByMovil(String movil) {
		Amigo a = null;
		a = daoAmigo.getByMovil(movil);
		return a;
	}

	@Override
	public Amigo getAmigoById(int id) {
		Amigo a = null;
		a = daoAmigo.getById(id);
		return a;
	}

	@Override
	public ArrayList<Amigo> getAll() {
		
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getAll();
		return listaAmigos;
	}

	@Override
	public boolean update(Amigo a, int id) {
		boolean result = daoAmigo.update(a, id);
		return result;
	}

	

	@Override
	public int insert(Amigo a) {
		
		int insertado = -1;
		insertado = daoAmigo.insertAmigo(a);
		return insertado;
	}



	@Override
	public boolean delete(int idAmigo) {
		boolean result = false;
		result = daoAmigo.delete(idAmigo);
		return result;
	}

	

	@Override
	public ArrayList<Amigo> getAmigoByNombre(String nombre) {
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getByNombre(nombre);
		return listaAmigos;
	}

	


}
