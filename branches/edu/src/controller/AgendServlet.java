package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AgendServlet
 */
public class AgendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatcher;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sec=(String)request.getAttribute("seccion");
		if ("anadir".equals(sec))
		{
			dispatcher= request.getRequestDispatcher("anadirContacto.jsp");
			//anyadirContacto(request,response);
		}
		else if ("modificar".equals(sec))
		{
			dispatcher= request.getRequestDispatcher("modificarContacto.jsp");
			modificarContacto(request,response);
		}
		else if ("eliminar".equals(sec))
		{
			dispatcher= request.getRequestDispatcher("eliminarContacto.jsp");
			eliminarContacto(request,response);
		}
		else if ("ver".equals(sec))
		{
			dispatcher= request.getRequestDispatcher("verContacto.jsp");
			verContacto(request,response);
		}
		
		dispatcher.forward(request, response);
	}

	private void verContacto(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		
	}

	private void eliminarContacto(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

	private void modificarContacto(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

	private void anyadirContacto(HttpServletRequest request,
			HttpServletResponse response) {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
