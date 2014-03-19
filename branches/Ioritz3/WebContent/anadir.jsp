<%--@ include file="core/abstract/functions.jsp" --%>

<%@ include file="core/model/forms/anadir.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="com.ipartek.agenda.bean.Contacto"%>
    <%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Incluir JQuery y data table -->
<script src="js/jquery.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="js/css/jquery.dataTables.css">
</head>
<body>
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
</body>