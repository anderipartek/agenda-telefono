
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<nav class="navBar">
	<ul>
		<li id="anadir" <%if(AgendaServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?<%=AgendaServlet.SECCION %>=<%=AgendaServlet.ANADIR %>" title="">Añadir
				amigo</a></li>
		<li id="modificar" <%if(AgendaServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?<%=AgendaServlet.SECCION %>=<%=AgendaServlet.MODIFICAR %>" title="">Modificar
				amigo</a></li>
		<li id="eliminar" <%if(AgendaServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?<%=AgendaServlet.SECCION %>=<%=AgendaServlet.ELIMINAR %>" title="">Eliminar
				amigo</a></li>
		<li id="ver" <%if(AgendaServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?<%=AgendaServlet.SECCION %>=<%=AgendaServlet.VER %>" title="">Ver
				todos</a></li>
	</ul>
</nav>