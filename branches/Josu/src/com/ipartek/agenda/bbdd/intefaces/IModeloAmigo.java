package com.ipartek.agenda.bbdd.intefaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

public interface IModeloAmigo {

	
	/**
	 * Obtenemos todos los amigos de la dao
	 * @return [ArrayList<T>] todos los amigos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	public int insert(Amigo a);
}
