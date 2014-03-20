<%@page import="com.ipartek.agenda.bbdd.model.ModeloAgenda"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
	
			<%
			ArrayList<Amigo> listaAmigos = null;
			ModeloAgenda modeloAgenda = new ModeloAgenda();
			if (modeloAgenda.getAll()!=null){
				listaAmigos = modeloAgenda.getAll();
			}else{
				System.out.println("Es null");
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
			
			</ul>
		</div>
<%@ include file="core/model/forms/eliminar.jsp"%>