package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.excepciones.AmigoExcepcion;
import com.ipartek.agenda.modelo.ModeloAmigo;

/**
 * Servlet que nos permite recoger datos para realizar las siguientes
 * operaciones
 * <ul>
 * <li>AÑADIR</li>
 * <li>MODIFICAR</li>
 * <li>ELIMINAR</li>
 * <li>VER</li>
 * <li>BUSQUEDA</li>
 * </ul>
 * Mediante los doGet realizamos las operaciones de VER y recogida de datos de
 * amigo seleccionado para ELIMINAR Y MODIFICAR
 * 
 * Mediante los doPost realizamos el resto de operaciones AÑADIMOS; MODIFICAMOS;
 * ELIMINAMOS; BUSCAMOS
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class AgendaServlet extends HttpServlet {
	static final Logger log = Logger.getLogger(AgendaServlet.class);
	private static final long serialVersionUID = 1L;
	// OPCIONES RECIBIDAS DESDE EL FORMULARIO
	public static final String OP_ANADIR = "añadir";
	public static final String OP_MODIFICAR = "modificar";
	public static final String OP_ELIMINAR = "eliminar";
	public static final String OP_VISUALIZAR = "ver";
	public static final String OP_BUSCAR = "buscar";
	// OPERACION A REALIZAR
	private static String op;
	// AMIGO
	private Amigo a;
	private ModeloAmigo modelo;
	private int idAmigo;
	private HashMap<Integer, Amigo> listaAmigos;
	private RequestDispatcher dispatcher;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		op = request.getParameter("op");
		if (op.equalsIgnoreCase(OP_VISUALIZAR)) {
			if (visualizar(request, response)) {
				dispatcher = request.getRequestDispatcher("main?seccion=ver");
				request.setAttribute("lista", listaAmigos);
			}
		} else if (op.equalsIgnoreCase(OP_ELIMINAR)) {
			getRecogerSelecionado(request, response);
			dispatcher = request.getRequestDispatcher("main?seccion=eliminar");
		} else if (op.equalsIgnoreCase(OP_MODIFICAR)) {
			getRecogerSelecionado(request, response);
			String nombre = request.getParameter("nombre");
			a = modelo.recogerUno(nombre);
			request.setAttribute("amigoDatos", a);
			dispatcher = request.getRequestDispatcher("main?seccion=modificar");
		}
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int todoOk = 0;
		int borradoSi = 0;
		int modificadoSi = 0;
		op = request.getParameter("op");
		String seccion = request.getParameter("busqueda");
		if (op != null) {
			if (op.equalsIgnoreCase(OP_ANADIR)) {
				if (agregar(request, response) != -1) {
					dispatcher = request
							.getRequestDispatcher("main?seccion=anadir");
					todoOk = 1;
					request.setAttribute("amigo", (a.getNombre().toUpperCase()
							+ " " + a.getApellido().toUpperCase()));
				}
			} else if (op.equalsIgnoreCase(OP_MODIFICAR)) {
				if (modificar(request, response)) {
					dispatcher = request
							.getRequestDispatcher("main?seccion=modificar");
					idAmigo = -1;
					modificadoSi = 1;
					request.setAttribute("modificadoSi", modificadoSi);
					request.setAttribute("id", idAmigo);
					request.setAttribute("amigo",
							(a.getNombre() + " " + a.getApellido()));
				}
			} else if (op.equalsIgnoreCase(OP_ELIMINAR)) {
				if (eliminar(request, response)) {
					dispatcher = request
							.getRequestDispatcher("main?seccion=eliminar");
					idAmigo = -1;
					borradoSi = 1;
					request.setAttribute("borradoSi", borradoSi);
					request.setAttribute("id", idAmigo);
				}
			} else if (op.equalsIgnoreCase(OP_BUSCAR)) {
				if (buscador(request, response)) {
					request.setAttribute("listaAmigos", listaAmigos);
					dispatcher = request.getRequestDispatcher("main?seccion="
							+ seccion);
					todoOk = 1;
					if (seccion.equalsIgnoreCase(OP_MODIFICAR)) {

					}
				} else {
					todoOk = 2;
					dispatcher = request.getRequestDispatcher("main?seccion="
							+ seccion);
				}
			}
		} else if (request.getParameter("id") != null) {
			idAmigo = Integer.parseInt(request.getParameter("id"));
			if (eliminar(request, response)) {
				dispatcher = request
						.getRequestDispatcher("main?seccion=eliminar");
				todoOk = 1;
			}
		}
		if (todoOk > 0) {
			request.setAttribute("todoOk", todoOk);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * Metodo para recoger los datos del amigo seleccionado en la busqueda
	 * 
	 * @param request
	 * @param response
	 */
	private void getRecogerSelecionado(HttpServletRequest request,
			HttpServletResponse response) {
		String amigo = "";
		if (request.getParameter("id") != null) {
			idAmigo = Integer.parseInt(request.getParameter("id"));
			amigo = request.getParameter("amigo");
			request.setAttribute("amigo", amigo);
			request.setAttribute("id", idAmigo);
		}
	}

	/**
	 * Metodo para la búsqueda de amigos en la agenda que coincidan en nombre
	 * 
	 * @param request
	 * @param response
	 * @return TRUE si hay datos, FALSE si no hay datos
	 */
	private boolean buscador(HttpServletRequest request,
			HttpServletResponse response) {
		boolean result = false;
		String nombreBusqueda = request.getParameter("nombreBusqueda");
		listaAmigos = modelo.recogerPorNombre(nombreBusqueda);
		if (listaAmigos.size() > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Metodo para agregar a los amigos a la Agenda
	 * 
	 * @param request
	 * @param response
	 * @return id del alumno (-1 en caso de error)
	 */
	private int agregar(HttpServletRequest request, HttpServletResponse response) {
		log.trace("metodo agregar init");
		recogerDatosAmigo(request, response);
		idAmigo = modelo.insertar(a);
		log.trace("amigo insertado con valores [" + a.toString() + "]");
		log.trace("metodo agregar final");
		return idAmigo;
	}

	/**
	 * Metodo para eliminar a un amigo de la Agenda
	 * 
	 * @param request
	 * @param response
	 * @return TRUE si se ha eliminado, FALSE si se ha podido eliminar
	 */
	private boolean eliminar(HttpServletRequest request,
			HttpServletResponse response) {
		log.trace("metodo eliminar init");
		boolean result = true;
		if (!modelo.eliminar(idAmigo)) {
			result = false;
			log.warn("ATENCION no se ha podido eliminar el amigo con id ["
					+ idAmigo + "]");
		} else {
			log.trace("Amigo eliminado con id [" + idAmigo + "]");
		}
		log.trace("metodo eliminar final");
		return result;
	}

	/**
	 * Metodo para modificar amigos de la Agenda
	 * 
	 * @param request
	 * @param response
	 * @return TRUE si se ha modificado, FALSE si no se ha podido modificar el
	 *         amigo
	 */
	private boolean modificar(HttpServletRequest request,
			HttpServletResponse response) {
		log.trace("metodo modificar init");
		boolean result = true;
		recogerDatosAmigo(request, response);
		if (!modelo.modificar(a, idAmigo)) {
			result = false;
			log.warn("ATENCION no se ha podido modificar el amigo con id ["
					+ idAmigo + "]");
		} else {
			log.trace("Amigo modificado con id [" + idAmigo + "]");
		}
		log.trace("metodo modificar final");
		return result;
	}

	/**
	 * Metodo para visualizar todos los amigos de la Agenda
	 * 
	 * @param request
	 * @param response
	 * @return TRUE si hay amigos en la Agenda, FALSE en caso contrario
	 */
	private boolean visualizar(HttpServletRequest request,
			HttpServletResponse response) {
		boolean result = false;
		listaAmigos = modelo.recogerTodos();
		if (listaAmigos.size() > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Metodo privado para recoger los datos del amigo del formulario. Valido
	 * para modificar, agregar o eliminar
	 * 
	 * @param request
	 * @param response
	 */
	private void recogerDatosAmigo(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String calle = request.getParameter("calle");
			int cp = Integer.parseInt(request.getParameter("CP"));
			String localidad = request.getParameter("localidad");
			String provincia = request.getParameter("provincia");
			String mTelefono = request.getParameter("movil");
			String fTelefono = request.getParameter("fijo");
			String anotaciones = request.getParameter("anotaciones");
			if (op.equalsIgnoreCase(OP_MODIFICAR)
					|| op.equalsIgnoreCase(OP_ELIMINAR)) {
				idAmigo = Integer.parseInt(request.getParameter("id"));
			}
			a = new Amigo(nombre, apellido, mTelefono, fTelefono, calle,
					provincia, localidad, cp, anotaciones);
		} catch (AmigoExcepcion ex) {
			if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_NOMBRE) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR NOMBRE ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_APELLIDO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR APELLIDO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_TELEFONO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR TELEFONO ["
						+ ex.getMensajeError() + "]");
			} else if (ex.getCodigoError() == AmigoExcepcion.COD_ERROR_CP) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL ["
						+ ex.getMensajeError() + "]");
			}
		}

	}

	@Override
	public void init() throws ServletException {
		super.init();
		modelo = new ModeloAmigo();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		modelo = null;
		a = null;
		listaAmigos = null;
	}
}
