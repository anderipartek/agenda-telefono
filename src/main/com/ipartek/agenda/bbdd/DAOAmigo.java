package com.ipartek.agenda.bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.interfaces.IAmigable;

public class DAOAmigo implements IAmigable {
	
	
	static ConnectionFactory factory=null;
	static Connection con=null;
	static Statement stmt=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	static Amigo a=null;
    public DAOAmigo(){
    	factory=ConnectionFactory.getInstance();
    }
	@Override
	public boolean crearTabla() {
		boolean result=false;
		
		try {
			con=factory.getConnection();
			String sql="CREATE TABLE if not exists `amigos` ("
					+ "`id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,"
					+ "`apellido` varchar(50) COLLATE utf8_unicode_ci NOT NULL,"
					+ "`calle` varchar(150) COLLATE utf8_unicode_ci NOT NULL,"
					+ "`cp` int(11) NOT NULL,"
					+ "`localidad` varchar(150) COLLATE utf8_unicode_ci NOT NULL,"
					+ "`provincia` varchar(150) COLLATE utf8_unicode_ci NOT NULL,"
					+ "`movil` int(11) NOT NULL,"
					+ "`fijo` int(11) NOT NULL,"
					+ "`anotaciones` varchar(300) COLLATE utf8_unicode_ci NOT NULL,"
					+ "PRIMARY KEY (`id`)"
					+ ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci";
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println("Error creando la tabla Amigo");
			e.printStackTrace();
		}finally{
			try {
				factory.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexion");
				
			}
		}
		
				
		
		return result;
	}

	@Override
	public int insertarAmigo(Amigo a) {
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
				System.out.println(sqlInsert);
				rs = pst.executeQuery();
				rs.next();
				id = (rs.getInt(1));
				a.setId(id);
			}
			
		} catch (SQLException ex) {
			ex.getMessage();
			id = -1;
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error desconocido al insertar alumno" + ex.getStackTrace());
			id = -1;
		} finally {

			try {
				factory.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexion");
				
			}
		}
		return id;

		
		
	}

	@Override
	public int delete(int id) {
		int result = -1;
		String sqlDelete = "delete from amigos where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlDelete);
			pst.setInt(1, id);
			if ((pst.executeUpdate()) == 1) {
				result = id;
			} else {
				result = -1;
			}
		} catch (SQLException ex) {
			System.out.println("Error al borrar el amigo");
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error desconocido al borrar.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		return result;
		
	}

	@Override
	public int update(Amigo a, int id) {
		int result = -1;
		String sqlUpdate = "update amigo set nombre=?, apellido=?, calle=?, cp=?, localidad=?, provincia=?,movil=?,fijo=?,anotaciones=? where id = ?";
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
			if (pst.executeUpdate() == 1) {
				result = id;
			} else {
				result = -1;
			}
		} catch (SQLException ex) {
			System.out.println("Error al actualizar el amigo");
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error desconocido al borrar.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		return result;
		
	}

	@Override
	public ArrayList<Amigo> getAll() {
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
			}
		} catch (SQLException ex) {
			System.out.println("Error al obtener los amigos de la BD");
		
		
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error desconocido al recoger todos los datos de los amigos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		return listaAlumnos;
	}

	@Override
	public Amigo obtenerAmigoByID(int id) {
		
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
		 
		} catch (SQLException ex) {
			System.out.println("Error al obtener el amigo por id ");
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error desconocido al recoger un alumno por id.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		return a;
	}
	
	private void datosAmigo(ResultSet rs) throws AmigoException {
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
			
		
		} catch (SQLException ex) {
			System.out.println("Error al parsear los datos del Amigo");
		}

	}
	@Override
	public Amigo obtenerAmigoByNombre(String nombre) {
		
		String sqlAmigo = "select * from amigo where nombre = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAmigo);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}
		 
		} catch (SQLException ex) {
			System.out.println("Error al obtener el amigo por nombre ");
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error desconocido al recoger un alumno por nombre.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		return a;
	}
	@Override
	public boolean borrarTabla() {
		boolean result=false;
		String sql="DROP TABLE Amigos";
		try {
			con = factory.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(sql);
			result=true;
		} catch (SQLException e) {
			System.out.println("Error al borrar la tabla Amigo");
			
		}finally{
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("Error al cerrar la conexion");
			}
			
		}
		
		return result;
	}
   
}
