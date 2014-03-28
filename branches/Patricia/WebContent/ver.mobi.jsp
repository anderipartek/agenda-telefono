<!DOCTYPE html>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver todos | Versión Móvil</title>

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
	<div data-role="page" id="home" class="">

		<div data-role="panel" id="mypanel">
			   
			<ul data-role="listview">
				<li><a href="anadir.mobi.jsp" data-role="button"
					data-inline="false" data-theme="a">Añadir</a></li>
				<li><a href="modificar.mobi.jsp" data-role="button"
					data-inline="false" data-theme="b">Modificar</a></li>
				<li><a href="eliminar.mobi.jsp" data-role="button"
					data-inline="false" data-theme="c">Eliminar</a></li>
				<li><a href="#" data-role="button" data-inline="false"
					data-theme="ver.mobi.jsp">Ver</a></li>
			</ul>

		</div>


		<div data-role="header" class="">
			<h1>Listado Amigos</h1>
			<!--  <a href="#" data-role="button" data-icon="back">Home</a>-->
			<a data-role="button" href="#mypanel"
				class="jqm-navmenu-link ui-nodisc-icon ui-alt-icon ui-btn-left ui-btn ui-icon-bars ui-btn-icon-notext ui-corner-all"></a>
		</div>
		<!-- /header -->

		<div data-role="content" class="">




			<ul data-role="listview" data-insert="true" data-filter="true"
				data-filter-placeholder="Busca a tu amigo" data-autodividers="true"
				data-icon="info">
				<c:forEach var="amigo" items="${requestScope.listaAmigos}">
					<li><a href="agenda?id=${amigo.id}&op=modificar">
							<h2>
								<c:out value="${amigo.nombre}" />
							</h2> <c:out value="${amigo.apellido}" />
					</a></li>

				</c:forEach>
			</ul>

			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
				penatibus et magnis dis parturient montes, nascetur ridiculus mus.
				Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
				Nulla consequat massa quis enim. Donec pede justo, fringilla vel,
				aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut,
				imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede
				mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum
				semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula,
				porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem
				ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra
				nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet.
				Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies
				nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget
				condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem
				neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar,
				hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus.
				Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante.
				Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed
				fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed
				consequat, leo eget bibendum sodales, augue velit cursus nunc,</p>
		</div>
		<!-- /content -->

		<div data-role="footer">
			<h4>Ipartek Servicios Informaticos 2014</h4>
		</div>
		<p>
			<a href="#politica" data-transition="slideup" data-rel="dialog">Politica
				Privacidad</a>
		<p>
			<!-- data-rel="dialog" -->
	</div>
	<!-- /page hom
	e-->

	<div data-role="page" id="politica" class="">

		<div data-role="header" class="">
			<h1>Politica Privacidad</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>
		<!-- /header -->

		<div data-role="content" class="">
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
				Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque
				penatibus et magnis dis parturient montes, nascetur ridiculus mus.
				Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.
				Nulla consequat massa quis enim.</p>

			<p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget,
				arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae,
				justo. Nullam dictum felis eu pede mollis pretium. Integer
				tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean
				vulputate eleifend tellus.</p>

			<p>Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac,
				enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a,
				tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque
				rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur
				ullamcorper ultricies nisi.</p>

			<p>Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget
				condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem
				neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar,
				hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus.
				Donec vitae sapien ut libero venenatis faucibus. Nullam quis ante.
				Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed
				fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed
				consequat, leo eget bibendum sodales, augue velit cursus nunc,</p>
		</div>
		<!-- /content -->

		<div data-role="footer">Ipartek Servicios Informaticos 2014</div>
		<!-- /footer -->

	</div>
	<!-- /page politica-->


</body>
</html>
