
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

<script src="js/jquery-2.1.0.min.js"></script>
<script>
	var url='servletAjax';
	$(document).ready(function() {
		console.debug('ready....');

		// seleccionar campo texto
		var asearch = $('#amigosearch');

		asearch.keyup(function() {
			console.debug(asearch.val());
			$.ajax(url,{
					"type" : "get", // usualmente post o get
					"success" : function(data) {
						console.log("Llego el contenido y no hubo error", data);
					},
					"error" : function(error) {
						console.error("Este callback maneja los errores", error);
					},
					"data" : {search : asearch.val() },
					"async" : true,
				});
			});
	});
</script>