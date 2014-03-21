<div class="contain">
		<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

		
		<form method="post" action="agenda">				
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">			
			<input type="hidden" name="apellido" value="<?php echo $result_row[2]; ?>">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="eliminar" name="eliminar" class="boton eliminar">
			</div>
		</form>

		
	</div>