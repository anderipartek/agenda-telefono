<header class="header">
	<div class="wrapper">
		
		
		<%if(request.getParameter("seccion") != null || request.getAttribute("seccion") !=  null ) {	%>
		
			<%@ include file="navBar.jsp"%>
			
		<%} %>
		
		<a  href="main">
			<div class="logo">
				<span>Agenda</span>
				<span>online</span>
						
			</div>
			</a>
	</div>
</header>