<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Incluir librerias jquery -->
<script type="text/JavaScript" src="js/jquery.js"></script>
	<title>Agenda Online</title>
	<link href="theme/css/styles.css" type="text/css" rel="stylesheet">
        <!--[if IE]>
			<link rel="stylesheet" type="text/css" href="css/ie.css" />
		<![endif]-->
	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>

	<!-- Javascript -->
                
        <!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
</head>

<body <%if(request.getAttribute("seccion") == null){%> id="home" <%}%> >
	<%@include file="header.jsp"%>