package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

/**
 * Interface con todos os metodos que se ejecutaran en el DAO
 * @author Saray Carralero
 *@version 1.0
 */
public interface IDAOAmigo {
	
	/**
	 * Insertamos un Amigo dentro de la tabla
	 * @param a Amigo
	 * @return [int] identificador del nuevo alumno insertado en la bbdd, en caso de fallo retona -1
	 */
	int insertAmigo(Amigo a);
	
	/**
	 * Obtenemos todos los alumnos de la BBDD
	 * @return [ArrayList<T>] todos los alumnos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos un listado de Amigo por su Nombre
	 * @param nombre del Amigo
	 * @return [Amigo] amigo
	 */
	ArrayList<Amigo> getByNombre( String nombre );
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Amigo getById(int id);
	
	/**
	 * Obtenemos el id del amigo y lo borramos
	 * @param id
	 * @return true si el amigo se ha eliminado y false si no se ha eliminado
	 */
	boolean delete( int id );	
	
	/**
	 * Modificar alumno seleccionado
	 * @param a amigo a modificar
	 * @param id identificador del amigo
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Amigo a, int id);
	
}
