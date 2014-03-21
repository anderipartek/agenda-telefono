
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<nav class="navBar">
	<ul>
		<li id="anadir" <%if(MainServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" title="">Añadir
				amigo</a></li>
		<li id="modificar" <%if(MainServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" title="">Modificar
				amigo</a></li>
		<li id="eliminar" <%if(MainServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>" title="">Eliminar
				amigo</a></li>
		<li id="ver" <%if(MainServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?op=ver" title="">Ver
				todos</a></li>
	</ul>
</nav>
		
	