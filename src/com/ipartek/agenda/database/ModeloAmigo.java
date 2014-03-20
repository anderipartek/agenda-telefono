package com.ipartek.agenda.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.interfaces.IDAOAmigo;



public class ModeloAmigo {
	static ConnectionFactory factoria;
	static IDAOAmigo DAOAmigo;


	public ModeloAmigo() {
		DAOAmigo = factoria.getInstance().getDAOAmigo();
	}
	
	public int add(Amigo amigo) {
		return DAOAmigo.add(amigo);
	}

	public ArrayList<Amigo> getAll() {
		return DAOAmigo.getAll();
	}

	
	public ArrayList<Amigo> getByName(String value) {
		return DAOAmigo.getByName(value);
	}

	
	public Amigo getById(int id) {
		return DAOAmigo.getById(id);
	}

	public boolean update(Amigo amigo) {
		return DAOAmigo.update(amigo);
	}

	public boolean delete(int id) {
		return DAOAmigo.delete(id);

	}

}
