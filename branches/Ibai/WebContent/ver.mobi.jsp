<!DOCTYPE html>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver amigos | Version Movil</title>

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
			    <li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" >A�adir</a></li>
				<li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" >Modificar</a></li>
				<li><a href="">Eliminar</a></li>
				<li><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" >Ver</a></li>
		    </ul>
		</div><!-- /panel -->
			
	
	
		<div data-role="header" class="">
			<h1>Listado Amigos</h1>
				<a href="#mypanel">menu</a>
		</div>

		<div data-role="content" class="">

			
			<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="Busca tu amigo" data-autodividers="true">
			<%
				ArrayList<Amigo> list = (ArrayList<Amigo>)request.getAttribute("lista_amigos");
				for(int i=0; i<list.size(); i++){
					out.print("<li><a href='main?seccion=modificar&id="+list.get(i).getId()+"'><h2>"+ list.get(i).getNombre()+" "+ list.get(i).getApellido() + "</h2><p>"+ list.get(i).getMovil()  +"</p></a></li>");
				}
			%>
			</ul>
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
