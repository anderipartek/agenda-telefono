package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

public interface IDAOAmigo {
	
	/**
	 * Insertamos un amigo dentro de la tabla
	 * @param a Amigo
	 * @return [int] identificador del nuevo amigo insertado en la bbdd, en caso de fallo retorna -1
	 */
	int insertAlumno( Amigo a );
	
	/**
	 * Obtenemos todos los amigos de la BBDD
	 * @return [ArrayList<T>] todos los amigos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos una lista de amigos con un mismo nombre
	 * @param nombre del amigo
	 * @return [Amigo] amigo
	 */
	ArrayList<Amigo> getByNombre( String nombre );
	
	/**
	 * Obtenemos un amigo por su numero de telefono movil
	 * @param movil del amigo
	 * @return [Amigo] amigo
	 */
	Amigo getByMovil( String movil );
	
	/**
	 * Obtenemos un amigo por su ID
	 * @param identificador del amigo
	 * @return [Amigo] amigo
	 */
	Amigo getById( int id );
	
	/**
	 * Eliminar amigo por su identificador
	 * @param identificador del amigo
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	
	
	/**
	 * Modificar amigo seleccionado
	 * @param a amigo a modificar
	 * @param identificador del amigo
	 * @return true si se ha modificado, false en caso contrario
	 */
	boolean update( Amigo a, int id );

}
