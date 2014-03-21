package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
 * Servlet implementation class ServletMaestro
 */
public class ServletMaestro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger log=Logger.getLogger(ServletMaestro.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMaestro() {
    	super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
        super.init(config);
		String prefix=getServletContext().getRealPath("/");
		String log4jpath=getInitParameter("log4j-config");
		if(log4jpath!=null)
		{
			PropertyConfigurator.configure(prefix+log4jpath);
		}
		log.trace("ServletMaestro Init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		log.trace("ServletMaestro Destroy");
	}

	

	
}
