package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.agenda.bbdd.ModeloAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger parametro search
		RequestDispatcher dispatcher = null;
		String busqueda=request.getParameter("search");
		//TODO llamar al modelo
		ModeloAmigo model= new ModeloAmigo();
		ArrayList<Amigo> listaAmigos=model.getAmigosByNombre(busqueda);
		//devolver datos
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//convierte el response a JSON
		response.getWriter().write(new Gson().toJson(listaAmigos));
		
		
		//dispatcher = request.getRequestDispatcher("modificar.jsp");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
