<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@include file="inc/head.jsp" %>

<!-- contenido central -->
<body>
<section class="wrapper content">	
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
			<th>Modificar</th>
			<th>Editar</th>
		</tr>
		<tr>
		<c:forEach var="amigo" items="${requestScope.listaAmigos}">
			<td><div><c:out value="${amigo.nombre}"/></div></td>
    		<td><div><c:out value="${amigo.apellido}"/></div></td>
    		<td><div><c:out value="${amigo.calle}"/></div></td>
    		<td><div><c:out value="${amigo.cp}"/></div></td>
    		<td><div><c:out value="${amigo.localidad}"/></div></td>
    		<td><div><c:out value="${amigo.provincia}"/></div></td>
    		<td><div><c:out value="${amigo.movil}"/></div></td>
    		<td><div><c:out value="${amigo.fijo}"/></div></td>
    		<td><div><c:out value="${amigo.anotaciones}"/></div></td>
    		<td><a href='agenda?id=${amigo.id}' name="modificar"><img src="../img/lapiz.gif"></a></td>
    		<td><a href='agenda?id=${amigo.id}' name='elimminar'><img src="../img/eliminar.jpg"></a></td>
    		</tr>
    	</c:forEach>
		</table>
	</section>
	<%@include file="/inc/footer.jsp"%>