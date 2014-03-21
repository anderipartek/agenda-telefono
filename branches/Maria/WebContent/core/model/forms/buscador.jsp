<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<!-- ?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<?php } ?-->

		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="Maria">
			
			<div class="botones">
				<input type="submit" value="buscar" name="op" class="boton buscar">
				<input type="hidden" name="modificar" value="buscador">
			</div>
		</form>
	</div>