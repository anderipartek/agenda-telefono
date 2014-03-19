<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="core/model/forms/buscador.jsp"%>

	<%
	int todOk = 0;
	if (request.getAttribute("todoOk")!= null){
		
		HashMap<Integer,Amigo> listaAmigos = (HashMap<Integer,Amigo>) request.getAttribute("listaAmigos");
		if(todOk == 0) {	
			%>

			<div class="contain">
					<p class="txt">Seleccionalo de la lista</p>
					<ul class="amigos modify">
					<%
					for (int i = 1 ; i <= listaAmigos.size(); i++) { 
						Amigo amigo = listaAmigos.get(i);
						String nombreApe = amigo.getNombre() + " " + amigo.getApellido();
					%>
						<li>
							<form action="agenda" method="get">
								<input type="submit" name="amigo" value="<%=nombreApe%>">
								<input type="hidden" name="buscar" value="ok">
								<input type="hidden" name="nombre" value="Erlantz">
								<input type="hidden" name="id" value="<%=listaAmigos.get(i).getId() %>">
								<input type="hidden" name="op" value="eliminar">
							</form>
						</li>
						<%}%>
					</ul>
				</div>
			<%
			if(request.getParameter("amigo")!=null){
				%>
				<%@ include file="core/model/forms/eliminar.jsp"%>
			<%} %>
			<%--@ include file="todoOk.jsp"--%>
		<%} else {
		%> <p> NO HAY AMIGOS QUE COINCIDAN CON ESE NOMBRE </p><%
		}
	}%>
		