package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String OP_AÑADIR="nuevo";
	public static final String OP_MODIFICAR="modificar";
	public static final String OP_ELIMINAR="eliminar";
	public static final String OP_VER="ver";

	private RequestDispatcher dispatcher;
	 HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		
		
		//recoger Operacion a realizar
		String op = (String) request.getParameter("op");
		
			if ( OP_AÑADIR.equalsIgnoreCase(op)){
				
				dispatcher = request.getRequestDispatcher("anadir.jsp");
				dispatcher.forward(request, response);
			}else if ( OP_MODIFICAR.equalsIgnoreCase(op)){
				modificarAgenda(request,response);
			}else if ( OP_ELIMINAR.equalsIgnoreCase(op)){
				eliminarAgenda(request, response);
			}else{
				throw new ServletException("Operacion no soportada " + op );
			}
		
	}

	private void eliminarAgenda(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void modificarAgenda(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void añadirAgenda(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
