<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.HashMap"%>
<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<form method="post" action="agenda">				
			<input id="asearch" type="text" placeholder="nombre que buscas..." name="nombreBusqueda" value="">
			
			<div class="botones">
				<input type="submit" value="buscar" name="op" class="boton buscar">
				<input type="hidden" name="buscador" value="modificar">
			</div>
		</form>
</div>

<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul id = "listaAmigos" class="amigos modify">
				<li>Busca un Amigo para modificar</li>

			<%
			/*if (request.getAttribute("listaNombre")!=null){
				HashMap<Integer,Amigo> listaAmigos = (HashMap<Integer,Amigo>) request.getAttribute("listaNombre");
			
				for(int i = 1; i <= listaAmigos.size() ; i++) {
					Amigo a = listaAmigos.get(i);*/%>
				<!-- <li>
					 <form action="agenda" method="get">
					
						<input type="submit" name="amigo" value="aaa">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="aa>">
						<input type="hidden" name="id" value="aaa">
						<input type="hidden" name="op" value="modificar>">
						
					</form>
				</li>-->
				<%/*} 
			}*/%>

			</ul>
</div>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido" value="apellido">
			<input type="text" placeholder="calle" name="calle" value="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="cp">
			<input type="text" placeholder="localidad" name="localidad" value="localidad">
			<input type="text" placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="mÃ³vil 999999999" name="movil" value="movil">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="telefono">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
			<input type="hidden" name="id" value="id">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="op" class="boton modificar">
			</div>
		</form>

	</div>
	
	<script src="js/jquery-2.1.0.min.js"></script>
	<script>
		
		var url= 'servletAjax';
	
		$(document).ready(function(){
			
			console.debug('ready....');
			//seleccionar campo texto
			var asearch= $('#asearch');
			
			asearch.keyup(function() {
				console.debug(asearch.val());
				//TODO llamar AJAX
				$.ajax( url , {
					"type": "get", // usualmente post o get
					"success": function(data) {
						cargarLista(data);
					},
					"error": function(error) {
						console.error("Este callback maneja los errores "+ error);
					},
					"data": {search: asearch.val() },
					"async": true,
				});
				
			});
			
		
		});
		
		function cargarLista(data){
			console.log("Comenzamos a cargar la lista con: "+ data);
			//limpiar lista
			$('#listaAmigos').empty();
			//iteramos sobre los datos recibidos
			$.each(data, function(index, amigo){ //por cada elemento de dato hago una funcion
				console.debug(index + " "+ amigo.id +" "+ amigo.nombre);
			
			//añadir en la lista un LI
			$('#listaAmigos').append('<li>' + amigo.nombre + '</li>');
			});
		}
		
		
		
		
		
		
		
		
	</script>