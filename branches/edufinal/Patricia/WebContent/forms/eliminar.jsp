
<!-- Obtener el id del alumno -->
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
	
	<%@include file="buscar.jsp"  %>

		<%@include file="/inc/mensajes.jsp" %>	
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
	<form method="post"
		action="agenda">
		<input type="hidden" name="id"
			value="">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="<%=MainServlet.OP_ELIMINAR %>" name="<%=MainServlet.OP_ELIMINAR %>" class="boton eliminar">
		</div>
	</form>

	<?php
		}
		?>
</div>