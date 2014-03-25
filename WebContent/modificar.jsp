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

		
		<form id="formulario" method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="mÃ³vil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			<input type="hidden" name="id" value="">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="op" class="boton modificar">
			</div>
		</form>

	</div>
	
	<script src="js/jquery-2.1.0.min.js"></script>
	<script>
		
		var url= 'servletAjax';
		var amigos; //Array de Amigos recuperados de la llamada AJAX
	
		$(document).ready(function(){
			
			console.debug('ready....');
			//seleccionar campo texto
			var asearch= $('#asearch');
			
			//llamada ajax sobre el evento KEYUP
			asearch.keyup(function() {
				console.debug(asearch.val());
				//TODO llamar AJAX
				$.ajax( url , {
					"type": "get", // usualmente post o get
					"success": function(data) {
						amigos= data;
						cargarLista(data);
					},
					"error": function(error) {
						console.error("Este callback maneja los errores "+ error);
					},
					"data": {search: asearch.val() },
					"async": true,
				});
				
			});
			
			//capturar evento click sobre lista de la busqueda
			$('#listaAmigos').on('click','li',function(){
				console.log($(this).index());
				//obtenemos el amigo señeccionado
				var amigo = amigos[$(this).index()+1];
				
				console.debug(amigo.nombre);
				
				//rellenar formulario
				$('#formulario input[name=nombre]').val(amigo.nombre);
				$('#formulario input[name=apellido]').val(amigo.apellido);
				$('#formulario input[name=calle]').val(amigo.calle);
				$('#formulario input[name=cp]').val(amigo.cp);
				$('#formulario input[name=localidad]').val(amigo.localidad);
				$('#formulario input[name=provincia]').val(amigo.provincia);
				$('#formulario input[name=movil]').val(amigo.movil);
				$('#formulario input[name=fijo]').val(amigo.fijo);
				$('#formulario input[name=anotaciones]').val(amigo.anotaciones);
				$('#formulario input[name=id]').val(amigo.id);
			});
			
		
		});
		
		

		
		function cargarLista(data){
			console.log("Comenzamos a cargar la lista con: "+ data);
			//limpiar lista
			$('#listaAmigos').empty();
			//TODO si no existen resultados
			//iteramos sobre los datos recibidos
			$.each(data, function(index, amigo){ //por cada elemento de dato hago una funcion
				console.debug(index + " "+ amigo.id +" "+ amigo.nombre);
			
				//añadir en la lista un LI
				$('#listaAmigos').append('<li>' + amigo.nombre +" "+ amigo.apellido +'</li>');
			});
		}
		

		
	</script>