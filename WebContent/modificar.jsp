<%@include file="core/abstract/functions.jsp"%>
<%@include file="core/model/forms/buscador.jsp"%>
<%@include file="core/model/forms/modificar.jsp"%>
<%@include file="todoOk.jsp"%>
<!--  <?php
// insertamos las funciones del site
include('../abstract/functions.php');

$error = false;

//comprobamos si hemos enviado al añadir
if(isset($_POST['buscar'])){

	// si hay errores
	if($_POST['nombre'] == ''){
		$error = true;
		
		include('forms/buscador.php');

	}
	// si no hay errores y esta todo ok
	else{

		// guardamos en variables
		$nombre = comillas_inteligentes($_POST['nombre'] . '%');

		// realizamos la conexion en la BBDD
		$connection = connectDB($db_host, $db_username, $db_password,$db_database);

		// enviamos la query
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		// mostramos el buscador
		include('forms/buscador.php');

		?>-->
		<!-- pintamos el listado de nombres -->
		<!--
		<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			<?php
			// mostramos los datos de la query
			while($result_row = mysql_fetch_array($result)){
			?>
				<li>
					<form action="<?php htmlentities($_SERVER['PHP_SELF']); ?>" method="post">
						<input type="submit" name="amigo" value="<?php echo $result_row[1] . ' ' . $result_row[2]; ?>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
						<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">
					</form>
				</li>
			<?php
			}
			?>
			</ul>
		</div>

		<?php

		//comprobamos si hay coincidencias de nombre
		// enviamos la query
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre";
		$resultado = mysql_query($query);
		$resultado = mysql_fetch_array($resultado);

		if($resultado == null){
			?>
			<ul class="errores contain">
				<li><p>El amigo que buscas no se encuentra aqui en estos momentos, puedes <a href="index.php?seccion=anadir">añadirlo</a></p></li>
			</ul>
			<?php
		}

		// comprobamos si queremos modificar algo
		if(isset($_POST['amigo'])){

			// mostramos el formulario para modificar
			include('forms/modificar.php');

		}

		// cerramos la conexion
		closeDB($connection);

  
	}
}
// la primera carga
else{
	//si hemos modificado
	if(isset($_POST['modificar'])){

		//guardamos el id a eliminar
		$id = comillas_inteligentes($_POST['id']); 
		$nombre = comillas_inteligentes($_POST['nombre']);
		$apellido = comillas_inteligentes($_POST['apellido']);
		$calle = comillas_inteligentes($_POST['calle']);
		$cp = comillas_inteligentes($_POST['CP']);
		$localidad = comillas_inteligentes($_POST['localidad']);
		$provincia = comillas_inteligentes($_POST['provincia']);
		$movil = comillas_inteligentes($_POST['movil']);
		$fijo = comillas_inteligentes($_POST['fijo']);
		$anotaciones = comillas_inteligentes($_POST['anotaciones']);

		// realizamos la insercion en la BBDD
		$connection = connectDB($db_host, $db_username, $db_password,$db_database);

		// enviamos la query
		$query = "UPDATE amigos SET nombre=$nombre,apellido=$apellido,calle=$calle,cp=$cp,localidad=$localidad,provincia=$provincia,movil=$movil,fijo=$fijo,anotaciones=$anotaciones WHERE id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		// cerramos la conexion
		closeDB($connection);

		include('todoOk.php');
	}
	else{
		include('forms/buscador.php');
	}
}
?>-->