<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<header class="header">
	<div class="wrapper">
		<%
			if (request.getAttribute("seccion") != null)
			{
				%> <%@include file="navBar.jsp" %>  <%
			}
		
		%>
		<div class="logo">
			<span>Agenda</span>
			<span>online</span>			
		</div>
	</div>
</header>