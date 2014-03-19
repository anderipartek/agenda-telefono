<%@page import="com.ipartek.agenda.bbdd.ModeloAmigo"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ include file="../../../inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="../../../inc/header.jsp" %>
<body>
<%@ include file="buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos del">
			
			<%
			Amigo a=(Amigo)request.getAttribute("Amigo");
			String nombre="";
			String apellidos="";
			if (a==null){
			  nombre="";
			  apellidos="";
			}
			else{
				nombre=a.getNombre();
				apellidos=a.getApellido();
			}
				
			
			%>
				<li>
					<form action="agenda?operacion=borrar" method="post">
					
						<input type="submit" name="amigo" value='<%=nombre+"  "+ apellidos%>'>
						
						
					</form>
				</li>
				
			
			</ul>
</div>

<!-- FOOTER -->

<%@include file="../../../inc/footer.jsp"%>

