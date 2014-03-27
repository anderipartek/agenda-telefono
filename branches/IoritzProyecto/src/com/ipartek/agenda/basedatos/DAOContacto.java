package com.ipartek.agenda.basedatos;

import com.ipartek.agenda.bbdd.interfaces.IDAOContacto;



import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.basedatos.ConnectionFactory;



import com.ipartek.agenda.exception.ContactoException;


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
		String sqlAll = "select * from amigos order by nombre";
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
			log.warn("Ha ocurrido un error desconocido al recoger todos los datos de contacto");
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
			}  catch (SQLException ex) {
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
			String sqlInsert = "insert into amigos (nombre,apellido,calle,cp,localidad,provincia,movil,fijo,anotaciones) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			String sqlId = "select max(id) from amigos;";
			int id = -1;
			try {
				con = factory.getConnection();
				pst = con.prepareStatement(sqlInsert);
				pst.setString(1, c.getNombre());
				pst.setString(2, c.getApellido());
				pst.setString(3, c.getCalle());
				pst.setInt(4, c.getCp());
				pst.setString(5, c.getLocalidad());
				pst.setString(6, c.getProvincia());
				pst.setInt(7, c.getMovil());
				pst.setInt(8, c.getFijo());
				pst.setString(9, c.getAnotaciones());
				if (pst.executeUpdate() > 0) {
					pst = con.prepareStatement(sqlId);
					rs = pst.executeQuery();
					rs.next();
					id = (rs.getInt(1));
					c.setId(id);
				}
			} catch (SQLException ex) {
				sqlExcepcion(ex);
				id = -1;
			} catch (Exception ex) {
				log.warn("Ha ocurrido un error desconocido al insertar contacto"
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
		public Contacto getById(int id) {
			// TODO Auto-generated method stub
			return null;
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

		@Override
		public boolean update(Contacto c, int id) {
			boolean result = false;
			String sqlUpdate = "update amigos set nombre=?, apellido=?, calle=?, cp=?, localidad=?, provincia=?, movil=?, fijo=?, anotaciones=? where id = ?";
			try {
				con = factory.getConnection();
				pst = con.prepareStatement(sqlUpdate);
				pst.setString(1, c.getNombre());
				pst.setString(2, c.getApellido());
				pst.setString(3, c.getCalle());
				pst.setInt(4, c.getCp());
				pst.setString(5, c.getLocalidad());
				pst.setString(6, c.getProvincia());
				pst.setInt(7, c.getMovil());
				pst.setInt(8, c.getFijo());
				pst.setString(9, c.getAnotaciones());
				pst.setInt(10, id);
				if (pst.executeUpdate() == 1) {
					result = true;
				} else {
					result = false;
				}
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			} catch (Exception ex) {
				log.warn("Ha ocurrido un error desconocido al modificar.");
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
		public Contacto getByNombre(String nombre) {
			String sqlContacto = "select * from amigos where nombre like = ?";
			try {
				con = factory.getConnection();
				c = new Contacto();
				pst = con.prepareStatement(sqlContacto);
				pst.setString(1, nombre);
				rs = pst.executeQuery();
				while (rs.next()) {
					datosContacto(rs);
				}
			} catch (ContactoException ex) {
				log.warn("Ha ocurrido un error al recoger un contacto por su nombre " + nombre);
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			} catch (Exception ex) {
				log.warn("Ha ocurrido un error desconocido al recoger un contacto por nombre.");
			} finally {
				try {
					factory.closeConnection();
				} catch (SQLException ex) {
					sqlExcepcion(ex);
				}
				return c;
			}
		}


}
