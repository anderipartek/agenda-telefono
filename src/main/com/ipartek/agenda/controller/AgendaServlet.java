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

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bean.Mensajes;
import com.ipartek.agenda.exceptions.AmigoException;
import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.modelo.ConnectionFactory;
import com.ipartek.agenda.modelo.DAOAmigo;
import com.ipartek.agenda.util.Util;
import com.ipartek.agenda.controller.i18nmessages.Menssagges;

/**
 * Servlet implementation class AmigoServlet.
 */
public class AgendaServlet extends MainServlet {
	private static final long serialVersionUID = 1L;

	static final Logger LOG = Logger.getLogger(AgendaServlet.class);

	private static RequestDispatcher dispatcher;
	private static IDAOAmigo modeloAmigo;

	private static final int COD_MSG_NOTFOUND = 200;
	private static final int COD_MSG_ERRORDATOS = 500;
	private static final String TIPO_ERROR = "ERR";

	private String opcion;
	private Amigo amigo;
	private ArrayList<Amigo> listaAmigos;

	private static Locale locale;

	private boolean isMobile = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgendaServlet() {
		super();

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
	 * @param key
	 * @return
	 */
	private static String obtenerMensages(HttpServletRequest request, String key) {

		locale = Menssagges.getLanguage(request);

		ResourceBundle messages = ResourceBundle.getBundle(Menssagges.NOMBRE_PAQUETE, locale);

		return messages.getString(key);
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Detecta si es m�vil o no
		detectUserAgent(request);

		// Obtiene el idoma de la aplicaci�n

		// recoger el parametro id
		final String idAmigo = (String) request.getParameter("id");

		if (idAmigo == null) {
			listarAmigos(request, response);
			if (!isMobile) {
				// Devuelve la informaci�n de todos los amigos

				dispatcher = request.getRequestDispatcher("ver.jsp");

				dispatcher.forward(request, response);
			} else {
				dispatcher = request.getRequestDispatcher("ver.mobi.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			String accion = (String) request.getParameter("op");
			detalleAmigo(request, response, idAmigo, accion);
		}

	}

	private void detectUserAgent(HttpServletRequest request) {
		isMobile = false;
		String userAgent = (String) request.getHeader("User-Agent");
		if (userAgent.contains("Mobile") || userAgent.contains("mobile")) {
			isMobile = true;
		}

	}

	/**
	 * M�todo para devolver los datos de todos los amigos.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void listarAmigos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos de todos los amigos
		final ArrayList<Amigo> amigos = modeloAmigo.getAll();

		// Guardar en la request la lista de amigos
		request.setAttribute("listaAmigos", amigos);

		// Dispatcher.forward

	}

	/**
	 * M�todo para devolver los datos de un amigo para las siguientes
	 * operaciones.
	 * <ol>
	 * <li>Modificar</li>
	 * <li>Eliminar</li>
	 * </ol>
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @throws ServletException
	 * @throws IOException
	 */
	private void detalleAmigo(HttpServletRequest request, HttpServletResponse response, String id, String accion) throws ServletException,
			IOException {
		// Pasar el id del amigo a int para poder buscar por id
		final int idAmigo = Integer.parseInt(id);

		// buscar el amigo en la tabla
		final Amigo amigoEncontrado = modeloAmigo.getById(idAmigo);

		if (amigoEncontrado != null) {
			// Se ha encontrado sin problema
			// devolver el amigo encontrado
			// Obtener si se elimina o si se modifica el alumno

			request.setAttribute("amigo", amigoEncontrado);
			detectUserAgent(request);
			if (MainServlet.OP_MODIFICAR.equalsIgnoreCase(accion)) {
				if (!isMobile) {
					dispatcher = request.getRequestDispatcher("modificar.jsp");
				} else {
					dispatcher = request.getRequestDispatcher("modificar.mobi.jsp");
				}
			} else {
				request.setAttribute("eliminando", String.valueOf(amigoEncontrado.getId()));
				dispatcher = request.getRequestDispatcher("eliminar.jsp");
			}

		} else {
			// No se ha encontrado el amigo
			// Establecer mensaje de error que no se ha podidio encontrar el
			// amigo

			// Rcuperar los mensajes correspondientes
			String amigo = obtenerMensages(request, "amigo");
			String noEncontrado = obtenerMensages(request, "noEncontrado");

			request.setAttribute("msg", new Mensajes(amigo + id + noEncontrado, COD_MSG_NOTFOUND, "WARN"));

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
		// Gesti�n de la operaciones de a�adir, modificar y eliminar.
		// Recoger el tipo de acci�n que se desea realizar

		opcion = (String) request.getParameter("op");

		if (MainServlet.OP_ANADIR.equalsIgnoreCase(opcion)) {
			// Se llama a la funci�n para a�adir el amigo a la tabla
			// Se guarda la operaci�n para el operaci�nCorrecta
			request.setAttribute("operaci�n", "a�adido");
			anadirAmigo(request, response);
		} else if (MainServlet.OP_MODIFICAR.equalsIgnoreCase(opcion)) {
			// Se guarda la operaci�n para el operaci�nCorrecta
			request.setAttribute("operaci�n", "modificado");
			// Se llama a la funci�n para modificar el amigo
			modificarAmigo(request, response);
		} else if (MainServlet.OP_ELIMINAR.equalsIgnoreCase(opcion)) {
			// Se guarda la operaci�n para el operaci�nCorrecta
			request.setAttribute("operaci�n", "eliminado");
			// Se llama a la funci�n para eliminar al amigo
			eliminarAmigo(request, response);
		} else {
			// Se busca por el nombre introducido
			buscarOperacion(request, response);
		}
	}

	/**
	 * M�todo para realizar la operaci�n de a�adir un nuevo amigo.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void anadirAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos del amigo

		final Amigo amigoNuevo = recogerDatosAmigo(request, response, MainServlet.OP_ANADIR);

		// intentar gusdar los datos en la bbdd
		final int idNuevo = modeloAmigo.insertAmigo(amigoNuevo);

		detectUserAgent(request);

		// Guardar la operaci�n que se ha realizado
		request.setAttribute("operacion", "");

		if (idNuevo > 0) {
			// Mensaje de alumno insertado correctamente

			// Recuperar mensajes
			String amigo = obtenerMensages(request, "elAmigo");
			String insertadoOK = obtenerMensages(request, "insertadoOK");

			request.setAttribute("msg", new Mensajes(amigo + amigoNuevo.getNombre() + insertadoOK, COD_MSG_NOTFOUND, "INFO"));
			// Guardar el nombre del amigo con el que se ha trabajado
			request.setAttribute("nombreAmigo", amigoNuevo.getNombre());

			if (!isMobile) {
				// Redirecci�n a operacion correcta
				dispatcher = request.getRequestDispatcher("operacionCorrecta.jsp");
			} else {
				// Redirecci�n a operacion correcta
				dispatcher = request.getRequestDispatcher("operacionCorrecta.mobi.jsp");
			}

		} else {
			// Devolver el amigo
			request.setAttribute("amigos", amigoNuevo);

			// Mensaje de error
			request.setAttribute("msg", new Mensajes("El amigo " + amigoNuevo.getNombre() + " no se ha introducido correctamente.", COD_MSG_NOTFOUND,
					TIPO_ERROR));
			if (!isMobile) {
				// Redirecci�n a a�adir amigo
				dispatcher = request.getRequestDispatcher("anadir.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("anadir.mobi.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	/**
	 * M�todo para realizar la operaci�n de modificar un amigo.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modificarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recoger los datos del amigo

		final Amigo amigoModificar = recogerDatosAmigo(request, response, MainServlet.OP_MODIFICAR);

		// intentar gusdar los datos en la bbdd
		final boolean actualizado = modeloAmigo.update(amigoModificar, amigoModificar.getId());

		// Detectar si es movil
		detectUserAgent(request);

		if (actualizado) {
			// Mensaje de alumno insertado correctamente
			request.setAttribute("msg", new Mensajes("El amigo " + amigoModificar.getNombre() + " se ha modificado correctamente.", COD_MSG_NOTFOUND,
					"INFO"));
			// Guardar el nombre del amigo con el que se ha trabajado
			request.setAttribute("nombreAmigo", amigoModificar.getNombre());

			if (!isMobile) {
				// Redirecci�n a operacion correcta
				dispatcher = request.getRequestDispatcher("operacionCorrecta.jsp");
			} else {
				// Redirecci�n a operacion correcta
				dispatcher = request.getRequestDispatcher("operacionCorrecta.mobi.jsp");
			}

		} else {
			// Devolver el amigo
			request.setAttribute("amigo", amigoModificar);

			// Mensaje de error
			request.setAttribute("msg", new Mensajes("El amigo " + amigoModificar.getNombre() + " no se ha introducido correctamente.",
					COD_MSG_NOTFOUND, TIPO_ERROR));

			// Redirecci�n a a�adir amigo
			if (!isMobile) {
				dispatcher = request.getRequestDispatcher("modificar.jsp");
			} else {
				dispatcher = request.getRequestDispatcher("modificar.mobi.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	/**
	 * M�todo para realizar la operaci�n de eliminar un amigo.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void eliminarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obtener el id del amigo a eliminar
		final int idAmigoEliminar = Integer.parseInt((String) request.getParameter("id"));
		// Buscar el amigo por el id
		Amigo amigoEliminar = modeloAmigo.getById(idAmigoEliminar);
		if (amigoEliminar != null) {
			// Eliminar el amigo
			final boolean eliminado = modeloAmigo.delete(idAmigoEliminar);
			if (eliminado) {
				// Mensaje de informaci�n
				request.setAttribute("msg", new Mensajes("El amigo " + amigoEliminar.getNombre() + " se ha borrado correctamente.", COD_MSG_NOTFOUND,
						"INFO"));
				// Guardar el nombre del amigo con el que se ha trabajado
				request.setAttribute("nombreAmigo", amigoEliminar.getNombre());

				if (!isMobile) {
					// Redirecci�n a operacion correcta
					dispatcher = request.getRequestDispatcher("operacionCorrecta.jsp");
				} else {
					// Redirecci�n a operacion correcta
					dispatcher = request.getRequestDispatcher("operacionCorrecta.mobi.jsp");
				}
			} else {
				// Mensaje de error
				request.setAttribute("msg", new Mensajes("El amigo " + amigoEliminar.getNombre() + " no se ha borrado correctamente.",
						COD_MSG_NOTFOUND, TIPO_ERROR));

				// Redirecci�n a a�adir amigo
				dispatcher = request.getRequestDispatcher("eliminar.jsp");
			}
		} else {
			// Mensaje de error
			request.setAttribute("msg", new Mensajes("El amigo " + idAmigoEliminar + " no se encuentra entre tus amigos", COD_MSG_NOTFOUND,
					TIPO_ERROR));
			if (!isMobile) {
				// Redirecci�n a a�adir amigo
				dispatcher = request.getRequestDispatcher("eliminar.jsp");
			}else{
				dispatcher = request.getRequestDispatcher("eliminar.mobi.jsp");
			}
		}
		dispatcher.forward(request, response);
	}

	/**
	 * M�todo para realizar la operaci�n de b�squeda en el caso de pinchar en el
	 * bot�n de b�scar.
	 * 
	 * @param request
	 * @param response
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void buscarOperacion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Obtener el nombre de b�usqueda
		final String nombre = (String) request.getAttribute("nombre");

		detectUserAgent(request);
		
		listaAmigos = Util.getAmigoBusqueda(nombre);

		// Devolver los resultados
		request.setAttribute("listaAmigos", listaAmigos);

		if(!isMobile){
			dispatcher = request.getRequestDispatcher("index.jsp");
		}else{
			dispatcher = request.getRequestDispatcher("ver.mobi.jsp");
		}

		dispatcher.forward(request, response);
	}

	/**
	 * M�todo para rellenar los datos del amigo que se desea modificar o a�adir.
	 * 
	 * @param request
	 * @param response
	 * @param operacion
	 * 
	 * @return Amigo con con el que se va a realizar alguna operaci�n
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
		final String anotaciones = (String) request.getParameter("anotaciones");

		if (request.getParameter("id") != null) { // !request.getParameter("id").isEmpty()
													// &&
			amigo.setId(Integer.parseInt(request.getParameter("id")));
		}
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
			request.setAttribute("msg", new Mensajes("Datos incorrectos " + ex.getMensajeError() + ", por favor revisa los datos introducidos.",
					COD_MSG_ERRORDATOS, TIPO_ERROR));
			dispatcher = request.getRequestDispatcher(operacion + ".jsp");
			dispatcher.forward(request, response);
		}

		return amigo;
	}
}
