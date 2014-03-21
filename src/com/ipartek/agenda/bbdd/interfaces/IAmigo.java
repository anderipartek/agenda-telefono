package com.ipartek.agenda.bbdd.interfaces;

/**
 * Interfaz para el Amigo
 */
import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

public interface IAmigo {
	
	/**
	 * Inserta un amigo en la base de datos
	 * @param a es el Amigo
	 * @return [int] -1 si ha ocurrido un error / identificador del amigo
	 */
	int insertAmigo(Amigo a);

	/**
	 * Para recoger todos los datos de los alumno
	 * 
	 * @return HashMap con todos los alumnos
	 */
	ArrayList<Amigo> getAll();

	/**
	 * Devuelve un amigo por su id
	 * @param id
	 * @return
	 */
	Amigo getById(String id);

}
