<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@include file="inc/head.jsp" %>

<!-- contenido central -->
<% String seccion= (String)request.getAttribute("seccion"); %>
<%@include file="inc/navBar.jsp" %>
<body id="home">
<section class="wrapper content">
		
		<%if("index".equalsIgnoreCase(seccion)){%>
			<%@include file="inc/navBar.jsp" %>
		<% }else if("anadir".equalsIgnoreCase(seccion)){%>
			<%@include file="forms/anadir.jsp" %>
		<% }else if("modificar".equalsIgnoreCase(seccion)){%>
			<%@include file="forms/modificar.jsp" %>
		<%}else if("eliminar".equalsIgnoreCase(seccion)){%>
			<%@include file="forms/eliminar.jsp" %>
		<%}else if("ver".equalsIgnoreCase(seccion)){%>
			<%@include file="ver.jsp" %>
		<%}
		%>
		
</section>

<%@include file="inc/footer.jsp"%>