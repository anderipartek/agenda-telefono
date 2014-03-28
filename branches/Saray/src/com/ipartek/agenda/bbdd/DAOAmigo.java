package com.ipartek.agenda.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.bbdd.interfaces.IDAOAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Clase que implementa las operaciones basicas CRUD contra la tabla de alumno
 * en la BBDD
 * 
 * @author Saray Carralero
 * @version 1.0
 */
public class DAOAmigo implements IDAOAmigo {
	static final Logger log = Logger.getLogger(DAOAmigo.class);
	ConnectionFactory factory;
	Connection con;
	StringBuilder sb;
	PreparedStatement pst;
	ResultSet rs;
	Amigo a;
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String APELLIDO = "apellido";
	public static final String CALLE = "calle";
	public static final String CP = "cp";
	public static final String LOCALIDAD = "localidad";
	public static final String PROVINCIA = "provincia";
	public static final String FIJO = "fijo";
	public static final String MOVIL = "movil";
	public static final String ANOTACIONES = "anotaciones";
	
	public DAOAmigo() {
		PropertyConfigurator.configure("./config/log4j.properties");
		factory = ConnectionFactory.getInstance();
	}

	public int insertAmigo(Amigo a) {
		String sqlInsert = "insert into agenda.amigos (nombre,apellido,calle,cp,localidad,provincia,movil,fijo,anotaciones) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			pst.setInt(7, a.gettMovil());
			pst.setInt(8, a.gettFijo());
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
			log.warn("Ha ocurrido un error desconocido al insertar el amigo"
					+ ex.getStackTrace());
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
		String sqlAll = "select * from agenda.amigos order by nombre";
		try {
			con = factory.getConnection();
			listaAmigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAll);
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(a,rs);
				listaAmigos.add(a);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger todos los datos de alumnos");
		} finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return listaAmigos;
		}
	}
	
	public Amigo getById(int id) {
		String sqlAmigo = "select * from amigos where id = ?";
		try {
			con = factory.getConnection();
			a = new Amigo();
			pst = con.prepareStatement(sqlAmigo);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				datosAmigo(a, rs);
			}
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger un alumno por id.");
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
	public ArrayList<Amigo> getByNombre(String nombre) {
		ArrayList<Amigo> listaAmigos = null;
		String sqlAmigo = "select * from agenda.amigos where nombre LIKE ?";
		try {
			con = factory.getConnection();
			listaAmigos = new ArrayList<Amigo>();
			pst = con.prepareStatement(sqlAmigo);
			pst.setString(1, nombre + "%");//LIKE
			rs = pst.executeQuery();
			while (rs.next()) {
				a = new Amigo();
				datosAmigo(a,rs);
				listaAmigos.add(a);
			}
		
		} catch (SQLException ex) {
			sqlExcepcion(ex);
		} catch (Exception ex) {
			log.warn("Ha ocurrido un error desconocido al recoger un amigo por nombre.");
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
	public boolean delete(int id) {
		boolean borrado = false;
		String sqlDelete = "delete from amigos where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlDelete);
			pst.setInt(1, id);
			if ((pst.executeUpdate()) == 1) {
				borrado = true;
			} else {
				borrado = false;
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
			return borrado;
		}


	}

	@Override
	public boolean update(Amigo a, int id) {
		boolean result = false;
		String sqlUpdate = "update amigos set nombre=?, apellido=?, calle=?, cp=?, localidad=?,provincia=?,movil=?,fijo=?,anotaciones=?  where id = ?";
		try {
			con = factory.getConnection();
			pst = con.prepareStatement(sqlUpdate);
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido());
			pst.setString(3, a.getCalle());
			pst.setInt(4, a.getCp());
			pst.setString(5, a.getLocalidad());
			pst.setString(6, a.getProvincia());
			pst.setInt(7, a.gettMovil());
			pst.setInt(8, a.gettFijo());
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

	private void datosAmigo(Amigo a,ResultSet rs) {
		try {
			a.setId(rs.getInt(ID));
			a.setNombre(rs.getString(NOMBRE));
			a.setApellido(rs.getString(APELLIDO));
			a.setCalle(rs.getString(CALLE));
			a.setCp(rs.getInt(CP));
			a.setLocalidad(rs.getString(LOCALIDAD));
			a.setProvincia(rs.getString(PROVINCIA));
			a.settFijo(rs.getInt(FIJO));
			a.settMovil(rs.getInt(MOVIL));
			a.setAnotaciones(rs.getString(ANOTACIONES));
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
}