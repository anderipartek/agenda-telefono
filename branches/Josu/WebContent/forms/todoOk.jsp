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
		<li><a href="main?seccion=anadir" class="boton anadir">añadir a un amigo</a></li>
		<li><a href="main?seccion=ver" class="boton ver">ver la lista</a></li>
	</ul>
</div>