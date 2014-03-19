package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.modelo.ModeloAmigo;
import com.ipartek.agenda.excepciones.AmigoExcepcion;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends HttpServlet {
	static final Logger log = Logger.getLogger(AgendaServlet.class);
	private static final long serialVersionUID = 1L;
	// OPCIONES RECIBIDAS DESDE EL FORMULARIO
	public static final String OP_ANADIR = "añadir";
	public static final String OP_MODIFICAR = "modificar";
	public static final String OP_ELIMINAR = "eliminar";
	public static final String OP_VISUALIZAR = "ver";
	// OPERACION A REALIZAR
	private static String op;
	// AMIGO
	private Amigo a;
	private ModeloAmigo modelo;
	private int idAmigo;
	private ArrayList<Amigo> listaAmigos;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		op = (String) request.getAttribute("op");
		if (op != null) {
			if (op.equalsIgnoreCase(OP_ANADIR)) {
				if (agregar(request, response)) {
					// TODO AGREGAR
				}
			} else if (op.equalsIgnoreCase(OP_MODIFICAR)) {
				if (modificar(request, response)) {
					// TODO MODIFICAR
				}
			} else if (op.equalsIgnoreCase(OP_ELIMINAR)) {
				if (eliminar(request, response)) {
					// TODO ELIMINAR
				}
			} else if (op.equalsIgnoreCase(OP_VISUALIZAR)) {
				if (visualizar(request, response)) {

				}
			}
		}
	}

	private boolean agregar(HttpServletRequest request,
			HttpServletResponse response) {
		log.trace("metodo agregar init");
		boolean result = true;
		recogerDatosAmigo(request, response);
		idAmigo = modelo.insertar(a);
		log.trace("amigo insertado con valores [" + a.toString() + "]");
		log.trace("metodo agregar final");
		return result;
	}

	private boolean eliminar(HttpServletRequest request,
			HttpServletResponse response) {
		log.trace("metodo eliminar init");
		boolean result = true;
		recogerDatosAmigo(request, response);
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

	private boolean visualizar(HttpServletRequest request,
			HttpServletResponse response) {
		boolean result = false;
		listaAmigos = modelo.getAll();
		if (listaAmigos.size() > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * Metodo privado para recoger los datos del amigo del formulario
	 * 
	 * @param request
	 * @param response
	 */
	private void recogerDatosAmigo(HttpServletRequest request, HttpServletResponse response) {
		try {
			String nombre = (String) request.getAttribute("nombre");
			String apellido = (String) request.getAttribute("apellido");
			String calle = (String) request.getAttribute("calle");
			int cp = (Integer) request.getAttribute("CP");
			String localidad = (String) request.getAttribute("localidad");
			String provincia = (String) request.getAttribute("provincia");
			String mTelefono = (String) request.getAttribute("movil");
			String fTelefono = (String) request.getAttribute("fijo");
			String anotaciones = (String) request.getAttribute("anotaciones");
			if (OP_MODIFICAR.equalsIgnoreCase(op)) {
				idAmigo = Integer.parseInt(request.getParameter("id"));
			}
			a = new Amigo(nombre, apellido, mTelefono, fTelefono, calle,
					provincia, localidad, cp, anotaciones);
		} catch (AmigoExcepcion e) {
			if (e.getCodigoError() == AmigoExcepcion.COD_ERROR_NOMBRE) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR NOMBRE ["
						+ e.getMensajeError() + "]");
			} else if (e.getCodigoError() == AmigoExcepcion.COD_ERROR_APELLIDO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR APELLIDO ["
						+ e.getMensajeError() + "]");
			} else if (e.getCodigoError() == AmigoExcepcion.COD_ERROR_TELEFONO) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR TELEFONO ["
						+ e.getMensajeError() + "]");
			} else if (e.getCodigoError() == AmigoExcepcion.COD_ERROR_CP) {
				log.warn("Excepcion capturada por AmigoExcepcion ERROR CODIGO POSTAL ["
						+ e.getMensajeError() + "]");
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
	}
}
