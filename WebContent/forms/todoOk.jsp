<div class="contain">
<%-- 	<p>Se ha 
	 	<% if($seccion == 'anadir') echo 'a�adido'; %> 
	 	<% if($seccion == 'modificar') echo 'modificado'; %> 
	 	<% if($seccion == 'eliminar') echo 'eliminado'; %> 
		correctamente a 
		<span><% echo $_POST['nombre'] . ' ' . $_POST['apellido']; %></span> 
		a la agenda</p> --%>
	<h3>�Qu� puedes hacer ahora?</h3>
	<ul class="links">
		<li><a href="anadir.jsp" class="boton anadir">a�adir a un amigo</a></li>
		<li><a href="modificar.jsp" class="boton modificar">modificar a un amigo</a></li>
		<li><a href="eliminar.jsp" class="boton eliminar">eliminar a un amigo</a></li>
	</ul>
</div>