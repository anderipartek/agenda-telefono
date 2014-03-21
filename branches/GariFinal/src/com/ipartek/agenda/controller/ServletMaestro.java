package com.ipartek.agenda.controller;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class servletMaestro
 */
public class ServletMaestro extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMaestro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		String prefix=getServletContext().getRealPath("/");
		String log4jpath= getInitParameter("log4j-config");
				
		if(log4jpath!=null){
			PropertyConfigurator.configure(prefix+log4jpath);
			
		}
	}
}

	