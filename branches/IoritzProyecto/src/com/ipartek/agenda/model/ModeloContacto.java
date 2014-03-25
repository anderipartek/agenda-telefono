package com.ipartek.agenda.model;
import java.util.ArrayList;
import java.util.HashMap;

import com.ipartek.agenda.bbdd.interfaces.IDAOContacto;
import com.ipartek.agenda.bbdd.interfaces.IModeloContacto;
import com.ipartek.agenda.basedatos.DAOContacto;
import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.basedatos.ConnectionFactory;
import com.ipartek.pruebas.bean.Alumno;
import com.ipartek.pruebas.bean.Calificacion;


public class ModeloContacto implements IModeloContacto{
	
	final int ID_PRUEBA = 1;
	static ConnectionFactory factoria;
	static IDAOContacto daoContacto;
	
	public ModeloContacto(){
		daoContacto = factoria.getInstance().getDAOContacto();
	}

	public ArrayList<Contacto> getAll() {
		ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
		listaContactos = daoContacto.getAll();
		return listaContactos;
	
	}

	@Override
	public Contacto getContactoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Contacto c, int id) {
		boolean result = daoContacto.update(c, id);
		return result;
	}

	@Override
	public int insert(Contacto c) {
		boolean result = false;
		int insertado = -1;
		insertado = daoContacto.insertContacto(c);
		return insertado;
	}

	@Override
	public boolean insert(ArrayList<Contacto> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		result = daoContacto.delete(id);
		return result;
	}

	@Override
	public Contacto getByNombre(String nombre) {
		Contacto c = null;
		c = daoContacto.getByNombre(nombre);
		return c;
	}

	@Override
	public Contacto getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<Integer, Contacto> recogetPorNombre(String nombreSearch) {
		// TODO Auto-generated method stub
		return null;
	}

}
