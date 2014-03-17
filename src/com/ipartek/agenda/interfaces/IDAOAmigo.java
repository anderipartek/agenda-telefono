package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

/**
 * Interfaz que define los métodos para las operaciones con la base de datos
 * @author Patricia Navascués
 * @version 1.0
 *
 */
public interface IDAOAmigo {
	
	/**
	 * Crear la tabla amigos siempre que no exista
	 */
	boolean createTable();
	
	/**
	 * Insertamos un amigo dentro de la tabla
	 * @param a Amigo
	 * @return [int] identificador del nuevo alumno insertado en la bbdd
	 */
	int insertAlumno( Amigo a );
	
	/**
	 * Obtenemos todos los amigos de la BBDD
	 * @return [ArrayList<T>] todos los alumnos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos un amigos por su DNI
	 * @param noombre del alumno
	 * @return [Alumno] alumno
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
	 * @param identificador del amigo
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	
	
	/**
	 * Modificar alumno seleccionado
	 * @param a amigo a modificar
	 * @param identificador del amigo
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Amigo a, int id );
	
}
	
	


