package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Contacto;


public interface IModeloContacto {
	
	/**
	 * Obtenemos todos los alumnos de la dao
	 * @return [ArrayList<T>] todos los alumnos sin filtro
	 */
	ArrayList<Contacto> getAll();
	

}
