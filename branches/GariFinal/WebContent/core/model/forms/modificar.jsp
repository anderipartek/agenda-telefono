<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<body>

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
		<form id="formulario"	 method="post" action="agenda">				
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
		
		<form id="formulario" method="post" action="agenda">				
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
				<input type="submit" value="modificar" name="modificar" class="boton modificar" onClick="if(!confirm('�Seguro que deseas modificar el registro?')){return false;}" >
			</div>
			
		<%} %>
		<script src="js/jquery-2.1.0.min.js"></script>
		<script>
		var url='servletAjax';
		var amigos;//Array de Amigos recupoerados de la llamada ajax
		
		
		$(document).ready(function(){
			console.debug('ready....');
			
			var asearch=$('#asearch');
			
			//llamada ajax sobre el evento keyuo
			asearch.keyup(function() {
				console.debug(asearch.val());
				//AJAX
				
				
				$.ajax(url, {
					"type": "post", // usualmente post o get
					"success": function(data) {
					amigos=data;
					cargarLista(data);
					},
					"error": function(error) {
					console.error("Este callback maneja los errores ", error);
					},
					"data": {search: asearch.val()},
					"async": true,
					});
				
				});
		});
			
			//Capturar evento click sobre lista busqueda
			$("#listaAmigos").on('click', 'li', function() {
			console.log($(this).index());
			
			//obtenemos el amigo selecionado
			var amigo = amigos[$(this).index()];
			console.debug(amigo.nombre);
			
			//rellenar formulario
			$('#formulario input[name=id]').val(amigo.id);
			$('#formulario input[name=nombre]').val(amigo.nombre);
			$('#formulario input[name=apellido]').val(amigo.apellido);
			$('#formulario input[name=calle]').val(amigo.calle);
			$('#formulario input[name=CP]').val(amigo.cp);
			$('#formulario input[name=localidad]').val(amigo.localidad);
			$('#formulario input[name=provincia]').val(amigo.provincia);
			$('#formulario input[name=movil]').val(amigo.movil);
			$('#formulario input[name=fijo]').val(amigo.fijo);
			$('#formulario input[name=anotaciones]').val(amigo.anotaciones);
				
				
				
				
				
			
			
		});
		
		function cargarLista(data){
			console.log("Comenzamos a cargar la lista con: " + data);

			//limpiar lista
			$('#listaAmigos').empty();

			//TODO controlar si no existen resultados

			//iteramos sobre los datos recibidos
			$.each(data, function(index, amigo) {
				console.debug(index + " " + amigo.id + " " + amigo.nombre);

				//a�adir en la lista un li
				$('#listaAmigos').append('<li>' + amigo.nombre + '</li>');

			});
		}
		
		

		
		</script>
			
			
			
		</form>
		

		<?php
		}
		?>
	</div>
	
	
	