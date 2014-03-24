

<div class="contain">
	<p class="titulo">Cuales son los datos de tu amigo:</p>


	<%@include file="buscador.jsp"%>

	<form method="post"
		action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">
		<input type="text" placeholder="nombre" name="nombre" value="">
		<input type="text" placeholder="apellido" name="apellido" value="">
		<input type="text" placeholder="calle" name="calle" value="">
		<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP"
			value=""> <input type="text" placeholder="localidad"
			name="localidad" value=""> <input type="text"
			placeholder="provincia" name="provincia" value=""> <input
			type="text" pattern="[0-9]{9}" placeholder="móvil 999999999"
			name="movil" value=""> <input type="text" pattern="[0-9]{9}"
			placeholder="fijo 999999999" name="fijo" value="">
		<textarea name="anotaciones" placeholder="anotaciones"></textarea>
		<input type="hidden" name="nombre" value=""> <input
			type="hidden" name="id" value="">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="modificar" name="modificar" class="boton modificar">
		</div>
	</form>
	<script src="js/jquery-2.1.0.min.js"></script>

	<script type="text/javascript">
		
	var url = 'servletAjax';
	
	$(document).ready(function() {

					console.debug('ready...');
					//seleccionar campo texto
					var aSearch = $('#aSearch');

					aSearch.keyup(function() {
						console.debug(aSearch.val());
						//llamar a AJax
						$.ajax(url, {
							"type" : "get", // usualmente post o get
							"success" : function(data) {
								console.log(
										"Llego el contenido y no hubo error" ,	data);
							},
							"error" : function(error) {
								console.error(
										"Este callback maneja los errores" ,error);
							},
							"data" : {search : aSearch.val()},
							"async" : true,
						});
					});

				});
	</script>

</div>

