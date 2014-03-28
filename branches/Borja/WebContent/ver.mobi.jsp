<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver listado Amigos | Version Amigos</title>

<link rel="stylesheet" href="theme/css/jquery.mobile-1.4.2.min.css">
<!--<link rel="stylesheet" href="_assets/css/jqm-demos.css">  -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<script src="js/jquery-2.1.0.min.js"></script>
<script src="_assets/js/index.js"></script>
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


		<div data-role="panel" data-display="push" data-theme="b"
			id="nav-panel">
			<ul data-role="listview">
				<li data-icon="delete"><a href="#" data-rel="close">Cerrar
						menu</a></li>
				<li><a href="#">Home</a></li>
				<li><a href="#ver">Ver</a></li>
				<li><a href="#panel-responsive-page2">Modificar</a></li>
				<li><a href="#panel-responsive-page2">Añadir</a></li>
				<li><a href="#panel-responsive-page2">Eliminar</a></li>

			</ul>
		</div>
			<div data-role="header" class="">
				<h1>Home</h1>
				<a href="#nav-panel" data-icon="bars" data-iconpos="notext">Menu</a>

			</div>


			<div data-role="content" class="">


				<ul data-role="listview" data-inset="true" data-filter="true"
					data-filter-placeholder="busca a tu amigo por su nombre"
					data-autodividers="true">
					<%
						ArrayList<Amigo> list = (ArrayList<Amigo>) request
								.getAttribute("listaAmigos");
						for (int i = 0; i < list.size(); i++) {
							out.print("<li><a href='#'>"
									+ ((Amigo) list.get(i)).getNombre() + " "
									+ ((Amigo) list.get(i)).getApellido() + "</a></li>");
						}
					%>

				</ul>

			</div>

			<div data-role="footer" class="">
				<h4>IparSex. Dando por culo desde 1980.</h4>
				<a href="#politica" data-role="button" data-transition="flip"
					 data-inset="true" data-icon="eye">Politica de privacidad</a>
			</div>

		</div>
		<!-- /page home -->

		<div data-role="page" id="politica">
		
		<div data-role="panel" data-display="push" data-theme="b"
			id="nav-panel1">
			<ul data-role="listview">
				<li data-icon="delete"><a href="#" data-rel="close">Cerrar
						menu</a></li>
				<li><a href="#home">Home</a></li>
				<li><a href="#ver">Ver</a></li>
				<li><a href="#panel-responsive-page2">Modificar</a></li>
				<li><a href="#panel-responsive-page2">Añadir</a></li>
				<li><a href="#panel-responsive-page2">Eliminar</a></li>

			</ul>
		</div>
		

			<div data-role="header" class="">
				<h1>Politica privacidad</h1>
				<a href="#nav-panel1" data-icon="bars" data-iconpos="notext">Menu</a>
			</div>

			<div data-role="content" class="">
				<p>LLorem ipsum dolor sit amet, consectetur adipiscing elit.
					Quisque sollicitudin odio eget dolor egestas, quis aliquam leo
					vestibulum. Nam quis massa porta, iaculis mi sed, elementum sem. Ut
					vulputate ac lacus non consequat. Cras convallis dui vitae nulla
					venenatis faucibus. Nunc congue lorem et erat consequat pulvinar.
					Maecenas luctus augue luctus libero ultricies, blandit pharetra
					elit congue. Nulla interdum, ante fermentum sollicitudin feugiat,
					orci risus rhoncus lacus, eu lobortis metus orci sit amet ligula.
					In blandit eros a odio blandit interdum. Nullam scelerisque quam
					dignissim neque auctor venenatis. Nulla mauris massa, fringilla
					quis tortor sed, aliquam commodo orci. Pellentesque placerat
					placerat libero sed eleifend. Mauris at sagittis massa. Nam
					vulputate posuere mi et faucibus. Nam in posuere neque. Donec
					ornare ipsum in sodales consectetur. Proin eleifend tortor odio, at
					egestas lacus rhoncus a. Mauris ullamcorper cursus nulla vitae
					mollis. Ut tristique egestas nibh, a tristique enim viverra in.
					Phasellus semper, augue in interdum facilisis, augue elit laoreet
					mi, quis mollis urna est sed leo. Donec quis vulputate libero. Duis
					et risus felis. Duis arcu felis, porttitor non tellus at, ultrices
					bibendum erat. Suspendisse eu ante elit. Nullam lobortis quam eget
					ante egestas, vitae viverra augue cursus. Praesent eu augue ac
					libero vulputate venenatis non vitae urna. Praesent malesuada, orci
					id aliquam imperdiet, magna orci porttitor leo, et eleifend eros mi
					sit amet justo. Vivamus non enim eu sapien ornare laoreet. Mauris
					tellus augue, faucibus quis eros eget, tincidunt vulputate arcu.
					Proin nec tincidunt nulla, ac tincidunt metus. Pellentesque vel
					massa nulla. Praesent id est aliquam, venenatis magna lobortis,
					aliquam velit. Integer a odio luctus, vulputate nulla eu,
					consectetur erat. Vestibulum ante orci, elementum et elementum vel,
					congue eu arcu. Etiam aliquam ante ac mollis tincidunt. Quisque
					sagittis viverra pulvinar. Aenean fringilla aliquet massa in
					luctus. In cursus non ante id porttitor. Nunc libero mi, dignissim
					pretium scelerisque sit amet, dapibus vitae felis. Cras non
					pellentesque orci. Nulla luctus consequat neque a pharetra. Sed
					vitae tortor mauris. Aenean nec feugiat tortor, eget faucibus leo.
					Nulla vel mauris ipsum. Nulla feugiat metus ac pulvinar feugiat.
					Nulla facilisi. Integer eget est nec sapien varius tincidunt nec
					quis dui. Cras et massa quis nisl sodales sollicitudin. Sed rhoncus
					et tellus nec mattis. Ut vitae sapien ullamcorper purus porttitor
					convallis. Phasellus magna neque, faucibus pretium ultricies sed,
					rutrum sit amet ipsum. Aliquam a libero a ante adipiscing dictum.
					Phasellus eget magna lectus. Duis elementum lacus non tempus
					commodo. Praesent luctus enim eget leo dignissim auctor. Nulla
					varius in sapien ac pellentesque. Interdum et malesuada fames ac
					ante ipsum primis in faucibus. Aenean porttitor dui ut aliquam
					blandit. Donec pellentesque eros in sollicitudin pharetra. Sed
					scelerisque diam at purus vestibulum, id interdum augue viverra.</p>

			</div>
			<div data-role="footer" class="">IparSex. Dando por culo desde
				1980.</div>

		</div>
		<!-- /page home -->
		
		<div data-role="page" id="ver">
		
		<div data-role="panel" data-display="push" data-theme="b"
			id="nav-panel2">
			<ul data-role="listview">
				<li data-icon="delete"><a href="#" data-rel="close">Cerrar
						menu</a></li>
				<li><a href="#home">Home</a></li>
				<li><a href="#">Ver</a></li>
				<li><a href="#panel-responsive-page2">Modificar</a></li>
				<li><a href="#panel-responsive-page2">Añadir</a></li>
				<li><a href="#panel-responsive-page2">Eliminar</a></li>

			</ul>
		</div>
		

			<div data-role="header" class="">
				<h1>Listado de tus amigos</h1>
				<a href="#nav-panel2" data-icon="bars" data-iconpos="notext">Menu</a>
			</div>

			<div data-role="content" class="">


				<ul data-role="listview" data-inset="true" data-filter="true"
					data-filter-placeholder="busca a tu amigo por su nombre"
					data-autodividers="true">
					<%
						
						for (int i = 0; i < list.size(); i++) {
							out.print("<li><a href='#'>"
									+ ((Amigo) list.get(i)).getNombre() + " "
									+ ((Amigo) list.get(i)).getApellido() + "</a></li>");
						}
					%>

				</ul>

			</div>
			<div data-role="footer" class="">IparSex. Dando por culo desde
				1980.</div>

		</div>
</body>
</html>
