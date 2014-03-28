<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver detalle Amigo | version movil</title>

<link rel="stylesheet" href="theme/css/jquery.mobile-1.4.2.min.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<script src="js/jquery-2.1.0.min.js"></script>

<script src="js/jquery.mobile-1.4.2.min.js"></script>

<script>
	$(document).ready(function() {
		$.mobile.defaultPageTransition = 'slideup';
		$.mobile.defaultDialogTransition = 'slideup';
	});
</script>

</head>
<body>
	<div data-role="page" id="home">
		<div data-role="header" class="">
			<h1>Detalle Amigo</h1>
			<div data-type="horizontal">
				<a href="anadir.jsp" data-role="button" data-inline="true" data-theme="a">Añadir</a>
				<a href="modificar.jsp" data-role="button" data-inline="true" data-theme="b">Modificar</a>
				<a href="ver.jsp" data-role="button" data-inline="true" data-theme="c">Ver</a>
				<a href="eliminar.jsp" data-role="button" data-inline="true" data-theme="d">Eliminar</a>

			</div>
		</div>
		<div data-role="content" class="">

			<p class="txt">Cuales son los datos de tu amigo</p>
			<%
				Amigo amigo = (Amigo)request.getAttribute("idAmigo");
			%>
			
			<form id="detalleFormulario" method="post" action="main">
				<input type="text" placeholder="nombre" name="nombre" value=<%=amigo.getNombre()%>>
				<input type="text" placeholder="apellido" name="apellido" value=<%=amigo.getApellido()%>>
				<input type="text" placeholder="calle" name="calle" value=<%=amigo.getCalle()%>>
				<input type="text" pattern="[0-9]{5}" placeholder="cp 48004"
					name="cp" value=<%=amigo.getCp()%>> 
					<input type="text"
					placeholder="localidad" name="localidad" value=<%=amigo.getLocalidad()%>> 
					<input
					type="text" placeholder="provincia" name="provincia" value="">
				<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999"
					name="movil" value=<%=amigo.getProvincia()%>> 
					<input type="text"
					pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo"
					value="">
				<textarea name="anotaciones" placeholder="anotaciones"></textarea>
				<input type="hidden" name="nombre" value=""> <input
					type="hidden" name="id" value="">

				<div class="botones">
					<a title="" href="main">cancelar</a> <input type="submit"
						value="modificar" name="accion" class="boton modificar">
				</div>
			</form>



			

		</div>

		<div data-role="footer">
			<h4>IparSex Servicios Informaticos 2014</h4>
			<p>
				<a href="#politica">Politica privacidad</a>
			</p>
		</div>


	</div>
	<!-- /page home -->


	<div data-role="footer">
		<h4>IparSex Servicios Informaticos 2014</h4>
		<p>
			<a href="#politica">Politica privacidad</a>
		</p>
	</div>


	</div>

	<div data-role="page" id="politica">
		<div data-role="header" class="">
			<h1>Politica privacidad</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>
		<div data-role="content" class="">
			<p>Al contrario del pensamiento popular, el texto de Lorem Ipsum
				no es simplemente texto aleatorio. Tiene sus raices en una pieza
				cl´sica de la literatura del Latin, que data del año 45 antes de
				Cristo, haciendo que este adquiera mas de 2000 años de antiguedad.
				Richard McClintock, un profesor de Latin de la Universidad de
				Hampden-Sydney en Virginia, encontró una de las palabras más oscuras
				de la lengua del latín, "consecteur", en un pasaje de Lorem Ipsum, y
				al seguir leyendo distintos textos del latín, descubrió la fuente
				indudable. Lorem Ipsum viene de las secciones 1.10.32 y 1.10.33 de
				"de Finnibus Bonorum et Malorum" (Los Extremos del Bien y El Mal)
				por Cicero, escrito en el año 45 antes de Cristo. Este libro es un
				tratado de teoría de éticas, muy popular durante el Renacimiento. La
				primera linea del Lorem Ipsum, "Lorem ipsum dolor sit amet..", viene
				de una linea en la sección 1.10.32</p>
		</div>

		<div data-role="footer">IparSex Servicios Informaticos 2014</div>


	</div>
	<!-- /page politica privacidad -->


</body>

</html>
