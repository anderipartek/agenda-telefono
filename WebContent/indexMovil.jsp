<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado Amigos | Version Movil</title>
	
	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.css">

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/jquery.mobile-1.4.2.min.js"></script>
	
	<script>
		$(document).ready(function(){
			$.mobile.defaultPageTransition='slideup';
			$.mobile.defaultDialogTransition='slideup';
		});
	</script>
</head>
<body>

<div data-role="page" id="home">

	<div data-role="header">
		<h1>Listado Amigos</h1>
		<a href="#" data-role="button" data-icon="back">Home</a>
	</div>

	<div data-role="content">
	
		<a href="#" data-role="button" data-inline="true" data-theme="a">Anadir</a>
		<a href="#" data-role="button" data-inline="true" data-theme="b">Modificar</a>
		<a href="#" data-role="button" data-inline="true" data-theme="c">Ver</a>
		<a href="#" data-role="button" data-inline="true" data-theme="d">Eliminar</a>
	
		<ul data-role="listview" data-filter="true" data-autodividers="true"
		data-filter-placeholder="busca a tu amigo">
		<%
			ArrayList<Amigo> list = (ArrayList<Amigo>)request.getAttribute("listaAmigos");
			for(int i=0;i<list.size();i++){
				out.print("<li><a href='main?seccion=modificar&id=" + ((Amigo)list.get(i)).getId() + "'>" + ((Amigo)list.get(i)).getNombre() + " " + ((Amigo)list.get(i)).getApellido() +"</li>");
			}
		%>
		</ul>
		
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue.
		</p>
	</div>
	
	<div data-role="footer">
		IparSex servicios Informaticos 2014
		<a href="#politica" data-transition="flip">politica privacidad</a>
	</div>

</div><!-- /page -->


<div data-role="page" id="politica">

	<div data-role="header">
		<h1>Politica privacidad</h1>
		<a href="#home" data-role="button" data-icon="back">Home</a>
	</div>

	<div data-role="content">
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue.
		</p>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue.
		</p>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue.
		</p>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue.
		</p>
		<p>
			Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue.
		</p>
	</div>
	
	<div data-role="footer">
		<h4>IparSex servicios Informaticos 2014</h4>
	</div>

</div><!-- /page -->

</body>
</html>
