<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- HEAD -->
<%--!public static String seccion; --%>

<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>
<section class="wrapper content">
 
	<%//seccion = (String) session.getAttribute("seccion")
	if ("anadir".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="anadir.jsp"%>	
	<% } else if ("modificar".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="modificar.jsp"%>
	<% } else if ("eliminar".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="eliminar.jsp"%>
	<% } else if ("ver".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="ver.jsp"%>
	<% } else if ("todoOk".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="todoOk.jsp"%>
	<%} else if (request.getParameter("seccion") == null){ %>
		<%@ include file="inc/navBar.jsp"%>
	<%}%>
</section>

<!-- FOOTER -->
<%@ include file="inc/footer.jsp"%>