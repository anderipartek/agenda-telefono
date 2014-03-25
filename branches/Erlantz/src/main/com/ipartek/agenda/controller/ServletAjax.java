package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.modelo.ModeloAmigo;

/**
 * Servlet implementation class ServletAjax.
 */
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ModeloAmigo modelo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String nombreSearch = request.getParameter("search");
		HashMap<Integer, Amigo> lista = modelo.recogerPorNombre(nombreSearch);

		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(lista));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public final void init() throws ServletException {
		super.init();
		modelo = new ModeloAmigo();
	}

	@Override
	public final void destroy() {
		super.destroy();
		modelo = null;
	}

}
