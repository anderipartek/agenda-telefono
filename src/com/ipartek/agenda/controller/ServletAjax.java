package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.agenda.bbdd.model.ModeloAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class ServletAjax
 */
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ModeloAmigo modelo=new ModeloAmigo();
       
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger parametros search
				String nombreSearch=(String) request.getParameter("search");
				
				//llamar al Modelo
				
				ArrayList<Amigo> amigosbuscados=modelo.getByNombre(nombreSearch);
				
				
				
				//devolver datos
				//response.setContentType("text/html;charset=UTF-8");
				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				//Obtener el Writer
				PrintWriter out=response.getWriter();
				out.write(new Gson().toJson(amigosbuscados));
				
				/*out.print("retornamos datos de los amigos que empiezan por ["+ nombreSearch);
				out.print(amigosbuscados);
				
				for(int i=0; i<amigosbuscados.size();i++){
					out.println(amigosbuscados.get(i));
					}
				out.print("retornamos datos de los amigos que empiezan por ["+ nombreSearch);*/
			
	
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
