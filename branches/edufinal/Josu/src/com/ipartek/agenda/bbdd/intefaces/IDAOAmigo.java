package com.ipartek.agenda.bbdd.intefaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;


public interface IDAOAmigo {

	/**
	 * Insertamos un alumno dentro de la tabla
	 * @param a Alumno
	 * @return [int] identificador del nuevo alumno insertado en la bbdd, en caso de fallo retona -1
	 */
	int insertAmigo( Amigo a );
	
	/**
	 * Obtenemos todos los amigos de la BBDD
	 * @return [ArrayList<T>] todos los amigos sin filtro
	 */
	ArrayList<Amigo> getAll();
	

	/**
	 * Obtenemos todos los amigos con ese nombre
	 * @return
	 */
	//ArrayList<Amigo> getByNombre(String nombre);
	
	/**
	 * Obtenemos un amigo con ese id
	 * @return
	 */
	Amigo getById( String id );
}
