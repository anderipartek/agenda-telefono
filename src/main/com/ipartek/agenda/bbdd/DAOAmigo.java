package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.excepciones.AmigoExcepcion;
import com.ipartek.agenda.interfaces.IAmigable;

/**
 * Clase que realiza las operaciones principales de insercion, modificacion,
 * eliminacion y busqueda directamente sobre la BBDD.
 * 
 * Implementa la interfaz IAmigable
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * @see com.ipartek.agenda.interfaces.IAmigable
 * 
 */
public class DAOAmigo implements IAmigable {

	/**
	 * 
	 */
	static final Logger LOG = Logger.getLogger(DAOAmigo.class);
	/**
	 * 
	 */
	private static PreparedStatement pst;
	/**
	 * 
	 */
	private static ResultSet rs;
	/**
	 * 
	 */
	private static Connection con;
	/**
	 * 
	 */
	private static Amigo a;
	/**
	 * 
	 */
	private static ConnectionFactory factory;
	/**
	 * 
	 */
	private static final String SQL_GETID = "select max(id) from amigos";
	/**
	 * 
	 */
	private static final String SQL_INSERT = "insert into amigos "
			+ "(nombre,apellido,calle,cp,localidad,provincia,movil,"
			+ "fijo,anotaciones) " + "value ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/**
	 * 
	 */
	private static final String SQL_UPDATE = "update amigos set "
			+ "nombre = ?, apellido = ?, calle = ?, cp = ?, "
			+ "localidad = ?, provincia = ?, "
			+ "movil = ?, fijo = ?, anotaciones = ? where id = ?";
	/**
	 * 
	 */
	private static final String SQL_DELETE = "delete from amigos where id = ?";
	/**
	 * 
	 */
	private static final String SQL_ALL = "select * from amigos";
	/**
	 * 
	 */
	private static final String SQL_ONE = "select * from "
			+ "amigos where nombre = ?";

	/**
	 * Constructor que crea una instancia a la conexion de la BBDD.
	 */
	public DAOAmigo() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public final int insertAmigo(final Amigo amigo) {
		LOG.trace("Insert de amigo [" + amigo.toString() + "]");
		int id = -1;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_INSERT);
			prepareStatment(amigo);
			if (pst.executeUpdate() == 1) {
				pst = con.prepareStatement(SQL_GETID);
				rs = pst.executeQuery();
				rs.next();
				id = (rs.getInt(1));
				amigo.setId(id);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			LOG.trace("Fin insert");
			return id;
		}

	}

	@Override
	public final boolean deleteAmigo(final int id) {
		LOG.trace("Inicio delete [ID = " + id + "]");
		boolean resul = false;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_DELETE);
			pst.setInt(1, id);
			if (pst.executeUpdate() == 1) {
				resul = true;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			LOG.trace("Fin delete");
			return resul;
		}
	}

	@Override
	public final boolean updateAmigo(final Amigo amigo, final int id) {
		LOG.trace("Actualizar amigo [" + amigo.toString() + "]");
		boolean result = false;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_UPDATE);
			prepareStatment(amigo);
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
			LOG.trace("Fin actualizar");
			return result;
		}
	}

	@Override
	public final HashMap<Integer, Amigo> getAllAmigo() {
		LOG.trace("Recoger todos los amigos");
		HashMap<Integer, Amigo> amigoMap = new HashMap<Integer, Amigo>();
		int keyHashMap = 0;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_ALL);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo();
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
			LOG.trace("Fin recoger amigos");
			return amigoMap;
		}

	}

	@Override
	public final HashMap<Integer, Amigo> getAllByName(final String nombre) {
		LOG.trace("Recoger todos los amigos");
		HashMap<Integer, Amigo> amigoMap = new HashMap<Integer, Amigo>();
		int keyHashMap = 0;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_ONE);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo();
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
			LOG.trace("Fin recoger amigos");
			return amigoMap;
		}
	}

	@Override
	public final Amigo getAmigoByName(final String nombre) {
		try {
			a = new Amigo();
			con = factory.getConnection();
			pst = con.prepareStatement(SQL_ONE);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo();
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
			a = null;
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return a;
		}
	}

	/**
	 * 
	 * @param e excepcion que se captura
	 */
	private void sqlExcepcion(final SQLException e) {
		SQLException ex = e;
		while (ex != null) {
			LOG.error("Message:> " + ex.getMessage());
			LOG.error("SQL State:> " + ex.getSQLState());
			LOG.error("Error Code:> " + ex.getErrorCode());
			LOG.error("Cause:> " + ex.getCause());
			ex = ex.getNextException();
		}
	}

	/**
	 * Metodo para rellenar el prepareStatment con los datos del amigo.
	 * 
	 * @param amigo del cual se recogen los datos a insertar en el pst
	 * @throws SQLException excepcion que captura en caso de error
	 */
	private void prepareStatment(final Amigo amigo) throws SQLException {
		pst.setString(1, amigo.getNombre());
		pst.setString(2, amigo.getApellido());
		pst.setString(3, amigo.getCalle());
		pst.setInt(4, amigo.getCodigoPostal());
		pst.setString(5, amigo.getLocalidad());
		pst.setString(6, amigo.getProvincia());
		pst.setString(7, amigo.getMTelefono());
		pst.setString(8, amigo.getFTelefono());
		pst.setString(9, amigo.getAnotaciones());
	}

	/**
	 * Metodo para recoger los datos de un amigo de un ResultSet.
	 * 
	 * @throws SQLException excepcion que captura en caso de error
	 */
	private void datosAmigo() throws SQLException {
		try {
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("nombre"));
			a.setApellido(rs.getString("apellido"));
			a.setCalle(rs.getString("calle"));
			a.setCodigoPostal(rs.getInt("cp"));
			a.setLocalidad(rs.getString("localidad"));
			a.setProvincia(rs.getString("provincia"));
			a.setMTelefono(rs.getString("movil"));
			a.setFTelefono(rs.getString("fijo"));
			a.setAnotaciones(rs.getString("anotaciones"));
		} catch (AmigoExcepcion ex) {
			if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_NOMBRE) {
				LOG.warn("Excepcion capturada por AmigoExcepcion ERROR NOMBRE ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_APELLIDO) {
				LOG.warn("Excepcion capturada por AmigoExcepcion ERROR APELLIDO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_TELEFONO) {
				LOG.warn("Excepcion capturada por AmigoExcepcion ERROR TELEFONO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_CP) {
				LOG.warn("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL ["
						+ ex.getMensajeError() + "]");
			}
		}
	}

}
