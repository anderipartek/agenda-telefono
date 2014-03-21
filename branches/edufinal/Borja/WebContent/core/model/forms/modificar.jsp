<div class="contain">
		<p class="titulo">Estos son los datos de tu amigo:</p>

		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="codigo postal" name="CP" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="nº de telefono movil" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="nº de telefono fijo" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			<input type="hidden" name="nombre" value="">
			<input type="hidden" name="id" value="">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

</div>