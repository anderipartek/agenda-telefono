<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'en_EN'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.agenda.controller.i18nmain" /> 

<!DOCTYPE>
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">

<!-- Incluir librerias jquery -->
<script type="text/JavaScript" src="js/jquery.js"></script>
<script type="text/JavaScript" src="js/jquery.dataTables.min.js"></script>
<script type="text/JavaScript" src="js/tinymce.min.js"></script>
<link href="js/css/jquery.dataTables.css" rel="stylesheet">
	<title>Agenda Online</title>
	<link href="theme/css/styles.css" type="text/css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>

</head>

<body <%if(request.getAttribute("seccion") == null){%> id="home" <%}%> >
	<%@include file="header.jsp"%>