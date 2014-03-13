<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@include file="inc/head.jsp"%>

<!-- contenido central -->


	<section class="wrapper content">
		
		<%if ("index".equalsIgnoreCase(seccion)){%>
			<%@include file="inc/navBar.jsp"%>
		<%}else	if ("anadir".equalsIgnoreCase(seccion)){%>
			<%@include file="anadir.jsp"%>
		<%}else	if ("modificar".equalsIgnoreCase(seccion)){%>
			<%@include file="modificar.jsp"%>
		<%}else if ("eliminar".equalsIgnoreCase(seccion)){%>
			<%@include file="eliminar.jsp"%>
		<%}else if ("ver".equalsIgnoreCase(seccion)){%>
			<%@include file="ver.jsp"%>
		<%}%>
	</section>
	<%@include file="inc/footer.jsp"%>
		
	

