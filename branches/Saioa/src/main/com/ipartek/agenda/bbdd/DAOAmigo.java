package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exception.AmigoException;

public class DAOAmigo implements IDAOAmigo {

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
				datosAlumno(rs);
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

	
	private void datosAlumno(ResultSet rs) {
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
		} catch (AmigoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public int insertarAmigo(Amigo a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Amigo a, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Amigo obtenerAmigoByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amigo obtenerAmigoByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
