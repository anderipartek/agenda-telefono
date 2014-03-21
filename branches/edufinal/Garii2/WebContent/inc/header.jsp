<header class="header">
	<div class="wrapper">
		<!-- include('inc/navBar.php'); -->
		
		<%if(request.getParameter("seccion") != null) {%>
		
			<%@ include file="navBar.jsp"%>
			
		<%} %>
		<a  href="main">
			<div class="logo">
				<span>Agenda</span>
				<span>online</span>
				<%--@ include file="navBar.jsp" --%>			
			</div>
			</a>
	</div>
</header>