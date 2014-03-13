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
		<p class="titulo">Busca a tu amigo:</p>

		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<?php } ?>

		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="<?php if(isset($_POST['nombre'])) echo $_POST['nombre']; ?>">
			
			<div class="botones">
				<input type="submit" value="buscar" name="buscar" class="boton buscar">
			</div>
		</form>
	</div>

</body>
</html>