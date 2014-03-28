
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<nav class="navBar">
	<ul>
		<li id="anadir" <%if(MainServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" title="">Añadir
				amigo</a></li>
		<li id="modificar" <%if(MainServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?op=modificar" title="">Modificar
				amigo</a></li>
		<li id="eliminar" <%if(MainServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?op=eliminar" title="">Eliminar
				amigo</a></li>
		<li id="ver" <%if(MainServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda?op=ver" title="">Ver
				todos <input type="hidden" name="op" value="ver"/></a></li>
	
	</ul>
</nav>