	<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<!--<?php if($error != false){ ?>-->
			<ul class="errores">
			<!--<?php if($_POST['nombre'] == '') ?>-->
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<!--<?php } ?>-->

		<form method="post" action="main">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="">
			
			<div class="botones">
				<input type="submit" value="buscar" name="operacion" class="boton buscar">
			</div>
		</form>
	</div>

	