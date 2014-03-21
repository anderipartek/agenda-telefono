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
public class MainServlet extends ServletMaestro {
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
		doGet(request, response);
		
	}
	

	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Amigos");
		dispatcher = request.getRequestDispatcher("ver.jsp");

		// conectar BBDD obtener Amigos
		ArrayList<Amigo> lAmigo = modelAmigo.getAll();

		log.debug(lAmigo.size() + " Amigos consultados");

		request.setAttribute("listaAmigos", lAmigo);
		
		if ( ELIMINAR.equalsIgnoreCase(op)){
			request.setAttribute("msg", new Mensaje("Amigo Eliminado Correctamente", 200, Mensaje.TIPO_MENSAJE.INFO));
		}

	}
	private void borrarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		log.trace("Eliminar Amigo");
		Amigo a=null;
		//Modificar Amigo
		String id=(String)request.getParameter("id");
		//Modificar
		Mensaje msg=null;
		try {
			a = new Amigo();
		
		    ModeloAmigo modelAmigo=new ModeloAmigo();
		    if (!modelAmigo.delete(Integer.parseInt(id))){
		    log.error("No se ha podido eliminar el Amigo. Consulte con su administrador");
		    request.setAttribute("msg", new Mensaje("Amigo Modificado",200,Mensaje.TIPO_MENSAJE.ERROR));
		    }
		    log.info("Amigo Eliminado[" + id + "]" );
		    	msg=new Mensaje("Usuario Modificado",703,Mensaje.TIPO_MENSAJE.INFO);
		    	request.setAttribute("msg", new Mensaje("Amigo Eliminado",200,Mensaje.TIPO_MENSAJE.INFO));
		    
		} catch (Exception e1) {
			log.warn("Excepcion general" + e1.getMessage());
			 request.setAttribute("msg", new Mensaje("Amigo Modificado",200,Mensaje.TIPO_MENSAJE.ERROR));
		}
		
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher= request.getRequestDispatcher("eliminar.jsp");
			dispatcher.forward(request, response);
		log.trace("Eliminar Amigo- Fin");
	}
	private void crearAmigo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.trace("crearAmigo");
		
		Amigo a = null;
		//TODO recoger parametros del formulario
		String nombre = (String)request.getParameter("nombre");
		String apellido = (String)request.getParameter("apellido");
		String calle = (String)request.getParameter("calle");
		int cp = Integer.parseInt(request.getParameter("cp"));
		String localidad = (String)request.getParameter("localidad");
		String provincia = (String)request.getParameter("provincia");
		int movil = Integer.parseInt(request.getParameter("movil"));
		int fijo = Integer.parseInt(request.getParameter("fijo"));
		String anotaciones = (String)request.getParameter("anotaciones");
		
		//apellido
		//calle
		//cp
		//no poner inicializar variables en mayusculas porque se confunde con clase
		//crear Amigo
		try {
			a = new Amigo();
			a.setNombre(nombre);
			a.setApellido(apellido);
			a.setCalle(calle);
			a.setCp(cp);
			a.setLocalidad(localidad);
			a.setProvincia(provincia);
			a.setMovil(movil);
			a.setFijo(fijo);
			a.setAnotaciones(anotaciones);
			//INSERT INTO DDBB
			modelAmigo.insert(a);
			log.info("Amigo insertado " + a.toString());
			request.setAttribute("msg",new Mensaje("Amigo insertado", 200, Mensaje.TIPO_MENSAJE.INFO));
		} catch (AmigoException e) {
			log.warn("Datos del Amigo no validos " + e.getMessage());
			//Mensaje de error
			request.setAttribute("msg", new Mensaje(e.getMensaje(), e.getCodigo(), Mensaje.TIPO_MENSAJE.ERROR));
		
			
		} catch (Exception e) {
			log.warn("Excepcion general " + e.getMessage());
			//Mensaje de error
			request.setAttribute("msg", new Mensaje("Excepcion general", 0, Mensaje.TIPO_MENSAJE.ERROR));
		}
		
		
		
		//dispatcher
		dispatcher = request.getRequestDispatcher("todoOk.jsp");
		
		
		
		
		
		log.trace("Fin crear Amigo");	
		
	}
	

}
