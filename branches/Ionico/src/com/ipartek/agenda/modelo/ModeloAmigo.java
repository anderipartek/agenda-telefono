package com.ipartek.agenda.modelo;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.controller.AgendaServlet;
import com.ipartek.agenda.bbdd.interfaces.IAmigo;

public class ModeloAmigo{
	static final Logger log = Logger.getLogger(AgendaServlet.class);
	static ConnectionFactory factoria;
	static IAmigo daoAmigo;

	public ModeloAmigo() {
		daoAmigo = factoria.getInstance().getDAOAmigo();
	}

	public int insertar(final Amigo a){
		int id;
		id = daoAmigo.insertarAmigo(a);
		if (id == -1) {
			log.error("Error ocurrido al insertar amigo en ModeloAmigo");
		}
		return id;
	}

	public boolean modificar(final Amigo a, final int id) {
		boolean result = true;
		if (!daoAmigo.modificarAmigo(a, id)) {
			result = false;
			log.error("Error ocurrido al modificar amigo en ModeloAmigo");
		}
		return result;
	}

	public boolean eliminar(final int id) {
		boolean result = true;
		if (!daoAmigo.borrarAmigo(id)) {
			result = false;
			log.error("Error ocurrido al eliminar amigo en ModeloAmigo");
		}
		return result;
	}

	public ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();
		listaAmigos = daoAmigo.getAll();
		return listaAmigos;
	}
}
