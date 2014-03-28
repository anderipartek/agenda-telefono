package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public static final String ATRIBUTO_AMIGO = "amigo";
	public static final String ATRIBUTO_MSG = "msg";
	

	public static final String LISTA_AMIGOS = "lista_amigos";
	public static final String NOMBRE_A_BUSCAR = "nombre_a_buscar";
	
	public boolean isMovil = false;
	public String prefijo = ".jsp";

	
	private ModeloAmigo modeloAmigo;
	private int codigoError = 200;
	
	private String prefix; 
	private String log4jpath;
	

	@Override
	public final void init(final ServletConfig config) throws ServletException {
		super.init(config);
		//obtiene la ruta del peoyecto
		prefix = getServletContext().getRealPath("/");
		//obtiene el nombre del archivo
    	log4jpath = getInitParameter("log4j-config"); 
    	if (log4jpath != null) {
        	PropertyConfigurator.configure(prefix + log4jpath);
    	}
    	modeloAmigo = new ModeloAmigo();
    	log.trace("Inicializado el Servlet");
    	
    	
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userAgent = request.getHeader("User-Agent");
		log.trace(userAgent);
		if (userAgent.contains("Mobile") || userAgent.contains("mobile") ){
			isMovil = true;
			prefijo = ".mobi.jsp";
		}else{
			isMovil = false;
			prefijo = ".jsp";
		}
		super.service(request, response);
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
		
		
		log.trace("Entrando en doGet");
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute(SECCION, seccion);

		if (ANADIR.equals(seccion)) { //redireccion a la pagina de añadir amigo
			dispatcher = request.getRequestDispatcher("anadir"+prefijo);
		//redirecion a la pagina de modificar amigo
		} else if (MODIFICAR.equals(seccion)) { 
			String id = (String) request.getParameter("id");
			if (id != null) {
				Amigo a = modeloAmigo.getById(Integer.parseInt(id));
				request.setAttribute(ATRIBUTO_AMIGO, a);
			}
			log.trace("Redirecionando a modificar");
			dispatcher = request.getRequestDispatcher("modificar"+prefijo);	
		//funcion para la busqueda dinamica de amigos
		} else if (BUSCAR.equals(seccion)) { 
			if (request.getParameter(NOMBRE_A_BUSCAR) != null
					&& !request.getParameter(NOMBRE_A_BUSCAR).equals("")) {
				response.setContentType("text/plain");
				response.setCharacterEncoding("UTF-8");
				String obj = new Gson().toJson(modeloAmigo.getByName(
						request.getParameter(NOMBRE_A_BUSCAR)));
				response.getWriter().write(obj);
				log.trace("Enviando datos al buscador: " + obj);
			}
		//redireccion a la pagina de elimnar amigo
		} else if (ELIMINAR.equals(seccion)) { 
			String id = (String) request.getParameter("id");
			if (id != null) {
				Amigo a = modeloAmigo.getById(Integer.parseInt(id));
				request.setAttribute(ATRIBUTO_AMIGO, a);
			}
			log.trace("Redirecionando a eliminar");
			dispatcher = request.getRequestDispatcher("eliminar"+prefijo);
			// redireccion a la pagina de ver todos los amigos
		} else if (VER.equals(seccion)) { 
			request.setAttribute(LISTA_AMIGOS, modeloAmigo.getAll());
			log.trace("Redireccionando a ver listado");
			dispatcher = request.getRequestDispatcher("ver"+prefijo);
		} else { // redireccion al index
			log.trace("Redirecionando al index");
			cargarIdioma(request);
			dispatcher = request.getRequestDispatcher("index"+prefijo);
		}
		
		if (dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * Metodo post.
	 * 
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @throws ServletException ServletException
	 * @throws IOException IOException
	 */
	@Override
	protected final void doPost(final HttpServletRequest request
			, final HttpServletResponse response)
			throws ServletException, IOException {
		log.trace("Entramos en el metodo doPost");
		String operacion = request.getParameter(OPERACION);
		RequestDispatcher dispatcher = null;

		if (ANADIR.equals(operacion)) { //enviamos el amigo a añadir
			Amigo amigo = null;
			try {
				amigo = setAmigoFromRequest(request);
				log.trace("Alumno insertado");
			} catch (Exception e) {
				log.error("Error al insertar alumno " + e.getMessage());
				request.setAttribute(ATRIBUTO_MSG, new Mensaje(
						"Error al insertar el alumno,"
						+ " comprueba que los datos sean correctos",
						codigoError, TIPO_MENSAJE.INFO));
			}
			int result = modeloAmigo.add(amigo);
			if (result != -1) {
				request.setAttribute(ATRIBUTO_AMIGO, amigo);
			} else {
				log.error("Error al añadir amigo");
				request.setAttribute(ATRIBUTO_MSG, new Mensaje(
						"Error al añadir amigo, comprueba que"
						+ " los datos sean correctos",
						codigoError, TIPO_MENSAJE.WARNING));
			}
			request.setAttribute(SECCION, "anadir");
			dispatcher = request.getRequestDispatcher("anadir"+prefijo);
		//recivimos el id del alumno de los datos a mostrar
		} else if (MOSTRAR.equals(operacion)) { 
			String id = request.getParameter("id");
			if (id != null) {
				log.trace("Mostramos el amigo a modificar");
				int idAmigo = Integer.parseInt(id);
				Amigo amigo = modeloAmigo.getById(idAmigo);
				request.setAttribute(ATRIBUTO_AMIGO, amigo);
			} else {
				log.error("No se pueden obtener los"
						+ " datos del amigo a modificar");
				request.setAttribute(ATRIBUTO_MSG, new Mensaje(
						"No se pueden obtener los datos del amigo a modificar",
						codigoError, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(SECCION, "modificar");
			dispatcher = request.getRequestDispatcher("modificar"+prefijo);
		//recivimos el id del alumno a eliminar para comprobar que existe
		} else if (MOSTRARELIMINAR.equals(operacion)) { 
				String id = request.getParameter("id");
				if (id != null) {
					log.trace("Mostramos el amigo a eliminar");
					int idAmigo = Integer.parseInt(id);
					Amigo amigo = modeloAmigo.getById(idAmigo);
					request.setAttribute(ATRIBUTO_AMIGO, amigo);
				} else {
					log.error("No se pueden obtener los"
							+ " datos del amigo a eliminar");
					request.setAttribute(ATRIBUTO_MSG, new Mensaje(
							"No se pueden obtener los datos del amigo"
							+ " a eliminar", codigoError, TIPO_MENSAJE.INFO));	
				}
				request.setAttribute(SECCION, "eliminar");
				dispatcher = request.getRequestDispatcher("eliminar"+prefijo);
		//recivimos el amigo a modificar
		} else if (MODIFICAR.equals(operacion)) { 
			Amigo amigo = null;
			try {
				amigo = setAmigoFromRequest(request);
			} catch (Exception e) {
				log.error("Error al modificar el amigo,"
						+ " datos de entrada incorrectos");
				request.setAttribute(ATRIBUTO_MSG, new Mensaje(
						"Error al modificar el amigo, comprueba"
						+ " que los datos sean correctos",
						codigoError, TIPO_MENSAJE.INFO));
			}
			if (modeloAmigo.update(amigo)) {
				request.setAttribute(ATRIBUTO_AMIGO, amigo);
				request.setAttribute(OPERACION_MODIFICAR, "ok");
			} else {
				log.error("Error al modificar el amigo en la bbdd");
				request.setAttribute(ATRIBUTO_MSG, new Mensaje(
						"Error al modificar el amigo",
						codigoError, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(SECCION, "modificar");
			dispatcher = request.getRequestDispatcher("modificar"+prefijo);
		} else if (ELIMINAR.equals(operacion)) { //revimos el amigo a eliminar
			String id = request.getParameter(DAOAmigo.ID);
			if (!id.isEmpty()) {
				request.setAttribute(OPERACION_ELIMINAR,
						modeloAmigo.delete(Integer.parseInt(id)));
			} else {
				log.warn("El id esta vacio al borrar");
				request.setAttribute(ATRIBUTO_MSG, new Mensaje(
						"No se puede eliminar el amigo",
						codigoError, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(LISTA_AMIGOS, modeloAmigo.getAll());
			request.setAttribute(SECCION, "ver");
			dispatcher = request.getRequestDispatcher("ver"+prefijo);
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

	private void cargarIdioma(HttpServletRequest request){
		//Locale por defecto Español
		Locale localeDef = new Locale("es_ES");

		//obtener lenguaje de la session del usuario
		Locale locale = request.getLocale();

		if ( (locale.getLanguage()+"_"+locale.getCountry()) == "en_EN" || locale.getLanguage() == "en"){
			HttpSession sesion= request.getSession();
			sesion.setAttribute("language", "en_EN");
			locale = new Locale("en_EN");
		}else{
			HttpSession sesion= request.getSession();
			sesion.setAttribute("language", "es_ES");
			locale = localeDef;
		}
		log.debug("locale: " + locale);


		//Cargar resourceBundle o properties dependiente del idioma

		// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale 
		ResourceBundle messages = ResourceBundle.getBundle("com.ipartek.agenda.controller.i18ntexto", locale );

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
		if (!request.getParameter(DAOAmigo.MOVIL).equals("")) {
			amigo.setMovil(Integer.parseInt(
					request.getParameter(DAOAmigo.MOVIL)));
		}
		if (!request.getParameter(DAOAmigo.FIJO).equals("")) {
			amigo.setFijo(Integer.parseInt(
					request.getParameter(DAOAmigo.FIJO)));
		}
		amigo.setAnotaciones(request.getParameter(DAOAmigo.ANOTACIONES));
		return amigo;
	}
}
