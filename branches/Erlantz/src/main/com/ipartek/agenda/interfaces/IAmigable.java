package com.ipartek.agenda.interfaces;

import java.util.HashMap;

import com.ipartek.agenda.bean.Amigo;

/**
 * Interfaz de acceso a BBDD para:
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
	 * Para insertar un amigo a la agenda
	 * 
	 * @param a es el Amigo
	 * @return [int] -1 si ha ocurrido un error / identificador del amigo
	 */
	public int insertAmigo(Amigo a);

	/**
	 * Para eliminar un amigo de la lista
	 * 
	 * @param id Identificador del amigo
	 * @return TRUE si se ha borrado / FALSE si no se ha podido borrar
	 */
	public boolean deleteAmigo(int id);

	/**
	 * Para modificar los datos de un amigo
	 * 
	 * @param a es el Amigo
	 * @param id Identificador del amigo a modificar
	 * @return TRUE si se ha modificado / FALSE si no se ha podido modificar
	 */
	public boolean updateAmigo(Amigo a, int id);

	/**
	 * Para recoger todos los datos de los alumno
	 * 
	 * @return HashMap con todos los alumnos
	 */
	public HashMap<Integer, Amigo> getAllAmigo();

	/**
	 * Para recoger los datos de un alumno
	 * 
	 * @param nombre Nombre del amigo
	 * @return [Amigo] buscado / null en caso de error
	 */
	public Amigo getAmigoByName(String nombre);

}
