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
import com.ipartek.agenda.model.ModeloAmigo;

/**
 * Servlet implementation class ServletAjax
 */
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloAmigo modelo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjax() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recoger parametro search
		String nombreSearch = request.getParameter("search");
		HashMap<Integer, Amigo> lista = modelo.recogerTodosNombre(nombreSearch);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(lista));

		// llamar al modelo

		// devolver datos
		// response.setContentType("text/html;charset=UTF-8");

		// out.print("retornamos datos de los amigos que empiezan por " + nombreSearch);
		/*
		 * for (int i = 0; i < lista.size(); i++) { out.print(lista.get(i)); }
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		modelo = new ModeloAmigo();
	}

	@Override
	public void destroy() {

		super.destroy();
		modelo = null;
	}

}
