
<!-- Obtener el id del alumno -->
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<div class="contain">
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
	<%@include file="/inc/mensajes.jsp" %>
	
	<form method="post"
		action="agenda">
		<input type="hidden" name="id"
			value="">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="<%=AgendaServlet.OP_ELIMINAR %>" name="<%=AgendaServlet.OP_ELIMINAR %>" class="boton eliminar">
		</div>
	</form>

	<?php
		}
		?>
</div>