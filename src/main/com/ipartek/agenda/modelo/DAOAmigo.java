package com.ipartek.agenda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exceptions.AmigoException;
import com.ipartek.agenda.interfaces.IDAOAmigo;

/**
 * Clase para implementar la interactuación con la BBDD.
 * @author Patricia Navascués
 * @version 1.0
 *
 */
public class DAOAmigo implements IDAOAmigo {

	private static final Logger LOG = Logger.getLogger(DAOAmigo.class);
	
	// Error del 
	private static final int ERROR_COD_TABLA = 1050;
	
	// Variables de conexión
	private static ConnectionFactory factory;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Connection con;
	private static StringBuilder sb;
	
	private static Amigo amigo;
	private static ArrayList<Amigo> amigos;
	
	/**
	 * Constructor de la clase.
	 */
	public DAOAmigo() {
		PropertyConfigurator.configure("./config/log4j.properties");

		factory = ConnectionFactory.getInstance();
		
	}
	
	
	@Override
	public final boolean createTable() {
		boolean resul = false;
		Statement st;
		try {
			con = factory.getConnection();
			sb = new StringBuilder();
			st = con.createStatement();
			
			sb.append("CREATE TABLE IF NOT EXISTS `amigos` (`id` int(11) NOT "
					+ "NULL AUTO_INCREMENT,`nombre` varchar(50) COLLATE "
					+ "utf8_unicode_ci NOT NULL,`apellido` varchar(50) COLLATE "
					+ "utf8_unicode_ci NOT NULL,`calle` varchar(150) COLLATE "
					+ "utf8_unicode_ci NOT NULL,`cp` int(11) NOT NULL,"
					+ "`localidad` varchar(150) COLLATE utf8_unicode_ci NOT "
					+ "NULL,`provincia` varchar(150) COLLATE utf8_unicode_ci "
					+ "NOT NULL,`movil` int(11) NOT NULL,`fijo` int(11) NOT "
					+ "NULL,`anotaciones` varchar(300) COLLATE utf8_unicode_ci"
					+ " NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB  DEFAULT "
					+ "CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;"
					+ "");
			st.executeQuery(sb.toString());
			resul = true;
		} catch (SQLException ex) {
			// comprobar si existe la tabla
			if (ex.getErrorCode() != ERROR_COD_TABLA) {
				sqlExcepcion(ex);
			} else {
				LOG.info("La tabla 'alumno' ya existe");
			}
		} catch (Exception ex) {
			LOG.error("Ha ocurrido un error desconocido"
					+ " al crear tabla" + ex.getStackTrace());
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			
		}
		return resul;
	}

	@Override
	public final int insertAmigo(Amigo amigo) {
		final String sqlInsert = "insert into amigos (nombre,apellido,"
				+ "calle, cp, localidad, provincia,movil, fijo"
				+ ",anotaciones) value (?, ?, ?, ?, ?, ?, ?, ?,"
				+ "?)";
		final String sqlId = "select max(id) from amigos;";
		int idInsert = -1;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlInsert);
			pst.setString(1, amigo.getNombre());
			pst.setString(2, amigo.getApellido());
			pst.setString(3, amigo.getCalle());
			pst.setInt(4, amigo.getCp());
			pst.setString(5, amigo.getLocalidad());
			pst.setString(6, amigo.getProvincia());
			pst.setInt(7, amigo.getMovil());
			pst.setInt(8, amigo.getFijo());
			pst.setString(9, amigo.getAnotaciones());
			
			if (pst.executeUpdate() > 0) {
				pst = con.prepareStatement(sqlId);
				rs = pst.executeQuery();
				rs.next();
				idInsert = (rs.getInt(1));
				amigo.setId(idInsert);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
			idInsert = -1;
		} catch (Exception ex) {
			LOG.warn("Ha ocurrido un error desconocido "
					+ "al insertar amigo" + ex.getStackTrace());
			idInsert = -1;
		} finally {

			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
		}
		return idInsert;
	}

	@Override
	public final ArrayList<Amigo> getAll() {
		final String sqlAll = "select * from amigos";
		try {
			con = factory.getConnection();
			amigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				amigo = new Amigo();
				datosAmigo(rs);
				amigos.add(amigo);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			LOG.warn("Ha ocurrido un error desconocido al "
					+ "recoger todos los datos de alumnos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			
		}
		return amigos;
	}

	@Override
	public final ArrayList<Amigo> getByName(String nombre) {
		
		amigos = new ArrayList<Amigo>();
		final String sqlAlumno = "select * from amigos where nombre = ?";
		try {
			con = factory.getConnection();
			amigo = new Amigo();
			pst = con.prepareStatement(sqlAlumno);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
				if (amigo != null) {
					amigos.add(amigo);
				}
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			LOG.warn("Ha ocurrido un error desconocido al "
					+ "recoger un alumno por dni.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
		}
		return amigos;
	}

	@Override
	public final Amigo getById(int idAmigo) {
		final String sqlAlumno = "select * from amigos where id = ?";
		try {
			con = factory.getConnection();
			amigo = new Amigo();
			pst = con.prepareStatement(sqlAlumno);
			pst.setInt(1, idAmigo);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			LOG.warn("Ha ocurrido un error desconocido al "
					+ "recoger un alumno por id.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
					}
		return amigo;
	}

	@Override
	public final boolean delete(int idAmigo) {
		boolean result = false;
		String sqlDelete = "delete from amigos where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlDelete);
			pst.setInt(1, idAmigo);
			if ((pst.executeUpdate()) == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			LOG.warn("Ha ocurrido un error desconocido al borrar.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			
		}
		return result;
	}

	@Override
	public final boolean update(Amigo amigo, int idAmigo) {
		boolean result = false;
		String sqlUpdate = "update amigos set nombre=?, apellido=?, calle=?, "
				+ "cp=?, localidad=?, provincia=?, movil=?, fijo=?, "
				+ "anotaciones=? where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, amigo.getNombre());
			pst.setString(2, amigo.getApellido());
			pst.setString(3, amigo.getCalle());
			pst.setInt(4, amigo.getCp());
			pst.setString(5, amigo.getLocalidad());
			pst.setString(6, amigo.getProvincia());
			pst.setInt(7, amigo.getMovil());
			pst.setInt(8, amigo.getFijo());
			pst.setString(9, amigo.getAnotaciones());
			pst.setInt(10, idAmigo);
			if (pst.executeUpdate() == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			LOG.warn("Ha ocurrido un error desconocido al borrar.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
		}
		return result;
	}

	/**
	 * Método para manejar los datos recogidos por la base de datos.
	 * @param rs
	 */
	private void datosAmigo(ResultSet rs) {
		try {
			amigo.setId(rs.getInt("id"));
			try {
				amigo.setNombre(rs.getString("nombre"));
				amigo.setApellido(rs.getString("apellido"));
				amigo.setCalle(rs.getString("calle"));
				amigo.setCp(rs.getInt("cp"));
				amigo.setLocalidad(rs.getString("localidad"));
				amigo.setProvincia(rs.getString("provincia"));
				amigo.setMovil(rs.getInt("movil"));
				amigo.setFijo(rs.getInt("fijo"));
				amigo.setAnotaciones(rs.getString("anotaciones"));
			} catch (AmigoException e) {
				amigo = null;
				LOG.error("Error al crear el amigo"
						+ " [ " + e.getMensajeError() + ","
								+ " " + e.getCodigoError());
			
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		}

	}
	
	/**
	 * Metodo para la gestión de las excepciones 
	 * producidas por la base de datos.
	 * @param ex
	 */
	
	private void sqlExcepcion(SQLException ex) {
		while (ex != null) {
			LOG.error("Message:> " + ex.getMessage());
			LOG.error("SQL State:> " + ex.getSQLState());
			LOG.error("Error Code:> " + ex.getErrorCode());
			LOG.error("Cause:> " + ex.getCause());
			ex = ex.getNextException();
		}

	}
	
}
