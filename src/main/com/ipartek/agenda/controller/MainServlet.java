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

import com.ipartek.agenda.exception.AmigoException;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// HttpSession session;
	static final Logger log = Logger.getLogger(MainServlet.class);

	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute("seccion", seccion);
		dispatcher = request.getRequestDispatcher("index.jsp");
		// Locale por defecto Español
		Locale locale = new Locale("es_ES");

		// obtener lenguaje de la session del usuario
		String language = (String) request.getSession().getAttribute("language");

		if (language != null) {
			locale = new Locale(language);
		}
		log.debug("language: " + language + " locale: " + locale);

		// Cargar resourceBundle o properties dependiente del idioma

		// Debemos indicara el package donde se encuentra y el nombre del /properties sin la extension del locale
		ResourceBundle messages = ResourceBundle.getBundle("com.ipartek.agenda.controller.i18nmessages", locale);
		request.setAttribute("locale", messages);
	}

	/**
	 * @throws AmigoException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		// configuracion básica del log
		// recoge la ruta dinámicamente hasta donde se encuentra el proyecto
		String prefix = getServletContext().getRealPath("/");
		// recoger el nombre del parametro init
		String log4jPath = getInitParameter("log4j-config");
		if (log4jPath != null) {
			PropertyConfigurator.configure(prefix + log4jPath);
		}

		log.trace("Init " + getServletName());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
