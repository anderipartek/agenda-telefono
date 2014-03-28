<!DOCTYPE html>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Eliminar | Versión Móvil</title>

<link rel="stylesheet" href="css/jquery.mobile-1.4.2.css">
<link rel="stylesheet" href="_assets/css/jqm-demos.css">

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<script src="js/jquery-2.1.0.min.js"></script>

<script src="js/jquery.mobile-1.4.2.min.js"></script>

<script>
	$(document).ready(function() {
		// Por defecto todas las paginas van a tener esta transición
		$.mobile.defaultPageTransition = 'slideup';
		$.mobile.defaultDialogTransition = 'flip';

	});
</script>

</head>
<body>
	<div data-role="page" id="modificar" class="">

		<div data-role="header" class="">
			<h1>Eliminar amigo</h1>
			<a href="agenda" data-role="button" data-icon="back">Back</a>
			<!--  <a href="#" data-role="button" data-icon="back">Home</a>-->
		</div>
		<!-- /Header -->
	</div>
</body>