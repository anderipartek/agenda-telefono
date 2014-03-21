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

import com.ipartek.agenda.bbdd.ModeloAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends AgendaServletMaestro {
	private static final long serialVersionUID = 1L;
	private final static Logger log = Logger.getLogger(MainServlet.class);

	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	
	private static String idAmigo;
	private static String nombre;
	
	public static String modo;
	
	RequestDispatcher dispatcher = null;
	ModeloAmigo modelAmigo;

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
		modelAmigo = null;
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		idAmigo = (String)request.getParameter("id");
		// realizar servicio
		super.service(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		request.setAttribute("seccion", seccion);

		if (ANADIR.equals(seccion)) {
			modo="anadir";
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)||(null != idAmigo)) {
			modo="modificar";
			detalleAmigo(request, response);			
		} else if (ELIMINAR.equals(seccion)) {
			modo="eliminar";
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) {
			listarAmigos(request, response);
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (modo=="anadir"){
			crearAmigo(request, response);
		}else if (modo=="eliminar"){
			buscarAmigos(request, response);
		}
	}

	private void crearAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
		dispatcher = request.getRequestDispatcher("todoOk.jsp");
		dispatcher.forward(request, response);
		log.trace("crearAmigo - Fin");
	}
	
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Amigos");
		dispatcher = request.getRequestDispatcher("ver.jsp");
		
		// conectar BBDD obtener amigos
		ArrayList<Amigo> listaAmigos = modelAmigo.getAll();
		
		log.debug(listaAmigos.size() + " amigos consultados");
		
		request.setAttribute("listaAmigos", listaAmigos);
		
	}
	
	private void detalleAmigo(HttpServletRequest request, HttpServletResponse response) {
		// detalle
		log.trace("Detalle amigo " + idAmigo);
		dispatcher = request.getRequestDispatcher("modificar.jsp");

		// obtener Alumnos
		Amigo a = modelAmigo.getAmigoById(idAmigo);
		// enviar datos en la request a la JSP
		request.setAttribute("detalleAmigo", a);
		// post method
		request.setAttribute("method", "post");
		request.setAttribute("title", "Modificar amigo");

	}
	
	private void buscarAmigos(HttpServletRequest request, HttpServletResponse response){
		/*ArrayList<Amigo> listaAmigos = modelAmigo.getAmigoByName(nombre);
		request.setAttribute("listaAmigos", listaAmigos);*/
		
	}
	private Amigo recogerDatos(HttpServletRequest request, HttpServletResponse response){
		
		log.trace("Init recoger datos alumno");
		Amigo newAmigo =  new Amigo();
				
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
		newAmigo.setNombre(nom);
		newAmigo.setApellido(ape);
		newAmigo.setCalle(call);
		newAmigo.setCp(codigop);
		newAmigo.setLocalidad(loc);
		newAmigo.setProvincia(prov);
		newAmigo.setMovil(mov);
		newAmigo.setFijo(fij);
		newAmigo.setAnotaciones(anot);
		
		log.trace("Retorno de recoger datos amigo");
		return newAmigo;

	}
}
