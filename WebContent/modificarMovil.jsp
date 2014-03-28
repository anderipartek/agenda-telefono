<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Modificar Amigos | Version Movil</title>
	
	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.css">

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/jquery.mobile-1.4.2.min.js"></script>
	
	<script>
		$(document).ready(function(){
			$.mobile.defaultPageTransition='slideup';
			$.mobile.defaultDialogTransition='slideup';
		});
	</script>
</head>
<body>

<div data-role="page" id="modificar">

	<%
Amigo a = null;
boolean nuevo = false;
if (request.getAttribute("detalleAmigo") == null) {
	a = new Amigo();
	nuevo = true;
} else {
	a = (Amigo) request.getAttribute("detalleAmigo");
}
%>
	<div data-role="header">
		<h1>Modificar amigo</h1>
		<a href="#home" data-role="button" data-icon="back">Home</a>
	</div>

	<div data-role="content">
		
		<form method="post" action="main">	
				
			<label for="nombre">Nombre:</label>
			<input name="nombre" id="nombre" value="<%=a.getNombre() %>">
			<label for="apellido">Apellido:</label>
			<input name="apellido" id="apellido" value="<%=a.getApellido() %>">
			<label for="calle">Calle:</label>
			<input name="calle" id="calle" value="<%=a.getCalle() %>">
			<label for="cp">Cp:</label>
			<input name="cp" id="cp" value="<%=a.getCp() %>">
			<label for="localidad">Localidad:</label>
			<input name="localidad" id="localidad" value="<%=a.getLocalidad() %>">
			<label for="provincia">Provincia:</label>
			<input name="provincia" id="provincia" value="<%=a.getProvincia() %>">
			<label for="movil">Móvil:</label>
			<input name="movil" id="movil" value="<%=a.getMovil() %>">
			<label for="fijo">Fijo:</label>
			<input name="fijo" id="fijo" value="<%=a.getFijo() %>">
			<label for="anotaciones">Anotaciones:</label>
			<input name="anotaciones" id="anotaciones" value="<%=a.getAnotaciones() %>">
			<input type="hidden" name="id" value="<%=a.getId()%>">
			
			<div class="botones">
					<a title="" href="main?seccion=ver">cancelar</a>
					<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
			
		</form>
	
	</div>
	
	
	
	<div data-role="footer">
		<h4>IparSex servicios Informaticos 2014</h4>
	</div>

</div><!-- /page -->

</body>
</html>