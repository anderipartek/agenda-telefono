package com.ipartek.agenda.interfaces;

import java.util.HashMap;

import com.ipartek.agenda.bean.Amigo;

/**
 * Interfaz para declarar los métodos necesarios para realizar operaciones
 * necesarias con la aplicacion AgendaOnline. Estas operaciones son:
 * <ul>
 * <li>Insertar amigos</li>
 * <li>Modificar amigos</li>
 * <li>Eliminar amigos</li>
 * <li>Buscar todos los amigos</li>
 * <li>Buscar amigos por nombre</li>
 * <li>Recoger un amigo especifico</li>
 * </ul>
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public interface IModeloAmigable {

	/**
	 * Insertar amigos en la agenda.
	 * 
	 * @param a Amigo a insertar
	 * @return id del alumno o -1 en caso de error
	 */
	int insertar(final Amigo a);

	/**
	 * Modificar un amigo de la agenda.
	 * 
	 * @param a Amigo a modificar
	 * @param id Identificador del amigo
	 * @return TRUE si se ha modificado, FALSE si no se ha podido modificar
	 */
	boolean modificar(final Amigo a, final int id);

	/**
	 * Eliminar un amigo de la agenda.
	 * 
	 * @param id Identificador del amigo
	 * @return TRUE si se ha eliminado, FALSE si no se ha podido eliminar
	 */
	boolean eliminar(final int id);

	/**
	 * Para obtener todos los amigos que tenemos en la agenda.
	 * 
	 * @return una lista de amigos
	 */
	HashMap<Integer, Amigo> recogerTodos();

	/**
	 * Para obtener todos los amigos que coincidan con un nombre.
	 * 
	 * @param nombre del amigo a buscar
	 * @return una lista de amigos que coincidan en el nombre
	 */
	HashMap<Integer, Amigo> recogerPorNombre(String nombre);

	/**
	 * Para poder recoger los datos de un amigo de la agenda.
	 * 
	 * @param id Identificador del amigo que queremos buscar
	 * @return todos los datos del amigo, Devuelve amigo por defecto si no se ha
	 *         encotrado el amigo
	 */
	Amigo recogerUno(final int id);

}
