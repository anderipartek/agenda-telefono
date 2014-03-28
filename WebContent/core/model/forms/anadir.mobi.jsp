<%@ include file="mensaje.jsp"%>

<!DOCTYPE html>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Insertar amigo||Version Mobile</title>

	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.min.css">
	
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script  type="text/javascript" src="js/jquery.mobile-1.4.2.min.js"></script>
	<script>
	$(document).ready(function(){
		$.mobile.defaultPageTransition='slideup';
		$.mobile.defaultDialogTransition='slideup';
	});
	</script>
</head>
<body>
<p class="errores"><%=msg%></p>
  <p class="titulo">Cuales son los datos de tu amigo:</p>

		<form method="post" action="agenda?operacion=anadir">

			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido"
				value="apellido"> <input type="text" placeholder="calle"
				name="calle" value="calle"> <input type="text"
				pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="CP">
			<input type="text" placeholder="localidad" name="localidad"
				value="localidad"> <input type="text"
				placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999"
				name="movil" value="telefono movil"> <input type="text"
				pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo"
				value="telefono fijo">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>

			<div class="botones">
				<a title="" href="agenda?operacion=ver">cancelar</a> <input type="submit"
					value="insertar" name="anadir" class="boton anadir">
			</div>
		</form>
	
</body>
</html>
