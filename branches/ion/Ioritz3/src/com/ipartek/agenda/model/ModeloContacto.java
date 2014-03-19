package com.ipartek.agenda.model;
import java.util.ArrayList;

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

}
