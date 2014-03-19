package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.ConnectionFactory;
import com.ipartek.agenda.database.DAOAmigo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	static final Logger log = Logger.getLogger(MainServlet.class);

	private static final long serialVersionUID = 1L;

	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";

	public static final String OPERACION = "operacion";
	public static final String OPERACION_ANADIR = "operacion_anadir";
	public static final String OPERACION_MODIFICAR = "operacion_modificar";
	public static final String OPERACION_OBTENER_ALUMNO = "operacion_obtener_alumno";
	public static final String OPERACION_ELIMINAR = "operacion_eliminar";
	public static final String OPERACION_VER_TODOS = "operacion_ver_todos";
	public static final String OPERACION_VER_NOMBRE = "operacion_ver_nombre";

	public static final String AMIGO = "amigo";
	public static final String LISTA_AMIGOS = "lista_amigos";
	public static final String NOMBRE_A_BUSCAR = "nombre_a_buscar";

	public static final String ERROR = "error";
	public static final String ERROR_ID_EMPTY = "error_id_empty";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute(SECCION, seccion);

		if (ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) {
			if (request.getParameter(NOMBRE_A_BUSCAR) != null) {
				// http://stackoverflow.com/questions/4112686/how-to-use-servlets-and-ajax
				// Set content type of the response so that jQuery knows what it
				// can expect.
				response.setContentType("text/plain");
				// You want world domination, huh?
				response.setCharacterEncoding("UTF-8");
				// Write response body.
				String obj = new Gson().toJson(getAmigoByName(request.getParameter(NOMBRE_A_BUSCAR)));
				response.getWriter().write(obj);
			} else {
				if (request.getParameter("id") != null) {
					try {
						int id = Integer.parseInt(request.getParameter("id"));
						request.setAttribute(AMIGO, getAmigoById(id));
					} catch (Exception e) {
					}
				}
				dispatcher = request.getRequestDispatcher("modificar.jsp");
			}
		} else if (ELIMINAR.equals(seccion)) {
			if (request.getParameter("id") != null) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					request.setAttribute(AMIGO, getAmigoById(id));
				} catch (Exception e) {
				}
			}
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) {
			request.setAttribute(LISTA_AMIGOS, getAll());
			dispatcher = request.getRequestDispatcher("ver.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter(OPERACION);
		RequestDispatcher dispatcher = null;

		if (OPERACION_ANADIR.equals(operacion)) {
			Amigo amigo = setAmigoFromRequest(request);
			request.setAttribute(SECCION, ANADIR);
			if (anadirAmigo(amigo) > -1) {
				request.setAttribute(OPERACION_ANADIR, amigo);
			} else {
				request.setAttribute(ERROR, "No se ha podido añadir el amigo");
			}

			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (OPERACION_MODIFICAR.equals(operacion)) {
			Amigo amigo = setAmigoFromRequest(request);
			request.setAttribute(SECCION, MODIFICAR);
			request.setAttribute(OPERACION_MODIFICAR, modificarAmigo(amigo));
			request.setAttribute(AMIGO, amigo);
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (OPERACION_ELIMINAR.equals(operacion)) {
			String id = request.getParameter(DAOAmigo.ID);
			if (!id.isEmpty()) {
				request.setAttribute(OPERACION_ELIMINAR, eliminarAmigo(Integer.parseInt(id)));
			} else {
				log.warn("El id esta vacio al borrar");
				request.setAttribute(ERROR, ERROR_ID_EMPTY);
			}
			request.setAttribute(SECCION, ELIMINAR);
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (OPERACION_VER_TODOS.equals(operacion)) {
			request.setAttribute(LISTA_AMIGOS, getAmigoByName(""));
		} else if (OPERACION_VER_NOMBRE.equals(operacion)) {
			request.setAttribute(LISTA_AMIGOS, getAmigoByName(request.getParameter(NOMBRE_A_BUSCAR)));
		} else if (OPERACION_OBTENER_ALUMNO.equals(operacion)) {
			String id = request.getParameter(DAOAmigo.ID);
			if (!id.isEmpty()) {
				request.setAttribute(AMIGO, getAmigoById(Integer.parseInt(id)));
			} else {
				log.warn("El id esta vacio al borrar");
				request.setAttribute(ERROR, ERROR_ID_EMPTY);
			}
		}
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	private int anadirAmigo(Amigo amigo) {
		return ConnectionFactory.getInstance().getDAOAmigo().add(amigo);
	}

	private boolean modificarAmigo(Amigo amigo) {
		return ConnectionFactory.getInstance().getDAOAmigo().update(amigo);
	}

	private boolean eliminarAmigo(int id) {
		return ConnectionFactory.getInstance().getDAOAmigo().delete(id);
	}

	private ArrayList<Amigo> getAmigoByName(String value) {
		return ConnectionFactory.getInstance().getDAOAmigo().getByName(value);
	}

	private ArrayList<Amigo> getAll() {
		return ConnectionFactory.getInstance().getDAOAmigo().getAll();
	}

	private Amigo getAmigoById(int id) {
		return ConnectionFactory.getInstance().getDAOAmigo().getById(id);
	}

	private Amigo setAmigoFromRequest(HttpServletRequest request) {
		Amigo amigo = new Amigo();

		amigo.setId(parseString(request.getParameter(DAOAmigo.ID)));
		amigo.setNombre(request.getParameter(DAOAmigo.NOMBRE));
		amigo.setApellido(request.getParameter(DAOAmigo.APELLIDO));
		amigo.setCalle(request.getParameter(DAOAmigo.CALLE));
		amigo.setCp(parseString(request.getParameter(DAOAmigo.CP)));
		amigo.setLocalidad(request.getParameter(DAOAmigo.LOCALIDAD));
		amigo.setProvincia(request.getParameter(DAOAmigo.PROVINCIA));
		amigo.setMovil(parseString(request.getParameter(DAOAmigo.MOVIL)));
		amigo.setFijo(parseString(request.getParameter(DAOAmigo.FIJO)));
		amigo.setAnotaciones(request.getParameter(DAOAmigo.ANOTACIONES));
		return amigo;
	}

	private int parseString(String value) {
		if ((value != null) && !value.isEmpty()) {
			return Integer.parseInt(value);
		}
		return -1;
	}
}
