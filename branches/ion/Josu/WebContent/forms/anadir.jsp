	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

<%-- 		<% if($error != false){ %> 
			<ul class="errores">
			<% if($_POST['nombre'] == '') %> 
				<li><p>Necesitamos saber su nombre</p></li>
 			<% if($_POST['movil'] == '') %> 
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>
 		<% } %>  --%>
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="Nombre" onFocus="if (this.value=='Nombre') this.value='';">
			<input type="text" placeholder="apellido" name="apellido" value="Apellido" onFocus="if (this.value=='Apellido') this.value='';">
			<input type="text" placeholder="calle" name="calle" value="Calle" onFocus="if (this.value=='Calle') this.value='';">
			<input type="text" pattern="[0-9]{5}" placeholder="cp" name="CP" value="CP" onFocus="if (this.value=='CP') this.value='';">
			<input type="text" placeholder="localidad" name="localidad" value="Localidad" onFocus="if (this.value=='Localidad') this.value='';">
			<input type="text" placeholder="provincia" name="provincia" value="Provincia" onFocus="if (this.value=='Provincia') this.value='';">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil" name="movil" value="Movil" onFocus="if (this.value=='Movil') this.value='';">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo" name="fijo" value="Fijo" onFocus="if (this.value=='Fijo') this.value='';">
			<textarea name="anotaciones" placeholder="anotaciones" value="Anotaciones" onFocus="if (this.value=='Anotaciones') this.value='';"></textarea>
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>

	