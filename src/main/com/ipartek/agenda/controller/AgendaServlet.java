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
import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensajes;
import com.ipartek.agenda.exceptions.AmigoException;
import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.modelo.ConnectionFactory;
import com.ipartek.agenda.modelo.DAOAmigo;
import com.ipartek.agenda.util.Util;

/**
 * Servlet implementation class AmigoServlet.
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static final Logger LOG = Logger.getLogger(DAOAmigo.class);

	private static RequestDispatcher dispatcher;
	private static IDAOAmigo modeloAmigo;
	private static final int COD_MSG_NOTFOUND = 200;
	private static final int COD_MSG_ERRORDATOS= 500;
	
	private String opcion;
	private Amigo amigo;
	private ArrayList<Amigo> listaAmigos;
	
	public static final String OP_ANADIR="anadir";
	public static final String OP_ELIMINAR="eliminar";
	public static final String OP_MODIFICAR="modificar";
	public static final String OP_CANCELAR="cancelar";
	public static final String OP_BUSCAR="buscar";

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
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recoger el parametro id
		String idAmigo = (String) request.getAttribute("id");
		if (idAmigo == null) {

			// Devuelve la información de todos los amigos
			listarAmigos(request, response);
		} else {
			detalleAmigo(request, response, idAmigo);
		}

	}

	/**
	 * Método para devolver los datos de todos los amigos.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos de todos los amigos
		ArrayList<Amigo> amigos = modeloAmigo.getAll();

		// Guardar en la request la lista de amigos
		request.setAttribute("listaAmigos", amigos);

		// Dispatcher.forward
		dispatcher = request.getRequestDispatcher("ver.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * Método para devolver los datos de un amigo.
	 * Sirve para las siguientes operaciones:
	 * <ol>
	 * 	<li>Modificar</li>
	 * 	<li>Eliminar</li>
	 * </ol>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @throws ServletException
	 * @throws IOException
	 */
	private void detalleAmigo(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
		// Pasar el id del amigo a int para poder buscar por id
		int idAmigo = Integer.parseInt(id);

		// buscar el amigo en la tabla
		Amigo amigoId = modeloAmigo.getById(idAmigo);
		if (amigoId != null) {
			// Se ha encontrado sin problema
			dispatcher = request.getRequestDispatcher("modificar.jsp");

		} else {
			// No se ha encontrado el amigo
			// Establecer mensaje de error que no se ha podidio encontrar el
			// amigo

			request.setAttribute("msg", new Mensajes("El amigo no existe......", COD_MSG_NOTFOUND, "WARN"));

			dispatcher = request.getRequestDispatcher("ver.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * 
	 * 
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gestión de la operaciones de añadir, modificar y eliminar.
		// Recoger el tipo de acción que se desea realizar

		opcion = (String) request.getParameter("op");

		if (OP_ANADIR.equalsIgnoreCase(opcion)) {
			// Se llama a la función para añadir el amigo a la tabla
			anadirAmigo(request, response);
		} else if (OP_MODIFICAR.equalsIgnoreCase(opcion)) {
			// Se llama a la función para modificar el amigo
			modificarAmigo(request, response);
		} else if (OP_ELIMINAR.equalsIgnoreCase(opcion)) {
			// Se llama a la función para eliminar al amigo
			eliminarAmigo(request, response);
		} else if (OP_BUSCAR.equalsIgnoreCase(opcion)) {
			
			buscarOperación(request, response);
		} else {
			// Cancelar cualquier operación
			cancelarOperación(request, response);
		}

	}

	/**
	 * Método para realizar la operación de añadir un nuevo amigo.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void anadirAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos del amigo

		final Amigo amigoNuevo = recogerDatosAmigo(request, response, OP_ANADIR);

		// intentar gusdar los datos en la bbdd
		final int idNuevo = modeloAmigo.insertAmigo(amigoNuevo);

		// Guardar la operación que se ha realizado
		request.setAttribute("operacion", "");
		
		if (idNuevo > 0) {
			// Mensaje de alumno insertado correctamente
			request.setAttribute("msg", new Mensajes(
					"El amigo se ha introducido correctamente....",
					COD_MSG_NOTFOUND, "INFO"));
			// Guardar el amigo con el que se ha trabajado
			
			// Redirección a operacion correcta
			dispatcher = request.getRequestDispatcher("operacionCorrecta.jsp");

		} else {
			// Devolver el amigo
			request.setAttribute("amigos", amigoNuevo);

			// Mensaje de error
			request.setAttribute("msg", new Mensajes(
					"El amigo no se ha introducido correctamente....",
					COD_MSG_NOTFOUND, "ERR"));

			// Redirección a añadir amigo
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	/**
	 * Método para realizar la operación de modificar un amigo.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modificarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos del amigo

		final Amigo amigoModificar = recogerDatosAmigo(request, response, OP_MODIFICAR );

		// intentar gusdar los datos en la bbdd
		final boolean actualizado = modeloAmigo.update(
				amigoModificar, amigoModificar.getId());

		if (actualizado) {
			// Mensaje de alumno insertado correctamente
			request.setAttribute("msg", new Mensajes(
					"El amigo se ha introducido correctamente....",
					COD_MSG_NOTFOUND, "INFO"));
			// Redirección a operacion correcta
			dispatcher = request.getRequestDispatcher("operacionCorrecta.jsp");

		} else {
			// Devolver el amigo
			request.setAttribute("amigos", amigoModificar);

			// Mensaje de error
			request.setAttribute("msg", new Mensajes(
					"El amigo no se ha introducido correctamente....",
					COD_MSG_NOTFOUND, "ERR"));

			// Redirección a añadir amigo
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * Método para realizar la operación de eliminar un amigo.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void eliminarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener el id del amigo a eliminar
		final int idAmigoEliminar = Integer.parseInt((String)
				request.getParameter("id"));

		// Eliminar el amigo
		final boolean eliminado = modeloAmigo.delete(idAmigoEliminar);
		if (eliminado) {
			// Mensaje de información
			request.setAttribute("msg", new Mensajes(
					"El amigo borrado correctamente....",
					COD_MSG_NOTFOUND, "INFO"));

			// Redirección a añadir amigo
			dispatcher = request.getRequestDispatcher("operacionCorrecta.jsp");
		} else {
			// Mensaje de error
			request.setAttribute("msg", new Mensajes(
					"El amigo no se ha borrado correctamente....",
					COD_MSG_NOTFOUND, "ERR"));

			// Redirección a añadir amigo
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	/**
	 * Método para realizar la operación de cancelación.
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */

	private void cancelarOperación(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Redirigir a la home

		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Método para realizar la operación de búsqueda 
	 * en el caso de pinchar en el botón de búscar.
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void buscarOperación(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtener el nombre de bíusqueda
		String nombre = (String) request.getAttribute("nombre");
				
		listaAmigos = Util.getAmigoBusqueda(nombre);
		
		// Devolver los resultados
		 request.setAttribute("listaAmigos", listaAmigos);
		 
		 dispatcher = request.getRequestDispatcher("modificar.jsp");
		 
		 dispatcher.forward(request, response);
	}
	
	
	/**
	 * Método para rellenar los datos del amigo que se desea modificar o añadir.
	 * 
	 * @param request
	 * @param response
	 * @param operacion
	 * 
	 * @return Amigo con con el que se va a realizar alguna operación
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private Amigo recogerDatosAmigo(HttpServletRequest request, HttpServletResponse response, String operacion) throws ServletException, IOException {
		 amigo = new Amigo();

		final String nombre = (String) request.getParameter("nombre");
		final String apellido = (String) request.getParameter("apellido");
		final String localidad = (String) request.getParameter("localidad");
		final String calle = (String) request.getParameter("calle");
		final String provincia = (String) request.getParameter("provincia"); 
		final int codigoPostal = Integer.parseInt(request.getParameter("CP"));
		final int fijo = Integer.parseInt(request.getParameter("fijo"));
		final int movil = Integer.parseInt(request.getParameter("movil"));
		final String anotaciones = request.getParameter("anotaciones");
		
		amigo.setId(Integer.parseInt(request.getParameter("id")));
		try {
			amigo.setNombre(nombre);
			amigo.setApellido(apellido);
			amigo.setLocalidad(localidad);
			amigo.setCalle(calle);
			amigo.setProvincia(provincia);
			amigo.setCp(codigoPostal);
			amigo.setFijo(fijo);
			amigo.setMovil(movil);
			amigo.setAnotaciones(anotaciones);

		} catch (AmigoException ex) {
			// Escribir en el log que se ha producido un error
			LOG.fatal("Se ha producido un error al crear el nuevo amigo");
			
			// Recoger todos los datos que son incorrectos
				request.setAttribute("nombre", nombre);
				request.setAttribute("apellido", apellido);
				request.setAttribute("localidad", localidad);
				request.setAttribute("calle", calle);
				request.setAttribute("provincia", provincia);
				request.setAttribute("CP", codigoPostal);
				request.setAttribute("fijo", fijo);
				request.setAttribute("movil", movil);
				request.setAttribute("anotaciones", anotaciones);
				
			// Establecer el mensaje de error que se ha producido.
				request.setAttribute("msg", new Mensajes(
						"Datos incorrectos " + ex.getMensajeError(),
						COD_MSG_ERRORDATOS , "ERR"));
				dispatcher = request.getRequestDispatcher(operacion + ".jsp");
				dispatcher.forward(request, response);
		}

		return amigo;
	}
}
