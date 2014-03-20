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
















import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.bean.Mensaje;
import com.ipartek.agenda.exception.ContactoException;
import com.ipartek.agenda.model.ModeloContacto;
import com.ipartek.agenda.bean.Mensaje.TIPO_MENSAJE;


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
	
	private final static Logger log = Logger.getLogger(MainServlet.class);
	
	ModeloContacto modeloContacto;
	HttpSession session;
	RequestDispatcher dispatcher;
	
	//parametros de la request
	private static String op; //Operacion a realizar	
	private static String idContacto;
		

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	 public void init(ServletConfig config) throws ServletException  {
	    	super.init(config);
	    	modeloContacto = new ModeloContacto();
	    }
	 
	 public void destroy(){
		 super.destroy();
		 modeloContacto = null;
	 }
	 


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute("seccion", seccion);
		dispatcher = request.getRequestDispatcher("index.jsp");
		
		if (ANADIR.equals(seccion)){
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		}else if (MODIFICAR.equals(seccion)){
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		}else if (ELIMINAR.equals(seccion)){
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		}else if (VER.equals(seccion)){
			listarContactos(request, response);
		}else{
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		/*
		 * if (ANADIR.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); } else if (MODIFICAR.equals(seccion)) { dispatcher =
		 * request.getRequestDispatcher("index.jsp"); } else if (ELIMINAR.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); }
		 * else if (VER.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); } else { dispatcher =
		 * request.getRequestDispatcher("index.jsp"); }
		 */

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String seccion = request.getParameter(SECCION);
		request.setAttribute("seccion", seccion);
		
		//doGet(request, response);
				//obtener dispatcher
				log.trace("doPost");
				
				//recoger a operacion a realizar
				String op = (String) request.getParameter("op");
				
				if (ANADIR.equalsIgnoreCase(op)){
					crearContacto(request, response);
				}else if (MODIFICAR.equalsIgnoreCase(op)){
					modificarContacto(request, response);
				}else if (ELIMINAR.equalsIgnoreCase(op)){
					eliminarContacto(request, response);
				}else{
					throw new ServletException("Operacion no soportada " + op);
				}
				dispatcher.forward(request, response);
				
				log.trace("doPost - Fin ");
	}
	
	private void listarContactos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Contactos");
		dispatcher = request.getRequestDispatcher("ver.jsp");

		// conectar BBDD obtener Alumnos
		ArrayList<Contacto> lContacto = modeloContacto.getAll();

		log.debug(lContacto.size() + " contactos consultados");

		request.setAttribute("listaContactos", lContacto);
		
		log.trace("Listado contactos salir");

	}
	
private void crearContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.trace("crearContacto");
		Contacto contacto = null;
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
		
		//crear contacto
		try {
			contacto = new Contacto();
			contacto.setNombre(nombre);
			contacto.setApellido(apellido);
			contacto.setCalle(calle);
			contacto.setCp(cp);
			contacto.setLocalidad(localidad);
			contacto.setProvincia(provincia);
			contacto.setMovil(movil);
			contacto.setFijo(fijo);
			contacto.setAnotaciones(anotaciones);
			//INSERT INTO DDBB
			modeloContacto.insert(contacto);
			log.info("Contacto insertado " + contacto.toString());
			request.setAttribute("msg",new Mensaje("Contacto insertado", 200, Mensaje.TIPO_MENSAJE.INFO));
		} catch (ContactoException e) {
			log.warn("Datos del contacto no validos " + e.getMessage());
			//Mensaje de error
			request.setAttribute("msg", new Mensaje(e.getMensajeError(), e.getCodigoError(), Mensaje.TIPO_MENSAJE.ERROR));
		
			
		} catch (Exception e) {
			log.warn("Excepcion general " + e.getMessage());
			//Mensaje de error
			request.setAttribute("msg", new Mensaje("Excepcion general", 0, Mensaje.TIPO_MENSAJE.ERROR));
		}
		
		//enviar contacto a la JSP
		request.setAttribute("todook", contacto);
		
		//titulo para la JSP
		request.setAttribute("title", "Insertar Contacto");
		
		//dispatcher
		dispatcher = request.getRequestDispatcher("todoOk.jsp");
		
		log.trace("FIN - Insertar contacto");
		
		
		dispatcher.forward(request, response);
		log.trace("Fin crear contacto");	
		
	}

private void eliminarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	log.trace("modificarContacto");
	try {
		String id = (String)request.getParameter("id");
		//INSERT INTO DDBB
		if (!modeloContacto.delete(Integer.parseInt(id))){
			request.setAttribute("msg", new Mensaje("No se ha podido eliminar el Contacto, por favor consulte con el Administrador de la AppWeb", 3, TIPO_MENSAJE.ERROR));
		}else{
		log.info("Contacto Eliminado ["+id+"]");
		request.setAttribute("msg",new Mensaje("Contacto eliminado", 200, Mensaje.TIPO_MENSAJE.INFO));
		}
	} catch (Exception e) {
		log.warn("Excepcion general " + e.getMessage());
		//Mensaje de error
		request.setAttribute("msg", new Mensaje("Excepcion general", 0, Mensaje.TIPO_MENSAJE.ERROR));
	}
	
	
	//titulo para la JSP
	request.setAttribute("title", "Listado Contacto");
	
	//dispatcher
	dispatcher = request.getRequestDispatcher("todoOk.jsp");
	
	this.doGet(request,response);
	log.trace("FIN - Eliminar alumno");
	
	
	
}

private void modificarContacto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	log.trace("modificarContacto");
	Contacto contacto = null;
	//TODO recoger parametros del formulario
	String id = (String)request.getParameter("id");
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
	
	//crear contacto
	try {
		contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellido(apellido);
		contacto.setCalle(calle);
		contacto.setCp(cp);
		contacto.setLocalidad(localidad);
		contacto.setProvincia(provincia);
		contacto.setMovil(movil);
		contacto.setFijo(fijo);
		contacto.setAnotaciones(anotaciones);
		//INSERT INTO DDBB
		if (! modeloContacto.update(contacto, Integer.parseInt(id))){
			request.setAttribute("msg", new Mensaje("No se ha podido modificar el Contacto, por favor consulte con el Administrador de la AppWeb", 3, TIPO_MENSAJE.ERROR));
		}
		log.info("Contacto modificado " + contacto.toString());
		request.setAttribute("msg",new Mensaje("Contacto modificado", 200, Mensaje.TIPO_MENSAJE.INFO));
	
	} catch (ContactoException e) {
		log.warn("Datos del contacto no validos " + e.getMessage());
		//Mensaje de error
		request.setAttribute("msg", new Mensaje(e.getMensajeError(), e.getCodigoError(), Mensaje.TIPO_MENSAJE.ERROR));
	}
		
	catch (Exception e) {
		log.warn("Excepcion general " + e.getMessage());
		//Mensaje de error
		request.setAttribute("msg", new Mensaje("Excepcion general", 0, Mensaje.TIPO_MENSAJE.ERROR));
	}
	
	//enviar contacto a la JSP
	request.setAttribute("todook", contacto);
	
	//titulo para la JSP
	request.setAttribute("title", "Modificar Contacto");
	
	//dispatcher
	dispatcher = request.getRequestDispatcher("todoOk.jsp");
	
	log.trace("FIN - Modificar contacto");
	
	
	dispatcher.forward(request, response);
	log.trace("Fin modificar contacto");
	
	
}


	

}
