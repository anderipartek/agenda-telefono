<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>

<%@ include file="../../../inc/head.jsp"%>
<!-- HEADER -->
<body>
	<%@ include file="../../../inc/header.jsp"%>

	<%@ include file="buscador.jsp"%>
	<div class="contain">

		
<%
	String msg = (String) request.getAttribute("Mensaje");
	if (msg == null) {
		msg = "";
	}
	String nombre = "";
	%>
	<p class="errores"><%=msg%></p>
	


	
	<script src="js/jquery-1.11.0.js"></script>

	<ul id="listaAmigos" class="amigos modify">
		
             
		
		

	</ul>
    
    <form id="formulario" method="post" action="agenda?operacion=modificar">
		<input type="text" placeholder="nombre" name="nombre" value="">
		<input type="text" placeholder="apellido" name="apellido" value="">
		<input type="text" placeholder="calle" name="calle" value="">
		<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp"
			value=""> 
		<input type="text" placeholder="localidad" name="localidad" value=""> 
		<input type="text" placeholder="provincia" name="provincia" value=""> 
		<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999"
			name="movil" value=""> 
		<input type="text" pattern="[0-9]{9}"
			placeholder="fijo 999999999" name="fijo" value="">
		<textarea name="anotaciones" placeholder="anotaciones"></textarea>
		<input type="hidden" name="id" value=""> 
		 

		<div class="botones">
			<a title="" href="agenda">cancelar</a> <input type="submit"
				value="modificar" name="modificar" class="boton modificar">
		</div>
	</form>


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
			
			
			//rellenar formulario
			$('#formulario input[name=nombre]').val(amigo.nombre);
			$('#formulario input[name=apellido]').val(amigo.apellido);
			$('#formulario input[name=calle]').val(amigo.calle);
			$('#formulario input[name=cp]').val(amigo.cp);
			$('#formulario input[name=localidad]').val(amigo.localidad);
			$('#formulario input[name=provincia]').val(amigo.provincia);
			$('#formulario input[name=movil]').val(amigo.movil);
			$('#formulario input[name=fijo]').val(amigo.fijo);
			$('#formulario input[name=id]').val(amigo.id);
			$('#formulario input[name=anotaciones]').val(amigo.anotaciones);
			
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
			//iteramos sobre los datos recibidos
			else{
				$.each(data, function(index, amigo) {
				console.debug(index + " " + amigo.id + " " + amigo.nombre);

				//añadir en la lista un li
				$('#listaAmigos').append('<li class="elemento">' + amigo.nombre + " " + amigo.apellido +  '</li>');
			
			    });
			}	
		}
	</script>  
</div>
