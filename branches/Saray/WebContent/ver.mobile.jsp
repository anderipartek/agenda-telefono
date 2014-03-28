<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver listado Amigo | version movil</title>

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
		<div data-role="header" >
			<h1>Listado Amigos</h1>
			<div data-role="page">
				<a href="#" data-role="button" data-inline="true" data-theme="a">Añadir</a>
				<a href="#" data-role="button" data-inline="true" data-theme="b">Modificar</a>
				<a href="#" data-role="button" data-inline="true" data-theme="c">Ver</a>
				<a href="#" data-role="button" data-inline="true" data-theme="d">Eliminar</a>

			</div>
		</div>
		<div data-role="content" class="">

			<ul data-role="listview" data-insert="true" data-filter="true"
			data-filter-placeholder="Busca a tu Amigo..." data-autodividers="true">
	<%
		ArrayList<Amigo> listaAmigos = (ArrayList<Amigo>) request
				.getAttribute("listaAmigos");
		if (listaAmigos.size() > 0) {
			for (int i = 0; i < listaAmigos.size(); i++) {
	%>
	
		<li><a href="main?ID=<%=listaAmigos.get(i).getId()%>"><%=listaAmigos.get(i).getNombre()%>
			<%=listaAmigos.get(i).getApellido()%>
		</a></li>
		

	
	<%
		}
		} else {
			out.println("No hay datos en la base de datos");
		}
	%>
			</ul>

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
