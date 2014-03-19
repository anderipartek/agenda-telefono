<div class="contain">
<%-- 	<p>Se ha 
	 	<% if($seccion == 'anadir') echo 'añadido'; %> 
	 	<% if($seccion == 'modificar') echo 'modificado'; %> 
	 	<% if($seccion == 'eliminar') echo 'eliminado'; %> 
		correctamente a 
		<span><% echo $_POST['nombre'] . ' ' . $_POST['apellido']; %></span> 
		a la agenda</p> --%>
	<h3>¿Qué puedes hacer ahora?</h3>
	<ul class="links">
		<li><a href="index.php?seccion=anadir" class="boton anadir">añadir a un amigo</a></li>
		<li><a href="index.php?seccion=modificar" class="boton modificar">modificar a un amigo</a></li>
		<li><a href="index.php?seccion=eliminar" class="boton eliminar">eliminar a un amigo</a></li>
	</ul>
</div>