<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			<!-- ?php
			// mostramos los datos de la query
			while($result_row = mysql_fetch_array($result)){
			
			?-->
			<%
			ArrayList<String> lista = new ArrayList<String>();
			lista.add("Saray Carralero");
			lista.add("David Romero");
			lista.add("Leticia Ortiz");
			lista.add("Marta Aguado");
			for (int i = 0 ; i < lista.size(); i++) { %>
				<li>
					<form action="<?php htmlentities($_SERVER['PHP_SELF']); ?>" method="post">
					
						<input type="submit" name="amigo" value="<%=lista.get(i)%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="Saray">
						<input type="hidden" name="id" value="<%=i %>>">
					</form>
				</li>
				<%} %>
			<!-- ?php
			}
			?-->
			</ul>
		</div>
<%@ include file="core/model/forms/eliminar.jsp"%>