<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<!-- ?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<?php } ?-->
	

		<form method="post" action="agenda">				
			<input id="asearch" type="text" placeholder="nombre que buscas..." name="nombre" value="">
			<input type="hidden" name="op" value="buscar"> 
			
			<div class="botones">
				<input type="submit" value="buscar" name="buscar" class="boton buscar">
			</div>
		</form>
	</div>