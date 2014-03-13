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
				<li id="anadir" ><a href="anadirContacto.jsp" title="">Añadir amigo</a></li>
				<li id="modificar"> <a href="modificarContacto.jsp" title="">Modificar amigo</a></li>
				<li id="eliminar"> <a href="eliminarContacto.jsp" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="verContacto.jsp" title="">Ver todos</a></li>
			</ul>				
		</nav>
</header>
</head>
<body>
  <div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<?php } ?>

		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="">
			
			<div class="botones">
				<input type="submit" value="buscar" name="buscar" class="boton buscar">
			</div>
		</form>
	</div>
	
</body>
</html>