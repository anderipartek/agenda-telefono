<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">

			<%
			ArrayList<String> lista = new ArrayList<String>();
			lista.add("Erlantz Romero");
			lista.add("Manolo Gisasola");
			lista.add("Manola Gisasola");
			lista.add("Manolito Abertxale");
			for (int i = 0 ; i < lista.size(); i++) { %>
				<li>
					<form action="agenda" method="post">
					
						<input type="submit" name="amigo" value="<%=lista.get(i)%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="Erlantz">
						<input type="hidden" name="id" value="<%=i %>>">
					</form>
				</li>
				<%} %>

			</ul>
		</div>
<div class="contain">
		<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

		
		<form method="post" action="agenda">				
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">			
			<input type="hidden" name="apellido" value="<?php echo $result_row[2]; ?>">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="eliminar" name="op" class="boton eliminar">
			</div>
		</form>

		
	</div>