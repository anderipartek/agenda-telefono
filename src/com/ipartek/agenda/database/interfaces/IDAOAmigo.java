package com.ipartek.agenda.database.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

public interface IDAOAmigo {

	/**
	 * Añade un contacto en la tabla amigos de la DB agenda.
	 * 
	 * @param amigo
	 *            a añadir
	 * @return [true] si la operacion ha tenido exito [false] si ha ocurrido
	 *         algun error durante la operacion.
	 */
	boolean add(Amigo amigo);

	/**
	 * Devuelve todos los amigos en la tabla amigos de la DB agenda
	 * 
	 * @return ArrayList<Amigo>
	 */
	ArrayList<Amigo> getAll();

	/**
	 * Devuelve todos los amigos en la tabla amigos de la DB agenda que empiezen
	 * por la cadena de caracteres value
	 * 
	 * @param value
	 *            Cadena de caracteres a buscar
	 * @return ArrayList<Amigo>
	 */
	ArrayList<Amigo> getByName(String value);

	/**
	 * Devuelve el amigo en la tabla amigos de la DB agenda que coincida con el
	 * id
	 * 
	 * @param id
	 *            del amigo a buscar
	 * @return Amigo
	 */
	Amigo getById(int id);

	/**
	 * Modifica un contacto en la tabla amigos de la DB agenda. Para modificar
	 * se usa el id de amigo y se actualiza con los parametros del objeto
	 * 
	 * @param amigo
	 *            a modificar
	 * @return [true] si la operacion ha tenido exito [false] si ha ocurrido
	 *         algun error durante la operacion.
	 */
	boolean update(Amigo amigo);

	/**
	 * Elimina un contacto en la tabla amigos de la DB agenda. Para eliminar se
	 * usa el id de amigo.
	 * 
	 * @param amigo
	 *            a eliminar
	 * @return [true] si la operacion ha tenido exito [false] si ha ocurrido
	 *         algun error durante la operacion.
	 */
	boolean delete(Amigo amigo);

}
