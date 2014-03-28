<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<nav class="navBar">
	<ul>
		<li id="anadir" <%if(MainServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" title=""><fmt:message key="menu.anadir"/></a></li>
		<li id="modificar" <%if(MainServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" title=""><fmt:message key="menu.modificar"/></a></li>
		<li id="eliminar" <%if(MainServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>" title=""><fmt:message key="menu.eliminar"/></a></li>
		<li id="ver" <%if(MainServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" title=""><fmt:message key="menu.ver"/></a></li>
	</ul>
</nav>