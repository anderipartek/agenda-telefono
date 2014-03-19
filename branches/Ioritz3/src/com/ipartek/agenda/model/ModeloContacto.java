package com.ipartek.agenda.model;
import java.util.ArrayList;

import com.ipartek.agenda.bbdd.interfaces.IDAOContacto;
import com.ipartek.agenda.bbdd.interfaces.IModeloContacto;
import com.ipartek.agenda.basedatos.DAOContacto;
import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.basedatos.ConnectionFactory;


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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insert(Contacto c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insert(ArrayList<Contacto> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
