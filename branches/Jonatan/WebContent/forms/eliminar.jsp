
<div class="contain">
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

	<%

		// enviamos la query
// 		$id = comillas_inteligentes($_POST['id']);
// 		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

// 		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
// 		if(!$result){
// 			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
// 		}

// 		while($result_row = mysql_fetch_array($result)){
		%>
	
	<%@include file="buscador.jsp"%>

	<form method="post"
		action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">
		<input type="hidden" name="nombre"
			value="<?php echo $result_row[1]; ?>"> <input type="hidden"
			name="id" value="<?php echo $result_row[0]; ?>"> <input
			type="hidden" name="apellido" value="<?php echo $result_row[2]; ?>">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="eliminar" name="eliminar" class="boton eliminar">
		</div>
	</form>

</div>