	<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
		<%@include file="buscar.jsp"  %>

		<%@include file="/inc/mensajes.jsp" %>	
		
			
		<form method="post" action="">				
			<input type="hidden" placeholder="id" name="id" value="${requestScope.amigo.id }">		
			<input type="text" placeholder="nombre" name="nombre" value="${requestScope.amigo.nombre}">
			<input type="text" placeholder="apellido" name="apellido" value="${requestScope.amigo.apellido }">
			<input type="text" placeholder="calle" name="calle" value="${requestScope.amigo.calle }">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="${requestScope.amigo.cp }">
			<input type="text" placeholder="localidad" name="localidad" value="${requestSope.amigo.localidad }">
			<input type="text" placeholder="provincia" name="provincia" value="${requestScope.amigo.provincia }">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 666666666" name="movil" value="${requestScope.amigo.movil }">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="${requestScope.amigo.fijo }">
			<textarea name="anotaciones" placeholder="anotaciones">${requestScope.agenda.anotaciones }</textarea>

			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="<%=MainServlet.OP_MODIFICAR %>" name="op" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>

<!--  <script src="js/jquery-2.1.0.min.js"></script>
<script>
	$(document).ready(function(){
		console.debug('ready....');
		
	});
</script>-->
	