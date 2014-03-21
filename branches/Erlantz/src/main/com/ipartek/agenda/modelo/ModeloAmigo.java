package com.ipartek.agenda.modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.controller.AgendaServlet;
import com.ipartek.agenda.interfaces.IAmigable;
import com.ipartek.agenda.interfaces.IModeloAmigable;

/**
 * Modelo para realizar las operaciones de insercion, eliminacion, modificacion
 * y busquedas. Implementa la interfaz IModeloAmigable.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * @see com.ipartek.agenda.interfaces.IModeloAmigable
 * 
 */
public class ModeloAmigo implements IModeloAmigable {
	/**
	 * 
	 */
	static final Logger LOG = Logger.getLogger(AgendaServlet.class);
	/**
	 * 
	 */
	static ConnectionFactory factoria;
	/**
	 * 
	 */
	static IAmigable daoAmigo;

	/**
	 * Constructor vacío que realiza la conexión con la BBDD.
	 */
	public ModeloAmigo() {
		daoAmigo = factoria.getInstance().getDAOAmigo();
	}

	@Override
	public final int insertar(final Amigo a) {
		int id;
		id = daoAmigo.insertAmigo(a);
		if (id == -1) {
			LOG.error("Error ocurrido al insertar amigo en ModeloAmigo");
		}
		return id;
	}

	@Override
	public final boolean modificar(final Amigo a, final int id) {
		boolean result = true;
		if (!daoAmigo.updateAmigo(a, id)) {
			result = false;
			LOG.error("Error ocurrido al modificar amigo en ModeloAmigo");
		}
		return result;
	}

	@Override
	public final boolean eliminar(final int id) {
		boolean result;
		if (!daoAmigo.deleteAmigo(id)) {
			result = false;
			LOG.error("Error ocurrido al eliminar amigo en ModeloAmigo");
		} else {
			result = true;
		}
		return result;
	}

	@Override
	public final HashMap<Integer, Amigo> recogerTodos() {
		HashMap<Integer, Amigo> listaAmigos = daoAmigo.getAllAmigo();
		return listaAmigos;
	}

	@Override
	public final Amigo recogerUno(final int id) {
		Amigo amigo = daoAmigo.getAmigoById(id);
		if (amigo == null) {
			amigo = new Amigo();
		}
		return amigo;
	}

	@Override
	public final HashMap<Integer, Amigo> recogerPorNombre(final String nombre) {
		HashMap<Integer, Amigo> listaPorNombre;
		listaPorNombre = daoAmigo.getAllByName(nombre);
		return listaPorNombre;
	}
}
