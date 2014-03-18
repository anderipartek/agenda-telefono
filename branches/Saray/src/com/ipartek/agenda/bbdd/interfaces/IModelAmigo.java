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
	 * Modificar alumno seleccionado
	 * @param a alumno a modificar
	 * @param identificador del alumno
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Alumno a, int id );
	/**
	 * Modificar alumno seleccionado
	 * @param a alumno a modificar
	 * @param identificador del alumno
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update(ArrayList<Calificacion> lista, int id);
	
	public int insert(Alumno a);
	public boolean insert(ArrayList<Calificacion> c);

	

	/**
	 * Eliminar alumno por su identificador
	 * @param identificador del alumno
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	
}
