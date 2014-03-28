<%@page import="com.ipartek.agenda.controller.MainServlet"%>	

<nav class="navBar">
			<ul>
		<li id="anadir" <%if(MainServlet.OP_ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.OP_ANADIR %>" title="">
			<fmt:message key="aniadir" />
		</a></li>
		<li id="modificar" <%if(MainServlet.OP_MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.OP_MODIFICAR %>" title="">
		<fmt:message key="modificar" /></a></li>
		<li id="eliminar" <%if(MainServlet.OP_ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.OP_ELIMINAR %>" title="">
		<fmt:message key="eliminar" /></a></li>
		<li id="ver" <%if(MainServlet.OP_VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda" title="">
		<fmt:message key="ver" /></a></li>
	</ul>			
		</nav>