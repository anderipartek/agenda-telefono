package com.ipartek.formacion.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String seccion = request.getParameter("seccion");
		if ("anadir".equals(seccion)){
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		}else if ("modificar".equals(seccion)){
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		}else if ("eliminar".equals(seccion)){
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		}else if ("ver".equals(seccion)){
			dispatcher = request.getRequestDispatcher("ver.jsp");
		}else{
			dispatcher = request.getRequestDispatcher("index.jsp");
		}
		request.setAttribute("seccion", seccion);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
