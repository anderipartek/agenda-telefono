<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="com.ipartek.agenda.controller.i18n" /> 

<c:set var="language" value="${sessionScope.language}" scope="session" />
<fmt:setLocale value="${language}" />
<!DOCTYPE html>
<html lang="${language}">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Agenda Online</title>
	<link href="theme/css/styles.css" type="text/css" rel="stylesheet">
        
	<link href='http://fonts.googleapis.com/css?family=Raleway:500,300' rel='stylesheet' type='text/css'>
</head>
<body  <%if(request.getAttribute("seccion") == null){%> id="home" <%} else {}%>>