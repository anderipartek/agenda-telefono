package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.controller.i18nmessages.Menssagges;
import com.ipartek.agenda.modelo.DAOAmigo;

/**
 * Servlet implementation class MainServlet.
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final Logger LOG = Logger.getLogger(MainServlet.class);

	
	public static final String SECCION = "seccion";
	
	public static final String OP_ANADIR = "anadir";
	public static final String OP_ELIMINAR = "eliminar";
	public static final String OP_MODIFICAR = "modificar";
	public static final String OP_CANCELAR = "cancelar";
	public static final String OP_BUSCAR = "buscar";
	public static final String OP_VER = "ver";
	
	private Locale locale;
	
	private HttpSession session;
	
	private RequestDispatcher dispatcher;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//Configuración del log4j
		String prefix = getServletContext().getRealPath("/");
		String log4jpath = getInitParameter("lo4j-config");

		if (log4jpath != null) {
			PropertyConfigurator.configure(prefix + log4jpath);
		}
		LOG.trace("Init " + getServletName());
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String seccion = request.getParameter(SECCION);
		
		// Detecta el idioma.
		Menssagges.getLanguage(request);
		
		//Guardar en sesión el idoma para  luego poder recuperarlo
		request.getSession().setAttribute("locale", locale);
		
		request.setAttribute("seccion", seccion);
		

		session = request.getSession(true);
			

		if (OP_ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (OP_MODIFICAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (OP_ELIMINAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (OP_VER.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("ver.jsp");
			//response.sendRedirect("/agenda");
			
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
	
}
