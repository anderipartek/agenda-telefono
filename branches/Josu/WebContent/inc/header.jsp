<header class="header">
	<div class="wrapper">

		<c:set var="seccion" value='<%=request.getAttribute("seccion")%>' />
		<c:if test="${!empty seccion}">
			<%@include file="navBar.jsp"%>
		</c:if>

		<a href="index.jsp" alt="inicio">
			<div class="logo">
				<span>Agenda</span>
				 <span>online</span>
			</div>	
		</a>
			
	</div>
</header>