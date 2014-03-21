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

import com.ipartek.agenda.bbdd.DAOAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.modelo.ModeloAmigo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger log=Logger.getLogger(MainServlet.class);
	
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	public static String apartado;
	
	RequestDispatcher dispatcher=null;
	ModeloAmigo modelAmigo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		
	}

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		modelAmigo = new ModeloAmigo();
	}
	
	
	@Override
	public void destroy() {	
		super.destroy();
		modelAmigo=null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		request.setAttribute("seccion", seccion);

		if (ANADIR.equals(seccion)) {
			apartado = "anadir";
			dispatcher = request.getRequestDispatcher("anadir.jsp");
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
	 * Lista los amigos que existen en la base de datos
	 * @param request
	 * @param response
	 */
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) {
		// listando
		log.trace("Listado Amigos");
		dispatcher = request.getRequestDispatcher("ver.jsp");
		
		// conectar BBDD obtener amigos
		ArrayList<Amigo> listaAmigos = modelAmigo.getAll();
		
		log.debug(listaAmigos.size() + " amigos consultados");
		
		request.setAttribute("listaAmigos", listaAmigos);
	}
	
	/**
	 * REcoge los datos facilitados en el formulario
	 * @param request
	 * @param response
	 * @return
	 */
	
	private Amigo recogerDatos(HttpServletRequest request, HttpServletResponse response){
		
		log.trace("Init recoger datos alumno");
		Amigo newAmigo =  new Amigo();
		
	
		String nom=(String) request.getParameter("nombre");
		String ape=(String) request.getParameter("apellido");
		String call=(String) request.getParameter("calle");
		int codigop = -1;
		try{
			codigop = Integer.parseInt(request.getParameter("cp"));
		}catch(Exception e){
			log.warn("Imposible parsear a entero el CP= " + request.getParameter("cp") );
		}
		String loc=(String) request.getParameter("localidad");
		String prov=(String) request.getParameter("provincia");
		int mov = -1;
		try{
			mov = Integer.parseInt(request.getParameter("movil"));
		}catch (Exception e){
			log.warn("Imposible parsear a entero el movil= " + request.getParameter("movil") );
		}
		int fij = -1;
		try{
			fij = Integer.parseInt(request.getParameter("fijo"));
		}catch (Exception e){
			log.warn("Imposible parsear a entero el fijo= " + request.getParameter("fijo") );
		}
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
	
	/**
	 * Crea un neuvo amigo con los datos recogidos anteriormente
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	private void crearAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		log.trace("datos del amigo");
		Amigo a = null;
		
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
	
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (apartado=="anadir"){
			crearAmigo(request, response);
		}
	}

}
