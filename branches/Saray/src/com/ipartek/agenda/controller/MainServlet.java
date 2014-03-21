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
		String seccion = request.getParameter(SECCION);

		request.setAttribute("seccion", seccion);
		
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
		request.setAttribute("accion", accion);

		if ("anadir".equals(accion)) {
			crearAmigo(request, response);

		
		}else if ("buscar".equals(accion)) {
				buscador(request, response);
		}else if ("modificar".equals(accion)) {			
					
					modificarAmigo(request, response);		
		}else if("eliminar".equals(accion)){
			eliminarAmigo(request,response);
		}

		dispatcher.forward(request, response);
	}

	private void eliminarAmigo(HttpServletRequest request,
			HttpServletResponse response) {
		
	}

	private void buscador(HttpServletRequest request,
			HttpServletResponse response) {
		String nombreBuscar = request.getParameter("nombreBuscar");
		
			ArrayList<Amigo> listaAmigosBuscador = factory.getDAOAmigo().getByNombre(nombreBuscar);
			request.setAttribute("listaAmigosBuscador", listaAmigosBuscador);
	
		dispatcher = request.getRequestDispatcher("modificar.jsp");
		
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
	

		boolean result = factory.getDAOAmigo().update(a,a.getId());
		if (result) {
			log.info("Amigo Modificado " + a.toString());
			dispatcher = request.getRequestDispatcher("todoOk.jsp");
		} else {
			textoError = "Error en la modificacion del contacto";
			request.setAttribute("mensaje", textoError);
		}
		
		request.setAttribute("listaAmigosBuscador", a);
		dispatcher = request.getRequestDispatcher("modificar.jsp");
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
