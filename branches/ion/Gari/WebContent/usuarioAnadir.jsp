<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Añadir</title>
<link href="css/styles.css" type="text/css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>

	<!-- Javascript -->
                
        <!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<nav class="navBar">
			<ul>
				<li id="anadir" ><a href="anadir" title="">Añadir amigo</a></li>
				<li id="modificar"> <a href="index.php?seccion=modificar" title="">Modificar amigo</a></li>
				<li id="eliminar"> <a href="index.php?seccion=eliminar" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="index.php?seccion=ver" title="">Ver todos</a></li>
			</ul>				
		</nav>
		
</head>
<body id="anadir">
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

	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
		
			<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			Nombre   	<input type="text" placeholder="nombre" name="nombre" value=""><br>
			Apellido 	<input type="text" placeholder="apellido" name="apellido" value=""><br>
			Calle		<input type="text" placeholder="calle" name="calle" value=""><br>
			C.Postal	<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value=""><br>
			Localidad	<input type="text" placeholder="localidad" name="localidad" value=""><br>
			Provincia	<input type="text" placeholder="provincia" name="provincia" value=""><br>
			Movil		<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value=""><br>
			T.Fijo		<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value=""><br>
			Anotacion	<textarea name="anotaciones" placeholder="anotaciones">
</textarea>
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>
</body>
</html>