
		<nav class="navBar">
			<ul>
				<li id="anadir" <?php if($seccion == 'anadir') echo 'class="sel"'; ?>><a href="index.php?seccion=anadir" title="">Añadir amigo</a></li>
				<li id="modificar" <?php if($seccion == 'modificar') echo 'class="sel"'; ?>><a href="index.php?seccion=modificar" title="">Modificar amigo</a></li>
				<li id="eliminar" <?php if($seccion == 'eliminar') echo 'class="sel"'; ?>><a href="index.php?seccion=eliminar" title="">Eliminar amigo</a></li>
				<li id="ver" <?php if($seccion == 'ver') echo 'class="sel"'; ?>><a href="index.php?seccion=ver" title="">Ver todos</a></li>
			</ul>				
		</nav>