<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>

<nav class="navBar">
	<ul>
		<li id="anadir" <%if(MainServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" title=""><fmt:message key="main.add" /></a></li>
		<li id="modificar" <%if(MainServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" title=""><fmt:message key="main.modify" /></a></li>
		<li id="eliminar" <%if(MainServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>" title=""><fmt:message key="main.remove" /></a></li>
		<li id="ver" <%if(MainServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" title=""><fmt:message key="view.add" /></a></li>
	</ul>
</nav>