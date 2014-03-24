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
import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.DAOAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ConnectionFactory factory;
	DAOAmigo daoAmigo;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	factory = ConnectionFactory.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recoger parametro 'search'
		String nSearch = (String)request.getParameter("search");
		
		//TODO llamar al modelo, en mi caso al dao
		ArrayList<Amigo> lista = factory.getDAOAmigo().getByNombre(nSearch);
		
		//devolver datos
		//response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.write(new Gson().toJson(lista));
		
		
		out.println("retornamos datos de los amigos que empiezan por: " + nSearch);
		for(int i=0; i<lista.size();i++){
			out.println(lista.get(i));
		}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
