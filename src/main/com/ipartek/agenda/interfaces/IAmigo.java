package com.ipartek.agenda.interfaces;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;

public interface IAmigo {
	
/**
 * Insertar amigo
 * @param a
 * @return
 */
  int insertarAmigo(Amigo a);
/**
 * Borrar amigo 
 * @param id
 * @return
 */
  boolean delete(int id);
 
  int update(Amigo a,int id);
 
  ArrayList<Amigo> getAll();

  Amigo obtenerAmigoByID(int id);

  Amigo obtenerAmigoByNombre(String nombre);
    
    
    
    
}
