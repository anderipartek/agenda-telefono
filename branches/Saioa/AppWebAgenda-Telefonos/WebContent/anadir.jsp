<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/styles.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
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
				<li id="anadir" ><a href="anadir.jsp" title="">A�adir amigo</a></li>
				<li id="modificar"> <a href="modificar.jsp" title="">Modificar amigo</a></li>
				<li id="eliminar"> <a href="eliminar.jsp" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="ver.jsp" title="">Ver todos</a></li>
			</ul>				
		</nav>
</header>
	
	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>Necesitamos saber su nombre</p></li>
			<?php if($_POST['movil'] == '') ?>
				<li><p>Necesitamos saber su tel�fono m�vil</p></li>
			</ul>
		<?php } ?>
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="<?php if(isset($_POST['nombre'])) echo $_POST['nombre']; ?>">
			<input type="text" placeholder="apellido" name="apellido" value="<?php if(isset($_POST['apellido'])) echo $_POST['apellido']; ?>">
			<input type="text" placeholder="calle" name="calle" value="<?php if(isset($_POST['calle'])) echo $_POST['calle']; ?>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<?php if(isset($_POST['CP'])) echo $_POST['CP']; ?>">
			<input type="text" placeholder="localidad" name="localidad" value="<?php if(isset($_POST['localidad'])) echo $_POST['localidad']; ?>">
			<input type="text" placeholder="provincia" name="provincia" value="<?php if(isset($_POST['provincia'])) echo $_POST['provincia']; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="m�vil 999999999" name="movil" value="<?php if(isset($_POST['movil'])) echo $_POST['movil']; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<?php if(isset($_POST['fijo'])) echo $_POST['fijo']; ?>">
			<textarea name="anotaciones" placeholder="anotaciones"><?php if(isset($_POST['anotaciones'])) echo $_POST['anotaciones']; ?></textarea>
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="a�adir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>
</body>
</html>