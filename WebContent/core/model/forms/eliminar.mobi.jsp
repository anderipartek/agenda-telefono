<%@ include file="mensaje.jsp"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado amigo||Version Mobile</title>

	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.min.css">
	
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script  type="text/javascript" src="js/jquery.mobile-1.4.2.min.js"></script>
	<script type="text/javascript">
		var url = 'servletAjax';
		var amigos; //Array de amigos recuperados de la llamada ajax
		$(document).ready(
				function() {

					console.debug('ready...');
					//seleccionar campo texto
					var aSearch = $('#aSearch');

					//Llamada ajax sobre el elemento KEYUP
					aSearch.keyup(function() {
						console.debug(aSearch.val());
						//llamar a AJax
						$.ajax(url, {
							"type" : "get", // usualmente post o get
							"success" : function(data) {
								amigos=data;
								cargarLista(data);
							},
							"error" : function(error) {
								console.error(
										"Este callback maneja los errores",
										error);
							},
							"data" : {
								parametro_busqueda : aSearch.val()
							},
							"async" : true,
						});
					});

				});

		//capturar evento click sobre lista de la busqueda
		$("#listaAmigos").on('click', 'li', function() {
			console.log($(this).index());
			
			//obtenemos el amigo selecionado
			var amigo = amigos[$(this).index()];
			
			$('#formularioB input[name=id]').val(amigo.id);
			
			
			
			
		});

		function cargarLista(data) {
			console.log("Comenzamos a cargar la lista con: " + data);

			//limpiar lista
			$('#listaAmigos').empty();

			//TODO controlar si no existen resultados
			if (data.length==0){
            	$('#listaAmigos').addClass('errores');
            	$('#listaAmigos').append('<p>No hay amigos en la BD que empiecen con ese nombre </p>');
            }
			else{
			//iteramos sobre los datos recibidos
			$.each(data, function(index, amigo) {
				console.debug(index + " " + amigo.id + " " + amigo.nombre);

				//añadir en la lista un li
				
				$('#listaAmigos').append('<li class="elemento">' + amigo.nombre + " " + amigo.apellido +  '</li>');

			});
			}
		}
	</script>  
</head>
<body>
  <%@ include file="buscador.jsp"%>
  <div class="contain">


		<p class="errores"><%=msg%></p>

		<ul id="listaAmigos" class="amigos del">
		
		</ul>	
	</div>
	
	<div class="contain">

			       
				   <form id="formularioB" method="post" action="agenda?operacion=eliminar">
						
						<div class="botones">
                            <input type="hidden" name="id" value="">
							<input type="submit" value="eliminar" name="op"
								class="boton eliminar"
								onClick="if(!confirm('¿Seguro que deseas eliminar el amigo seleccionado?')){return false;}">
							
						</div>
					</form>
					
				</div>
     
	<!-- FOOTER -->

	<%@include file="../../../inc/footer.jsp"%>
</body>
</html>
