<!DOCTYPE html>
<%@page import="com.ipartek.agenda.bean.Contacto"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado Amigos | Version Movil</title>
	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.min.css">
	
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/jquery.mobile-1.4.2.js"></script>
	<script>
		$(document).ready(function()){
			
			$.mobile.defaultPageTransition="slideup";
			$.mobile.defaultDialogTransition="slideup";
			
		});
	
	
	</script>
</head>
<body>

<div class="contain">
		<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

		<!--  ?php

		// enviamos la query
		$id = comillas_inteligentes($_POST['id']);
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		while($result_row = mysql_fetch_array($result)){
		?-->
		
		<form method="post" action="main">
			<input type="hidden" name="op" value="eliminar">				
			<input type="hidden" name="nombre" value="nombre">
			<input type="hidden" name="id" value="id">			
			<input type="hidden" name="apellido" value="apellido">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="eliminar" name="eliminar" class="boton eliminar">
			</div>
		</form>

		<!-- ?php
		}
		?-->
	</div>
	
	<script src="js/jquery-2.1.0.min.js"></script>
			
			<script>
				$(document).ready(function(){
					console.debug('ready.......');
				});
				
				//seleccionar campo texto
				var asearch = $('#asearch');
				
				console.debug();
			
			
			
			
			
			</script>
</body>