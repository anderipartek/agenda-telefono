<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Añadir amigo | Version Movil</title>

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

	<div data-role="page" id="home">
	
		<div data-role="panel" id="mypanel">
		    <ul  data-role="listview" >
			    <li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" >Añadir</a></li>
				<li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" >Modificar</a></li>
				<li><a href="">Eliminar</a></li>
				<li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" >Ver</a></li>
		    </ul>
		</div><!-- /panel -->
			
	
	
		<div data-role="header" class="">
			<h1>Añadir Amigos</h1>
			<a href="#mypanel">menu</a>
		</div>

				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" data-role="button" data-inline="true" data-theme="a">Añadir</a>
				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" data-role="button" data-inline="true" data-theme="b">Modificar</a>
				<a href="" data-role="button" data-inline="true" data-theme="c">Eliminar</a>
				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" data-role="button" data-inline="true" data-theme="d">Ver</a>


		<div data-role="content" class="">

			<%@include file="../mensaje.jsp"%>	
			
			<%
				Amigo amigo = (Amigo)request.getAttribute("amigo");
	
			   	if (amigo == null){
			   		amigo = new Amigo();
			   	}else{
			   		%><p class="titulo correcto">Amigo añadido</p><%
			   	}
			%>
		
			<p class="titulo">Cuales son los datos de tu amigo:</p>
		
			
			<form method="post" action="main">				
				<input type="text" pattern=[A-Za-z]{2,25} placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
				<input type="text" pattern=[A-Za-z]{2,25} placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
				<input type="text" pattern=[A-Za-z]{2,25} placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
				<input type="text" pattern="[0-9]{5}" placeholder="cp" name="cp" value="<%if(amigo.getCp()!=0){%><%=amigo.getCp() %><%}%>">
				<input type="text" pattern=[A-Za-z]{2,25} placeholder="localidad" name="localidad" value="<%=amigo.getLocalidad()%>">
				<input type="text" pattern=[A-Za-z]{2,25} placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>">
				<input type="text" pattern="[0-9]{9}" placeholder="móvil " name="movil" value="<%if(amigo.getMovil()!=0){%><%=amigo.getMovil() %><%}%>">
				<input type="text" pattern="[0-9]{9}" placeholder="fijo " name="fijo" value="<%if(amigo.getFijo()!=0){%><%=amigo.getFijo() %><%}%>">
				<textarea name="anotaciones" placeholder="anotaciones"></textarea>
				
				<div class="botones">
					<a data-role="button" data-inline="true" title="" href="main">cancelar</a>
					<input data-role="button" data-inline="true" type="submit" value="anadir" name="operacion" class="boton anadir">
				</div>
			</form>
		</div>

		<div data-role="footer" class="">
			<h4>IparSex servicios Informaticos 2014</h4>
			<p><a href="#politica" data-transition="slideup">Politica privacidad</a></p>
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
			sido el texto de relleno estándar de las industrias desde el año
			1500, cuando un impresor (N. del T. persona que se dedica a la
			imprenta) desconocido usó una galería de textos y los mezcló de tal
			manera que logró hacer un libro de textos especimen. No sólo
			sobrevivió 500 años, sino que tambien ingresó como texto de relleno
			en documentos electrónicos, quedando esencialmente igual al original.
			Fue popularizado en los 60s con la creación de las hojas "Letraset",
			las cuales contenian pasajes de Lorem Ipsum, y más recientemente con
			software de autoedición, como por ejemplo Aldus PageMaker, el cual
			incluye versiones de Lorem Ipsum.</div>

		<div data-role="footer" class="">IparSex servicios Informaticos
			2014</div>
	</div>
	<!-- /page politica-->




</body>
</html>
