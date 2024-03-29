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
	 * Metodo que obtiene Amigos por nombre
	 * @param nombre a buscar
	 * @return ArrayList<Amigo> amigos
	 */
	//public ArrayList<Amigo> obtenerAmigosByNombre(String nombre);
	
	/**
	 * Obtenemos un amigo con ese id
	 * @return
	 */
	Amigo getById( String id );
	
	/**
	 * Modificar amigo seleccionado
	 * @param a amigo a modificar
	 * @param identificador del amigo
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Amigo a, int id );
}
