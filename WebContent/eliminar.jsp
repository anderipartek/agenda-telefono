<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc/head.jsp" %>

<!-- pintamos el listado de nombres -->
<div class="contain">

	<%
		ArrayList<String> lista= new ArrayList<String>();
		lista.add("Manolo");
		lista.add("Manola");
	%>

	<p class="txt">Seleccionalo de la lista</p>
	<ul class="amigos del">
		<li>
		<c:forEach var="amigo" items="<%=lista %>">
			<form action="" method="post">
				<input type="submit" name="amigo" value="${amigo}">
				<input type="hidden" name="buscar" value="ok">
				<input type="hidden" name="nombre" value="">
				<input type="hidden" name="id" value="">
			</form>
		</c:forEach>
		</li>
	</ul>
</div>

<%@include file="inc/footer.jsp" %>