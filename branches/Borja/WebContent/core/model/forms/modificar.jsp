<div class="contain">
		<p class="titulo">Estos son los datos de tu amigo:</p>

		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="erlantz">
			<input type="text" placeholder="apellido" name="apellido" value="romero">
			<input type="text" placeholder="calle" name="calle" value="ibarreko">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="48004">
			<input type="text" placeholder="localidad" name="localidad" value="barakaldo">
			<input type="text" placeholder="provincia" name="provincia" value="bizkaia">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="666666666">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="999999999">
			<textarea name="anotaciones" placeholder="anotaciones">erlantz romero</textarea>
			<input type="hidden" name="nombre" value="erlantz">
			<input type="hidden" name="id" value="0">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>