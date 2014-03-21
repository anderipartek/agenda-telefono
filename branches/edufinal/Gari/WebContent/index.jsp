<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">

	<title>Agenda Online</title>
	<link href="css/styles.css" type="text/css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>

	<!-- Javascript -->
                
        <!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

</head>
<body id="home">
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
</header>


		<nav class="navBar">
			<ul>
				<li id="anadir" ><a href="anadir" title="">Añadir amigo</a></li>
				<li id="modificar"> <a href="modificar" title="">Modificar amigo</a></li>
				<li id="eliminar"> <a href="eliminar" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="ver" title="">Ver todos</a></li>
			</ul>				
		</nav>
		
		
		
		

</body>
</html>