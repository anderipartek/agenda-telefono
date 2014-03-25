
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
	<p class="titulo">Busca a tu amigo:</p>


	<form method="post" action="agenda">
		<input id="amigosearch" type="text" placeholder="nombre que buscas..."
			name="nombre" value="">

		<div class="botones">
			<input type="submit" value="<%=MainServlet.OP_BUSCAR%>" name="op"
				class="boton buscar">
		</div>
	</form>
</div>


<p class="txt">Seleccionalo de la lista</p>
<ul id="listaAmigos" class="amigos modify">
	<li>Busca un amigo para modificar</li>
</ul>


<script src="js/jquery-2.1.0.min.js"></script>
<script>
	var url = 'servletAjax';
	var amigos; // Array de amigos recuperados de la búsqueda por Ajax

	function cargarLista(data) {
		console.log("Comenzamos a cargar la lista con: " + data);
		// Limpiar lista
		$("#listaAmigos ").empty();
		$("#listaAmigos ").removeClass('ERR');

		if (data.length == 0) {
			//console.info('No hay datos');
			$('#listaAmigos')
					.append(
							'<div>No hubo exito con su búsqueda, por favor intentelo con otro nombre. </div>');
			$('#listaAmigos').addClass('ERR');

		} else {
			// Recorre la lista que devuelve el servlet en forma de Json
			$.each(data, function(index, amigo) {
				//console.debug(amigo.nombre);
				// Añadir en la lista un LI
				$("#listaAmigos").append(
						'<li class="modificar">' + amigo.nombre + ' '
								+ amigo.apellido + '</li>');
			});
		}
	}

	//function cargarFormulario(data) {
	//	console.debug('cargando formulario');
	//}

	$(document).ready(
			function() {
				console.debug('ready....');

				// seleccionar campo texto
				var asearch = $('#amigosearch');
				// Llamada Ajax sobre el elemento keyup
				asearch.keyup(function() {
					console.debug(asearch.val());
					$.ajax(url, {
						"type" : "get", // usualmente post o get
						"success" : function(data) {
							console.log("Llego el contenido y no hubo error",
									data);
							amigos = data;
							cargarLista(data);
						},
						"error" : function(error) {
							console.error("Este callback maneja los errores",
									error);
						},
						"data" : {
							search : asearch.val()
						},
						"async" : true,
					});
				});

				//Capturar evento click sobre lista busqueda
				$('#listaAmigos').on(
						'click',
						'li',
						function() {
							//cargarFormulario();
							var indice = $(this).index();
							/// Para eliminar 
							$('#eliminar').val(amigos[indice].id);
							// Rellenar formulario
							// Para modificar
							$('#formulario input[name=id]').val(
									amigos[indice].id);
							$('#formulario input[name=nombre]').val(
									amigos[indice].nombre);
							$('#formulario input[name=apellido]').val(
									amigos[indice].apellido);
							$('#formulario input[name=calle]').val(
									amigos[indice].calle);
							$('#formulario input[name=localidad]').val(
									amigos[indice].localidad);
							$('#formulario input[name=CP]').val(
									amigos[indice].cp);
							$('#formulario input[name=provincia]').val(
									amigos[indice].provincia);
							$('#formulario input[name=movil]').val(
									amigos[indice].movil);
							$('#formulario input[name=fijo]').val(
									amigos[indice].fijo);
							$('#formulario html .mce-content-body').val(
									amigos[indice].anotaciones);
						});

			});
</script>