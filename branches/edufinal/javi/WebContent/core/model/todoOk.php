<div class="contain">
	<p>Se ha 
		<?php if($seccion == 'anadir') echo 'añadido'; ?> 
		<?php if($seccion == 'modificar') echo 'modificado'; ?> 
		<?php if($seccion == 'eliminar') echo 'eliminado'; ?> 
		correctamente a 
		<span><?php echo $_POST['nombre'] . ' ' . $_POST['apellido']; ?></span> 
		a la agenda</p>
	<h3>¿Qué puedes hacer ahora?</h3>
	<ul class="links">
		<li><a href="index.php?seccion=anadir" class="boton anadir">añadir a un amigo</a></li>
		<li><a href="index.php?seccion=modificar" class="boton modificar">modificar a un amigo</a></li>
		<li><a href="index.php?seccion=eliminar" class="boton eliminar">eliminar a un amigo</a></li>
	</ul>
</div>