<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
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
				<li id="anadir" ><a href="anadir.jsp" title="">Añadir amigo</a></li>
				<li id="modificar"> <a href="modificar.jsp" title="">Modificar amigo</a></li>
				<li id="eliminar"> <a href="eliminar.jsp" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="ver.jsp" title="">Ver todos</a></li>
			</ul>				
		</nav>
</header>

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
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">			
			<input type="hidden" name="apellido" value="<?php echo $result_row[2]; ?>">
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="eliminar" name="eliminar" class="boton eliminar">
			</div>
		</form>

		<?php
		}
		?>
	</div>

	
</body>
</html>