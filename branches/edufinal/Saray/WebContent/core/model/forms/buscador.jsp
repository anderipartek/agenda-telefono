
<%String formulario = (String)request.getAttribute("form"); %>

<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<?php } ?-->

		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="erlantz">
			
			<div class="botones">
				<input type="submit" value="buscar" name="buscar" class="boton buscar">
			</div>
		</form>
	</div>