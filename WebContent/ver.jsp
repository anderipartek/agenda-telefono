<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@include file="inc/head.jsp" %>

<!-- contenido central -->
<body>
<section class="wrapper content">	
<h3>Estos son tus amigos:</h3>

	<% ArrayList<Amigo> amigos= (ArrayList<Amigo>) request.getAttribute("amigos"); %>
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

	<%for(Amigo amigo: amigos){ %> 
		<tr>
			<td><%=amigo.getNombre() %></td>
			<td><%=amigo.getApellido() %></td>
			<td><%=amigo.getCalle() %></td>
			<td><%=amigo.getCp() %></td>
			<td><%=amigo.getLocalidad() %></td>
			<td><%=amigo.getProvincia() %></td>
			<td><%=amigo.getMovil() %></td>
			<td><%=amigo.getFijo() %></td>
			<td><%=amigo.getAnotaciones() %></td>
		</tr>
		<%} %>
	
		</table>
	</section>
	<%@include file="/inc/footer.jsp"%>