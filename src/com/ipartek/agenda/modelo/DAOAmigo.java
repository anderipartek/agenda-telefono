package com.ipartek.agenda.modelo;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IDAOAmigo;

/**
 * Clase para implementar la interactuación con la BBDD
 * @author Patricia Navascués
 * @version 1.0
 *
 */
public class DAOAmigo implements IDAOAmigo {

	@Override
	public boolean createTable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertAlumno(Amigo a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Amigo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amigo getByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amigo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Amigo a, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
