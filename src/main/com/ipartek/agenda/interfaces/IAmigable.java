package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
/**
 * Interfaz que declara los m�todos que podr� utilizar la clase DAOAmigo
 * @author Eduardo Monterrubio
 *
 */
public interface IAmigable {
	
    /**
     * Metodo que inserta un amigo en la base de datos
     * @param a Amigo
     * @return id en caso de insertado, -1 en caso contrario
     */
    public int insertarAmigo(Amigo a);
    /**
     * Metodo que elimina un amigo por id
     * @param id del Amigo a borrar
     * @return id del Amigo en caso correcto, -1 en caso incorrecto
     */
    public int delete(int id);
    /**
     * Metodo que modifica un amigo por id
     * @param a Amigo del Amigo a modificar
     * @param id del Amigo a modificar
     * @return id del Amigo en caso correcto, -1 en caso incorrecto
     */
    public int update(Amigo a,int id);
    /**
     * Metodo que obtiene todos los amigos de la BD y lo almacena en un ArrayList<Amigo>
     * @return ArrayList<Amigo> amigos
     */
    public ArrayList<Amigo> getAll();
    /**
     * Metodo que obtiene un Amigo por id
     * @param id del Amigo a obtener
     * @return a Amigo
     */
    public Amigo obtenerAmigoByID(int id);
    /**
     * Metodo que obtiene Amigos por nombre
     * @param nombre a buscar
     * @return ArrayList<Amigo> amigos
     */
    public ArrayList<Amigo> obtenerAmigosByNombre(String nombre);
    
    
    
    
}
