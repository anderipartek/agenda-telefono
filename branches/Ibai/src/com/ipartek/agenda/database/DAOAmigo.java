package com.ipartek.agenda.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.interfaces.IDAOAmigo;

/**
 * DAO para gestionar las operaciones contra la base de datos de la clase amigo.
 * 
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 */
public class DAOAmigo implements IDAOAmigo {
	private static final Logger log = Logger.getLogger(DAOAmigo.class);

	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Connection con;
	// Datos tabla
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String APELLIDO = "apellido";
	public static final String CALLE = "calle";
	public static final String CP = "cp";
	public static final String LOCALIDAD = "localidad";
	public static final String PROVINCIA = "provincia";
	public static final String MOVIL = "movil";
	public static final String FIJO = "fijo";
	public static final String ANOTACIONES = "anotaciones";
	
	private String sqlId;
	private String sqlAll;





	@Override
	public final int add(final Amigo amigo) {
		String sqlInsert = "INSERT INTO `agenda`.`amigos` "
				+ "(`nombre`, `apellido`, `calle`, `cp`, `localidad`,"
				+ " `provincia`, `movil`, `fijo`, `anotaciones`)"
				+ " VALUES (?,?,?,?,?,?,?,?,?);";

		sqlId = "select max(id) from amigos;";
		int id = -1;
		try {
			con = ConnectionFactory.getInstance().getConnection();
			pst = con.prepareStatement(sqlInsert);
			setPst(amigo);
			if (pst.executeUpdate() > 0) {
				pst = con.prepareStatement(sqlId);
				rs = pst.executeQuery();
				rs.next();
				id = (rs.getInt(1));
				amigo.setId(id);
				log.trace("Amigo " + amigo.getNombre() + " insertado");
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
			id = -1;
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al insertar alumno"
					+ ex.getStackTrace());
			id = -1;
		}

		return id;
	}

	@Override
	public final ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAmigos = null;
		Amigo amigo;
		sqlAll = "SELECT * FROM agenda.amigos";

		try {
			con = ConnectionFactory.getInstance().getConnection();
			listaAmigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				amigo = new Amigo();
				datosAmigo(rs, amigo);
				listaAmigos.add(amigo);
			}
			log.trace("Obtenidos " + listaAmigos.size() + " amigos");
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido"
					+ " al recoger todos los datos de alumnos");
		}
		return listaAmigos;
	}

	@Override
	public final ArrayList<Amigo> getByName(final String nombre) {
		ArrayList<Amigo> listaAmigos = null;
		Amigo amigo;
		sqlAll = "SELECT * FROM agenda.amigos where nombre like ?;";

		try {
			con = ConnectionFactory.getInstance().getConnection();
			listaAmigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			pst.setString(1, nombre + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				amigo = new Amigo();
				datosAmigo(rs, amigo);
				listaAmigos.add(amigo);
			}
			log.trace("Obtenidos " + listaAmigos.size() + " amigos con nombre " + nombre);
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido"
					+ " al recoger todos los datos de alumnos");
		}
		return listaAmigos;
	}

	@Override
	public final Amigo getById(final int id) {
		String sql = "SELECT * FROM agenda.amigos where id = ?";
		Amigo amigo = null;
		try {
			con = ConnectionFactory.getInstance().getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				amigo = new Amigo();
				datosAmigo(rs, amigo);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido"
					+ " al recoger un alumno por id.");
		}
		return amigo;
	}

	@Override
	public final boolean update(final Amigo amigo) {
		boolean result = false;
		String sqlUpdate = "UPDATE `agenda`.`amigos` SET `nombre`=?,"
				+ " `apellido`=?, `calle`=?, `cp`=?, `localidad`=?,"
				+ " `provincia`=?, `movil`=?, `fijo`=?,"
				+ " `anotaciones`=? WHERE `id`=?";

		try {
			con = ConnectionFactory.getInstance().getConnection();
			pst = con.prepareStatement(sqlUpdate);
			setPst(amigo);
			if (pst.executeUpdate() == 1) {
				result = true;
				log.trace(amigo.getNombre() + " modificado");
			} else {
				result = false;
				log.error("Error al modificar el amigo " + amigo.getNombre());
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al borrar.");
		}

		return result;
	}

	@Override
	public final boolean delete(final int id) {
		boolean result = false;
		String sqlDelete = "DELETE FROM agenda.amigos WHERE id=?";
		try {
			con = ConnectionFactory.getInstance().getConnection();
			pst = con.prepareStatement(sqlDelete);
			pst.setInt(1, id);
			if ((pst.executeUpdate()) == 1) {
				result = true;
				log.trace("Amigo con id " + id + " eliminado");
			} else {
				result = false;
				log.error("Error ale limnar amigo con id " + id);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al borrar.");
		}
		return result;

	}

	/**
	 * Introduce los datos de un amigo en un pst para hacer operaciones.
	 * 
	 * @param amigo datos del amigo
	 * @throws SQLException exception de sql
	 */

	private void setPst(final Amigo amigo) throws SQLException {
		pst.setString(1, amigo.getNombre());
		pst.setString(2, amigo.getApellido());
		pst.setString(3, amigo.getCalle());
		pst.setInt(4, amigo.getCp());
		pst.setString(5, amigo.getLocalidad());
		pst.setString(6, amigo.getProvincia());
		pst.setInt(7, amigo.getMovil());
		pst.setInt(8, amigo.getFijo());
		pst.setString(9, amigo.getAnotaciones());
		// Si el id es mayor que 0 significa que es una modificacion, si no es
		// una creacion y no introduciremos el id
		if (amigo.getId() > -1) {
			pst.setInt(10, amigo.getId());
		}

	}

	/**
	 * Parsea un ResultSet en un Amigo.
	 * 
	 * @param rsParam resultset
	 * @param amigo a crear
	 *            ResultSet
	 */
	private void datosAmigo(final ResultSet rsParam, final Amigo amigo) {
		try {
			amigo.setId(rsParam.getInt(ID));
			amigo.setNombre(rsParam.getString(NOMBRE));
			amigo.setApellido(rsParam.getString(APELLIDO));
			amigo.setCalle(rsParam.getString(APELLIDO));
			amigo.setCp(rsParam.getInt(CP));
			amigo.setLocalidad(rsParam.getString(LOCALIDAD));
			amigo.setProvincia(rsParam.getString(PROVINCIA));
			amigo.setMovil(rsParam.getInt(MOVIL));
			amigo.setFijo(rsParam.getInt(FIJO));
			amigo.setAnotaciones(rsParam.getString(ANOTACIONES));
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		}

	}

	/**
	 * Parsea una SQLException para añadirla al log.
	 * 
	 * @param ex
	 */
	private void sqlExcepcion(SQLException ex) {
		while (ex != null) {
			log.error("Message:> " + ex.getMessage());
			log.error("SQL State:> " + ex.getSQLState());
			log.error("Error Code:> " + ex.getErrorCode());
			log.error("Cause:> " + ex.getCause());
			ex = ex.getNextException();
		}
	}
}
