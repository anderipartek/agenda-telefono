<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>A�adir amigo | Version Movil</title>

<link rel="stylesheet" href="theme/css/jquery.mobile-1.4.2.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<script src="js/jquery.js"></script>
<script src="js/jquery.mobile-1.4.2.min.js"></script>

<script>
	$(document).ready(function(){
		$.mobile.defaultPageTransition='slideup';
		$.mobile.defaultDialogTransition='pop';
	});
</script>

</head>
<body>

	<div data-role="panel" id="mypanel">
	    <ul  data-role="listview" >
		    <li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" >A�adir</a></li>
			<li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" >Modificar</a></li>
			<li><a href="">Eliminar</a></li>
			<li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" >Ver</a></li>
	    </ul>
	</div><!-- /panel -->
			
	

	<div data-role="page" id="home">
		<div data-role="header" class="">
			<h1>A�adir Amigos</h1>
			<a href="#mypanel">menu</a>
		</div>

				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" data-role="button" data-inline="true" data-theme="a">A�adir</a>
				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" data-role="button" data-inline="true" data-theme="b">Modificar</a>
				<a href="" data-role="button" data-inline="true" data-theme="c">Eliminar</a>
				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" data-role="button" data-inline="true" data-theme="d">Ver</a>


		<div data-role="content" class="">

		</div>
	</div>
	<!-- /page home-->

	<div data-role="page" id="politica">
		<div data-role="header" class="">
			<h1>Politica privacidad</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>

		<div data-role="content" class="">Lorem Ipsum es simplemente el
			texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha
			sido el texto de relleno est�ndar de las industrias desde el a�o
			1500, cuando un impresor (N. del T. persona que se dedica a la
			imprenta) desconocido us� una galer�a de textos y los mezcl� de tal
			manera que logr� hacer un libro de textos especimen. No s�lo
			sobrevivi� 500 a�os, sino que tambien ingres� como texto de relleno
			en documentos electr�nicos, quedando esencialmente igual al original.
			Fue popularizado en los 60s con la creaci�n de las hojas "Letraset",
			las cuales contenian pasajes de Lorem Ipsum, y m�s recientemente con
			software de autoedici�n, como por ejemplo Aldus PageMaker, el cual
			incluye versiones de Lorem Ipsum.</div>

		<div data-role="footer" class="">IparSex servicios Informaticos
			2014</div>
	</div>
	<!-- /page politica-->




</body>
</html>
