package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bbdd.interfaces.IAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.excepciones.AmigoExcepcion;


public class DAOAmigo implements IAmigo{
	
	static final Logger log = Logger.getLogger(DAOAmigo.class);
	private static final String sql_insertar = "insert into amigos (nombre,apellido,calle,cp,localidad,provincia,movil,fijo,anotaciones) "+ "value ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sql_borrar = "delete from amigos where id = ?";
	private static final String sql_modificar = "update amigos set nombre = ?, apellido = ?, calle = ?, cp = ?, localidad = ?, provincia = ?, "+ "movil = ?, fijo = ?, anotaciones = ? where id = ?";
	private static final String sql_vertodos = "select * from amigos";
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static Connection con;
	private static Amigo a;
	private static ConnectionFactory factory;
	
	public DAOAmigo() {

		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public int insertarAmigo(Amigo a) {
		log.trace("Insert de amigo [" + a.toString() + "]");
		int id = -1;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql_insertar);
			prepareStatment(a);
			if (pst.executeUpdate() == 1) {
				rs = pst.executeQuery();
				rs.next();
				id = (rs.getInt(1));
				a.setId(id);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			log.trace("Fin insert");
			return id;
		}
	
	}


	@Override
	public boolean borrarAmigo(int id) {
		log.trace("Inicio delete [ID = " + id + "]");
		boolean resul = false;
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql_borrar);
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
			log.trace("Fin delete");
			return resul;
		}
	}



	@Override
	public HashMap<Integer, Amigo> getAllAmigo() {
		log.trace("Recoger todos los amigos");
		HashMap<Integer, Amigo> amigoMap = new HashMap<Integer, Amigo>();
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sql_vertodos);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo();
				amigoMap.put(a.getId(), a);
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

	/**
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

	/**
	 * Metodo para rellenar el prepareStatment con los datos del amigo
	 * 
	 * @throws SQLException
	 */
	private void prepareStatment(Amigo a) throws SQLException {
		pst.setString(1, a.getNombre());
		pst.setString(2, a.getApellido());
		pst.setString(3, a.getCalle());
		pst.setInt(4, a.getCodigoPostal());
		pst.setString(5, a.getLocalidad());
		pst.setString(6, a.getProvincia());
		pst.setString(7, a.getMTelefono());
		pst.setString(8, a.getFTelefono());
		pst.setString(9, a.getAnotaciones());
	}

	/**
	 * Metodo para recoger los datos de un amigo de un ResultSet
	 * 
	 * @throws SQLException
	 */
	private void datosAmigo() throws SQLException{
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
				log.warn("Excepcion capturada por AmigoExcepcion ERROR NOMBRE ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_APELLIDO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR APELLIDO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_TELEFONO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR TELEFONO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_CP) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL ["
						+ ex.getMensajeError() + "]");
			}
		}
	}

	@Override
	public boolean modificarAmigo(Amigo a, int id) {
		// TODO Auto-generated method stub
		return false;
	}


}
