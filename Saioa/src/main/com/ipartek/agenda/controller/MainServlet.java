package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;

	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	private final static Logger log=Logger.getLogger(MainServlet.class);

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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.trace("Main Servlet doGet" );
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute("seccion", seccion);
		dispatcher = request.getRequestDispatcher("index.jsp");
		/*
		 * if (ANADIR.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); } else if (MODIFICAR.equals(seccion)) { dispatcher =
		 * request.getRequestDispatcher("index.jsp"); } else if (ELIMINAR.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); }
		 * else if (VER.equals(seccion)) { dispatcher = request.getRequestDispatcher("index.jsp"); } else { dispatcher =
		 * request.getRequestDispatcher("index.jsp"); }
		 */

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.trace("MainServlet doPost");
		doGet(request, response);
	}

}
