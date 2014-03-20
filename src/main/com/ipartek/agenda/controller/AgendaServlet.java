package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensajes;
import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.modelo.ConnectionFactory;
import com.ipartek.agenda.modelo.DAOAmigo;

/**
 * Servlet implementation class AmigoServlet.
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final Logger LOG = Logger.getLogger(DAOAmigo.class);
		
	private static RequestDispatcher dispatcher;
	private static IDAOAmigo modeloAmigo;
	private static final int COD_MSG_NOTFOUND = 200;
	private String opcion;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		modeloAmigo = ConnectionFactory.getInstance().getDAOAmigo();
		super.init(config);
	}

	@Override
	public void destroy() {

		super.destroy();
		modeloAmigo = null;
		dispatcher = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// recoger el parametro id
		String idAmigo = request.getAttribute("id");
		if (idAmigo == null) {

			// Devuelve la información de todos los amigos
			listarAmigos(request, response);
		} else {
			detalleAmigo(request, response, idAmigo);
		}

	}

	private void listarAmigos(HttpServletRequest request,
			HttpServletResponse response) {
		// Recoger los datos de todos los amigos
		ArrayList<Amigo> amigos = modeloAmigo.getAll();

		// Guardar en la request la lista de amigos
		request.setAttribute("listaAmigos", amigos);

		// Dispatcher.forward
		dispatcher = request.getRequestDispatcher("ver.jsp");

		dispatcher.forward(request, response);
	}

	private void detalleAmigo(HttpServletRequest request,
			HttpServletResponse HttpServletResponse response, String id) {
		// Pasar el id del amigo a int para poder buscar por id
		int idAmigo = Integer.parseInt(id);

		// buscar el amigo en la tabla
		Amigo amigoId = modeloAmigo.getById(idAmigo);
		if (amigoId != null) {
			// Se ha encontrado sin problema
			dispatcher = request.getRequestDisatcher("modificar.jsp");

		} else {
			// No se ha encontrado el amigo
			// Establecer mensaje de error que no se ha podidio encontrar el
			// amigo

			request.setAttribute("msg", new Mensajes(
					"El amigo no existe......", COD_MSG_NOTFOUND, "WARN"));

			dispatcher = request.getRequestDisatcher("ver.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
			// Gestión de la operaciones de añadir, modificar y eliminar.
			// Recoger el tipo de acción que se desea realizar
			
			 opcion = (String) request.getParameter("op");
			 
			 if(opcion="aniadir"){
				 // Se llama a la función para añadir el amigo a la tabla
				 anadirAmigo(request, response);
			 }else if(opcion=="modificar"){
				 // Se llama a la función para modificar el amigo
				 modificarAmigo(request, response);
			 }else if(opcion=="eliminar"){
				 // Se llama a la función para eliminar al amigo
				 eliminarAmigo(request, response);
			 }else{
				 // Cancelar cualquier operación
				 cancelarOperación(request, response);
			 }
			 
	}
	
	private void anadirAmigo(HttpServletRequest request, HttpServletResponse response){
		// Recoger los datos del amigo
		
		Amigo amigoNuevo= recogerDatosAmigo(request, response);
		
		// intentar gusdar los datos en la bbdd
		int idNuevo= modeloAmigo.insertAmigo(amigoNuevo);
		
		if(idNuevo>0){
			//Mensaje de alumno insertado correctamente
			request.setAttribute("msg", new Mensajes(
					"El amigo se ha introducido correctamente....", COD_MSG_NOTFOUND, "INFO"));
			// Redirección a operacion correcta
			dispatcher= request.getRequestDispatcher("operacionCorrecta.jsp");
			
		}else
		{
			// Devolver el amigo
			request.setAttribute("amigos", amigoNuevo);
			
			// Mensaje de error
			request.setAttribute("msg", new Mensajes(
					"El amigo no se ha introducido correctamente....", COD_MSG_NOTFOUND, "ERR"));

			// Redirección a añadir amigo
			dispatcher= request.getRequestDispatcher("anadir.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	
	private void modificarAmigo(HttpServletRequest request, HttpServletResponse response){
		// Recoger los datos del amigo
		
		Amigo amigoModificar= recogerDatosAmigo(request, response);
		
		// intentar gusdar los datos en la bbdd
		boolean actualizado= modeloAmigo.update(amigoModificar, amigoModificar.getId());
		
		if(actualizado){
			//Mensaje de alumno insertado correctamente
			request.setAttribute("msg", new Mensajes(
					"El amigo se ha introducido correctamente....", COD_MSG_NOTFOUND, "INFO"));
			// Redirección a operacion correcta
			dispatcher= request.getRequestDispatcher("operacionCorrecta.jsp");
			
		}else
		{
			// Devolver el amigo
			request.setAttribute("amigos", amigoModificar);
			
			// Mensaje de error
			request.setAttribute("msg", new Mensajes(
					"El amigo no se ha introducido correctamente....", COD_MSG_NOTFOUND, "ERR"));

			// Redirección a añadir amigo
			dispatcher= request.getRequestDispatcher("modificar.jsp");
		}
		dispatcher.forward(request, response);
	}

	
	private void eliminarAmigo(HttpServletRequest request, HttpServletResponse response){
		// Obtener el id del amigo a eliminar
		int idAmigoEliminar= request.getParameter("id");
		
		// Eliminar el amigo
		boolean eliminado = modeloAmigo.delete(idAmigoEliminar);
		if(eliminado){
				// Mensaje de información
						request.setAttribute("msg", new Mensajes(
								"El amigo borrado correctamente....", COD_MSG_NOTFOUND, "INFO"));

						// Redirección a añadir amigo
						dispatcher= request.getRequestDispatcher("operacionCorrecta.jsp");
		}else{
			// Mensaje de error
						request.setAttribute("msg", new Mensajes(
								"El amigo no se ha borrado correctamente....", COD_MSG_NOTFOUND, "ERR"));

						// Redirección a añadir amigo
						dispatcher= request.getRequestDispatcher("eliminar.jsp");
					}
					dispatcher.forward(request, response);
	}
	private void cancelarOperación(HttpServletRequest request, HttpServletResponse response){
		// Redirigir a la home
		
		dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	private Amigo recogerDatosAmigo(HttpServletRequest request, HttpServletResponse response){
		Amigo amigo= new Amigo();
		
		amigo.setId(request.getParameter("id"));
		amigo.setNombre(request.getParameter("nombre"));
		amigo.setApellido(request.getParameter("apellido"));
		amigo.setLocalidad(request.getParameter("localidad"));
		amigo.setCalle(request.getParameter("calle"));
		amigo.setProvincia(request.getParameter("provincia"));
		amigo.setCp(request.getParameter("CP"));
		amigo.setFijo(request.getParameter("fijo"));
		amigo.setMovil(request.getParameter("movil"));
		amigo.setMovil(request.getParameter("anotaciones"));
				
	}
}
