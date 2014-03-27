package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.model.ModeloAmigo;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends MainServlet {

	private static final long serialVersionUID = 1L;

	static final Logger log = Logger.getLogger(AgendaServlet.class);

	// OPCIONES RECIBIDAS DESDE EL FORMULARIO
	public static final String OP_ANADIR = "añadir";
	public static final String OP_MODIFICAR = "modificar";
	public static final String OP_ELIMINAR = "eliminar";
	public static final String OP_VER = "ver";
	public static final String OP_BUSCAR = "buscar";

	// parametros de la request
	private static int idAmigo;
	private Amigo amigo;
	public static String op;
	boolean isMobile = false;
	public static String buscadorSeccion;
	public static String nombre;
	private HashMap<Integer, Amigo> listaAmigos;
	private HashMap<Integer, Amigo> listaNombres;

	RequestDispatcher dispatcher;
	HttpSession session;
	private ModeloAmigo model;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendaServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		model = new ModeloAmigo();
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		super.destroy();
		model = null;
		amigo = null;
		listaAmigos = null;
	}

	/**
	 * Funcion que permite recoger los datos de un alumno del formulario Si se modifica el alumno, recogemos el id, sino será un alumno nuevo
	 * 
	 * @param request
	 * @param response
	 * @return retorna un alumno con los datos del formulario, null en caso de error
	 */
	private Amigo recogerDatos(HttpServletRequest request, HttpServletResponse response) {
		log.trace("Init recoger datos amigo");
		Amigo newAmigo = null;

		try {
			newAmigo = new Amigo();

			if (OP_MODIFICAR.equalsIgnoreCase(op)) {
				idAmigo = Integer.parseInt(request.getParameter("id"));
				newAmigo.setId(idAmigo);
			}

			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String calle = request.getParameter("calle");
			int cp = Integer.parseInt(request.getParameter("cp"));
			String localidad = request.getParameter("localidad");
			String provincia = request.getParameter("provincia");
			String movil = request.getParameter("movil");
			String fijo = request.getParameter("fijo");
			String anotaciones = request.getParameter("anotaciones");

			newAmigo.setNombre(nombre);
			newAmigo.setApellido(apellido);
			newAmigo.setCalle(calle);
			newAmigo.setCp(cp);
			newAmigo.setLocalidad(localidad);
			newAmigo.setProvincia(provincia);
			newAmigo.setMovil(movil);
			newAmigo.setFijo(fijo);
			newAmigo.setAnotaciones(anotaciones);

		} catch (AmigoException e) {

			log.warn("ERROR Datos de amigo no válidos [" + e.getCodigoError() + "]");
			newAmigo = null;
		} catch (Exception e) {

			log.error("Excepcion General " + e.getMessage() + " " + e.getCause() + " " + e.getLocalizedMessage());
			newAmigo = null;
		}
		log.trace("Retorno de recoger datos amigo");
		return newAmigo;
	}

	private int insertarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("Inicio insertar amigo");
		Amigo nuevoAmigo;
		// Crear nuevo alumno
		nuevoAmigo = recogerDatos(request, response);
		idAmigo = model.insertar(nuevoAmigo);
		log.trace("Fin insertar usuario");
		return idAmigo;
	}

	private boolean modificarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean result = false;
		log.trace("Inicio modificar amigo");
		Amigo amigoModificar;
		amigoModificar = recogerDatos(request, response);
		if (model.modificar(amigoModificar, idAmigo)) {
			result = true;
			log.info("Amigo modificado [" + idAmigo + "]");
		} else {
			log.info("Nose ha podido modificar amigo[" + idAmigo + "]");
		}
		log.trace("Fin modificar amigo");
		return result;

	}

	private boolean eliminarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean result = false;
		log.trace("Inicio eliminar amigo");
		idAmigo = Integer.parseInt(request.getParameter("id"));
		if (model.eliminar(idAmigo)) {
			result = true;
			log.info("Amigo eliminado [" + idAmigo + "]");
		} else {
			log.info("Nose ha podido eliminar amigo[" + idAmigo + "]");
		}

		log.trace("Fin eliminar amigo");
		return result;
	}

	private boolean verTodos(HttpServletRequest request, HttpServletResponse response) {
		boolean result = false;
		listaAmigos = model.recogerTodos();
		if (listaAmigos.size() > 0) {
			result = true;
		}
		return result;
	}

	private boolean buscarAmigos(HttpServletRequest request, HttpServletResponse response) {

		boolean result = false;
		nombre = request.getParameter("nombre");
		listaNombres = model.recogerTodosNombre(nombre);
		if (listaNombres.size() > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = null;

		// detectar agente navegacion
		String userAgent = request.getHeader("User-Agent");
		isMobile = userAgent.contains("mobile") || userAgent.contains("Mobile");

		op = request.getParameter("op");
		if (op != null) {
			if (op.equalsIgnoreCase(OP_VER)) {
				if (isMobile) {
					dispatcher = request.getRequestDispatcher("ver.mobi.jsp");
				} else if (verTodos(request, response)) {
					dispatcher = request.getRequestDispatcher("main?seccion=ver");
					// enviar datos en la request a la JSP
					request.setAttribute("listaTodos", listaAmigos);
				}

			}
		}

		// Redireccionar a la JSP
		dispatcher.forward(request, response);
		log.trace("doGet");
	}

	/**
	 * @throws AmigoException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		op = request.getParameter("op");
		buscadorSeccion = request.getParameter("buscador");
		if (op != null) {
			if (op.equalsIgnoreCase(OP_ANADIR)) {
				if (insertarAmigo(request, response) != -1) {
					dispatcher = request.getRequestDispatcher("main");

				}
			} else if (op.equalsIgnoreCase(OP_MODIFICAR)) {
				if (modificarAmigo(request, response)) {
					dispatcher = request.getRequestDispatcher("main");

				}
			} else if (op.equalsIgnoreCase(OP_ELIMINAR)) {
				if (eliminarAmigo(request, response)) {
					dispatcher = request.getRequestDispatcher("main");

				}
			} else if (op.equalsIgnoreCase(OP_BUSCAR)) {
				if (buscarAmigos(request, response)) {
					dispatcher = request.getRequestDispatcher("main?seccion=" + buscadorSeccion);
					// enviar datos en la request a la JSP
					request.setAttribute("listaNombre", listaNombres);

				}
			}
		}

		dispatcher.forward(request, response);
	}

}
