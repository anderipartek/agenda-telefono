<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<c:set var="language" value="${requestScope.language}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.agenda.controller.i18ntexto" />    
      
<!DOCTYPE>
<html>
<html lang="${language}">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Agenda Online</title>
	<link href="theme/css/styles.css" type="text/css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>
</head>

<body <%if(request.getAttribute("seccion") == null){%> id="home" <%}%> >
	<%@include file="header.jsp"%>
