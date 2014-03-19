package com.ipartek.agenda.bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.controller.ServletMaestro;
import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.interfaces.IAmigable;

public class DAOAmigo implements IAmigable {
	
	
	static ConnectionFactory factory=null;
	static Connection con=null;
	static Statement stmt=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	static Amigo a=null;
	private final static Logger log=Logger.getLogger(DAOAmigo.class);
    public DAOAmigo(){
    	factory=ConnectionFactory.getInstance();
    	
    }
	
	@Override
	public int insertarAmigo(Amigo a) {
		log.trace("Insertando Alumno...");
		int id;
		String sqlInsert = "insert into amigos (nombre,apellido,calle,cp,localidad,provincia,movil,fijo,anotaciones) value (?, ?, ?, ?, ?,?,?,?,?)";
		String sqlId = "select max(id) from amigos;";
		id = -1;
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
			log.info("Amigo insertado correctamente");
			
		} catch (SQLException ex) {
			log.error("SQLException " + ex.getMessage());
			id = -1;
		} catch (Exception ex) {
			log.error("Ha ocurrido un error desconocido al insertar alumno" + ex.getMessage());
			id = -1;
		} finally {

			try {
				factory.closeConnection();
				log.info("Cerrada la conexion");
			} catch (SQLException e) {
				log.error("Error al cerrar la conexion");
				
			}
		}
		log.info("Fin insercion alumno");
		return id;
        
		
		
	}

	@Override
	public int delete(int id) {
		log.trace("Borrando amigo..." );
		int result = -1;
		String sqlDelete = "delete from amigos where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlDelete);
			pst.setInt(1, id);
			if ((pst.executeUpdate()) == 1) {
				result = id;
				log.info("Amigo eliminado correctamente");
			} else {
				result = -1;
				log.error("Error al borrar el amigo");
			}
		} catch (SQLException ex) {
			log.error("SqlException" + ex.getMessage());
		} catch (Exception ex) {
			log.error("Ha ocurrido un error desconocido al borrar" + ex.getMessage());
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				log.error("SqlException" + ex.getMessage());
			}
			
		}
		log.trace("Fin Delete");
		return result;
		
	}

	@Override
	public int update(Amigo a, int id) {
		log.trace("Actualizando amigo... " );
		int result = -1;
		String sqlUpdate = "update amigos set nombre=?, apellido=?, calle=?, cp=?, localidad=?, provincia=?,movil=?,fijo=?,anotaciones=? where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido());
			pst.setString(3, a.getCalle());
			pst.setInt(4, a.getCp());
			pst.setString(5, a.getLocalidad());
			pst.setString(6, a.getProvincia());
			pst.setInt(7, a.getMovil());
			pst.setInt(8, a.getFijo());
			pst.setString(9, a.getAnotaciones());
			pst.setInt(10, id);
			if (pst.executeUpdate() == 1) {
				result = id;
				log.info("Amigo actualizado");
			} else {
				result = -1;
				log.error("Error al actualizar amigo");
			}
		} catch (SQLException ex) {
			log.error("SQLException" + ex.getMessage());
		} catch (Exception ex) {
			log.error("Excepcion desconocida" + ex.getMessage());
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		log.trace("Fin Update");
		return result;
		
	}

	@Override
	public ArrayList<Amigo> getAll() {
		log.trace("Obteniendo amigos " );
		ArrayList<Amigo> listaAlumnos = null;
		String sqlAll = "select * from amigos";
		try {
			con = factory.getConnection();
			listaAlumnos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(rs);
				listaAlumnos.add(a);
				log.info("Obtenidos los alumnos de la BD");
			}
			
		} catch (SQLException ex) {
			log.error("SQLException" + ex.getMessage());
		
		
		} catch (Exception ex) {
			log.error("Excepcion Desconocida" + ex.getMessage());
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				log.error("Error al cerrar la conexion");
			}
			
		}
		log.trace("Fin getAll");
		return listaAlumnos;
	}

	@Override
	public Amigo obtenerAmigoByID(int id) {
		log.trace("ObteniendoAmigoById... " );
		String sqlAmigo = "select * from amigos where id = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAmigo);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}
			log.info("Alumno obtenido por ID");
		 
		} catch (SQLException ex) {
			log.error("SQLException"+ ex.getMessage());
		} catch (Exception ex) {
			log.error("Excepcion Desconocida"+ ex.getMessage());
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				log.error("Error al cerrar la conexion");
			}
			
		}
		return a;
	}
	
	private void datosAmigo(ResultSet rs) throws AmigoException {
		   log.trace("Inicio datosAmigo");
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
			log.info("Alumno parseado correctamente");
		
		} catch (SQLException ex) {
			log.error("Error al parsear los datos del Amigo");
		}
		log.trace("Fin datosAmigo");

	}
	@Override
	public Amigo obtenerAmigoByNombre(String nombre) {
		log.trace("Inicio ObtenerAmigosByNombre");
		String sqlAmigo = "select * from amigos where nombre = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAmigo);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}
			log.info("Amigo obtenido por nombre");
		 
		} catch (SQLException ex) {
			log.error("Error al obtener el amigo por nombre " + ex.getMessage());
		} catch (Exception ex) {
			log.error("Ha ocurrido un error desconocido al recoger un alumno por nombre." + ex.getMessage());
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				log.error("Error al cerrar la conexion");
			}
			
		}
		log.trace("Fin obtenerAmigoByNombre");
		return a;
	}
	
   
}
