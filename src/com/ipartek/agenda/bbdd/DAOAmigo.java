package com.ipartek.agenda.bbdd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.bbdd.ConnectionFactory;

public class DAOAmigo implements IDAOAmigo{
	
	
	static ResultSet rs;
	static PreparedStatement pst;
	static ConnectionFactory factory;
	static StringBuilder sb;
	static Connection con;
	
	public DAOAmigo(){
		
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public boolean createAgenda() {
	/*	boolean result = false;
		Statement st;
		sb = new StringBuilder();
		try{
		String sql = "CREATE DATABASE IF NOT EXISTS 'amigo' "
		+ "( `id` int(10) NOT NULL AUTO_INCREMENT,"
		+ " `numMovil` varchar(9) NOT NULL, "
		+ "`nombre` varchar(250) NOT NULL,"
		+ " `apellido` varchar(250) NOT NULL,"
		+ " `edad` int(11) NOT NULL DEFAULT '18',"
		+ " `email` varchar(250) DEFAULT NULL,"
		+ " `f_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
		+ " `f_update` timestamp NULL DEFAULT NULL, "
		+ "`f_delete` timestamp NULL DEFAULT NULL,"
		
		st.executeQuery(sql);
		catch(Exception e){
			System.out.println("No ha conectado con la base de datos");
			}
		}*/
		return false;
	}

	@Override
	public int insertarAmigo(Amigo a) {
		int insertado = -1;
		String sql = "INSERT INTO amigos (nombre, apellido, calle, cp, localidad, provincia, movil, fijo, anotaciones )"
				+ " VALUE(?,?,?,?,?,?,?,?,?)";
		String sql2 = "select max(id) from amigos";
		try{
		//	System.out.println("pasa x aki");
			con = factory.getConnection();
			pst= con.prepareStatement(sql);
			pst.setString(1,a.getNombre());
			pst.setString(2,a.getApellido());
			pst.setString(3,a.getCalle());
			pst.setInt(4, a.getCp());
			pst.setString(5, a.getLocalidad());
			pst.setString(6, a.getProvincia());
			pst.setInt(7, a.getNumMovil());
			pst.setInt(8, a.getNumFijo());
			pst.setString(9, a.getAnotaciones());
				if(pst.executeUpdate()>0){
					
					pst = con.prepareStatement(sql2);
					rs = pst.executeQuery();
					rs.next();
					insertado=rs.getInt(1);
					a.setId(insertado);
					
				}
			}catch(Exception e){
				System.out.println("No inserta " + e.getCause());
				System.out.println("No inserta " + e.getMessage());
				insertado = -1;
			}finally{
				try{
					factory.closeConnection();
				}catch(SQLException e){
					System.out.println("No se ha podido cerrar la conexion");
				}
			}
		return insertado;
	}

	@Override
	public ArrayList<Amigo> getAll(){
		ArrayList<Amigo> lista = null;
		String sql = "select * from amigos";
		try{
			Amigo amigo;
			con = factory.getConnection();
			lista = new ArrayList<Amigo>();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				amigo = new Amigo();
				datosAmigo(rs);
				lista.add(amigo);
				}
			}catch(Exception e){
			
		}
		return lista;
	}

	@Override
	public Amigo getByNombre(String nombre) {
		String sql = "select * from amigos where nombre = ?";
		Amigo amigo =  new Amigo();
		try{
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, nombre);
			rs = pst.executeQuery();
			while(rs.next()){
				datosAmigo(rs);
			}
		}catch(Exception e){
			
		}
		return amigo;
	}

	@Override
	public boolean delete(int id) {
		Amigo amigo = new Amigo();
		boolean borrado = false;
		String sql = "delete from amigos where id =?";
		try{
			con = factory.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
				if(pst.executeUpdate() == 1){
					borrado = true;
				}else{
					borrado = false;
				}
			
		}catch(Exception e){
			System.out.println("No se ha borrado" + e.getMessage());
		}finally {
			try {
				factory.closeConnection();
			} catch (SQLException ex) {
				System.out.println("No se ha cerrado la conexion");
			}
		}
		return borrado;
	}
	//No esta terminado!!!!!
	@Override
	public boolean update(Amigo a, int id) {
		boolean actualizado = false;
		String sql = "update amigos set nombre=?, apellido=?, , calle=?, cp=?, localidad=? provincia = ?"
				+ "movil = ? fijo =? anotaciones=? where id = ?";
		try{
		con = factory.getConnection();
		pst = con.prepareStatement(sql);
		pst.executeUpdate();
			if(pst.executeUpdate() == 1){
				actualizado = true;
			}else{
				actualizado = false;
			}
		}catch(Exception e){
			System.out.println("No se ha actualizado porque " + e.getMessage());
		}
		
		return actualizado;
	}
	
	private void datosAmigo(ResultSet rs){
		Amigo a = new Amigo();
		try{
			a.setId(rs.getInt("id"));
			a.setNombre(rs.getString("nombre"));
			a.setApellido(rs.getString("apellido"));
			a.setCalle(rs.getString("calle"));
			a.setCp(rs.getInt("cp"));
			a.setLocalidad(rs.getString("localidad"));
			a.setProvincia(rs.getString("provincia"));
			a.setNumMovil(rs.getInt("movil"));
			a.setNumFijo(rs.getInt("fijo"));
			a.setAnotaciones("anotaciones");
		}catch(Exception e){
			System.out.println("el datos amigo ha cascao" + e.getMessage());
		
		}
	}

}
