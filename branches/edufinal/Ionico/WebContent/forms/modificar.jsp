	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<%

// 		// enviamos la query
// 		$id = comillas_inteligentes($_POST['id']);
// 		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

// 		$result = mysql_query($query);
// 		//comprobamos si la query ha ido bien
// 		if(!$result){
// 			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
// 		}

// 		while($result_row = mysql_fetch_array($result)){
		%>
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre"">
			<input type="text" placeholder="apellido"">
			<input type="text" placeholder="calle"">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP"">
			<input type="text" placeholder="localidad" name="localidad">
			<input type="text" placeholder="provincia" name="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>

	