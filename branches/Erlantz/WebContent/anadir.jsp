<%--@ include file="core/abstract/functions.jsp" --%>

<%@ include file="core/model/forms/anadir.jsp"%>

<!-- ?php
// insertamos las funciones del site
include('../abstract/functions.php');

$error = false;

//comprobamos si hemos enviado al añadir
if(isset($_POST['anadir'])){

	// si hay errores
	if($_POST['nombre'] == '' || $_POST['movil'] == ''){
		$error = true;
		
		include('forms/anadir.php');

	}
	// si no hay errores y esta todo ok
	else{
		$error = false;	

		// guardamos en variables
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
		$query = "INSERT INTO amigos VALUES (null,$nombre,$apellido,$calle,$cp,$localidad,$provincia,$movil,$fijo,$anotaciones)";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		// cerramos la conexion
		closeDB($connection);

		// se ha añadido correctamente
		include('todoOk.php');
	}
}
// la primera carga
else{

	include('forms/anadir.php');

}
? -->