
<div class="contain">
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
	<%@include file="/inc/mensajes.jsp" %>
	
	<form method="post"
		action="agenda">
		<input type="hidden" name="id"
			value=""> <input type="hidden"
			name="id" value="<?php echo $result_row[0]; ?>"> <input
			type="hidden" name="apellido" value="<?php echo $result_row[2]; ?>">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="eliminar" name="eliminar" class="boton eliminar">
		</div>
	</form>

	<?php
		}
		?>
</div>