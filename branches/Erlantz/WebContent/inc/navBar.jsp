<nav class="navBar">
			<ul>
				<li id="anadir"<%-- if("anadir".equalsIgnoreCase(seccion)) out.print("class='sel'");--%>> <!-- php if($seccion == 'anadir') echo 'class="sel"'; ?--><a href="index.jsp?seccion=anadir" title="">Añadir amigo</a></li>
				<li id="modificar" <%-- if("modificar".equalsIgnoreCase(seccion)) out.print("class='sel'");--%>><!--  ?php if($seccion == 'modificar') echo 'class="sel"'; ?--><a href="index.jsp?seccion=modificar" title="">Modificar amigo</a></li>
				<li id="eliminar" <%-- if("eliminar".equalsIgnoreCase(seccion)) out.print("class='sel'");--%>><!-- ?php if($seccion == 'eliminar') echo 'class="sel"'; ?--><a href="index.jsp?seccion=eliminar" title="">Eliminar amigo</a></li>
				<li id="ver" <%-- if("ver".equalsIgnoreCase(seccion)) out.print("class='sel'");--%>><!--  ?php if($seccion == 'ver') echo 'class="sel"'; ?--><a href="index.jsp?seccion=ver" title="">Ver todos</a></li>
			</ul>				
		</nav>