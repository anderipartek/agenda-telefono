package com.ipartek.agenda.interfaces;

import java.util.HashMap;

import com.ipartek.agenda.bean.Amigo;

public interface IModeloAmigable {

	/**
	 * Insertar amigos en la agenda
	 * 
	 * @param a Amigo a insertar
	 * @return id del alumno o -1 en caso de error
	 */
	public int insertar(final Amigo a);

	/**
	 * Modificar un amigo de la agenda
	 * 
	 * @param a Amigo a modificar
	 * @param id Identificador del amigo
	 * @return TRUE si se ha modificado, FALSE si no se ha podido modificar
	 */
	public boolean modificar(final Amigo a, final int id);

	/**
	 * Eliminar un amigo de la agenda
	 * 
	 * @param id Identificador del amigo
	 * @return TRUE si se ha eliminado, FALSE si no se ha podido eliminar
	 */
	public boolean eliminar(final int id);

	/**
	 * Para obtener todos los amigos que tenemos en la agenda
	 * 
	 * @return una lista de amigos
	 */
	public HashMap<Integer, Amigo> recogerTodos();

	/**
	 * Para poder recoger los datos de un amigo de la agenda
	 * 
	 * @param nombre del amigo que queremos buscar
	 * @return todos los datos del amigo, Devuelve amigo por defecto si no se ha encotrado el amigo
	 */
	public Amigo recogerUno(final String nombre);
}
