<!DOCTYPE html>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Añadir | Versión Móvil</title>

<link rel="stylesheet" href="css/jquery.mobile-1.4.2.css">
<link rel="stylesheet" href="_assets/css/jqm-demos.css">

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<script src="js/jquery-2.1.0.min.js"></script>

<script src="js/jquery.mobile-1.4.2.min.js"></script>

<script>
	$(document).ready(function() {
		// Por defecto todas las paginas van a tener esta transición
		$.mobile.defaultPageTransition = 'slideup';
		$.mobile.defaultDialogTransition = 'flip';

	});
</script>

</head>

<body>
	<div data-role="page" id="modificar" class="">

		<div data-role="header" class="">
			<h1>Añadir amigo</h1>
			<a href="agenda" data-role="button" data-icon="back">Back</a>
			<!--  <a href="#" data-role="button" data-icon="back">Home</a>-->
		</div>
		<!-- /Header -->
		<div data-role="content">
			<div class="contain">
			<p class="titulo">Cuales son los datos de tu amigo:</p>
			
			<%@include file="/inc/mensajes.jsp" %>
			
			<form id="formulario" method="post" action="agenda" >
		
			<input name="id" id="id" value="${requestScope.amigo.id}" type="hidden">
			
			<label for="nombre">Nombre:</label> 
			<input id="nombre" name="nombre" data-ajax="false" type="text" name="nombre" id="nombre" value="${requestScope.amigo.nombre}">
			
			<label for="nombre">Apellido:</label> 
			<input id="apellido" name="apellido" data-ajax="false" type="text" value="${requestScope.amigo.apellido}">
			
			<label for="nombre">Calle:</label>
			<input id="calle" name="calle" data-ajax="false" type="text" value="${requestScope.amigo.calle}">
			
			<label for="CP">CP:</label>
			<input id="cp" name="CP" data-ajax="false" type="number" name="CP" pattern="[0-9]{5}" id="number-pattern" value="${requestScope.amigo.cp}">
			
			<label for="nombre">Localidad:</label> 
			<input id="localidad" name="localidad" data-ajax="false" type="text" value="${requestScope.amigo.localidad}">
			
			<label for="nombre">Provincia:</label> 
			<input id="provincia" name="provincia" data-ajax="false" type="text" value="${requestScope.amigo.provincia}">
			
			<label for="tel">Teléfono fijo:</label>
			<input id="fijo" name="fijo" data-ajax="false" type="tel" name="tel" id="tel" pattern="[8-9]{1}[0-9]{8}" value="${requestScope.amigo.fijo}">
			
			<label for="movil">Teléfono móvil:</label>
			<input id="movil" name="movil" data-ajax="false" type="tel" name="tel" id="tel" pattern="[6-7]{1}[0-9]{8}" value="${requestScope.amigo.movil}">
			
			<label for="anotaciones">Anotaciones:</label>
			<textarea id="anotaciones" name="anotaciones" data-ajax="false" cols="40" rows="8" name="anotaciones" id="anotaciones">${requestScope.amigo.anotaciones}</textarea>
				
				<div class="botones">
					
					<input type="submit" value="<%=MainServlet.OP_ANADIR %>" name="op" class="boton anadir">
					
				</div>
			</form>
		</div>
		
		
		</div>
		
		
	</div>
</body>