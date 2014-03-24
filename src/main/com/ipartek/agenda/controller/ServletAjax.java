package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.interfaces.IDAOAmigo;
import com.ipartek.agenda.modelo.ConnectionFactory;

/**
 * Servlet implementation class ServletAjax
 */
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDAOAmigo modeloAmigo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	modeloAmigo = ConnectionFactory.getInstance().getDAOAmigo();
    	super.init(config);
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recoger Parametro search
		String nombre = request.getParameter("search");
		
		
		ArrayList<Amigo> amigos = modeloAmigo.getByName(nombre);
		
		 //response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json");
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out=  response.getWriter();
		
		// se devuelve por medio de json
		
		out.write(new Gson().toJson(amigos));
		
		/*// retornar respuesta, datos
		  
		   
		   		   
		   out.print("Número de amigos: " + amigos.size());
		   
		   for(int i=0; i<amigos.size(); i++){
			   out.print("amigos " + amigos.get(i).toString());
		   }*/
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
