package com.ipartek.agenda.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.agenda.bbdd.ConnectionFactory;
import com.ipartek.agenda.bbdd.DAOAmigo;
import com.ipartek.agenda.bean.Amigo;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends ServletMaestro {
	private static final long serialVersionUID = 1L;
	
	
	public static final String SECCION = "seccion";
	public static final String ANADIR = "anadir";
	public static final String MODIFICAR = "modificar";
	public static final String ELIMINAR = "eliminar";
	public static final String VER = "ver";
	
	
	public static final String ACCION = "ACCION";
	public static final String ACCION_ANADIR = "accionAnadir";
	public static final String ACCION_MODIFICAR = "accionModificar";
	public static final String ACCION_ELIMINAR = "accionEliminar";
	public static final String ACCION_VER = "accionVer";
	
	DAOAmigo daoAmigo;
	RequestDispatcher dispatcher = null;
	ConnectionFactory factory;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		factory = ConnectionFactory.getInstance();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String seccion = request.getParameter(SECCION);
		
		request.setAttribute("seccion", seccion);

		if (ANADIR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("anadir.jsp");
		} else if (MODIFICAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("modificar.jsp");
		} else if (ELIMINAR.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("eliminar.jsp");
		} else if (VER.equals(seccion)) {
			dispatcher = request.getRequestDispatcher("ver.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("index.jsp");
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter(ACCION);
		request.setAttribute("accion", accion);
		
		if("anadir".equals(ACCION)){	
			Amigo a = crearAmigo(request);
			int resul = añadirAmigo(a);
			request.setAttribute(ACCION_ANADIR, resul);
		}else if("modificar".equals(ACCION)){
			
		}
	}

	private int añadirAmigo(Amigo a) {
		return factory.getDAOAmigo().insertAmigo(a);
	}

	private Amigo crearAmigo(HttpServletRequest request) {
		Amigo a = new Amigo();
		String id = request.getParameter(daoAmigo.ID);
		if(id !=null){
			a.setId(Integer.parseInt(id));
		}	
		
			a.setNombre(request.getParameter(daoAmigo.NOMBRE));
			a.setApellido(request.getParameter(daoAmigo.APELLIDO));
			a.setCalle(request.getParameter(daoAmigo.CALLE));
			a.setCp(request.getParameter(daoAmigo.CP));
			a.setLocalidad(request.getParameter(daoAmigo.LOCALIDAD));
			a.setProvincia(request.getParameter(daoAmigo.PROVINCIA));
			a.settMovil(request.getParameter(daoAmigo.MOVIL));
			a.settFijo(request.getParameter(daoAmigo.FIJO));
			
		
		return a;
	}

}
