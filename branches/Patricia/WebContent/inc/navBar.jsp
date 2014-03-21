<%@page import="com.ipartek.agenda.controller.MainServlet"%>	<nav class="navBar">
			<ul>
		<li id="anadir" <%if(MainServlet.OP_ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.OP_ANADIR %>" title="">Añadir
				amigo</a></li>
		<li id="modificar" <%if(MainServlet.OP_MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.OP_MODIFICAR %>" title="">Modificar
				amigo</a></li>
		<li id="eliminar" <%if(MainServlet.OP_ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.OP_ELIMINAR %>" title="">Eliminar
				amigo</a></li>
		<li id="ver" <%if(MainServlet.OP_VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="agenda" title="">Ver
				todos</a></li>
	</ul>			
		</nav>