package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Contacto;
import com.ipartek.pruebas.bean.Alumno;



public interface IDAOContacto {
	
	/**
	 * Obtenemos todos los contactos de la BBDD
	 * @return [ArrayList<T>] todos los contactos sin filtro
	 */
	ArrayList<Contacto> getAll();
	
	/**
	 * Insertamos un contacto dentro de la tabla
	 * @param c Contacto
	 * @return [int] identificador del nuevo contacto insertado en la bbdd, en caso de fallo retona -1
	 */
	int insertContacto( Contacto c );
	
	/**
	 * Obtenemos un contacto por su ID
	 * @param identificador del alumno
	 * @return [Alumno] alumno
	 */
	Contacto getById( int id );
	
	/**
	 * Eliminar contacto por su identificador
	 * @param identificador del contacto
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	
	
	/**
	 * Modificar contacto seleccionado
	 * @param c contacto a modificar
	 * @param identificador del contacto
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Contacto c, int id );
	

}
