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
		</tr>

	
		<tr>
			<td>NombreEjemplo</td>
			<td>ApellidoEjemplo</td>
			<td>CalleEjemplo</td>
			<td>CpEjemplo</td>
			<td>LocalidadEjemplo</td>
			<td>ProvinciaEjemplo</td>
			<td>MovilEjemplo</td>
			<td>FijoEjemplo</td>
			<td>AnotacionesEjemplo</td>
		</tr>
	
		</table>
	</section>
	<%@include file="/inc/footer.jsp"%>