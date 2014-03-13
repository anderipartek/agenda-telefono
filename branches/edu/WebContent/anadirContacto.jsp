<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
<title>Agenda Online</title>
<link href="theme/css/styles.css" type="text/css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>
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
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
</div>
</body>
</html>
	