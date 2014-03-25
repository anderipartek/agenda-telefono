package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Contacto;
import com.ipartek.agenda.model.ModeloContacto;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloContacto modeloContacto;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException  {
    	super.init(config);
    	modeloContacto = new ModeloContacto();
    }
 
 public void destroy(){
	 super.destroy();
	 modeloContacto = null;
 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger parametro 'search'
		String nombreSearch=request.getParameter("search");
	
		//TODO llamar al Modelo
		Contacto lista = modeloContacto.getByNombre(nombreSearch);
		
		//devolver datos
		//response.setContentType("text/html;charset=UTF-8");
		//out.println("retomamos datos de los amigos que empiezan por: " + nombreSearch);
		//for(int i=0; i < lista.size(); i++){	
		//}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(lista));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
