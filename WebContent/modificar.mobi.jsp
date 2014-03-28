<!DOCTYPE html>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Datos amigos | Version Movil</title>

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
			<h1>Datos Amigos</h1>
			<a href="#mypanel">menu</a>
		</div>

				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" data-role="button" data-inline="true" data-theme="a">Añadir</a>
				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" data-role="button" data-inline="true" data-theme="b">Modificar</a>
				<a href="" data-role="button" data-inline="true" data-theme="c">Eliminar</a>
				<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" data-role="button" data-inline="true" data-theme="d">Ver</a>


		<div data-role="content" class="">
		
			<%@include file="forms/buscador.jsp"%>
				<div class="contain" id="listContainer">
	
			</div>

			<%
				if (request.getAttribute("amigo") != null){
					Amigo amigo = (Amigo)request.getAttribute("amigo");
					%>		
						<form id="datosAlumno" method="post">
							<input type="text" placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
							<input type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
							<input type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
							<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp"
								value="<%=amigo.getCp()%>"> <input type="text" placeholder="localidad"
								name="localidad" value="<%=amigo.getLocalidad()%>"> <input type="text"
								placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>"> <input
								type="text" pattern="[0-9]{9}" placeholder="móvil 999999999"
								name="movil" value="<%=amigo.getMovil()%>"> <input type="text" pattern="[0-9]{9}"
								placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo()%>">
							<textarea name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones()%></textarea>
							<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
								type="hidden" name="id" value="<%=amigo.getId()%>">
					
							<div class="botones">
								<a data-role="button" data-inline="true" title="" href="main">cancelar</a>
								<input data-role="button" data-inline="true" type="submit" value="modificar" name="operacion" class="boton modificar">
								<input data-role="button" data-inline="true" type="submit"value="eliminar" name="operacion" class="boton modificar">
							</div>
						</form>		
					<%
				}
			
			
			%>

		</div>
		
		<script>
		$(document).ready(function() { // When the HTML DOM is ready loading, then execute the following function...
			$('#btnbuscar').click(function() { // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
				search();
			});
		
			$('#textbuscar').keyup(function() {
			    search();
			});
			
			function search(){
				$.get('main?<%=MainServlet.SECCION%>=<%=MainServlet.BUSCAR%>&<%=MainServlet.NOMBRE_A_BUSCAR%>=' + $('#textbuscar').val(), function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...	
					console.log(responseText);
					fillList(responseText)
				});
			}
			
			var list;
			function fillList(data) {
				$("#listContainer").empty();
				$("#datosAlumno").empty();

				list = jQuery.parseJSON(data);
				if (list.length > 0){
					drawContainer();
					for (var i=0; i < list.length; i++){
						fillItem(list[i]);
					}
				}
			};
			
			function drawContainer(){
				$('#listContainer').append('<p>Seleccionalo de la lista</p>')
					.append('<ul data-role="listview" data-inset="true" id="listaAmigosModificar">')
					.append('</ul>');
			}
			
			function fillItem(data) {
				$("#listaAmigosModificar").append('<li><form method="post" action="main"></form></li>');
				$('#listaAmigosModificar li:last-child form')
					.append('<input type="submit" name="amigo" value="' + data.nombre + ' ' + data.apellido  + '">')
					.append('<input type="hidden" name="operacion" value="mostrar">')
					.append('<input type="hidden" name="nombre" value="' + data.nombre + '">')
					.append('<input type="hidden" name="id" value="' + data.id + '">');
			}
			

		});
		
		</script>

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
