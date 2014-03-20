package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;


public interface IAmigable {
	
	
	
	/**
	 * Insertamos un alumno dentro de la tabla
	 * @param a Alumno
	 * @return [int] identificador del nuevo alumno insertado en la bbdd, en caso de fallo retona -1
	 */
	int insertAmigo( Amigo a );
	
	/**
	 * Obtenemos todos los alumnos de la BBDD
	 * @return [ArrayList<T>] todos los alumnos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos un alumno por su nombre
	 * @param nombre del amigo
	 * @return [Amigo] amigo
	 */
	Amigo getByNombre( String nombre );
	
	/**
	 * Obtenemos un amigo por su ID
	 * @param identificador del amigo
	 * @return [Amigo] amigo
	 */
	Amigo getById( int id );
	
	/**
	 * Eliminar alumno por su identificador
	 * @param identificador del alumno
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	
	
	/**
	 * Modificar alumno seleccionado
	 * @param a alumno a modificar
	 * @param identificador del alumno
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Amigo a, int id );
	
}



