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




/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;
	public static String pagina;
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	RequestDispatcher dispatcher = null;
	private int idAmigo;
	private final static Logger log = Logger.getLogger(MainServlet.class);
	ModeloAmigo modelAmigo;
	HttpSession session;
	private static String op; //Operacion a realizar	
	private Amigo a;
		
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
		request.setAttribute("seccion", seccion);

		if (ANADIR.equals(seccion)) {
			pagina = "anadir";
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) {
			pagina = "modificar";
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
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		if (pagina=="anadir"){
			crearAmigo(request, response);
		}else if(pagina=="modificar"){
			modificar(request, response);
		}
		
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
	private boolean modificar(final HttpServletRequest request,
			final HttpServletResponse response) {
		log.trace("metodo modificar init");
		boolean result = true;
		recogerDatos(request, response);
		if (!modelAmigo.modificar(a, idAmigo)) {
			result = false;
			log.warn("ATENCION no se ha podido modificar el amigo con id ["
					+ idAmigo + "]");
		} else {
			log.trace("Amigo modificado con id [" + idAmigo + "]");
		}
		log.trace("metodo modificar final");
		return result;
	}

	private Amigo recogerDatos(HttpServletRequest request,
			HttpServletResponse response) {
		log.trace("Init recoger datos alumno");
		Amigo a =  new Amigo();
		
	
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
	
		a.setNombre(nom);
		a.setApellido(ape);
		a.setCalle(call);
		a.setCp(codigop);
		a.setLocalidad(loc);
		a.setProvincia(prov);
		a.setMovil(mov);
		a.setFijo(fij);
		a.setAnotaciones(anot);
	

		
		log.trace("Retorno de recoger datos amigo");
		return a;

	}
	private boolean buscador(final HttpServletRequest request,
			final HttpServletResponse response) {
		boolean result = false;
		ArrayList<Amigo> lAmigo = modelAmigo.obtenerAmigoByNombre("nombre");
		String nombreBusqueda = request.getParameter("nombreBusqueda");
		lAmigo = modelAmigo.obtenerAmigoByNombre(nombreBusqueda);
		if (lAmigo.size() > 0) {
			result = true;
		}
		return result;
	}

}
