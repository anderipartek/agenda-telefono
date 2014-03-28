<header class="header">

	<div class="wrapper">
		
		<%if(request.getParameter("seccion") != null) {%>
			<%@ include file="navBar.jsp"%>
		<%} %>
		<a  href="main">
			<div class="logo">
				<span><fmt:message key="titulo.parte1" /></span>
				<span><fmt:message key="titulo.parte2" /></span>
					
			</div>
			</a>
	</div>
</header>