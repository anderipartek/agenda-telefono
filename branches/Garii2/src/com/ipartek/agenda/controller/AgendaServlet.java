package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bbdd.model.ModeloAmigo;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensaje;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends ServletMaestro {
	private final static Logger log = Logger.getLogger(AgendaServlet.class);
	private static final long serialVersionUID = 1L;
	private Amigo amigo;
	
	
	public static final String OP_NUEVO_AMIGO="nuevo";
	public static final String OP_MODIFICAR_AMIGO="modificar";
	public static final String OP_ELIMINAR_AMIGO="eliminar";
	public static final String OP_DETALLE_AMIGO="detalle";
	public static final String OP_BUSCAR_AMIGO="buscar";
	public static final String OP_LISTAR_AMIGO="listar";
	
	HttpSession session;
	ModeloAmigo modelAmigo;
	RequestDispatcher dispatcher = null;	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	   public AgendaServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	    
		/**
		 * @see Servlet#init(ServletConfig)
		 */
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			modelAmigo=new ModeloAmigo();
		}
		/**
		 * @see Servlet#destroy()
		 */
		public void destroy() {
			super.destroy();
			modelAmigo=null;
		}
	    

		/**
		 * @param id 
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// Obtener Dispatcher
			log.trace("inicio listado/detalle usuario");
			String idel=request.getParameter("IDEL");
			String imod=request.getParameter("IMOD");
			String nombre=request.getParameter("NOMBRE");
			
			
			if(idel==null && imod==null){
			RequestDispatcher dispatcher = null;

			String idAmigo = request.getParameter("id");

						// listando
				// ************
				log.trace("Listado de todos los amigos");
				dispatcher = request.getRequestDispatcher("ver.jsp");
				ArrayList<Amigo> listaAmigo = new ArrayList<Amigo>();
				listaAmigo = modelAmigo.getAll();
				log.warn(listaAmigo.size() + " amigos consultados");
				// enviar datos en la request a la JSP
				request.setAttribute("listaAmigo", listaAmigo);
				
				// Redireccionar a la JSP
				dispatcher.forward(request, response);

			}else if(idel!=null){
				
				//Titulo para la jsp
				amigo=modelAmigo.getById(Integer.valueOf(idel));
				request.setAttribute("amigoeliminar", amigo);
				
				dispatcher = request.getRequestDispatcher("eliminar.jsp");
				// Redireccionar a la JSP
				dispatcher.forward(request, response);
				log.trace("fin eliminar Alumno");
				
			}else if(imod!=null){
				amigo=null;			
				//Titulo para la jsp
				amigo=modelAmigo.getById(Integer.valueOf(imod));
				request.setAttribute("amigomodificar", amigo);
				dispatcher = request.getRequestDispatcher("modificar.jsp");
				// Redireccionar a la JSP
				dispatcher.forward(request, response);
				log.trace("fin eliminar Alumno");
			}
			
		}

		
			
		

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			log.trace("doPost");
			String op = request.getParameter("op");
			RequestDispatcher dispatcher = null;
			
			if(OP_NUEVO_AMIGO.equalsIgnoreCase(op)){
				crearAmigo(request,response);
			}else if (OP_MODIFICAR_AMIGO.equalsIgnoreCase(op)){
				modificarAmigo(request,response);
			}else if (OP_ELIMINAR_AMIGO.equalsIgnoreCase(op)){
				eliminarAmigo(request,response);
			}else if (OP_BUSCAR_AMIGO.equalsIgnoreCase(op)){
				buscarAmigo(request,response);
			}else {
				throw new ServletException ("operacion no soportada "+op);
			}
			
			
			
			log.trace("doPost-fin");
			
			
				
			}
		
		private void buscarAmigo(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			String nombre = request.getParameter("nombre");
			
			    ArrayList<Amigo> abuscar= new ArrayList<Amigo>();
			    abuscar=modelAmigo.getByNombre(nombre);
			    request.setAttribute("listaAmigo", abuscar);
			    dispatcher = request.getRequestDispatcher("ver.jsp");		   
				
				// Redireccionar a la JSP
				dispatcher.forward(request, response);
				
			 		
			
		}

		private void eliminarAmigo(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			log.trace("eliminar Amigo");
			
			
			
			Amigo aborrar = null;
			
			int id=Integer.valueOf(request.getParameter("id"));
			String name=request.getParameter("nombre");
			String apellidos=request.getParameter("apellido");
			
			try {
				aborrar= new Amigo();
				aborrar.setId(id);
				aborrar.setNombre(name);
				aborrar.setApellido(apellidos);
				
				//update BBDD
				if (!modelAmigo.delete(id)){
					log.error("No se ha podido eliminar el amigo ["+id+"]"+aborrar.toString());
					request.setAttribute("msg", new Mensaje("No se ha podido eliminar el amigo, por favor consulte con el administrador",0,Mensaje.TIPO_MENSAJE.INFO));

				}else{
				log.info("Alumno elimador");
				request.setAttribute("msg", new Mensaje("Amigo eliminado",200,Mensaje.TIPO_MENSAJE.INFO));
				}		
				
			} catch (Exception e) {
				log.warn("DAtos Amigo no eliminado"+e.getMessage());
				request.setAttribute("msg", new Mensaje("Datos de amigo no valido",0,Mensaje.TIPO_MENSAJE.INFO));
			}

			
			//dispatcher = request.getRequestDispatcher("eliminar.jsp");
			//dispatcher.forward(request, response);			
				
				this.doPost(request, response);
				
				log.trace("fin eliminar Amigo");
			
			
			}
			
		

		private void modificarAmigo(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			log.trace("modificar Alumno");
			
			
			
			Amigo amodi = null;
			int id=Integer.valueOf(request.getParameter("id"));
			String name=request.getParameter("nombre");
			String apellidos=request.getParameter("apellido");
			String calle=request.getParameter("calle");
			int cp=Integer.valueOf(request.getParameter("CP"));
			String localidad=request.getParameter("localidad");
			String provincia=request.getParameter("provincia");
			int movil=Integer.valueOf(request.getParameter("movil"));
			int fijo=Integer.valueOf(request.getParameter("fijo"));
			String anotaciones=request.getParameter("anotaciones");
			
			
		
		
			try {
				amodi= new Amigo();
				amodi.setId(id);
				amodi.setNombre(name);
				amodi.setApellido(apellidos);
				amodi.setCalle(calle);
				amodi.setCp(cp);
				amodi.setLocalidad(localidad);
				amodi.setProvincia(provincia);
				amodi.setMovil(movil);
				amodi.setFijo(fijo);
				amodi.setAnotaciones(anotaciones);
				//update BBDD
				if (!modelAmigo.update(amodi, id)){
					log.error("No se ha podido modificar el alumno ["+amodi.getId()+"]"+amodi.toString());
					request.setAttribute("msg", new Mensaje("No se ha podido modificar el amigo, por favor consulte con el administrador",0,Mensaje.TIPO_MENSAJE.INFO));

				}else{
				log.info("Amigo modificado");
				request.setAttribute("msg", new Mensaje("Amigo modificado",200,Mensaje.TIPO_MENSAJE.INFO));
				}
				
			}  catch (Exception e) {
				log.warn("Datos Amigo no insertados"+e.getMessage());
				request.setAttribute("msg", new Mensaje("Datos de amigo no valido",0,Mensaje.TIPO_MENSAJE.INFO));
			}

				
				request.setAttribute("amigomodificar", amodi);
				
				
				
							
				dispatcher = request.getRequestDispatcher("modificar.jsp");
				dispatcher.forward(request, response);
				
				log.trace("fin modificar Amigo");
			
		
		}
	
			
		

		private void crearAmigo(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			
			
			
			String name=request.getParameter("nombre");
			String apellidos=request.getParameter("apellido");
			String calle=request.getParameter("calle");
			int cp=Integer.valueOf(request.getParameter("CP"));
			String localidad=request.getParameter("localidad");
			String provincia=request.getParameter("provincia");
			int movil=Integer.valueOf(request.getParameter("movil"));
			int fijo=Integer.valueOf(request.getParameter("fijo"));
			String anotaciones=request.getParameter("anotaciones");
			
			Amigo acrear=null;
			
			
		
			try {
				acrear= new Amigo();
				acrear.setNombre(name);
				acrear.setApellido(apellidos);
				acrear.setCalle(calle);
				acrear.setCp(cp);
				acrear.setLocalidad(localidad);
				acrear.setProvincia(provincia);
				acrear.setMovil(movil);
				acrear.setFijo(fijo);
				acrear.setAnotaciones(anotaciones);
				
				modelAmigo.insertAmigo(acrear);
				log.info("Amigo insertado");
				request.setAttribute("msg", new Mensaje("Amigo creado",200,Mensaje.TIPO_MENSAJE.INFO));
				
				
			}  catch (Exception e) {
				log.warn("Datos Amigos no insertados"+e.getMessage());
				request.setAttribute("msg", new Mensaje("Datos de amigo no valido",0,Mensaje.TIPO_MENSAJE.INFO));
			}

				
				
				request.setAttribute("anadido", acrear);
				dispatcher = request.getRequestDispatcher("anadir.jsp");
				dispatcher.forward(request, response);
				log.trace("fin crear Alumno");
			
			
			}
}
		
			
			
			
			
			
		
	
	
