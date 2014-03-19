<?php 
	// incluimos los datos de conexion de la BBDD
	include('../abstract/db_acceso.php');

	function connectDB($db_host, $db_username, $db_password,$db_database){
		// conexion a la BBDD
		$connection = mysql_connect($db_host, $db_username, $db_password);
		// comprobamos si todo va ok
		if(!$connection){
			die('No se ha podido conectar a la BBDD ' . mysql_error() . '<br>');
		}

		selectDB($db_database);

		return $connection;
	}

	function selectDB($db_database){
		// seleccion de BBDD
		$db_select = mysql_select_db($db_database);
		if(!$db_select){
			die('No se puede seleccionar la BBDD ' . mysql_error() . '<br>');
		}
	}

	function closeDB($connection){
		// cerramos la conexion de la BBDD
		mysql_close($connection);
	}

	// Aplicar comillas sobre la variable para hacerla segura
	function comillas_inteligentes($valor)
	{
	    // Retirar las barras
	    if (get_magic_quotes_gpc()) {
	        $valor = stripslashes($valor);
	    }

	    // Colocar comillas si no es entero
	    if (!is_numeric($valor)) {
	        $valor = "'" . mysql_real_escape_string($valor) . "'";
	    }
	    
	    return $valor;
	}



?>