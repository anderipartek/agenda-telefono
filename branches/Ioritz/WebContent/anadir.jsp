<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/styles.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

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
			<input type="text" placeholder="nombre" name="nombre" value="<?php if(isset($_POST['nombre'])) echo $_POST['nombre']; ?>">
			<input type="text" placeholder="apellido" name="apellido" value="<?php if(isset($_POST['apellido'])) echo $_POST['apellido']; ?>">
			<input type="text" placeholder="calle" name="calle" value="<?php if(isset($_POST['calle'])) echo $_POST['calle']; ?>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<?php if(isset($_POST['CP'])) echo $_POST['CP']; ?>">
			<input type="text" placeholder="localidad" name="localidad" value="<?php if(isset($_POST['localidad'])) echo $_POST['localidad']; ?>">
			<input type="text" placeholder="provincia" name="provincia" value="<?php if(isset($_POST['provincia'])) echo $_POST['provincia']; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<?php if(isset($_POST['movil'])) echo $_POST['movil']; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<?php if(isset($_POST['fijo'])) echo $_POST['fijo']; ?>">
			<textarea name="anotaciones" placeholder="anotaciones"><?php if(isset($_POST['anotaciones'])) echo $_POST['anotaciones']; ?></textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="A�adir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>

	

</body>
</html>