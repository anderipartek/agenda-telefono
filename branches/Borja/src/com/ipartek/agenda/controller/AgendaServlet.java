package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.model.ModeloAgenda;

/**
 * Servlet implementation class AgendaServlet
 */
public class AgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ModeloAgenda modeloAgenda;
       
	
	public static final String OP_AÑADIR_AMIGO = "nuevo";
	public static final String OP_MODIFICAR_ALUMNO = "modificar";
	public static final String OP_ELIMINAR_ALUMNO = "borrar";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void borrarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Amigo a = null;
		int id = parseIdToInt(request);
		if (this.modeloAgenda.delete(id)) {
			//log.debug("Se ha borrado el alumno " + id);
		} else {
			//log.warn("No se ha podido borrar el alumno " + id);
		}
		request.setAttribute("mostrarLista", true);
		doGet(request, response);
	}
	
	private int parseIdToInt(HttpServletRequest request) {
		int id = -1;
		try {
			id = (Integer.parseInt(request.getParameter("id")));
		} catch (Exception e) {
		}
		return id;
	}

}
