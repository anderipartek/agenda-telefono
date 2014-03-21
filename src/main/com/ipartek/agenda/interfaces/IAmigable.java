package com.ipartek.agenda.interfaces;

import java.util.HashMap;

import com.ipartek.agenda.bean.Amigo;

public interface IAmigable {

	int insertAmigo(Amigo a);

	public HashMap<Integer, Amigo> getAll();

	public HashMap<Integer, Amigo> getAllByName(final String nombre);

	boolean delete(int id);

	boolean update(Amigo a, int id);

	Amigo getAmigoByName(final String nombre);
}
