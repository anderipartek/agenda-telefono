package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Contacto;



public interface IModeloContacto {
	
	/**
	 * Obtenemos todos los contactos de la dao
	 * @return [ArrayList<T>] todos los contactos sin filtro
	 */
	ArrayList<Contacto> getAll();
	
	/**
	 * Obtenemos un contacto por su ID
	 * @param ID del contacto
	 * @return [Contacto] contacto
	 */
	Contacto getContactoById( int id );
	
	
	
	
	/**
	 * Modificar contacto seleccionado
	 * @param c contacto a modificar
	 * @param identificador del contacto
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Contacto c, int id );
	/**
	 * Modificar contacto seleccionado
	 * @param c alumno a modificar
	 * @param identificador del contacto
	 * @return true si se a modificado, false en caso contrario
	 */

	
	public int insert(Contacto c);
	public boolean insert(ArrayList<Contacto> c);

	

	/**
	 * Eliminar contacto por su identificador
	 * @param identificador del contacto
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	
	
	/**
	 * Buscar por nombre el contacto
	 * @param nombre nombre del contacto
	 * @return
	 */
	Contacto getByNombre( String nombre );

	
}

	


