
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<nav class="navBar">
	<ul>
		<li id="anadir" <%if(MainServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" title=""><fmt:message key="menu.op1" />
				</a></li>
		<li id="modificar" <%if(MainServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" title=""><fmt:message key="menu.op2" />
				</a></li>
		<li id="eliminar" <%if(MainServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>" title=""><fmt:message key="menu.op3" />
				</a></li>
		<li id="ver" <%if(MainServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?op=ver" title=""><fmt:message key="menu.op4" />
				</a></li>
	</ul>
</nav>
		
	