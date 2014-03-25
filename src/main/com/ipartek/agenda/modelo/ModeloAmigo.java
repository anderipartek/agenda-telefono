package com.ipartek.agenda.modelo;

import java.util.ArrayList;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IAmigo;


public class ModeloAmigo  {

	static ConnectionFactory factoria;
	static IAmigo daoAmigo;
	
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
	public boolean modificar( Amigo a, int id) {
		boolean result = true;
		if (!daoAmigo.modificar(a,id)) {
			result = false;
		
		}
		return result;
	}
	public ArrayList<Amigo> obtenerAmigoByNombre(String nombre) {
		// TODO Auto-generated method stub
		ArrayList<Amigo> listaPorNombre = new ArrayList<Amigo>();
		listaPorNombre = daoAmigo.obtenerAmigoByNombre(nombre);
		return listaPorNombre;
		
	}
}
