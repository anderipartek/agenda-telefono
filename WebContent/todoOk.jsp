<div class="contain">
<%String seccion = (String) session.getAttribute("seccion"); %>
	<p>Se ha 
	<% if ("anadir".equalsIgnoreCase(seccion)) out.print(" a�adido ");%>
	<% if ("modificar".equalsIgnoreCase(seccion)) out.print(" modificado ");%>
	<% if ("anadir".equalsIgnoreCase(seccion)) out.print(" eliminado ");%>
	<!-- 
		<?php if($seccion == 'anadir') echo 'añadido'; ?> 
		<?php if($seccion == 'modificar') echo 'modificado'; ?> 
		<?php if($seccion == 'eliminar') echo 'eliminado'; ?> 
		correctamente a 
		<span><?php echo $_POST['nombre'] . ' ' . $_POST['apellido']; ?></span>  --> 
		a la agenda</p>
	<h3>�Que puedes hacer ahora?</h3>
	<ul class="links">
		<li><a href="main?seccion=anadir" class="boton anadir">a�adir a un amigo</a></li>
		<li><a href="main?seccion=modificar" class="boton modificar">modificar a un amigo</a></li>
		<li><a href="main?seccion=eliminar" class="boton eliminar">eliminar a un amigo</a></li>
	</ul>
</div>