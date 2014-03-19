package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.agenda.modelo.ModeloAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensaje;
import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.modelo.ModeloAmigo;


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
	RequestDispatcher dispatcher = null;
	private final static Logger log = Logger.getLogger(MainServlet.class);
	ModeloAmigo modelAmigo;
	HttpSession session;

	//parametros de la request
	private static String op; //Operacion a realizar	
	private static String idAmigo;
		
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
	modelAmigo = new ModeloAmigo();
}

@Override
public void destroy() {
	super.destroy();
	modelAmigo =null;
}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		

		if (ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
			crearAmigo(request, response);
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

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void crearAmigo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.trace("crearAmigo");
		Amigo a = null;
		// crear Amigo
		try {
			a = recogerDatos(request, response);		
			// Insert into DDBB
			modelAmigo.insert(a);
			log.info("Amigo insertado " + a.toString());
		} catch (Exception e) {
			log.warn("Excepcion general " + e.getMessage());
		}
		// enviar alumno a la JSP
		//request.setAttribute("detalleAlumno", a);
		// titulo para la JSP
		//request.setAttribute("title", "Insertar Alumno");
		// dispatcher
		
		dispatcher = request.getRequestDispatcher("todoOk.jsp");
		dispatcher.forward(request, response);
		log.trace("crearAmigo - Fin");
		
	}
	
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Amigos");
		dispatcher = request.getRequestDispatcher("ver.jsp");

		// conectar BBDD obtener Alumnos
		ArrayList<Amigo> lAmigo = modelAmigo.getAll();

		log.debug(lAmigo.size() + " Amigos consultados");

		request.setAttribute("listaAmigos", lAmigo);
		
		if ( ELIMINAR.equalsIgnoreCase(op)){
			request.setAttribute("msg", new Mensaje("Alumno Eliminado Correctamente", 200, Mensaje.TIPO_MENSAJE.INFO));
		}

	}
	
	private Amigo recogerDatos(HttpServletRequest request,
			HttpServletResponse response) throws AmigoException {
		log.trace("Init recoger datos alumno");
		Amigo amigoNuevo =  new Amigo();
		
		//coger datos del formulario
		String nom=(String) request.getParameter("nombre");
		String ape=(String) request.getParameter("apellido");
		String call=(String) request.getParameter("calle");
		int codigop = Integer.parseInt(request.getParameter("cp"));
		String loc=(String) request.getParameter("localidad");
		String prov=(String) request.getParameter("provincia");
		int mov = Integer.parseInt(request.getParameter("movil"));
		int fij = Integer.parseInt(request.getParameter("fijo"));
		String anot=(String) request.getParameter("anotaciones");
		
		//meter los datos nuevos en el nuevo amigo
		amigoNuevo.setNombre(nom);
		amigoNuevo.setApellido(ape);
		amigoNuevo.setCalle(call);
		amigoNuevo.setCp(codigop);
		amigoNuevo.setLocalidad(loc);
		amigoNuevo.setProvincia(prov);
		amigoNuevo.setMovil(mov);
		amigoNuevo.setFijo(fij);
		amigoNuevo.setAnotaciones(anot);
		
		log.trace("Retorno de recoger datos amigo");
		return amigoNuevo;
	}
}
