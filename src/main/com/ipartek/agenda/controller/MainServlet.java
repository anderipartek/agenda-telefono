package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class MainServlet. Para cambiar de jsp e
 * inicizalizador del LOG
 */
public class MainServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// LOGGER /////////////////////////////////////////
	/**
	 * 
	 */
	static final Logger LOG = Logger.getLogger(MainServlet.class);

	/**
	 * 
	 */
	public static final String SECCION = "seccion";
	/**
	 * 
	 */
	public static final String ANADIR = "anadir";
	/**
	 * 
	 */
	public static final String MODIFICAR = "modificar";
	/**
	 * 
	 */
	public static final String ELIMINAR = "eliminar";
	/**
	 * 
	 */
	public static final String VER = "ver";

	@Override
	public void init() throws ServletException {
		super.init();
		// configuracion básica del LOG
		// recoge la ruta dinámicamente hasta donde se encuentra el proyecto
		String prefix = getServletContext().getRealPath("/");
		// recoger el nombre del parametro init
		String log4jPath = getInitParameter("log4j-config");
		if (log4jPath != null) {
			PropertyConfigurator.configure(prefix + log4jPath);
		}
		LOG.trace("Init " + getServletName());

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @param request request
	 * @param response response
	 * @throws ServletException excepcion de servlet
	 * @throws IOException excepcion de entrada y salida
	 */
	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		LOG.trace("doGet MainServlet");
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute("seccion", seccion);
		dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		LOG.trace("doGet MainServlet fin");
		// Locale por defecto Español
		Locale locale = new Locale("es_ES");

		// obtener lenguaje de la session del usuario
		String language = (String) request.getSession()
				.getAttribute("language");
		if (language != null) {
			locale = new Locale(language);
		}

		LOG.debug("language: " + language + " locale: " + locale);
		ResourceBundle.getBundle("com.ipartek.agenda.controller.i18nmessages",
				locale);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @param request request
	 * @param response response
	 * @throws ServletException excepcion de servlet
	 * @throws IOException excepcion de entrada y salida
	 */
	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		doGet(request, response);
	}

}
