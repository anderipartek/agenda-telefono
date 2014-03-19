package com.ipartek.agenda.modelo;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.controller.AgendaServlet;
import com.ipartek.agenda.interfaces.IAmigable;
import com.ipartek.agenda.interfaces.IModeloAmigable;

public class ModeloAmigo implements IModeloAmigable {
	static final Logger log = Logger.getLogger(AgendaServlet.class);
	static ConnectionFactory factoria;
	static IAmigable daoAmigo;

	public ModeloAmigo() {
		daoAmigo = factoria.getInstance().getDAOAmigo();
	}

	@Override
	public int insertar(final Amigo a) {
		int id;
		id = daoAmigo.insertAmigo(a);
		if (id == -1) {
			log.error("Error ocurrido al insertar amigo en ModeloAmigo");
		}
		return id;
	}

	@Override
	public boolean modificar(final Amigo a, final int id) {
		boolean result = true;
		if (!daoAmigo.updateAmigo(a, id)) {
			result = false;
			log.error("Error ocurrido al modificar amigo en ModeloAmigo");
		}
		return result;
	}

	@Override
	public boolean eliminar(final int id) {
		boolean result = true;
		if (!daoAmigo.deleteAmigo(id)) {
			result = false;
			log.error("Error ocurrido al eliminar amigo en ModeloAmigo");
		}
		return result;
	}

	@Override
	public HashMap<Integer, Amigo> recogerTodos() {
		HashMap<Integer, Amigo> listaAmigos = daoAmigo.getAllAmigo();
		return listaAmigos;
	}

	@Override
	public Amigo recogerUno(final String nombre) {
		Amigo amigo = daoAmigo.getAmigoByName(nombre);
		if (amigo == null) {
			amigo = new Amigo();
		}
		return amigo;
	}

	@Override
	public HashMap<Integer, Amigo> recogerPorNombre(final String nombre) {
		HashMap<Integer, Amigo> listaPorNombre;
		listaPorNombre = daoAmigo.getAllByName(nombre);
		return listaPorNombre;
	}
}
