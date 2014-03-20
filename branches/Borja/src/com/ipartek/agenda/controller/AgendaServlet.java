package com.ipartek.agenda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	public static final String OP_MODIFICAR_AMIGO = "modificar";
	public static final String OP_ELIMINAR_AMIGO = "borrar";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaServlet() {
        super();
      
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.modeloAgenda = new ModeloAgenda();
		//log.trace("init " + getServletName());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		//log.trace("destroy " + getServletName());
		super.destroy();
		this.modeloAgenda = null;
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// obtener dispatcher
				RequestDispatcher dispatcher = null;

				// comprobar si es para detalle o listar
				String idAmigo = request.getParameter("id");
				boolean mostrarLista = false;
				try {
					if (request.getAttribute("mostrarLista") != null) {
						mostrarLista = ((boolean) request.getAttribute("mostrarLista"));
					}
				} catch (Exception e) {
				}

				if ((idAmigo == null) || mostrarLista) {
					//log.trace("Listado Alumno");
					//request.setAttribute("title", "Lista Amigos");

					dispatcher = request.getRequestDispatcher("alumnoList.jsp");

					ArrayList<Amigo> listaAmigos = this.modeloAgenda.getAll();
					//log.debug(listaAmigos.size() + " alumnos consultados");
					// enviar datos en la request ala JSP
					request.setAttribute("listaAmigos", listaAmigos);
				} else {
					//log.trace("Detalle alumno " + idAlumno);
					request.setAttribute("title", "Nuevo Alumno");

					int id = Integer.parseInt(idAmigo);
					if (id >= 0) {
						request.setAttribute("detalle", ConnectionFactory.getInstance().getDAOAmigo().getById(id));
						request.setAttribute("isNombreValid", true);
						request.setAttribute("isApellidoValid", true);
						request.setAttribute("isEmailValid", true);
						request.setAttribute("isEdadValid", true);
						request.setAttribute("isDniValid", true);
					}
					dispatcher = request.getRequestDispatcher("alumnoDetalle.jsp");
				}

				// Redireccionar a la jsp
				dispatcher.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");

		if (OP_AÑADIR_AMIGO.equalsIgnoreCase(op)) {
			crearAmigo(request, response);

		} else if (OP_MODIFICAR_AMIGO.equalsIgnoreCase(op)) {
			modificarAmigo(request, response);
		} else if (OP_ELIMINAR_AMIGO.equalsIgnoreCase(op)) {
			borrarAmigo(request, response);

			return;
		}

	}// end doPost
	
	
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
	
	private void modificarAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Amigo a = null;
		a = validateValues(request, response, true);
		if (a != null) {
			// if (!modeloAlumno.update(a, a.getId())) {
			if (ConnectionFactory.getInstance().getDAOAmigo().update(a, a.getId())) {
				//log.debug("Se ha modificado el alumno " + a.getId());
			} else {
				//log.warn("No se ha podido modificar el alumno " + a.getId());
			}
		}
		dispatcher = request.getRequestDispatcher("alumnoDetalle.jsp");
		dispatcher.forward(request, response);

	}
	
	private void crearAmigo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		Amigo a = null;
		a = validateValues(request, response, false);
		if (a != null) {
			this.modeloAgenda.insert(a);
		}
		//log.debug("Creado alumno " + a.getId());

		dispatcher = request.getRequestDispatcher("alumnoDetalle.jsp");
		dispatcher.forward(request, response);

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
