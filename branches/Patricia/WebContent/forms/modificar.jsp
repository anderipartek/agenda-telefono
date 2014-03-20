	<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
		<%@include file="buscar.jsp"  %>

		<%@include file="/inc/mensajes.jsp" %>	
		
		<% Amigo amigo= (Amigo)request.getAttribute("amigos"); %>	
		<form method="post" action="">				
			<input type="hidden" placeholder="id" name="id" value="<%=(amigo!=null)?amigo.getId(): ' '%>">		
			<input type="text" placeholder="nombre" name="nombre" value="<%=(amigo!=null)?amigo.getNombre(): ' '%>">
			<input type="text" placeholder="apellido" name="apellido" value="<%=(amigo!=null)?amigo.getApellido(): ' '%>">
			<input type="text" placeholder="calle" name="calle" value="<%=(amigo!=null)?amigo.getCalle(): ' '%>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<%=(amigo!=null)?amigo.getCp(): ' '%>">
			<input type="text" placeholder="localidad" name="localidad" value="<%=(amigo!=null)?amigo.getLocalidad(): ' '%>">
			<input type="text" placeholder="provincia" name="provincia" value="<%=(amigo!=null)?amigo.getProvincia(): ' '%>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=(amigo!=null)?amigo.getMovil(): ' '%>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=(amigo!=null)?amigo.getFijo(): ' '%>">
			<textarea name="anotaciones" placeholder="anotaciones"><%=(amigo!=null)?amigo.getAnotaciones(): ' '%></textarea>

			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>

	