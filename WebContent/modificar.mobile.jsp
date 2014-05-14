<!DOCTYPE html>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.HashMap"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver listado Amigos | Version Movil</title>

<link rel="stylesheet" href="theme/css/jquery.mobile-1.4.2.css">

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/jquery.mobile-1.4.2.min.js"></script>

<script>
	$(document).ready(function() {

		$.mobile.defaultPageTransition = 'pop';
		$.mobile.defaultDialogTransition = 'pop';

	});
</script>
<%!
Amigo a;
HashMap<Integer, Amigo> listaAmigo;
%>
</head>
<body>
	<!-- HOME -->
	<div data-role="page" id="home">

		<div data-role="header">
			<h1>Agenda Online</h1>
		</div>
		<!-- header -->

		<div data-role="content">
			<a href="#" data-role="button" data-inline="true" data-theme="b">A&ntilde;adir</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Modificar</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Eliminar</a>
			<a href="#ver" data-role="button" data-inline="true" data-theme="b">Ver</a>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam
				pharetra elit volutpat justo iaculis imperdiet. Donec vulputate
				risus eget arcu ultricies, quis faucibus nisl faucibus. Vivamus
				sollicitudin congue magna et convallis. Nulla non condimentum
				sapien. Praesent tincidunt quis tortor mattis blandit. Cras at
				mauris at massa fermentum ornare nec at nisi. Praesent nisi nisi,
				interdum sit amet diam at, sollicitudin dapibus orci. Nullam
				bibendum consequat mauris eget consectetur. Etiam ac consequat
				tortor. Cras mollis erat in nulla suscipit, quis faucibus ante
				euismod. Pellentesque eu turpis mi. Praesent ultrices rutrum
				rhoncus.</p>
		</div>
		<!-- content -->

		<div data-role="footer">
			<h4>IparSex Servicios Inform&aacute;ticos 2014</h4>
			<p>
				<a href="#politica">Politica Privacidad</a>
			</p>
		</div>
		<!-- footer -->

	</div>
	<!-- /page home-->
	
	<!-- VER -->
	<div data-role="page" id="ver">

		<div data-role="header">
			<h1>Listado Amigos</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>
		<!-- header -->

		<div data-role="content">
			<a href="#" data-role="button" data-inline="true" data-theme="b">A&ntilde;adir</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Modificar</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Eliminar</a>
			<a href="#ver" data-role="button" data-inline="true" data-theme="b">Ver</a>
			<ul id="listado" data-role="listview" data-insert="true" data-filter="true"
				data-filter-placeholder="Busca a tu colega"> <!-- data-autodividers="true"-->
				<%
					listaAmigo = (HashMap<Integer, Amigo>) request
							.getAttribute("lista");
					for (int i = 1; i <= listaAmigo.size(); i++) {
						a = listaAmigo.get(i);
				%>
				<li id="<%=i%>"><a href="#mostrar"><h2><%=a.getNombre() + " " + a.getApellido()%></h2>
				<p><%=a.getMTelefono() + " - " + a.getFTelefono()%></p></a></li>
				<%
					}
				%>
			</ul>
		</div>http://localhost:8080/AgendaTelefonica/agenda?op=ver
		<!-- content -->

		<div data-role="footer">
			<h4>IparSex Servicios Inform&aacute;ticos 2014</h4>
			<p>
				<a href="#politica">Politica Privacidad</a>
			</p>
		</div>
		<!-- footer -->

	</div>
	<!-- /page ver-->
	
	<!-- MOSTRAR DATOS -->
	<div data-role="page" id="mostrar">

		<div data-role="header">
			<h1>Listado Amigos</h1>
			<a href="#ver" data-role="button" data-icon="back">Ver</a>
		</div>
		<!-- header -->

		<div data-role="content">
			<a href="#" data-role="button" data-inline="true" data-theme="b">A&ntilde;adir</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Modificar</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Eliminar</a>
			<a href="#ver" data-role="button" data-inline="true" data-theme="b">Ver</a>
			<p>
				MOSTRAR DETALLE AMIGO
			</p>
		</div>
		<!-- content -->

		<div data-role="footer">
			<h4>IparSex Servicios Inform&aacute;ticos 2014</h4>
			<p>
				<a href="#politica">Politica Privacidad</a>
			</p>
		</div>
		<!-- footer -->

	</div>
	<!-- /page mostrar datos-->



	<!-- POLITICA PRIVACIDAD -->
	<div data-role="page" id="politica">

		<div data-role="header">
			<h1>Politica Privacidad</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>
		<!-- header -->

		<div data-role="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Maecenas tincidunt diam et mauris feugiat feugiat. Aenean enim
				mauris, adipiscing id nunc ut, mollis pretium odio. Nam imperdiet
				lorem vel luctus blandit. Aenean et nisi vel eros adipiscing
				tincidunt. Integer semper, enim sed dignissim fermentum, eros risus
				adipiscing dolor, et dapibus sem tellus vitae nisl. Mauris interdum
				faucibus sapien eu suscipit. Duis sit amet tincidunt nisi, in varius
				felis. Maecenas id leo lobortis, vestibulum elit vel, tempus arcu.
				Donec vehicula neque elementum nulla adipiscing, id tristique purus
				gravida. Nunc vel nulla nulla. Praesent tincidunt felis nisi,
				lacinia elementum velit vulputate in.</p>

			<p>Aenean hendrerit commodo tincidunt. Curabitur eleifend egestas
				turpis vel fermentum. Donec placerat molestie scelerisque. Quisque
				aliquet rutrum arcu. Suspendisse metus nunc, ultrices quis iaculis
				ut, ornare sit amet enim. Mauris et viverra arcu, imperdiet viverra
				enim. Donec consequat semper odio consequat dignissim. Ut eget lorem
				lorem. Fusce imperdiet dictum nisl quis convallis.</p>

			<p>Maecenas varius, eros eget aliquet pellentesque, lectus orci
				porttitor ligula, at convallis lectus ligula a dui. Integer mi
				lacus, tincidunt vel massa aliquam, lobortis fringilla tellus.
				Aliquam pulvinar dolor quis quam aliquet, sit amet cursus tortor
				dignissim. Sed id neque vitae arcu sagittis bibendum. Mauris
				facilisis urna vitae est suscipit, a porttitor orci rhoncus. Aliquam
				erat volutpat. Proin orci nisl, commodo et felis ut, commodo aliquet
				mauris.</p>

			<p>Nunc velit leo, rutrum quis dapibus non, posuere convallis mi.
				Curabitur pellentesque pharetra odio, ac fringilla sem tincidunt a.
				Proin imperdiet accumsan dui non condimentum. Donec euismod justo id
				metus tincidunt, sit amet pretium nunc congue. Nulla id eros
				pulvinar, viverra arcu nec, aliquam erat. Vivamus sit amet lacus eu
				justo rutrum mattis. Pellentesque habitant morbi tristique senectus
				et netus et malesuada fames ac turpis egestas. Suspendisse dictum
				ullamcorper est. Morbi vulputate augue vitae blandit hendrerit.
				Nullam a dignissim nulla. Ut ut suscipit risus. Mauris mattis elit
				tellus, a egestas risus convallis eget. Nunc interdum dui quis
				sapien congue aliquam nec eu mauris.</p>
		</div>
		<!-- content -->

		<div data-role="footer">
			<p>IparSex Servicios Inform&aacute;ticos 2014</p>
		</div>
		<!-- footer -->

	</div>
	<!-- /page politica-->
	

</body>
</html>
