package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;


public interface IDAOAmigo {
	
	
	/**
	 * Crear nueva agenda
	 * @return true si la agenda fue creada correctamente
	 */
	boolean createAgenda();

	/**
	 * Creamos un nuevo contacto en la agenda
	 * @param Amigo a insertar
	 */
	int insertarAmigo(Amigo a);
	
	/**
	 * Devuelve un array con todos los contactos
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Devuelve un contacto con todos sus datos
	 * @return
	 */
	Amigo getByNombre(String nombre);
	
	/**
	 * Borrar un contacto de la agenda
	 * @param id del contacto
	 * @return true si el contacto se ha borrado satisfactoriamente
	 */
	boolean delete(int id);
	
	/**
	 * Modificamos algun atributo de un contacto
	 * @param id del contacto
	 * @return true si el contacto se ha cambiado correctamente
	 */
	boolean update(Amigo a, int id);
	
}
