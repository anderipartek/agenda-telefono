<!DOCTYPE html>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modificar | Versión Móvil</title>

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
			<h1>Modificar amigo ${requestScope.amigo.nombre}</h1>
			<a href="agenda" data-role="button" data-icon="back">Back</a>
			<!--  <a href="#" data-role="button" data-icon="back">Home</a>-->
		</div><!-- /Header -->
		<form id="formulario" method="post" action="agenda" >
			<label for="text-basic">Nombre:</label> 
			<input id="nombre" name="nombre" data-ajax="false" type="text" name="text-basic" id="text-basic" value="${requestScope.amigo.nombre}">
			
			<label for="number-pattern">CP:</label>
			<input id="cp" name="cp" data-ajax="false" type="number" name="number" pattern="[0-9]{5}" id="number-pattern" value="${requestScope.amigo.cp}">
			
			<label for="tel">Teléfono fijo:</label>
			<input id="fijo" name="fijo" data-ajax="false" type="tel" name="tel" id="tel" pattern="[8-9]{1}[0-9]{8}" value="${requestScope.amigo.fijo}">
			
			<label for="textarea-2">Anotaciones:</label>
			<textarea id="anotaciones" name="anotaciones" data-ajax="false" cols="40" rows="8" name="textarea-2" id="textarea-2">${requestScope.amigo.anotaciones}</textarea>
			
			<input type="submit" value="<%=MainServlet.OP_MODIFICAR %>" name="op" class="boton modificar">
		</form>

	</div>
	<!-- /page modificars-->




</body>
</html>