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

import com.ipartek.agenda.bbdd.ModeloAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exception.AmigoException;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	private final static Logger log=Logger.getLogger(AgendaServlet.class);
	static Amigo a;
	static ModeloAmigo model;
	RequestDispatcher dispatcher;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AgendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	model= new ModeloAmigo();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("AgendaServlet doGet" );
		ArrayList<Amigo> amigos= new ArrayList<Amigo>();
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		//redirigir a ver todos
		if (VER.equals(seccion)){
			amigos=model.getAll();
			request.setAttribute("listaAmigos", amigos);
			dispatcher = request.getRequestDispatcher("ver.jsp");
		}
		//redirigir a borrar
		
		
		else
		{
		  dispatcher = request.getRequestDispatcher("index.jsp");
		}
		

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("AgendaServlet doPost");
		insertar(request,response);
		
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		log.trace("Direccionando a insertar");
		a=new Amigo();
		String texto="";
		try {
			a.setNombre(request.getParameter("nombre"));
			a.setApellido(request.getParameter("apellido"));
			a.setCalle(request.getParameter("calle"));
			a.setCp(Integer.parseInt(request.getParameter("CP")));
			a.setLocalidad(request.getParameter("localidad"));
			a.setProvincia(request.getParameter("provincia"));
			a.setMovil(Integer.parseInt(request.getParameter("movil")));
			a.setFijo(Integer.parseInt(request.getParameter("fijo")));
			a.setAnotaciones(request.getParameter("anotaciones"));
			model.insertarAmigo(a);
			dispatcher = request.getRequestDispatcher("AgendaServlet?seccion=ver");
			texto="Añadido";
			request.setAttribute("Mensaje", texto);
		} catch (AmigoException e) {
			texto=e.getMensaje();
			request.setAttribute("Mensaje", texto);
			dispatcher = request.getRequestDispatcher("AgendaServlet?seccion=ver");
			
		}
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("Mensaje", texto);
			texto="ServletException";
			log.error("ServletException/IOException" + e.getMessage());
		}
		log.trace("Fin direccionamiento insertar");
		
		
	}
	
	

}
