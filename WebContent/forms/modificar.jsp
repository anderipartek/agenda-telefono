<%@page import="com.ipartek.agenda.bean.Amigo"%>
	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

<%
Amigo a = null;
boolean nuevo = false;
if (request.getAttribute("detalleAmigo") == null) {
	a = new Amigo();
	nuevo = true;
} else {
	a = (Amigo) request.getAttribute("detalleAmigo");
}
%>
		
		<form method="post" action="main">				
			<input type="text" placeholder="nombre" name="nombre" value="<%=a.getNombre() %>">
			<input type="text" placeholder="apellido" name="apellido" value="<%=a.getApellido() %>">
			<input type="text" placeholder="calle" name="calle" value="<%=a.getCalle() %>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="<%=a.getCp() %>">
			<input type="text" placeholder="localidad" name="localidad" value="<%=a.getLocalidad() %>">
			<input type="text" placeholder="provincia" name="provincia" value="<%=a.getProvincia() %>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=a.getMovil() %>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=a.getFijo() %>">
			<textarea name="anotaciones" placeholder="anotaciones"><%=a.getAnotaciones() %></textarea>
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<%=a.getId()%>">
			
			<div class="botones">
				<a title="" href="main?seccion=ver">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>
	
	
	<script src="js/jquery-2.1.0.min.js"></script>
		
	<script>
		$(document).ready(function(){
			console.debug('ready.....')
		});
	</script>

	