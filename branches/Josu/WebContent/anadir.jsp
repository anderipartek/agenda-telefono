<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
	<link href="css/styles.css" type="text/css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>

</head>
<body id="home">

	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>Necesitamos saber su nombre</p></li>
			<?php if($_POST['movil'] == '') ?>
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>
		<?php } ?>
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido" value="<?php if(isset($_POST['apellido'])) echo $_POST['apellido']; ?>">
			<input type="text" placeholder="calle" name="calle" value="<?php if(isset($_POST['calle'])) echo $_POST['calle']; ?>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<?php if(isset($_POST['CP'])) echo $_POST['CP']; ?>">
			<input type="text" placeholder="localidad" name="localidad" value="<?php if(isset($_POST['localidad'])) echo $_POST['localidad']; ?>">
			<input type="text" placeholder="provincia" name="provincia" value="<?php if(isset($_POST['provincia'])) echo $_POST['provincia']; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<?php if(isset($_POST['movil'])) echo $_POST['movil']; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<?php if(isset($_POST['fijo'])) echo $_POST['fijo']; ?>">
			<textarea name="anotaciones" placeholder="anotaciones"><?php if(isset($_POST['anotaciones'])) echo $_POST['anotaciones']; ?></textarea>
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>

</body>
</html>