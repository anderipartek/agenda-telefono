package com.ipartek.agenda.interfaces;

import java.util.HashMap;

import com.ipartek.agenda.bean.Amigo;

/**
 * Interfaz de acceso a BBDD para.
 * <ul>
 * <li>INSERTAR</li>
 * <li>ELIMINAR</li>
 * <li>MODIFICAR</li>
 * <li>RECUPERAR</li>
 * </ul>
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public interface IAmigable {

	/**
	 * Para insertar un amigo a la agenda.
	 * 
	 * @param a es el Amigo
	 * @return [int] -1 si ha ocurrido un error / identificador del amigo
	 */
	int insertAmigo(Amigo a);

	/**
	 * Para eliminar un amigo de la lista.
	 * 
	 * @param id Identificador del amigo
	 * @return TRUE si se ha borrado / FALSE si no se ha podido borrar
	 */
	boolean deleteAmigo(int id);

	/**
	 * Para modificar los datos de un amigo.
	 * 
	 * @param a es el Amigo
	 * @param id Identificador del amigo a modificar
	 * @return TRUE si se ha modificado / FALSE si no se ha podido modificar
	 */
	boolean updateAmigo(Amigo a, int id);

	/**
	 * Para recoger todos los datos de los amigo.
	 * 
	 * @return HashMap con todos los amigo
	 */
	HashMap<Integer, Amigo> getAllAmigo();

	/**
	 * Para recoger todos los datos de amigos que coincidan con el nombre.
	 * 
	 * @return Una lista de la gente que coincida con el nombre / NULL en caso
	 *         de no encontrar nada
	 * @param nombre del amigo
	 */
	HashMap<Integer, Amigo> getAllByName(String nombre);

	/**
	 * Para recoger los datos de un amigo.
	 * 
	 * @param nombre Nombre del amigo
	 * @return [Amigo] buscado / null en caso de error
	 */
	Amigo getAmigoByName(String nombre);

}
