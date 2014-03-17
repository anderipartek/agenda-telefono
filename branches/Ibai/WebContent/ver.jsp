<%@include file="inc/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>Estos son tus amigos:</h3>

	<table>
		<colgroup><col width="10%" span="2"><col width="20%"><col width="5%"><col width="10%" span="4"><col width="15%"></colgroup>
		<tr>
			<th>nombre</th>
			<th>apellido</th>
			<th>calle</th>
			<th>cp</th>
			<th>localidad</th>
			<th>provincia</th>
			<th>movil</th>
			<th>fijo</th>
			<th>anotaciones</th>
		</tr>

		<c:forEach var="amigo" items="${requestScope.lista_amigos}">
			<tr>
				<td>${amigo.nombre}</td>
				<td>${amigo.apellido}</td>
				<td>${amigo.calle}</td>
				<td>${amigo.cp}</td>
				<td>${amigo.localidad}</td>
				<td>${amigo.provincia}</td>
				<td>${amigo.movil}</td>
				<td>${amigo.fijo}</td>
				<td>${amigo.anotaciones}</td>
			</tr>
		</c:forEach>
		</table>
<!-- cerramos db -->

<%@include file="inc/footer.jsp"%>