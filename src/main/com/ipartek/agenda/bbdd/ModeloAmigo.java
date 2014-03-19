package com.ipartek.agenda.bbdd;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IAmigable;
/**
 * Clase que esconde al usuario la conexion a la factoría y al DAOAmigo
 * @author Eduardo Monterrubio
 *
 */
public class ModeloAmigo{
	static ConnectionFactory factoria;
	static IAmigable daoAmigo;
	
	public ModeloAmigo() {
		factoria = ConnectionFactory.getInstance(); 
		daoAmigo = factoria.getDAOAmigo();
	}	
	
	public Amigo getAlumnoByNombre(String nombre) {
		
		Amigo a = null;
		a=daoAmigo.obtenerAmigoByNombre(nombre);
		return a;
	}

	
	public Amigo getAlumnoById(int id) {
		Amigo a = null;
		a = daoAmigo.obtenerAmigoByID(id);
		return a;
	}

	
	public ArrayList<Amigo> getAll() {
		Amigo a = null;
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getAll();
		return listaAmigos;
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
