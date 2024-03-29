package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.DAOAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(MainServlet.class);
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	boolean isMobile=false;
	
	DAOAmigo daoAmigo;
	RequestDispatcher dispatcher = null;
	ConnectionFactory factory;
	String textoError;
	
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = ConnectionFactory.getInstance();

	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.debug("Comienza doGEt");
		
		String id = request.getParameter("ID");
		
		if(id!=null){
			
			Amigo amigo =  factory.getDAOAmigo().getById(Integer.parseInt(id));
			request.setAttribute("idAmigo", amigo);
			dispatcher = request.getRequestDispatcher("detalle.mobile.jsp");
			
			
		}else{
			
		
		

		//Locale por defecto Español
		Locale locale = new Locale("es_ES");

		//obtener lenguaje de la session del usuario
		String language = (String) request.getSession().getAttribute("language");

		if ( language != null ){
		locale = new Locale(language);
		}
		log.debug("language: " + language + " locale: " + locale);


		//Cargar resourceBundle o properties dependiente del idioma

		// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale 
		ResourceBundle messages = ResourceBundle.getBundle("com.ipartek.agenda.controller.i18nmessages_es_ES", locale );
		
		String seccion = request.getParameter(SECCION);
		request.setAttribute("seccion", seccion);
		//controlar si es dispositivo es un movil
		String userAgent = request.getHeader("User-Agent");
		isMobile = userAgent.contains("Mobile") || userAgent.contains("mobile");
		
		if (ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) {

			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (ELIMINAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) {
			mostrarListaAmigos(request, response);
			dispatcher = request.getRequestDispatcher("ver.jsp");

		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		
		if(isMobile){
			log.debug("es movil");
			dispatcher = request.getRequestDispatcher("ver.mobile.jsp");
			
		}				
		}

		dispatcher.forward(request, response);
		
	}

	private void mostrarListaAmigos(HttpServletRequest request,
			HttpServletResponse response) {
		// listando
		log.trace("Listado Amigos");
		// conectar BBDD obtener Amigos
		ArrayList<Amigo> listaAmigos = factory.getDAOAmigo().getAll();
		log.debug(listaAmigos.size() + " alumnos consultados");
		request.setAttribute("listaAmigos", listaAmigos);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		RequestDispatcher dispatcher = null;

		if ("anadir".equals(accion)) {
			crearAmigo(request, response);

		} else if ("modificar".equals(accion)) {
			modificarAmigo(request, response);
		} else if ("eliminar".equals(accion)) {
			eliminarAmigo(request, response);
		}
		request.setAttribute("accion", accion);
		//dispatcher.forward(request, response);
	}

	private void eliminarAmigo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int idAmigo = Integer.parseInt(request.getParameter("id"));
	
		boolean result = factory.getDAOAmigo().delete(idAmigo);
		if (!result) {
			textoError = "Error en la borrado del contacto";
			request.setAttribute("mensaje", textoError);

		} else {
			log.info("Amigo Modificado ");
			dispatcher = request.getRequestDispatcher("todoOk.jsp");
		}

		dispatcher.forward(request, response);
		

	}


	private void modificarAmigo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Amigo a = new Amigo();
		int idAmigo = Integer.parseInt(request.getParameter("id"));

		a.setId(idAmigo);
		a.setNombre(request.getParameter("nombre"));
		a.setApellido(request.getParameter("apellido"));
		a.setCalle(request.getParameter("calle"));
		a.setCp(Integer.valueOf(request.getParameter("cp")));
		a.setLocalidad(request.getParameter("localidad"));
		a.setProvincia(request.getParameter("provincia"));
		a.settMovil(Integer.valueOf(request.getParameter("movil")));
		a.settFijo(Integer.valueOf(request.getParameter("fijo")));

		boolean result = factory.getDAOAmigo().update(a, idAmigo);
		if (!result) {
			textoError = "Error en la modificacion del contacto";
			request.setAttribute("mensaje", textoError);

		} else {
			log.info("Amigo Modificado " + a.toString());
			dispatcher = request.getRequestDispatcher("todoOk.jsp");
		}

		request.setAttribute("listaAmigosBuscador", a);
		// dispatcher = request.getRequestDispatcher("modificar.jsp");
		dispatcher.forward(request, response);

	}

	private void crearAmigo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		Amigo a = new Amigo();
		a.setNombre(request.getParameter("nombre"));
		a.setApellido(request.getParameter("apellido"));
		a.setCalle(request.getParameter("calle"));
		a.setCp(Integer.parseInt(request.getParameter("CP")));
		a.setLocalidad(request.getParameter("localidad"));
		a.setProvincia(request.getParameter("provincia"));
		a.settMovil(Integer.parseInt(request.getParameter("movil")));
		a.settFijo(Integer.parseInt(request.getParameter("fijo")));

		int result = factory.getDAOAmigo().insertAmigo(a);

		if (result != -1) {
			request.setAttribute("amigo", a);
			dispatcher = request.getRequestDispatcher("todoOk.jsp");

		} else {
			String texto = "Faltan datos en el formulario";
			request.setAttribute("mensaje", texto);
			String nombreError = "Necesitamos saber su nombre";
			request.setAttribute("nombre", nombreError);
			String telefonoError = "Necesitamos saber su telefono";
			request.setAttribute("telefono", telefonoError);
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		}
	}
}
