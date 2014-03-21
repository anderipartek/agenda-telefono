package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.agenda.bbdd.DAOAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class AgendaAñadirServlet
 */
public class AgendaAñadirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAmigo dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaAñadirServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	dao = new DAOAmigo();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher;
		
		//Creamos el DAO que maneja los amigos
		
		
		//recogemos los datos 
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String calle = request.getParameter("calle");
		int cp = Integer.parseInt(request.getParameter("cp"));
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		int movil = Integer.parseInt(request.getParameter("movil"));
		int fijo = Integer.parseInt(request.getParameter("fijo"));
		String anotaciones = request.getParameter("anotaciones");
		String añadir = request.getParameter("anadir");
		
		//metemos los datos en un objeto de tipo amigo
		Amigo amigoDePrueba = new Amigo();
		amigoDePrueba.setNombre(nombre);
		amigoDePrueba.setApellido(apellido);
		amigoDePrueba.setCalle(calle);
		amigoDePrueba.setCp(cp);
		amigoDePrueba.setLocalidad(localidad);
		amigoDePrueba.setProvincia(provincia);
		amigoDePrueba.setNumMovil(movil);
		amigoDePrueba.setNumFijo(fijo);
		amigoDePrueba.setAnotaciones(anotaciones);
		
		request.setAttribute("añadido", amigoDePrueba);
		//insertamos el amigo en la bd
		if(amigoDePrueba!= null){
			if(dao.insertarAmigo(amigoDePrueba)!= -1){
				request.setAttribute("amigoDePrueba", amigoDePrueba);
			}
		}
		
		
		
		//si se inserta bien, vamos a ver.jsp para ver el resultado 
			dispatcher  = request.getRequestDispatcher("ver.jsp");
			dispatcher.forward(request, response);
		
	}

}
