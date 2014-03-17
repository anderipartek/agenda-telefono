package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.ConnectionFactory;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		RequestDispatcher dispatcher = null;

		request.setAttribute("seccion", seccion);

		if (ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (ELIMINAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("ver.jsp");
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

	private boolean anadirAmigo(Amigo amigo) {
		return ConnectionFactory.getInstance().getDAOAmigo().add(amigo);
	}

	private boolean modificarAmigo(Amigo amigo) {
		return ConnectionFactory.getInstance().getDAOAmigo().update(amigo);
	}

	private boolean eliminarAmigo(Amigo amigo) {
		return ConnectionFactory.getInstance().getDAOAmigo().delete(amigo);
	}

	private ArrayList<Amigo> getAmigoByName(String value) {
		return ConnectionFactory.getInstance().getDAOAmigo().getByName(value);
	}

	private Amigo getAmigoById(int id) {
		return ConnectionFactory.getInstance().getDAOAmigo().getById(id);
	}

}
