package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.interfaces.IAmigable;

/**
 * Clase que implementa las operaciones basicas CRUD contra la tabla de alumno en la BBDD
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class DAOAmigo implements IAmigable {

	static final Logger log = Logger.getLogger(DAOAmigo.class);

	static final int ERROR_COD_TABLA = 1050;
	static PreparedStatement pst;
	static ResultSet rs;
	static Connection con;
	static StringBuilder sb;
	static Amigo a;
	static ConnectionFactory factory;

	public DAOAmigo() {

		factory = ConnectionFactory.getInstance();
	}

	@Override
	public int insertAmigo(Amigo a) {
		String sqlInsert = "insert into amigos (nombre,apellido,calle,cp,localidad,provincia,movil,fijo,anotaciones) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sqlId = "select max(id) from amigos;";
		int id = -1;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido());
			pst.setString(3, a.getCalle());
			pst.setInt(4, a.getCp());
			pst.setString(5, a.getLocalidad());
			pst.setString(6, a.getProvincia());
			pst.setString(7, a.getMovil());
			pst.setString(8, a.getFijo());
			pst.setString(9, a.getAnotaciones());
			if (pst.executeUpdate() > 0) {
				pst = con.prepareStatement(sqlId);
				rs = pst.executeQuery();
				rs.next();
				id = (rs.getInt(1));
				a.setId(id);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
			id = -1;
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al insertar amigo" + ex.getStackTrace());
			id = -1;
		} finally {

			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return id;

		}
	}

	@Override
	public HashMap<Integer, Amigo> getAll() {
		log.trace("Recoger todos los amigos");
		String sqlAll = "select * from amigos";
		HashMap<Integer, Amigo> amigoMap = new HashMap<Integer, Amigo>();
		int keyHashMap = 0;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(rs);
				keyHashMap++;
				amigoMap.put(keyHashMap, a);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			log.trace("Fin recoger amigos");
			return amigoMap;
		}

	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		String sqlDelete = "delete from amigos where id = ?";
		try {
			con = factory.getConnection();
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
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return result;
		}
	}

	@Override
	public boolean update(Amigo a, int id) {
		log.trace("Actualizar amigo [" + a.toString() + "]");
		boolean result = false;
		String sqlUpdate = "update amigos set nombre = ?, apellido = ?, calle = ?, cp = ?, localidad = ?, provincia = ?, "
				+ "movil = ?, fijo = ?, anotaciones = ? where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlUpdate);
			prepareStatment(a);
			pst.setInt(10, id);
			if (pst.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			log.trace("Fin actualizar");
			return result;
		}
	}

	@Override
	public Amigo getAmigoByName(final String nombre) {
		String sqlAlumno = "select * from amigos where nombre = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAlumno);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger un alumno por dni.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return a;
		}

	}

	@Override
	public HashMap<Integer, Amigo> getAllByName(final String nombre) {
		log.trace("Recoger todos los amigos");
		String sqlAlumno = "select * from amigos where nombre = ?";
		HashMap<Integer, Amigo> amigoMap = new HashMap<Integer, Amigo>();
		int keyHashMap = 0;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlAlumno);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(rs);
				keyHashMap++;
				amigoMap.put(keyHashMap, a);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			log.trace("Fin recoger amigos");
			return amigoMap;
		}

	}

	private void datosAmigo(ResultSet rs) throws SQLException {
		try {
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("nombre"));
			a.setApellido(rs.getString("apellido"));
			a.setCalle(rs.getString("calle"));
			a.setCp(rs.getInt("cp"));
			a.setFijo(rs.getString("fijo"));
			a.setMovil(rs.getString("movil"));
			a.setLocalidad(rs.getString("localidad"));
			a.setProvincia(rs.getString("provincia"));
		} catch (AmigoException ex) {
			if (ex.getCodigoError() == AmigoException.COD_ERROR_NOMBRE) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR NOMBRE [" + ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoException.COD_ERROR_APELLIDO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR APELLIDO [" + ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoException.COD_ERROR_MOVIL) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR MOVIL [" + ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoException.COD_ERROR_CP) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL [" + ex.getMensajeError() + "]");
			}
		}
	}

	private void sqlExcepcion(SQLException ex) {
		while (ex != null) {
			log.error("Message:> " + ex.getMessage());
			log.error("SQL State:> " + ex.getSQLState());
			log.error("Error Code:> " + ex.getErrorCode());
			log.error("Cause:> " + ex.getCause());
			ex = ex.getNextException();
		}

	}

	/**
	 * Metodo para rellenar el prepareStatment con los datos del amigo
	 * 
	 * @throws SQLException
	 */
	private void prepareStatment(Amigo a) throws SQLException {
		pst.setString(1, a.getNombre());
		pst.setString(2, a.getApellido());
		pst.setString(3, a.getCalle());
		pst.setInt(4, a.getCp());
		pst.setString(5, a.getLocalidad());
		pst.setString(6, a.getProvincia());
		pst.setString(7, a.getMovil());
		pst.setString(8, a.getFijo());
		pst.setString(9, a.getAnotaciones());
	}

}
