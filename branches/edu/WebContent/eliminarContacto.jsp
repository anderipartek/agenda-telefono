<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="theme/css/styles.css" type="text/css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>
<title>Insert title here</title>
<header class="header">
	<div class="wrapper">
		<?php if($seccion != 'index'){ 
			include('inc/navBar.php');
		} ?>
		<div class="logo">
			<span>Agenda</span>
			<span>online</span>			
		</div>
	</div>
<nav class="navBar">
			<ul>
				<li id="anadir" ><a href="anadirContacto.jsp" title="">A�adir amigo</a></li>
				<li id="modificar"> <a href="modificarContacto.jsp" title="">Modificar amigo</a></li>
				<li id="eliminar"> <a href="eliminarContacto.jsp" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="verContacto.jsp" title="">Ver todos</a></li>
			</ul>				
		</nav>
</header>
</head>
<body>
  <div class="contain">
		<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

		<?php

		// enviamos la query
		$id = comillas_inteligentes($_POST['id']);
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		while($result_row = mysql_fetch_array($result)){
		?>
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="hidden" name="nombre" value="">
			<input type="hidden" name="id" value="">			
			<input type="hidden" name="apellido" value="">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="eliminar" name="eliminar" class="boton eliminar">
			</div>
		</form>

		<?php
		}
		?>
	</div>

	

	
</body>
</html>