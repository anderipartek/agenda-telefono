package com.ipartek.agenda.bbdd;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IAmigable;
/**
 * Clase que esconde al usuario la conexion a la factoria y al DAOAmigo
 * @author Eduardo Monterrubio
 *
 */
public class ModeloAmigo{
	static ConnectionFactory factoria;//factoria
	static IAmigable daoAmigo;        //dao
	static ArrayList<Amigo> amigos;   //amigos
	static Amigo a;                   //amigo  

	public ModeloAmigo() {
		factoria = ConnectionFactory.getInstance(); 
		daoAmigo = factoria.getDAOAmigo();
	}	
    /**
     * Metodo que recoge los amigos que coinciden en nombre
     * @param nombre del amigo
     * @return amigos ArrayList<Amigo>
     */
	public ArrayList<Amigo> getAmigosByNombre(String nombre) {

		amigos=null;
		amigos=daoAmigo.obtenerAmigosByNombre(nombre);
		return amigos;
	}

    /**
     * Metodo que recoge el amigo por id
     * @param id
     * @return Amigo a
     */
	public Amigo getAmigoById(int id) {
		a = null;
		a = daoAmigo.obtenerAmigoByID(id);
		return a;
	}

    /**
     * Metodo que recoge todos los amigos de la BD
     * @return amigos
     */
	public ArrayList<Amigo> getAll() {

		ArrayList<Amigo> amigos = new ArrayList<Amigo>();
		amigos = daoAmigo.getAll();
		return amigos;
	}

    /**
     * Metodo que actualiza un amigo por id
     * @param a Amigo
     * @param id
     * @return true si actualizado, false si no actualizado
     */
	public boolean update(Amigo a, int id) {
		int actualizado = daoAmigo.update(a, id);
		boolean result=false;
		if (actualizado>0){
			result=true;
		}
		else
			result= false;
		return result;
	}

    /**
     * Metodo que inserta un Amigo en la BD
     * @param a Amigo
     * @return true si insertado, false si no insertado
     */
	public boolean insertarAmigo(Amigo a) {
		boolean result = false;
		int insertado = 0;
		insertado = daoAmigo.insertarAmigo(a);
		if (insertado>0){
			result=true;
		}
		else
			result= false;
		return result;
	}
    /**
     * Metodo que borra el Amigo por id
     * @param id
     * @return true si borrado,false si no borrado
     */
	public boolean delete(int id) {
		boolean result = false;
		int borrado=0;
		borrado = daoAmigo.delete(id);
		if (borrado>0) {
			result=true;
		}
		else
			result=false;
		return result;
	}








}
