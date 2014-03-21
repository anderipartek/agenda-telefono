package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.agenda.bbdd.interfaces.IDAOAmigo;
import com.ipartek.agenda.bean.Amigo;



public class DAOAmigo implements IDAOAmigo {
	
	static ConnectionFactory factory;
	static PreparedStatement pst;
	static ResultSet rs;
	static Connection con;
	static StringBuilder sb;
	static Amigo a;


	public DAOAmigo() {
		

		factory = ConnectionFactory.getInstance();
	}

	@Override
	public int insertAmigo (Amigo a) {
	
		String sqlInsert = "insert into amigos (nombre,apellido,calle,cp, localidad, provincia, movil, fijo, anotaciones) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		} /*catch (AlumnoException ex) {
			log.error("No se ha podido crear alumno " + ex.getMensajeError());
		} */
		  catch (Exception ex) {
			//log.warn("Ha ocurrido un error desconocido al recoger todos los datos de alumnos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return listaAmigos;
		}
		
	}

	@Override
	public ArrayList<Amigo> getByNombre(String nombre) {
		
		ArrayList<Amigo> listaAmigos = null;
		String sqlAmigos = "select * from amigos where nombre = ?";
		try {
			con = factory.getConnection();
			con = factory.getConnection();
			listaAmigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAmigos);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(rs);
				listaAmigos.add(a);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} /*catch (AlumnoException ex) {
			log.error("No se ha podido crear alumno " + ex.getMensajeError());
		} */
		  catch (Exception ex) {
			//log.warn("Ha ocurrido un error desconocido al recoger todos los datos de alumnos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return listaAmigos;
		}
	}

	@Override
	public Amigo getByMovil(String movil) {
		
		String sqlAmigo = "select * from amigos where movil = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAmigo);
			pst.setString(1, movil);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}
		} /*catch (AlumnoException ex) {
			log.warn("Ha ocurrido un error un recoger el alumno por dni " + dni);
		}*/ catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			//log.warn("Ha ocurrido un error desconocido al recoger un alumno por dni.");
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
	public Amigo getById(int id) {
		
		String sqlAmigo = "select * from amigos where id = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAmigo);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(rs);
			}/*
		} catch (AlumnoException ex) {
			log.warn("Ha ocurrido un error al recoger un alumno por dni " + id);
		*/} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			//log.warn("Ha ocurrido un error desconocido al recoger un alumno por id.");
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
			//log.warn("Ha ocurrido un error desconocido al borrar.");
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
	
		boolean result = false;
		String sqlUpdate = "update alumno set nombre=?, apellido=?, localidad=?, cp=?, calle=?, provincia=?, fijo=?, movil=?, anotaciones=? where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido());
			pst.setString(3, a.getLocalidad());
			pst.setInt(4, a.getCp());
			pst.setString(5, a.getCalle());
			pst.setString(6, a.getProvincia());
			pst.setString(7, a.getFijo());
			pst.setString(8, a.getMovil());
			pst.setString(9, a.getAnotaciones());
			pst.setInt(10, id);
			if (pst.executeUpdate() == 1) {
				result = true;
			} else {
				result = false;
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			//log.warn("Ha ocurrido un error desconocido al borrar.");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return result;
		}
	}
	
	private void datosAmigo (ResultSet rs) {
		try {
			a.setId(rs.getInt("id"));
		
			a.setNombre(rs.getString("nombre"));
			a.setApellido(rs.getString("apellido"));
			a.setCalle(rs.getString("calle"));
			a.setLocalidad(rs.getString("localidad"));
			a.setProvincia(rs.getString("provincia"));
			a.setCp(rs.getInt("cp"));
			a.setFijo(rs.getString("fijo"));
			a.setMovil(rs.getString("movil"));
			a.setAnotaciones(rs.getString("anotaciones"));
		}/* catch (AlumnoException ex) {
		}*/ catch (SQLException ex) {
			sqlExcepcion(ex);
		}

	}
	

	private void sqlExcepcion(SQLException ex) {
		while (ex != null) {
			
			/*
			log.error("Message:> " + ex.getMessage());
			log.error("SQL State:> " + ex.getSQLState());
			log.error("Error Code:> " + ex.getErrorCode());
			log.error("Cause:> " + ex.getCause());*/
			ex = ex.getNextException();
		}

	}

}
