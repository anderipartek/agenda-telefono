<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<nav class="navBar">
	<ul>
		<li id="anadir" <%if ("anadir".equals(request.getAttribute("seccion"))){ %> class="sel" <%} %>><a href="main?seccion=anadir" title="">Añadir amigo</a></li>
		<li id="modificar" <%if ("modificar".equals(request.getAttribute("seccion"))){ %> class="sel" <%} %>><a href="main?seccion=modificar" title="">Modificar amigo</a></li>
		<li id="eliminar" <%if ("eliminar".equals(request.getAttribute("seccion"))){ %> class="sel" <%} %>><a href="main?seccion=eliminar" title="">Eliminar amigo</a></li>
		<li id="ver" <%if ("ver".equals(request.getAttribute("seccion"))){ %> class="sel" <%} %>><a href="main?seccion=ver" title="">Ver todos</a></li>
	</ul>				
</nav>