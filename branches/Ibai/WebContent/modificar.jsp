<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="inc/head.jsp" %>


<%@include file="forms/buscador.jsp" %>

<!-- pintamos el listado de nombres -->
<div class="contain">
	<p class="txt">Seleccionalo de la lista</p>
	
	<%
		ArrayList<String> lista= new ArrayList<String>();
		lista.add("Manolo");
		lista.add("Manola");
	%>
	
	<ul class="amigos modify">
		<c:forEach var="amigo" items="<%=lista %>">
			<li>
				<form action="" method="post">
					<input type="submit" name="amigo" value="${amigo}">
					<input type="hidden" name="buscar" value="ok">
					<input type="hidden" name="nombre" value="">
					<input type="hidden" name="id" value="">
				</form>
			</li>
		</c:forEach>
	</ul>
</div>

<%@include file="forms/modificar.jsp" %>

<%@include file="inc/footer.jsp" %>