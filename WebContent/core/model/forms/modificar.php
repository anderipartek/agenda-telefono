	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<?php

		// enviamos la query
		$id = comillas_inteligentes($_POST['id']);
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		while($result_row = mysql_fetch_array($result)){
		?>
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="text" placeholder="apellido" name="apellido" value="<?php echo $result_row[2]; ?>">
			<input type="text" placeholder="calle" name="calle" value="<?php echo $result_row[3]; ?>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<?php echo $result_row[4]; ?>">
			<input type="text" placeholder="localidad" name="localidad" value="<?php echo $result_row[5]; ?>">
			<input type="text" placeholder="provincia" name="provincia" value="<?php echo $result_row[6]; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<?php echo $result_row[7]; ?>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<?php echo $result_row[8]; ?>">
			<textarea name="anotaciones" placeholder="anotaciones"><?php echo $result_row[9]; ?></textarea>
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>

	