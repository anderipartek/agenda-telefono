<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
	<%-- 
		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>Necesitamos saber su nombre</p></li>
			<?php if($_POST['movil'] == '') ?>
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>
		<?php } ?>--%>
		
		<form method="post" action="main">
		
			<input type="hidden" name="op" value="anadir">
						
			<input type="text" placeholder="nombre" name="nombre" value="nombre" required>
			<input type="text" placeholder="apellido" name="apellido" value="apellido">
			<input type="text" placeholder="calle" name="calle" value="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="CP">
			<input type="text" placeholder="localidad" name="localidad" value="localidad">
			<input type="text" placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999" name="movil" value="tel�fono movil" required>
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="tel�fono fijo">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="a�adir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>