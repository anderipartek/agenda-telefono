<%@page import="com.ipartek.agenda.controller.MainServlet"%>

<div data-role="panel" id="defaultpanel">
	<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Añadir</a></li>
	<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Modificar</a></li>
	<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR%>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Eliminar</a></li>
	<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER%>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Ver</a></li>
</div><!-- /panel -->

<div data-role="header">
	<h1>Listado Amigos</h1>
<!-- 	<a href="index.jsp" data-role="button" data-icon="back">Home</a> -->
	<a href="#defaultpanel" class="ui-btn ui-shadow ui-corner-all ui-btn-inline ui-btn-icon-left ui-icon-bars"></a>
</div>
		
<div>
	<ul>
		<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Añadir</a></li>
		<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Modificar</a></li>
		<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR%>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Eliminar</a></li>
		<li><a data-ajax="true" href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER%>" data-ajax="false" class="ui-btn ui-btn-icon-right ui-icon-carat-r">Ver</a></li>
	</ul>
</div>