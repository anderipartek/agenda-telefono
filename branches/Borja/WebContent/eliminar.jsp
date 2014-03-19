<%@page import="com.ipartek.agenda.bbdd.model.ModeloAgenda"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
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
			ModeloAgenda modeloAgenda = new ModeloAgenda();
			if (modeloAgenda.getAll()!=null){
				ArrayList<Amigo> listaAmigos = modeloAgenda.getAll();
			}else{
				
			}
			
			for (int i = 0 ; i < listaAmigos.size(); i++) { %>
				<li>
					<form action="<?php htmlentities($_SERVER['PHP_SELF']); ?>" method="post">
					
						<input type="submit" name="amigo" value="<%=listaAmigos.get(i).getNombre()%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="Erlantz">
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