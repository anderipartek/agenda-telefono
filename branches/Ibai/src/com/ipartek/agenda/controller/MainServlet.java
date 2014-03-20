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
import org.apache.log4j.PropertyConfigurator;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensaje;
import com.ipartek.agenda.database.ConnectionFactory;
import com.ipartek.agenda.database.DAOAmigo;
import com.ipartek.agenda.database.ModeloAmigo;
import com.ipartek.agenda.enumeration.TIPO_MENSAJE;

/**
 * Servlet implementation class MainServlet
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

	public static final String ERROR = "error";
	public static final String ERROR_ID_EMPTY = "error_id_empty";
	
	public ModeloAmigo modeloAmigo;

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
		String prefix = getServletContext().getRealPath("/"); //obtiene la ruta del peoyecto
    	String log4jpath = getInitParameter("log4j-config"); //obtiene el nombre del archivo
    	if (log4jpath != null){
        	PropertyConfigurator.configure(prefix+log4jpath);
    	}
    	modeloAmigo = new ModeloAmigo();
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

		if (ANADIR.equals(seccion)) { //redireccion a la pagina de añadir amigo
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) { //redirecion a la pagina de modificar amigo
			dispatcher = request.getRequestDispatcher("modificar.jsp");	
		} else if (BUSCAR.equals(seccion)) { //funcion para la busqueda dinamica de amigos
			if (request.getParameter(NOMBRE_A_BUSCAR) != null && request.getParameter(NOMBRE_A_BUSCAR) != "") {
				// http://stackoverflow.com/questions/4112686/how-to-use-servlets-and-ajax
				// Set content type of the response so that jQuery knows what it
				// can expect.
				response.setContentType("text/plain");
				// You want world domination, huh?
				response.setCharacterEncoding("UTF-8");
				// Write response body.
				String obj = new Gson().toJson(getAmigoByName(request.getParameter(NOMBRE_A_BUSCAR)));
				response.getWriter().write(obj);
			}
		} else if (ELIMINAR.equals(seccion)) { //redireccion a la pagina de elimnar amigo
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) { // redireccion a la pagina de ver todos los amigos
			request.setAttribute(LISTA_AMIGOS, getAll());
			dispatcher = request.getRequestDispatcher("ver.jsp");
		} else { // redireccion al index
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		if (dispatcher != null){
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

		if (ANADIR.equals(operacion)) { //enviamos el amigo a añadir
			Amigo amigo = null;
			try {
				amigo = setAmigoFromRequest(request);
			} catch (Exception e) {
				log.error("Error al insertar alumno");
				request.setAttribute("msg", new Mensaje("Error al insertar el alumno, comprueba que los datos sean correctos", 200, TIPO_MENSAJE.INFO));
			}
			int result = anadirAmigo(amigo);
			if (result != -1){
				request.setAttribute("amigo", amigo);
			}else{
				log.error("Error al añadir amigo");
				request.setAttribute("msg", new Mensaje("Error al añadir amigo, comprueba que los datos sean correctos", 200, TIPO_MENSAJE.WARNING));
			}
			request.setAttribute(SECCION, "anadir");
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MOSTRAR.equals(operacion)) { //recivimos el id del alumno de los datos a mostrar
			String id = request.getParameter("id");
			if (id != null) {
				int idAmigo = Integer.parseInt(id);
				Amigo amigo = getAmigoById(idAmigo);
				request.setAttribute("amigo", amigo);
			}else{
				log.error("No se pueden obtener los datos del amigo a modificar");
				request.setAttribute("msg", new Mensaje("No se pueden obtener los datos del amigo a modificar", 200, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(SECCION, "modificar");
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (MOSTRARELIMINAR.equals(operacion)) { //recivimos el id del alumno a eliminar para comprobar que existe
				String id = request.getParameter("id");
				if (id != null) {
					int idAmigo = Integer.parseInt(id);
					Amigo amigo = getAmigoById(idAmigo);
					request.setAttribute("amigo", amigo);
				}else{
					log.error("No se pueden obtener los datos del amigo a eliminar");
					request.setAttribute("msg", new Mensaje("No se pueden obtener los datos del amigo a eliminar", 200, TIPO_MENSAJE.INFO));	
				}
				request.setAttribute(SECCION, "eliminar");
				dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (MODIFICAR.equals(operacion)) { //recivimos el amigo a modificar
			Amigo amigo = null;
			try{
				amigo = setAmigoFromRequest(request);
			}catch(Exception e){
				log.error("Error al modificar el amigo");
				request.setAttribute("msg", new Mensaje("Error al modificar el amigo, comprueba que los datos sean correctos", 200, TIPO_MENSAJE.INFO));
			}
			if (modificarAmigo(amigo))
			{
				request.setAttribute("amigo", amigo);
				request.setAttribute(OPERACION_MODIFICAR, "ok");
			}else{
				log.error("Error al modificar el amigo");
				request.setAttribute("msg", new Mensaje("Error al modificar el amigo", 200, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(SECCION, "modificar");
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (ELIMINAR.equals(operacion)) { //revimos el amigo a eliminar
			String id = request.getParameter(DAOAmigo.ID);
			if (!id.isEmpty()) {
				request.setAttribute(OPERACION_ELIMINAR, eliminarAmigo(Integer.parseInt(id)));
			} else {
				log.warn("El id esta vacio al borrar");
				request.setAttribute("msg", new Mensaje("No se puede eliminar el amigo", 200, TIPO_MENSAJE.INFO));
			}
			request.setAttribute(LISTA_AMIGOS, getAll());
			request.setAttribute(SECCION, "ver");
			dispatcher = request.getRequestDispatcher("ver.jsp");
		} else if (OPERACION_VER_TODOS.equals(operacion)) {
			request.setAttribute(LISTA_AMIGOS, getAmigoByName(""));
		} else if (OPERACION_VER_NOMBRE.equals(operacion)) {
			request.setAttribute(LISTA_AMIGOS, getAmigoByName(request.getParameter(NOMBRE_A_BUSCAR)));
		}
		if (dispatcher != null){
			dispatcher.forward(request, response);
		}
	}

	private int anadirAmigo(Amigo amigo) {
		return modeloAmigo.add(amigo);
	}

	private boolean modificarAmigo(Amigo amigo) {
		return modeloAmigo.update(amigo);
	}

	private boolean eliminarAmigo(int id) {
		return modeloAmigo.delete(id);
	}

	private ArrayList<Amigo> getAmigoByName(String value) {
		return modeloAmigo.getByName(value);
	}
	
	private ArrayList<Amigo> getAll() {
		return modeloAmigo.getAll();
	}

	private Amigo getAmigoById(int id) {
		return modeloAmigo.getById(id);
	}

	private Amigo setAmigoFromRequest(HttpServletRequest request) throws Exception{
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
		if (request.getParameter(DAOAmigo.MOVIL)!= "")
			amigo.setMovil(Integer.parseInt(request.getParameter(DAOAmigo.MOVIL)));
		if (request.getParameter(DAOAmigo.FIJO)!= "")
			amigo.setFijo(Integer.parseInt(request.getParameter(DAOAmigo.FIJO)));
		amigo.setAnotaciones(request.getParameter(DAOAmigo.ANOTACIONES));
		return amigo;
	}
}
