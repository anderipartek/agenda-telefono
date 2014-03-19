
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>

<nav class="navBar">
	<ul>
		<li id="anadir" class="sel"><a href="AgendaServlet?<%=AgendaServlet.SECCION %><%=AgendaServlet.ANADIR %>" title="">Añadir
				amigo</a></li>
		<li id="modificar" class="sel"><a href="AgendaServlet?<%=AgendaServlet.SECCION %><%=AgendaServlet.MODIFICAR %>" title="">Modificar
				amigo</a></li>
		<li id="eliminar" class="sel"><a href="AgendaServlet?<%=AgendaServlet.SECCION %><%=AgendaServlet.ELIMINAR %>" title="">Eliminar
				amigo</a></li>
		<li id="ver" class="sel"><a href="AgendaServlet?<%=AgendaServlet.SECCION %><%=AgendaServlet.VER %>" title="">Ver
				todos</a></li>
	</ul>
</nav>