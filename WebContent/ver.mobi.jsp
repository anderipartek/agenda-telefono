<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado Amigos | Version Movil</title>
	
	<link rel="stylesheet"  href="js/themes/default/jquery.mobile-1.4.2.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    
	<script src="js/jquery.js"></script>
	<script src="js/jquery.mobile-1.4.2.min.js"></script>
</head>
<body>
	<!-- Home -->
	<div data-role="page" id="home">
		<%@include file="header.mobi.jsp"%>
		
		<div role="main" data-role="content">
			<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="Busca a tu colega..." data-autodividers="true">
				<c:set var="lista" value='<%=request.getAttribute(MainServlet.LISTA_AMIGOS)%>' />
				<c:forEach var="amigo" items='${lista}'>
					<li>
						<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>&id=${amigo.id}">
							<h2>${amigo.nombre}</h2>
							<p>${amigo.apellido}</p>
						</a>
					</li>
				</c:forEach>
			</ul>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
		</div>
		
		<div data-role="footer">
			<h4>IparSex servicios Informaticos 2014</h4>
			<p><a href="#politica" >Politica Privacidad</a></p>
		</div>
	</div><!-- /page -->
	
	<!--  Politica Privacidad -->
	<div data-role="page" id="politica">
		<div data-role="header">
			<h1>Politica Privacidad</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>

		<div data-role="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
		</div>
		<div data-role="footer">
			<h4>IparSex servicios Informaticos 2014</h4>
			
		</div>
	</div><!-- /page -->
</body>

<script type="text/javascript">
	$(document).ready(function(){
		$.mobile.defaultPageTransition = 'slide';
		$.mobile.defaultDialogTransition = 'slideup';
	});
</script>

</html>
