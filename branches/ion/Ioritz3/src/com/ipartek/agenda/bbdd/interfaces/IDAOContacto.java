package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Contacto;



public interface IDAOContacto {
	
	/**
	 * Obtenemos todos los contactos de la BBDD
	 * @return [ArrayList<T>] todos los contactos sin filtro
	 */
	ArrayList<Contacto> getAll();
	

}
