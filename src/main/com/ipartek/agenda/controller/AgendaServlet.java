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
	private final static Logger log=Logger.getLogger(AgendaServlet.class);//instancia log4j
	static Amigo a;//Objeto Amigo
	static ArrayList<Amigo> amigos;//amigos
	static ModeloAmigo model;//modelo
	RequestDispatcher dispatcher;//dispatcher
	String operacion;//parametro pasado en el action para determinar que accion realizar
	String texto;//mensaje enviado al jsp en funcion del resultado del metodo
	String msg;//Attribute mandado en el request
	String form;//Attribute mandado en el request para determinar de donde viene al ir a busqueda.jsp
	int idAmigo;//id amigo
	int cp;//codigo postal
	String id; //parameter de la request que contiene el id del amigo
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
		amigos= new ArrayList<Amigo>();
		//recogemos la operacion del request
		operacion = request.getParameter("operacion");
		RequestDispatcher dispatcher = null;

		//redirigir a ver todos
		if ("ver".equals(operacion)){
			log.trace("Redirigiendo a ver.jsp" );
			amigos=model.getAll();
			//Si no hay alumnos en la BD
			if (amigos.size()==0)
			{
				//mensaje que anyadimos al .jsp
				msg="No hay amigos para mostrar en la BD";
				request.setAttribute("mensaje", msg);
			}
			//mandamos la lista de amigos a ver.jsp
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
			form="Del";
			request.setAttribute("form",form );

			dispatcher=request.getRequestDispatcher("core/model/forms/eliminar.jsp");

		}
		//redirigir a modificar
		else if("modificar".equals(operacion)){
			log.trace("Redirigiendo a modificar.jsp");
			//Para saber de que formulario llama a buscar
			form="Mod";
			request.setAttribute("form",form );
			dispatcher=request.getRequestDispatcher("core/model/forms/modificar.jsp");
		}

		//redirigir a index.jsp al iniciar la aplicación
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
			//recogemos la operacion para saber que mostrar en el buscador.jsp
			form=request.getParameter("op");	
			buscar(request,response,form);

		}
		//submit eliminar
		else if ("eliminar".equals(operacion)){
			delete(request,response);
		}
		//submit modificar
		else if ("modificar".equals(operacion)){
			id=request.getParameter("id");
			modificar(request,response,id);
		}
		//submit datos
		else if("datos".equals(operacion)){
			log.trace("Cargando datos en el formulario");
			idAmigo=Integer.parseInt(request.getParameter("idM"));
			a=model.getAmigoById(idAmigo);
			request.setAttribute("Amigo",a );
			dispatcher=request.getRequestDispatcher("core/model/forms/modificar.jsp");
		}
		//submit confirmacion borrar
		else if("confirmacion".equals(operacion)){
			log.trace("Confirmacion borrar");
			id=request.getParameter("idB");
			request.setAttribute("amigo",id);
			dispatcher=request.getRequestDispatcher("core/model/forms/eliminar.jsp");
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
			HttpServletResponse response,String id) {
		log.trace("Modificando Amigo");
		

		idAmigo=Integer.parseInt(id);
		try {
			//parseamos el amigo a traves del request
			a=parsearAmigo(request,idAmigo);
			//actualizamos al amigo
			if (model.update(a, idAmigo)){
				texto="Amigo modificado correctamente";
				request.setAttribute("Mensaje", texto);


			}
		} catch (AmigoException e) {
			texto=e.getMensaje();
			request.setAttribute("Mensaje", texto);

		}
		//tanto si el amigo es correcto como si salta la excepcion llevarle el alumno original 
		request.setAttribute("Amigo", a);

		dispatcher = request.getRequestDispatcher("core/model/forms/modificar.jsp");
	}
    /**
     * Metodo que recoge el request Amigo y lo parseamos al objeto Amigo
     * @param request
     * @param idAmigo 
     * @return Amigo a
     * @throws AmigoException al recoger un campo que no cumple con una serie de caracteristicas
     */
	private Amigo parsearAmigo(HttpServletRequest request,int idAmigo) throws AmigoException {
		log.trace("Parseando Amigo desde formulario");
		a.setId(idAmigo);
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


    /**
     * Metodo que elimina el amigo
     * @param request
     * @param response
     */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		log.trace("eliminando Amigo");
		id=request.getParameter("id");
		idAmigo=Integer.parseInt(id);
		model.delete(idAmigo);
		texto="Amigo eliminado correctamente";
		request.setAttribute("Mensaje", texto);
		dispatcher = request.getRequestDispatcher("core/model/forms/eliminar.jsp");

	}
    /**
     * Metodo que busca en la BD los amigos que tienen el mismo nombre
     * @param request
     * @param response
     * @param form referencia del formulario del que viene
     */
	private void buscar(HttpServletRequest request, HttpServletResponse response,String form) {
		log.trace("buscando");
		amigos=model.getAmigosByNombre(request.getParameter("nombre"));
		request.setAttribute("Amigos", amigos);
		if (amigos.size()==0){
			texto="No se ha encontrado ningun amigo con ese nombre";
			request.setAttribute("Mensaje", texto);
		}
		//en funcion de que formulario venga
		if ("Mod".equals(form)){
			dispatcher = request.getRequestDispatcher("core/model/forms/modificar.jsp");
		}
		else if ("Del".equals(form)){
			dispatcher = request.getRequestDispatcher("core/model/forms/eliminar.jsp");
		}


	}
    /**
     * Metodo que inserta en la BD el Amigo
     * @param request
     * @param response
     */
	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		log.trace("Insertando"); 
		a=new Amigo();
		texto="";
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
			texto="Amigo insertado correctamente";
			request.setAttribute("Mensaje", texto);
		} catch (AmigoException e) {
			texto=e.getMensaje();
			request.setAttribute("Mensaje", texto);
			dispatcher = request.getRequestDispatcher("core/model/forms/anadir.jsp");

		}

		log.trace("Fin direccionamiento insertar");


	}





}
