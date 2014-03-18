package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;






import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.bean.Mensaje;
import com.ipartek.agenda.model.ModeloContacto;


/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	
	private final static Logger log = Logger.getLogger(MainServlet.class);
	
	ModeloContacto modeloContacto;
	HttpSession session;
	RequestDispatcher dispatcher;
	
	//parametros de la request
	private static String op; //Operacion a realizar	
	private static String idContacto;
		

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute("seccion", seccion);
		dispatcher = request.getRequestDispatcher("index.jsp");
		/*
		 * if (ANADIR.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); } else if (MODIFICAR.equals(seccion)) { dispatcher =
		 * request.getRequestDispatcher("index.jsp"); } else if (ELIMINAR.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); }
		 * else if (VER.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); } else { dispatcher =
		 * request.getRequestDispatcher("index.jsp"); }
		 */

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listarContactos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Contactos");
		dispatcher = request.getRequestDispatcher("ver.jsp");

		// conectar BBDD obtener Alumnos
		ArrayList<Contacto> lContacto = modeloContacto.getAll();

		log.debug(lContacto.size() + " contactos consultados");

		request.setAttribute("listaContactos", lContacto);
		
		if ( ELIMINAR.equalsIgnoreCase(op)){
			request.setAttribute("msg", new Mensaje("Alumno Eliminado Correctamente", 200, Mensaje.TIPO_MENSAJE.INFO));
		}

	}

}
