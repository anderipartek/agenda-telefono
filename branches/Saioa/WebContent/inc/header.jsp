<header class="header">
	<div class="wrapper">
		<%String seccion = (String)request.getAttribute("seccion");%>
		<% if ("index".equalsIgnoreCase(seccion)){%>
			<%@include file="navBar.jsp"%>
		<%}%>
		<div class="logo">
			<span>Agenda</span>
			<span>online</span>			
		</div>
	</div>
</header>