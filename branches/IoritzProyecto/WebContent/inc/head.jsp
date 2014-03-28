<!DOCTYPE html>
<html lang="${language}">
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'es_ES'}" scope="session" />
	<fmt:setLocale value="${language}" />
	<fmt:setBundle basename="com.ipartek.agenda.controller.i18nmessages" /> 
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
<body  <%if(request.getAttribute("seccion") == null){%> id="home" <%} else {}%>>