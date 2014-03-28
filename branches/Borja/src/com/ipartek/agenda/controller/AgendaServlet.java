package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.model.ModeloAgenda;


/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	boolean isMobile;
	private ModeloAgenda modeloAgenda;
    
	private static String op; // Operacion a realizar
	HttpSession session;
	RequestDispatcher dispatcher = null;
	
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";

	
	public static final String OP_AÑADIR_AMIGO = "anadir";
	public static final String OP_MODIFICAR_AMIGO = "modificar";
	public static final String OP_ELIMINAR_AMIGO = "borrar";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AgendaServlet() {
        super();
      
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.modeloAgenda = new ModeloAgenda();
		//log.trace("init " + getServletName());
		
		
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				

		//obtener locale del navegador
		Locale locale = request.getLocale();
		
		//String con el lenguaje por defecto Ingles
		String lang = locale.getLanguage()+"_EN";
				

				/*if (language.getCountry&&!language.equals(new Locale("eu_ES"))&&!language.equals(new Locale("en_EN"))){
					language = new Locale("en_EN");
				}*/
				
		//ResourceBundle webTexts = ResourceBundle.getBundle("com.ipartek.agenda.controller.i18n", lang);
	  
		session = request.getSession(true);
		session.setAttribute("language", lang);
		op = (String) request.getParameter("op");
		super.service(request, response);
	
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		//log.trace("desVEtroy " + getServletName());
		super.destroy();
		this.modeloAgenda = null;
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String userAgent = request.getHeader("User-Agent");
	    
	    isMobile = userAgent.contains("Mobile")||userAgent.contains("mobile");

		
		
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;
		request.setAttribute("seccion", seccion);
		if(VER.equals(seccion)){
			
			listarAmigos(request, response);

			dispatcher = request.getRequestDispatcher("index.jsp");
			
		}else if (ANADIR.equals(SECCION)) {

			dispatcher = request.getRequestDispatcher("index.jsp");
			
		}else if (ELIMINAR.equals(SECCION)){
			
			//recogerDatos (request, response);
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		if (isMobile){
			dispatcher = request.getRequestDispatcher("ver.mobi.jsp");
		}
		
		// Redirecionar a la JSP
		dispatcher.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");

		if (OP_AÑADIR_AMIGO.equalsIgnoreCase(op)) {
			crearAmigo(request, response);

		}/*else if (OP_MODIFICAR_AMIGO.equalsIgnoreCase(op)) {
			modificarAmigo(request, response);
		} else if (OP_ELIMINAR_AMIGO.equalsIgnoreCase(op)) {
			borrarAmigo(request, response);

			return;
		}*/

	}// end doPost
	
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) {
		
		// listando
		//log.trace("Listado Amigos");
		dispatcher = request.getRequestDispatcher("ver.jsp");

		// conectar BBDD obtener Alumnos
		ArrayList<Amigo> listaAmigos = modeloAgenda.getAll();

		//log.debug(listaAmigos.size() + " amigos");

		request.setAttribute("listaAmigos", listaAmigos);

		/*if (OP_ELIMINAR_ALUMNO.equalsIgnoreCase(op)) {
			request.setAttribute("msg", new Mensaje("Alumno Eliminado Correctamente", 200, Mensaje.TIPO_MENSAJE.INFO));
		}*/

	}
	
	
	
	
	private void crearAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//log.trace("crearAlumno");
		
		Amigo a = null;
		
		// crear Amigo
		try {
			a = recogerDatos(request, response);		
			// Insert into DDBB
			modeloAgenda.insert(a);
			//log.info("Alumno insertado " + a.toString());
			//request.setAttribute("msg", new Mensaje("Alumno creado", 200, Mensaje.TIPO_MENSAJE.INFO));

		} /*catch (AlumnoException e) {
			log.warn("Datos del Alumno no validos " + e.getMessage());
			request.setAttribute("msg", new Mensaje(e.getMensajeError(), e.getCodigoError(), Mensaje.TIPO_MENSAJE.ERROR));

		}*/ catch (Exception e) {
			//log.warn("Excepcion general " + e.getMessage());
			//request.setAttribute("msg", new Mensaje("Excepcion general", 0, Mensaje.TIPO_MENSAJE.ERROR));
		}
		// enviar alumno a la JSP
		request.setAttribute("detalleAlumno", a);
		// titulo para la JSP
		request.setAttribute("title", "Insertar Alumno");
		// dispatcher
		dispatcher = request.getRequestDispatcher("alumnoDetalle.jsp");
		dispatcher.forward(request, response);
		//log.trace("crearAlumno - Fin");
	}
	
	
	/**
	 * Funcion que permite recoger los datos de un amigo del formulario Si se
	 * modifica el amigo, recogemos el id, sino será un aamigo nuevo
	 * 
	 * @param request
	 * @param response
	 * @return retorna un amigo con los datos del formulario
	 * 
	 */
	private Amigo recogerDatos(HttpServletRequest request, HttpServletResponse response) {
		
		//log.trace("Init recoger datos alumno");
		Amigo newAmigo =  new Amigo();
		if (OP_MODIFICAR_AMIGO.equalsIgnoreCase(op)) {
			int idAmigo = Integer.parseInt(request.getParameter("id"));
			newAmigo.setId(idAmigo);
		}
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String calle = request.getParameter("calle");
		String localidad = request.getParameter("localidad");
		String provincia = request.getParameter("provincia");
		int cp = Integer.parseInt(request.getParameter("cp"));
		String anotaciones = request.getParameter("anotaciones");
		
		newAmigo.setNombre(nombre);
		newAmigo.setApellido(apellido);
		newAmigo.setCalle(calle);
		newAmigo.setLocalidad(localidad);
		newAmigo.setCp(cp);
		newAmigo.setProvincia(provincia);
		newAmigo.setAnotaciones(anotaciones);
		
		//log.trace("Retorno de recoger datos alumno");
		return newAmigo;
	}

}
