package com.ipartek.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class ServletAjax
 */
public class ServletAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		//recoger parametro 'search'
		
		//TODO lllamar al Modelo
		
		//devolver datos
		ArrayList <Amigo> listaAmigos = ma.getByNombre();
		
		response.setContentType("application/json; charset=UTF-8");
		String nombreSearch = request.getParameter("searcch");
		
		PrintWriter out = response.getWriter();
		out.write(new Gson().toJson(listaAmigos));
		
		
		
		/*
		 * 
		response.setContentType("text/html; charset=UTF-8");
		String nombreSearch = request.getParameter("searcch");
		PrintWriter out = response.getWriter();
		out.print("retornamos datoss de los amigos que empiezan por: "+nombreSearch);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
