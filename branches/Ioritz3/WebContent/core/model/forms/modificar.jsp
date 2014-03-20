<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<!--  ? php

		// enviamos la query
		$id = comillas_inteligentes($_POST['id']);
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		while($result_row = mysql_fetch_array($result)){
		?-->
		
		<form method="post" action="main">
			<input type="hidden" name="op" value="modificar">				
			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido" value="apellido">
			<input type="text" placeholder="calle" name="calle" value="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="cp">
			<input type="text" placeholder="localidad" name="localidad" value="localidad">
			<input type="text" placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="movil">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="movil">
			<textarea name="anotaciones" placeholder="anotaciones" value="anotaciones"></textarea>
			<input type="hidden" name="nombre" value="erlantz">
			<input type="hidden" name="id" value="0">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>