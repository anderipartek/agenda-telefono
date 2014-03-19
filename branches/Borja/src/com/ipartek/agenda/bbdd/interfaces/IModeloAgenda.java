package com.ipartek.agenda.bbdd.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;


public interface IModeloAgenda {
	
	/**
	 * Obtenemos todos los amigos de la bd
	 * @return [ArrayList<T>] todos los amigos sin filtro
	 */
	ArrayList<Amigo> getAll();
	
	/**
	 * Obtenemos un amigo por su ID
	 * @param ID del amigo
	 * @return [Amigo] amigo
	 */
	Amigo getAmigoById( int id );
	
	/**
	 * Obtenemos un amigo por su movil
	 * @param movil del amigo
	 * @return [Amigo] amigo
	 */
	
	Amigo getAmigoByMovil(String movil);
	
	/**
	 * Obtenemos todos los amigos de la bd con un nombre determinado
	 * @return [ArrayList<T>] todos los amigos con el nombre obtenido por parametro
	 */
	ArrayList<Amigo> getAmigoByNombre (String nombre);
	
	
	/**
	 * Modificar amigo seleccionado
	 * @param a amigo a modificar
	 * @param identificador del amigo
	 * @return true si se a modificado, false en caso contrario
	 */
	boolean update( Amigo a, int id );

	
	/**
	 * Inserta un amigo 
	 * @param a amigo a insertar
	 * @return identificador del amigo si se ha insertado, -1 en caso contrario
	 */
	public int insert(Amigo a);
	
	

	/**
	 * Eliminar amigo por su identificador
	 * @param identificador del amigo
	 * @return true si se a borrado, false en caso contrario
	 */
	boolean delete( int id );	

}
