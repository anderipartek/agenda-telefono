<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<!--  ? php

		// enviamos la query
		$id = comillas_inteligentes($_POST['id']);
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		while($result_row = mysql_fetch_array($result)){
		?-->
		<%
			Amigo amigo =(Amigo) request.getAttribute("amigomodificar");
			if(amigo!=null){%>
			
			
		<%@ include file="../../../mensaje.jsp" %>
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="<%=amigo.getNombre() %>">
			<input type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido() %>">
			<input type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle() %>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<%=amigo.getCp() %>">
			<input type="text" placeholder="localidad" name="localidad" value="<%=amigo.getLocalidad() %>">
			<input type="text" placeholder="provincia" name="provincia" value="<%=amigo.getProvincia() %>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=amigo.getMovil() %>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo() %>">
			<textarea name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones() %></textarea>
			
			
			
			
			<input type="hidden" name="id" value="<%=amigo.getId() %>">
			<input type="hidden" name="op" value="modificar">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar"  >
			</div>
		</form>
		<%}else{%>
		
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			
			
			<input type="hidden" name="id" value="">
			<input type="hidden" name="op" value="modificar">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>
		<%} %>

		<?php
		}
		?>
	</div>
	
	
	