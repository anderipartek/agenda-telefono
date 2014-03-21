package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

/**
 * Interfaz que define los métodos para las operaciones con la base de datos.
 * @author Patricia Navascués
 * @version 1.0
 *
 */
public interface IDAOAmigo {
	
	/**
	 * Crea la table si no existe, si existe devuelve un error.
	 * @return <b>true</b> si se crea correctamente, 
	 * <b>false</b>, en caso contrario
	 */
	boolean createTable();
	
	/**
	 * Insertamos un amigo dentro de la tabla.
	 * @param amigo Amigo
	 * @return [int] identificador del nuevo alumno insertado en la bbdd
	 */
	int insertAmigo(Amigo amigo);
	
	/**
	 * Obtenemos todos los amigos de la BBDD.
	 * @return [ArrayList<T>] todos los alumnos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos un amigos por su DNI.
	 * @param nombre del alumno
	 * @return [Alumno] alumno
	 */
	ArrayList<Amigo> getByName(String nombre);
	
	/**
	 * Obtenemos un amigo por su ID.
	 * @param idAmigo identificador del amigo
	 * @return [Amigo] amigo
	 */
	Amigo getById(int idAmigo);
	
	/**
	 * Eliminar alumno por su identificador.
	 * @param idAmigo identificador del amigo
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete(int idAmigo);	
	
	/**
	 * Modificar alumno seleccionado.
	 * @param amigo amigo a modificar
	 * @param idAmigo identificador del amigo
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update(Amigo amigo, int idAmigo);
	
}
	
	


