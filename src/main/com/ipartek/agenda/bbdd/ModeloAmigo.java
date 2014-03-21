package com.ipartek.agenda.bbdd;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IAmigable;
/**
 * Clase que esconde al usuario la conexion a la factor�a y al DAOAmigo
 * @author Eduardo Monterrubio
 *
 */
public class ModeloAmigo{
	static ConnectionFactory factoria;
	static IAmigable daoAmigo;
	static ArrayList<Amigo> amigos;
	static Amigo a;

	public ModeloAmigo() {
		factoria = ConnectionFactory.getInstance(); 
		daoAmigo = factoria.getDAOAmigo();
	}	

	public ArrayList<Amigo> getAmigosByNombre(String nombre) {

		amigos=null;
		amigos=daoAmigo.obtenerAmigosByNombre(nombre);
		return amigos;
	}


	public Amigo getAmigoById(int id) {
		a = null;
		a = daoAmigo.obtenerAmigoByID(id);
		return a;
	}


	public ArrayList<Amigo> getAll() {

		ArrayList<Amigo> amigos = new ArrayList<Amigo>();
		amigos = daoAmigo.getAll();
		return amigos;
	}


	public boolean update(Amigo a, int id) {
		int actualizado = daoAmigo.update(a, id);
		boolean result=false;
		if (actualizado>0){
			result=true;
		}
		else
			result= false;
		return result;
	}


	public boolean insertarAmigo(Amigo a) {
		boolean result = false;
		int insertado = 0;
		insertado = daoAmigo.insertarAmigo(a);
		if (insertado>0){
			result=true;
		}
		else
			result= false;
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		int borrado=0;
		borrado = daoAmigo.delete(id);
		if (borrado>0) {
			result=true;
		}
		else
			result=false;
		return result;
	}








}