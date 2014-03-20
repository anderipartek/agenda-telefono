package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

public interface IAmigo {
	
	/**
	 * Inserta un amigo en la base de datos
	 * @param a es el Amigo
	 * @return [int] -1 si ha ocurrido un error / identificador del amigo
	 */
	public int insertarAmigo(Amigo a);

	/**
	 * Elimina un amigo
	 * @param id Identificador del amigo
	 * @return TRUE si se ha borrado / FALSE si no se ha podido borrar
	 *//*
	public boolean borrarAmigo(int id);

	*//**
	 * Modifica un amigo
	 * 
	 * @param a es el Amigo
	 * @param id Identificador del amigo a modificar
	 * @return TRUE si se ha modificado / FALSE si no se ha podido modificar
	 *//*
	public boolean modificarAmigo(Amigo a, int id);*/

	/**
	 * Para recoger todos los datos de los alumno
	 * 
	 * @return HashMap con todos los alumnos
	 */
	ArrayList<Amigo> getAll();




}
