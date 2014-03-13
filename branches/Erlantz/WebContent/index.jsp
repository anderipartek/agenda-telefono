<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- HEAD -->
<%!public static String seccion; %>
<%seccion = (String) request.getParameter("seccion");%>
<%@ include file="inc/head.jsp"%>

<section class="wrapper content">
 
	<%//seccion = (String) session.getAttribute("seccion");
	if ("anadir".equalsIgnoreCase(seccion)) { %>
		<%@ include file="anadir.jsp"%>	
	<% } else if ("modificar".equalsIgnoreCase(seccion)) { %>
		<%@ include file="modificar.jsp"%>
	<% } else if ("eliminar".equalsIgnoreCase(seccion)) { %>
		<%@ include file="eliminar.jsp"%>
	<% } else if ("ver".equalsIgnoreCase(seccion)) { %>
		<%@ include file="ver.jsp"%>
	<% } else if (seccion == null){ %>
		<%@ include file="inc/navBar.jsp"%>
	<%} %>
</section>

<!-- FOOTER -->
<%@ include file="inc/footer.jsp"%>