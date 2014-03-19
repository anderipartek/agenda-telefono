package com.ipartek.agenda.basedatos;

import com.ipartek.agenda.bbdd.interfaces.IDAOContacto;



import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.basedatos.ConnectionFactory;



import com.ipartek.agenda.exception.ContactoException;
import com.ipartek.pruebas.exception.AlumnoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;


public class DAOContacto implements IDAOContacto{
	
	static final Logger log = Logger.getLogger(DAOContacto.class);
	
	static final int ERROR_COD_TABLA = 1050;
	static PreparedStatement pst;
	static ResultSet rs;
	static Connection con;
	static StringBuilder sb;
	static Contacto c;
	static ConnectionFactory factory;
	
	public DAOContacto(){
		factory = ConnectionFactory.getInstance();
	}
	
	public ArrayList<Contacto> getAll() {
		ArrayList<Contacto> lContactos = null;
		String sqlAll = "select * from amigos";
		try {
			con = factory.getConnection();
			lContactos = new ArrayList<Contacto>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				c = new Contacto();
				datosContacto(rs);
				lContactos.add(c);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		}  catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger todos los datos de alumnos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return lContactos;
		}
	}
		
		private void datosContacto(ResultSet rs) {
			try {
				c.setId(rs.getInt("id"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setCalle(rs.getString("calle"));
				c.setCp(rs.getInt("cp"));
				c.setLocalidad(rs.getString("localidad"));
				c.setProvincia(rs.getString("provincia"));
				c.setMovil(rs.getInt("movil"));
				c.setFijo(rs.getInt("fijo"));
				c.setAnotaciones(rs.getString("anotaciones"));
			} catch (ContactoException ex){
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
		public int insertContacto(Contacto c) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Contacto getById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean delete(int id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean update(Contacto c, int id) {
			// TODO Auto-generated method stub
			return false;
		}


}
