package com.ipartek.agenda.database;

import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.interfaces.IDAOAmigo;

/**
 * 
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 */
public class ModeloAmigo {
	static ConnectionFactory factoria;
	static IDAOAmigo daoAmigo;

	/**
	 * Constructor por defecto.
	 */
	public ModeloAmigo() {
		daoAmigo = factoria.getInstance().getDAOAmigo();
	}

	/**
	 * Añade amigo a la bbdd.
	 * 
	 * @param amigo
	 *            a insertar
	 * @return id del amigo, -1 si falla
	 */
	public final int add(final Amigo amigo) {
		return daoAmigo.add(amigo);
	}

	/**
	 * Obtiene todos los amigos guardados.
	 * 
	 * @return lista con los amigos
	 */
	public final ArrayList<Amigo> getAll() {
		return daoAmigo.getAll();
	}

	/**
	 * Obtiene lisa de usuarios por nombre.
	 * 
	 * @param value
	 *            nombre a buscar
	 * @return lista de usuarios
	 */
	public final ArrayList<Amigo> getByName(final String value) {
		return daoAmigo.getByName(value);
	}

	/**
	 * Obtiene amigo por Id.
	 * 
	 * @param id
	 *            a buscar
	 * @return amigo
	 */
	public final Amigo getById(final int id) {
		return daoAmigo.getById(id);
	}

	/**
	 * Actualiza un amigo en la bd.
	 * 
	 * @param amigo
	 *            a actualizar
	 * @return true si se actualiza bien, false si no
	 */
	public final boolean update(final Amigo amigo) {
		return daoAmigo.update(amigo);
	}

	/**
	 * Elimina el amigo especificado.
	 * 
	 * @param id
	 *            del amigo a eliminar
	 * @return true si se ha eliminado, false si no
	 */
	public final boolean delete(final int id) {
		return daoAmigo.delete(id);

	}

}
