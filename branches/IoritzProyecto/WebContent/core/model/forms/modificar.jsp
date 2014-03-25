<div class="contain">


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
		
		<p class="txt">Seleccionalo de la lista</p>
		<ul id="listaAmigos" class="amigos modify">		
		<li>Busca un Amigo para modificar</li>
		<!--  
				<li>
					<form action="agenda" method="get">
						<input type="submit" name="amigo" value="aaa">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="aa">
						<input type="hidden" name="id" value="aaa">						
						<input type="hidden" name="op" value="modificar">
					</form>
				</li>
				-->
				
		
			</ul>
		<p class="titulo">Cuales son los datos de tu amigo:</p>
			
		<form id="formulario" method="post" action="main">
			
			<input type="hidden" name="op" value="modificar">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="mÃ³vil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones" value=""></textarea>
			<input type="hidden" name="id" value="id">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
			
		</form>

		<?php
		}
		?>
	</div>
	
	<script src="js/jquery-2.1.0.min.js"></script>
			
			<script>
			
			var url='servletAjax';
			var contact; //Array de amigos recuperados de la llamada Ajax
			
			$(document).ready(function(){
					console.debug('ready.......');
				
				//seleccionar campo texto
				var asearch = $('#asearch');
				
				//Llamada Ajax sobre el evento KEYUP
				asearch.keyup(function(){
					console.debug(asearch.val());
					//TODO LLAMAR AJAX
					
					
					
					$.ajax( url , {
						"type": "get", // usualmente post o get
						"success": function(data) {
							contact = data;
							cargarLista(data);
						},
						"error": function(error) {
							console.error("Este callback maneja los errores " + error);
						},
						"data": {search: asearch.val()},
						"async": true,
						});

				});
				
			//Capturar evento click sobre lista busqueda
			$('#listaAmigos').on('click', 'li', function(){
				console.log($(this).index());
				
				//obtenemos el amigo seleccionado
				var contacto = contact[$(this).index()];
				
				console.debug();
				
				//rellenar formulario
				$('#formulario input[name=nombre]').val(contacto.nombre);
				
				
			});
		});
			
			
			function cargarLista(data){
				console.log("Comenzamos a cargar lista " + data);
				
				//limpiar lista
				$('#listaAmigos').empty();
				
				//TODO controlar si no existen resultados
				
				//iteramos sobre los datos recibidos
				$.each(data, function(index, contacto){
					console.debug(index + " " + contacto.id + " " + contacto.nombre);
					//añadir en la lista un LI
					$('#listaAmigos').append('<li>' + contacto.nombre + '</li>');
				});
			}
			
			function cargarFormulario(){
				console.debug('cargarFormulario');
			}
			
			</script>