package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.modelo.ModeloAmigo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger log=Logger.getLogger(MainServlet.class);
	
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	
	RequestDispatcher dispatcher=null;
	ModeloAmigo modelAmigo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		modelAmigo = new ModeloAmigo();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		modelAmigo=null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		

		request.setAttribute("seccion", seccion);

		if (ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (ELIMINAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) {
			listarAmigos(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}

		dispatcher.forward(request, response);
	}
	
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Amigos");
		dispatcher = request.getRequestDispatcher("ver.jsp");
		
		// conectar BBDD obtener amigos
		ArrayList<Amigo> listaAmigos = modelAmigo.getAll();
		
		log.debug(listaAmigos.size() + " amigos consultados");
		
		request.setAttribute("listaAmigos", listaAmigos);
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
