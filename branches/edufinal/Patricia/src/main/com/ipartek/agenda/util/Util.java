package com.ipartek.agenda.util;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.modelo.ConnectionFactory;

/**
 * Clase util en donde se realizan las tareas necesarias para la búsuqeda de
 * amigos.
 * 
 * @author Patricia Navascués
 * @version 1.0
 * 
 */
public class Util {
	
	private static ArrayList<Amigo> amigosBusqueda;
	private static IDAOAmigo modeloAmigo;

	/**
	 * Método para realizar la busqueda de amigos.
	 * 
	 * @param nombre
	 *            nombre o fragmento de nombre que se va a buscar
	 * 
	 *            return listaAmigos
	 */
	public static ArrayList<Amigo> getAmigoBusqueda(String nombre) {
		
		amigosBusqueda = new ArrayList<Amigo>();
		if (nombre != null) {
			modeloAmigo = ConnectionFactory.getInstance().getDAOAmigo();
			
			amigosBusqueda = modeloAmigo.getByName(nombre);
		}

		return amigosBusqueda;
	}

}
