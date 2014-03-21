package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;;


public interface IModeloAmigo{
	
	/**
	 * Obtenemos todos los alumnos de la dao
	 * @return [ArrayList<T>] todos los alumnos sin filtro
	 */
	ArrayList<Amigo> getAll();
	

}
