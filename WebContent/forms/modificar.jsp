<div class="contain">
	<p class="titulo">Cuales son los datos de tu amigo:</p>

	
	
	<form method="post" action="">				
		<input type="text" placeholder="nombre" name="nombre" value="">
		<input type="text" placeholder="apellido" name="apellido" value="">
		<input type="text" placeholder="calle" name="calle" value="">
		<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
		<input type="text" placeholder="localidad" name="localidad" value="">
		<input type="text" placeholder="provincia" name="provincia" value="">
		<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="">
		<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
		<textarea name="anotaciones" placeholder="anotaciones"></textarea>
		<input type="hidden" name="nombre" value="">
		<input type="hidden" name="id" value="">
		
		<div class="botones">
			<a title="" href="index.php">cancelar</a>
			<input type="submit" value="modificar" name="modificar" class="boton modificar">
		</div>
	</form>


</div>