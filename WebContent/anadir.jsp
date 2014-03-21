
		<%@ include file="inc/head.jsp"%>
			<!-- HEADER -->
			<%Amigo amigos =(Amigo) request.getAttribute("anadido");
		
		if(amigos!=null){%>
		<%@ include file="inc/header.jsp"%>
		<%} %>
		 
<%@ include file="core/model/forms/anadir.jsp"%>
<%@ include file="mensaje.jsp" %>

