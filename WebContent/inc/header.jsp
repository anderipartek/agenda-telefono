<header class="header">
	<div class="wrapper">

		<c:set var="seccion" value='<%=request.getAttribute("seccion")%>' />
		<c:if test="${!empty seccion}">
			<%@include file="navBar.jsp"%>
		</c:if>

		<div class="logo">
			<span>Agenda</span>
			 <span>online</span>
		</div>	
			
	</div>
</header>