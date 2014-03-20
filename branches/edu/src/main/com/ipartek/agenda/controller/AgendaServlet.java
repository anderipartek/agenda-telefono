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
import com.ipartek.agenda.exception.AmigoException;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;
	
	
	
	private final static Logger log=Logger.getLogger(AgendaServlet.class);
	static Amigo a;
	static ModeloAmigo model;
	RequestDispatcher dispatcher;
	String operacion,texto;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AgendaServlet() {
        super();
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	model= new ModeloAmigo();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("Inicio AgendaServlet doGet" );
		ArrayList<Amigo> amigos= new ArrayList<Amigo>();
		String operacion = request.getParameter("operacion");
		RequestDispatcher dispatcher = null;

		//redirigir a ver todos
		if ("ver".equals(operacion)){
			log.trace("Redirigiendo a ver.jsp" );
			amigos=model.getAll();
			//Si no hay alumnos en la BD
			if (amigos.size()==0)
			{
				String msg="No hay alumnos para mostrar en la BD";
				request.setAttribute("mensaje", msg);
			}
			request.setAttribute("listaAmigos", amigos);
			dispatcher = request.getRequestDispatcher("ver.jsp");
		}
		//redirigir a insertar
		else if ("anadir".equals(operacion)){
			log.trace("Redirigiendo a anadir.jsp" );
			dispatcher=request.getRequestDispatcher("core/model/forms/anadir.jsp");
		}
		//redirigir a borrar
		else if("eliminar".equals(operacion)){
			log.trace("Redirigiendo a eliminar.jsp" );
			String form="Del";
			request.setAttribute("form",form );
			dispatcher=request.getRequestDispatcher("core/model/forms/eliminar.jsp");
			
		}
		//redirigir a modificar
		else if("modificar".equals(operacion)){
			log.trace("Redirigiendo a modificar.jsp");
			//Para saber de que formulario llama a buscar
			String form="Mod";
			request.setAttribute("form",form );
			dispatcher=request.getRequestDispatcher("core/model/forms/modificar.jsp");
		}
		
		//redirigir a index
		else if (operacion==null)
		{
		  log.trace("Redirigiendo a index.jsp" );	
		  dispatcher = request.getRequestDispatcher("index.jsp");
		}
		
		log.trace("Fin AgendaServlet doGet" );
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("AgendaServlet doPost");
		operacion = request.getParameter("operacion");
		//submit insertar
		if ("anadir".equals(operacion)){
		   	
		   insertar(request,response);
		}
		//submit buscar
		else if ("buscar".equals(operacion)){
		  String form=request.getParameter("op");	
		  buscar(request,response,form);
			
		}
		//submit eliminar
		else if ("eliminar".equals(operacion)){
			delete(request,response);
		}
		//submit modificar
		else if ("modificar".equals(operacion)){
			String id=request.getParameter("id");
			modificar(request,response,id);
		}
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			request.setAttribute("Mensaje", texto);
			texto="ServletException";
			log.error("ServletException/IOException" + e.getMessage());
		}
		
	}

	private void modificar(HttpServletRequest request,
			HttpServletResponse response,String idAmigo) {
		    log.trace("Modificando Amigo");
		    //parseo amigo
		    
		    int id=Integer.parseInt(idAmigo);
		    try {
				a=parsearAmigo(request,id);
				if (model.update(a, id)){
					texto="Alumno modificado correctamente";
					request.setAttribute("Mensaje", texto);
					request.setAttribute("Amigo", a);
					
			    }
			} catch (AmigoException e) {
				texto=e.getMensaje();
				request.setAttribute("Mensaje", texto);
				
			}
		    
		    dispatcher = request.getRequestDispatcher("core/model/forms/modificar.jsp");
	}

	private Amigo parsearAmigo(HttpServletRequest request,int id) throws AmigoException {
		log.trace("Parseando Amigo desde formulario");
		int cp;
		a.setId(id);
		a.setNombre(request.getParameter("nombre"));
		a.setApellido(request.getParameter("apellido"));
		a.setCalle(request.getParameter("calle"));
		cp=Integer.parseInt(request.getParameter("cp"));
		a.setCp(cp);
		a.setFijo(Integer.parseInt(request.getParameter("fijo")));
		a.setMovil(Integer.parseInt(request.getParameter("movil")));
		a.setLocalidad(request.getParameter("localidad"));
		a.setProvincia(request.getParameter("provincia"));
		a.setAnotaciones(request.getParameter("anotaciones"));
		log.info("Amigo parseado correctamente");
		
		return a;
		
	}
		
	

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		log.trace("eliminando Amigo");
		String idAmigo=request.getParameter("id");
		int id=Integer.parseInt(idAmigo);
		model.delete(id);
		texto="Amigo eliminado correctamente";
		request.setAttribute("Mensaje", texto);
		dispatcher = request.getRequestDispatcher("core/model/forms/eliminar.jsp");
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response,String form) {
		log.trace("buscando");
		a=model.getAlumnoByNombre(request.getParameter("nombre"));
		request.setAttribute("Amigo", a);
		if (a==null){
			texto="No se ha encontrado ningun amigo con ese nombre";
			request.setAttribute("Mensaje", texto);
		}
		//en función de que formulario venga
		if ("Mod".equals(form)){
			dispatcher = request.getRequestDispatcher("core/model/forms/modificar.jsp");
		}
		else if ("Del".equals(form)){
			dispatcher = request.getRequestDispatcher("core/model/forms/modificar.jsp");
		}
		
		
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		log.trace("Insertando"); 
		a=new Amigo();
		String texto="";
		try {
			a.setNombre(request.getParameter("nombre"));
			a.setApellido(request.getParameter("apellido"));
			a.setCalle(request.getParameter("calle"));
			a.setCp(Integer.parseInt(request.getParameter("CP")));
			a.setLocalidad(request.getParameter("localidad"));
			a.setProvincia(request.getParameter("provincia"));
			a.setMovil(Integer.parseInt(request.getParameter("movil")));
			a.setFijo(Integer.parseInt(request.getParameter("fijo")));
			a.setAnotaciones(request.getParameter("anotaciones"));
			model.insertarAmigo(a);
			dispatcher = request.getRequestDispatcher("core/model/forms/anadir.jsp");
			texto="Añadido";
			request.setAttribute("Mensaje", texto);
		} catch (AmigoException e) {
			texto=e.getMensaje();
			request.setAttribute("Mensaje", texto);
			dispatcher = request.getRequestDispatcher("core/model/forms/anadir.jsp");
			
		}
		
		log.trace("Fin direccionamiento insertar");
		
		
	}
	
	
	
	

}
