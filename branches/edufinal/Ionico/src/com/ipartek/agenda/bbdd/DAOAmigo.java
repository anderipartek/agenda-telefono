package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



import com.ipartek.agenda.bbdd.interfaces.IAmigo;
import com.ipartek.agenda.bean.Amigo;

public class DAOAmigo implements IAmigo {

	static final Logger log = Logger.getLogger(DAOAmigo.class);
	
	static Amigo a;
	static ResultSet rs;
	static PreparedStatement pst;
	static Connection con;
	static ConnectionFactory factory;
	
	public DAOAmigo() {
		PropertyConfigurator.configure("./config/log4j.properties");
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public ArrayList<Amigo> getAll() {
		ArrayList<Amigo> listaAmigos = null;
		String sqlAll = "select * from amigos";
		try {
			con = factory.getConnection();
			listaAmigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(rs);
				listaAmigos.add(a);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger todos los datos de amigos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return listaAmigos;
		}
	}

	
	private void datosAmigo(ResultSet rs) {
		try {
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("nombre"));
			a.setApellido(rs.getString("apellido"));
			a.setCalle(rs.getString("calle"));
			a.setCp(rs.getInt("cp"));
			a.setLocalidad(rs.getString("localidad"));
			a.setProvincia(rs.getString("provincia"));
			a.setMovil(rs.getInt("movil"));
			a.setFijo(rs.getInt("fijo"));
			a.setAnotaciones(rs.getString("anotaciones"));
		} catch (SQLException ex) {
			sqlExcepcion(ex);
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
			pst.setInt(7, a.getMovil());
			pst.setInt(8, a.getFijo());
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
			log.warn("Ha ocurrido un error desconocido al insertar alumno" + ex.getStackTrace());
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

}
