	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

<%-- 		<% if($error != false){ %> --%>
			<ul class="errores">
<%-- 			<% if($_POST['nombre'] == '') %> --%>
				<li><p>Necesitamos saber su nombre</p></li>
<%-- 			<% if($_POST['movil'] == '') %> --%>
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>
<%-- 		<% } %> --%>
		
		<form method="post" action="main">			
			<input type="text" placeholder="nombre" name="nombre">
			<input type="text" placeholder="apellido" name="apellido">
			<input type="text" placeholder="calle" name="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp">
			<input type="text" placeholder="localidad" name="localidad">
			<input type="text" placeholder="provincia" name="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>

	