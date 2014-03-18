package com.ipartek.agenda.bbdd;

import java.sql.SQLException;
import java.util.ArrayList;




import com.ipartek.agenda.bbdd.interfaces.IDAOAmigo;
import com.ipartek.agenda.bean.Amigo;


public class DAOAmigo implements IDAOAmigo {
	
	static DAOFactory daofac;

	public DAOAmigo() {
		

		daofac = DAOFactory.getDAOFactory(1);
	}

	@Override
	public int insertAlumno(Amigo a) {
	
		String sqlInsert = "insert into amigos (nombre,apellido,calle,cp, localidad, provincia, movil, fijo, anotaciones) value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sqlId = "select max(id) from amigos;";
		int id = -1;
		try {
			con = daofac.
			pst = con.prepareStatement(sqlInsert);
		
			pst.setString(1, a.getNombre());
			pst.setString(2, a.getApellido());
			pst.setInt(3, a.getCalle());
			pst.setInt(4, a.getCp());
			pst.setInt(5, a.getLocalidad());
			pst.setInt(6, a.getProvincia());
			pst.setInt(7, a.getMovil());
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
			log.warn("Ha ocurrido un error desconocido al insertar alumno"
					+ ex.getStackTrace());
			id = -1;
		} finally {

			try {
				daofac.closeConnection();
			} catch (SQLException ex) {
				sqlExcepcion(ex);
			}
			return id;

		}
	}

	@Override
	public ArrayList<Amigo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Amigo> getByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amigo getByMovil(String movil) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Amigo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Amigo a, int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
