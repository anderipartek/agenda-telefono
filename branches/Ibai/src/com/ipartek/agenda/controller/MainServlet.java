package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensaje;
import com.ipartek.agenda.database.DAOAmigo;
import com.ipartek.agenda.database.ModeloAmigo;
import com.ipartek.agenda.enumeration.TIPO_MENSAJE;

/**
 * Servlet implementation class MainServlet.
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 */
public class MainServlet extends HttpServlet {
	public static final Logger log = Logger.getLogger(MainServlet.class);

	private static final long serialVersionUID = 1L;

	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	public static final String BUSCAR = "buscar";
	public static final String MOSTRAR = "mostrar";
	public static final String MOSTRARELIMINAR = "mostrarEliminar";


	public static final String OPERACION = "operacion";
	public static final String OPERACION_ANADIR = "operacion_anadir";
	public static final String OPERACION_MODIFICAR = "operacion_modificar";
	public static final String OPERACION_ELIMINAR = "operacion_eliminar";
	public static final String OPERACION_VER_TODOS = "operacion_ver_todos";
	public static final String OPERACION_VER_NOMBRE = "operacion_ver_nombre";
	

	public static final String LISTA_AMIGOS = "lista_amigos";
	public static final String NOMBRE_A_BUSCAR = "nombre_a_buscar";

	
	private ModeloAmigo modeloAmigo;
	private int codigoError = 200;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
	}

	@Override
	public final void init(final ServletConfig config) throws ServletException {
		super.init(config);
		//obtiene la ruta del peoyecto
		String prefix = getServletContext().getRealPath("/");
		//obtiene el nombre del archivo
    	String log4jpath = getInitParameter("log4j-config"); 
    	if (log4jpath != null) {
        	PropertyConfigurator.configure(prefix + log4jpath);
    	}
    	modeloAmigo = new ModeloAmigo();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException ServletException
	 * @throws IOException IOException
	 */
	@Override
	protected final void doGet(final HttpServletRequest request,
			final HttpServletResponse response)
					throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute(SECCION, seccion);

		if (ANADIR.equals(seccion)) { //redireccion a la pagina de añadir amigo
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		//redirecion a la pagina de modificar amigo
		} else if (MODIFICAR.equals(seccion)) { 
			String id = (String) request.getParameter("id");
			if (id != null) {
				Amigo a = modeloAmigo.getById(Integer.parseInt(id));
				request.setAttribute("amigo", a);
			}
			dispatcher = request.getRequestDispatcher("modificar.jsp");	
		//funcion para la busqueda dinamica de amigos
		} else if (BUSCAR.equals(seccion)) { 
			if (request.getParameter(NOMBRE_A_BUSCAR) != null
					&& request.getParameter(NOMBRE_A_BUSCAR) != "") {
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				String obj = new Gson().toJson(modeloAmigo.getByName(
						request.getParameter(NOMBRE_A_BUSCAR)));
				response.getWriter().write(obj);
			}
		//redireccion a la pagina de elimnar amigo
		} else if (ELIMINAR.equals(seccion)) { 
			String id = (String) request.getParameter("id");
			if (id != null) {
				Amigo a = modeloAmigo.getById(Integer.parseInt(id));
				request.setAttribute("amigo", a);
			}
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
			// redireccion a la pagina de ver todos los amigos
		} else if (VER.equals(seccion)) { 
			request.setAttribute(LISTA_AMIGOS, modeloAmigo.getAll());
			dispatcher = request.getRequestDispatcher("ver.jsp");
		} else { // redireccion al index
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException ServletException
	 * @throws IOException IOException
	 */
	@Override
	protected final void doPost(final HttpServletRequest request
			, final HttpServletResponse response)
			throws ServletException, IOException {
		String operacion = request.getParameter(OPERACION);
		RequestDispatcher dispatcher = null;

		if (ANADIR.equals(operacion)) { //enviamos el amigo a añadir
			Amigo amigo = null;
			try {
				amigo = setAmigoFromRequest(request);
			} catch (Exception e) {
				log.error("Error al insertar alumno");
				request.setAttribute("msg", new Mensaje(
						"Error al insertar el alumno,"
						+ " comprueba que los datos sean correctos",
						codigoError, TIPO_MENSAJE.INFO));
			}
			int result = modeloAmigo.add(amigo);
			if (result != -1) {
				request.setAttribute("amigo", amigo);
			} else {
				log.error("Error al añadir amigo");
				request.setAttribute("msg", new Mensaje(
						"Error al añadir amigo, comprueba que"
						+ " los datos sean correctos",
						codigoError, TIPO_MENSAJE.WARNING));
			}
			request.setAttribute(SECCION, "anadir");
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		//recivimos el id del alumno de los datos a mostrar
		} else if (MOSTRAR.equals(operacion)) { 
			String id = request.getParameter("id");
			if (id != null) {
				int idAmigo = Integer.parseInt(id);
				Amigo amigo = modeloAmigo.getById(idAmigo);
				request.setAttribute("amigo", amigo);
			} else {
				log.error("No se pueden obtener los"
						+ " datos del amigo a modificar");
				request.setAttribute("msg", new Mensaje(
						"No se pueden obtener los datos del amigo a modificar",
						codigoError, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(SECCION, "modificar");
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		//recivimos el id del alumno a eliminar para comprobar que existe
		} else if (MOSTRARELIMINAR.equals(operacion)) { 
				String id = request.getParameter("id");
				if (id != null) {
					int idAmigo = Integer.parseInt(id);
					Amigo amigo = modeloAmigo.getById(idAmigo);
					request.setAttribute("amigo", amigo);
				} else {
					log.error("No se pueden obtener los"
							+ " datos del amigo a eliminar");
					request.setAttribute("msg", new Mensaje(
							"No se pueden obtener los datos del amigo"
							+ " a eliminar", codigoError, TIPO_MENSAJE.INFO));	
				}
				request.setAttribute(SECCION, "eliminar");
				dispatcher = request.getRequestDispatcher("eliminar.jsp");
		//recivimos el amigo a modificar
		} else if (MODIFICAR.equals(operacion)) { 
			Amigo amigo = null;
			try {
				amigo = setAmigoFromRequest(request);
			} catch (Exception e) {
				log.error("Error al modificar el amigo");
				request.setAttribute("msg", new Mensaje(
						"Error al modificar el amigo, comprueba"
						+ " que los datos sean correctos",
						codigoError, TIPO_MENSAJE.INFO));
			}
			if (modeloAmigo.update(amigo)) {
				request.setAttribute("amigo", amigo);
				request.setAttribute(OPERACION_MODIFICAR, "ok");
			} else {
				log.error("Error al modificar el amigo");
				request.setAttribute("msg", new Mensaje(
						"Error al modificar el amigo",
						codigoError, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(SECCION, "modificar");
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (ELIMINAR.equals(operacion)) { //revimos el amigo a eliminar
			String id = request.getParameter(DAOAmigo.ID);
			if (!id.isEmpty()) {
				request.setAttribute(OPERACION_ELIMINAR,
						modeloAmigo.delete(Integer.parseInt(id)));
			} else {
				log.warn("El id esta vacio al borrar");
				request.setAttribute("msg", new Mensaje(
						"No se puede eliminar el amigo",
						codigoError, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(LISTA_AMIGOS, modeloAmigo.getAll());
			request.setAttribute(SECCION, "ver");
			dispatcher = request.getRequestDispatcher("ver.jsp");
		} else if (OPERACION_VER_TODOS.equals(operacion)) {
			request.setAttribute(LISTA_AMIGOS, modeloAmigo.getByName(""));
		} else if (OPERACION_VER_NOMBRE.equals(operacion)) {
			request.setAttribute(LISTA_AMIGOS, modeloAmigo.getByName(
					request.getParameter(NOMBRE_A_BUSCAR)));
		}
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}




	/**
	 * 
	 * @param request HttpServletRequest
	 * @return el objeto amigo creado con los datos
	 * @throws Exception puede saltar por campos no validos
	 */
	private Amigo setAmigoFromRequest(
			final HttpServletRequest request) throws Exception {
		Amigo amigo = new Amigo();
		String id = request.getParameter(DAOAmigo.ID);
		if (id != null) {
			amigo.setId(Integer.parseInt(id));
		}
		amigo.setNombre(request.getParameter(DAOAmigo.NOMBRE));
		amigo.setApellido(request.getParameter(DAOAmigo.APELLIDO));
		amigo.setCalle(request.getParameter(DAOAmigo.CALLE));
		amigo.setCp(Integer.parseInt(request.getParameter(DAOAmigo.CP)));
		amigo.setLocalidad(request.getParameter(DAOAmigo.LOCALIDAD));
		amigo.setProvincia(request.getParameter(DAOAmigo.PROVINCIA));
		if (request.getParameter(DAOAmigo.MOVIL) != "") {
			amigo.setMovil(Integer.parseInt(
					request.getParameter(DAOAmigo.MOVIL)));
		}
		if (request.getParameter(DAOAmigo.FIJO) != "") {
			amigo.setFijo(Integer.parseInt(
					request.getParameter(DAOAmigo.FIJO)));
		}
		amigo.setAnotaciones(request.getParameter(DAOAmigo.ANOTACIONES));
		return amigo;
	}
}
