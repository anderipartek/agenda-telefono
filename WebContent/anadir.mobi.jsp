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
		<p class="titulo">Cuales son los datos de tu amigo:</p>
	<%-- 
		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>Necesitamos saber su nombre</p></li>
			<?php if($_POST['movil'] == '') ?>
				<li><p>Necesitamos saber su tel√©fono m√≥vil</p></li>
			</ul>
		<?php } ?>--%>
		
		<form method="post" action="main">
		
			<input type="hidden" name="op" value="anadir">
						
			<input type="text" placeholder="nombre" name="nombre" value="nombre" required>
			<input type="text" placeholder="apellido" name="apellido" value="apellido">
			<input type="text" placeholder="calle" name="calle" value="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="cp">
			<input type="text" placeholder="localidad" name="localidad" value="localidad">
			<input type="text" placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999" name="movil" value="telÈfono movil" required>
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="telÈfono fijo">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="aÒadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>
</body>