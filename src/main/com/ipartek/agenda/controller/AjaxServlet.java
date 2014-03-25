package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.modelo.ModeloAmigo;
import com.google.gson.Gson;
/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
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
		//especificar tipo de respuesta
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//Obtener el Writer
		ArrayList<Amigo> listaAmigos=model.obtenerAmigoByNombre(busqueda);
		//devolver datos
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//convierte el response a JSON
		response.getWriter().write(new Gson().toJson(listaAmigos));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
