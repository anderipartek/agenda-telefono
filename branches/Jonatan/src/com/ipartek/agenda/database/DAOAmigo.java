package com.ipartek.agenda.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.interfaces.IDAOAmigo;

public class DAOAmigo implements IDAOAmigo {
	static final Logger log = Logger.getLogger(DAOAmigo.class);

	static final int ERROR_COD_TABLA = 1050;
	static final int SIN_CONEXION = -1919;
	static PreparedStatement pst;
	static ResultSet rs;
	static Connection con;
	static StringBuilder sb;

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

	@Override
	public int add(Amigo amigo) {
		String sqlInsert = "INSERT INTO `agenda`.`amigos` (`nombre`, `apellido`, `calle`, `cp`, `localidad`, `provincia`, `movil`, `fijo`, `anotaciones`) VALUES (?,?,?,?,?,?,?,?,?);";

		String sqlId = "select max(id) from `agenda`.`amigos`";
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
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
			id = -1;
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al insertar alumno" + ex.getStackTrace());
			id = -1;
		}

		return id;
	}

	@Override
	public ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAlumnos = null;
		Amigo amigo;
		String sqlAll = "SELECT * FROM agenda.amigos ORDER BY " + NOMBRE;

		try {
			con = ConnectionFactory.getInstance().getConnection();
			listaAlumnos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				amigo = new Amigo();
				datosAmigo(rs, amigo);
				listaAlumnos.add(amigo);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger todos los datos de alumnos");
		}
		return listaAlumnos;
	}

	@Override
	public ArrayList<Amigo> getByName(String value) {
		ArrayList<Amigo> listaAlumnos = null;
		Amigo amigo;
		String sqlAll = "SELECT * FROM agenda.amigos where agenda.amigos.nombre like ? ORDER BY " + NOMBRE;
		value += "%";
		try {
			con = ConnectionFactory.getInstance().getConnection();
			listaAlumnos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			pst.setString(1, value);
			rs = pst.executeQuery();
			while (rs.next()) {
				amigo = new Amigo();
				datosAmigo(rs, amigo);
				listaAlumnos.add(amigo);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger todos los datos de alumnos");
		}
		return listaAlumnos;
	}

	@Override
	public Amigo getById(int id) {
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
			log.warn("Ha ocurrido un error desconocido al recoger un alumno por id.");
		}
		return amigo;
	}

	@Override
	public boolean update(Amigo amigo) {
		boolean result = false;
		String sqlUpdate = "UPDATE `agenda`.`amigos` SET `nombre`=?, `apellido`=?, `calle`=?, `cp`=?, `localidad`=?, `provincia`=?, `movil`=?, `fijo`=?, `anotaciones`=? WHERE `id`=?";

		try {
			con = ConnectionFactory.getInstance().getConnection();
			pst = con.prepareStatement(sqlUpdate);
			setPst(amigo);
			if (pst.executeUpdate() == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al borrar.");
		}

		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		String sqlDelete = "DELETE FROM agenda.amigos WHERE id=?";
		try {
			con = ConnectionFactory.getInstance().getConnection();
			pst = con.prepareStatement(sqlDelete);
			pst.setInt(1, id);
			if ((pst.executeUpdate()) == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al borrar.");
		}
		return result;

	}

	/**
	 * Introduce los datos de un amigo en un pst para hacer operaciones
	 * 
	 * @param amigo
	 * @throws SQLException
	 */
	private void setPst(Amigo amigo) throws SQLException {
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
	 * Parsea un ResultSet en un Amigo
	 * 
	 * @param rs
	 *            ResultSet
	 */
	private void datosAmigo(ResultSet rs, Amigo amigo) {
		try {
			amigo.setId(rs.getInt(ID));
			amigo.setNombre(rs.getString(NOMBRE));
			amigo.setApellido(rs.getString(APELLIDO));
			amigo.setCalle(rs.getString(APELLIDO));
			amigo.setCp(rs.getInt(CP));
			amigo.setLocalidad(rs.getString(LOCALIDAD));
			amigo.setProvincia(rs.getString(PROVINCIA));
			amigo.setMovil(rs.getInt(MOVIL));
			amigo.setFijo(rs.getInt(FIJO));
			amigo.setAnotaciones(rs.getString(ANOTACIONES));
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		}

	}

	/**
	 * Parsea una SQLException para a�adirla al log
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
