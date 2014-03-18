package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.main.bean.Amigo;

public interface IModelAmigo {
	/**
	 * Obtenemos todos los amigos de la dao
	 * @return [ArrayList<T>] todos los Amigo sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos un Amigo por su nombre
	 * @param nombre del alumno
	 * @return [Amigo] amigo
	 */
	Amigo getAlumnoByNombre( String nombre);
	
	/**
	 * Modificar Amigo seleccionado
	 * @param a Amigo a modificar
	 * @param nombre del Amigo
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Amigo a, String nombre );
	
	
	/**
	 * Insertar amigo nuevo
	 * @param a Amigo a insertar
	 * @return el id del amigo nuevo insertado
	 */
	public int insert(Amigo a);
	
	/**
	 * Eliminar Amigo por su identificador
	 * @param nombre del Amigo
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( String nombre );	
}
