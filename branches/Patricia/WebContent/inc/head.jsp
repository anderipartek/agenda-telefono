<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Agenda Online</title>
	<link href="css/styles.css" type="text/css" rel="stylesheet">
	
	<link href="css/style.css" type="text/css" rel="stylesheet">
        <!--[if IE]>
			<link rel="stylesheet" type="text/css" href="css/ie.css" />
		<![endif]-->
	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>

	<!-- Javascript -->
                
        <!--[if lt IE 9]>
			<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

</style>
		
</head>

<body <%if(request.getAttribute("seccion") == null){%> id="home" <%}%> >
	<%@include file="header.jsp"%>