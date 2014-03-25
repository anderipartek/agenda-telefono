
<div class="contain">

<p class="txt">Seleccionalo de la lista</p>
		<ul id="listaAmigos" class="amigos modify">		
				<li>Busca un amigo para modificar			</li>
		
			</ul>



<form id="formulario" method="post" action="main">				
				<input type="text" placeholder="nombre (minimo 2 caracteres)" required="required" name="nombre" value="">
				<input type="text" placeholder="apellido" name="apellido" value="">
				<input type="text" placeholder="calle" name="calle" value="">
				<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
				<input type="text" placeholder="localidad" name="localidad" value="">
				<input type="text" placeholder="provincia" name="provincia" value="">
				<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="">
				<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
				<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
				
				<input type="hidden" name="id" value="id">
				
				<div class="botones">
					<a title="" href="index.jsp">cancelar</a>
					<input type="submit" value="modificar" name="op" class="boton modificar">
				</div>
			</form>

	</div>
	<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
	<script>
	 var url='servletAjax';
	 var amigos; //Array de Amigos recuperados de la llamada Ajax
	 $(document).ready(function(){
	       console.debug('ready...'); 
	       //seleccionar campo texto
	       var asearch=$('#asearch');
	       asearch.keyup(function() {
	    	   console.debug(asearch.val());
	    	   //TODO LLamada AJAX
	    	   $.ajax(url, {
	    		   "type": "get", // usualmente post o get
	    		   "success": function(data) {
	    		   console.log("Llego el contenido y no hubo error:" + data);
	    		   },
	    		   "error": function(error) {
	    		   console.error("Este callback maneja los errores:" + error);
	    		   },
	    		   "data": {search: asearch.val()},
	    		   "async": true,
	    		   });

	    	   });
	       $('#listaAmigos').on('click','li',function(){
	    	   console.log($(this).index());
	    	   //obtener amigo seleccionado
	    	   var amigo=amigos[$(this).index()];
	    	   console.debug(amigo.nombre);
	    	   //rellenar formulario
	    	   $('#formulario input[name=nombre]').val('Manoloooooooooooooooooooooo');
	    	   $('#formulario input[name=apellido]').val('Apellidorrrrrrrrrrrr');
	    	   $('#formulario input[name=calle]').val('Zarandoa');
	    	   $('#formulario input[name=cp]').val('48015');
	    	   
	       });
	      
	 });
			
			function cargarLista(data){
				console.log("Comenzamos a cargar la lista con: " + data);
				$('#listaAmigos').empty();
				$.each(data,function(index,amigo){
					console.debug(index + " " + amigo);
					//añadir en la lista un LI
					$('#listaAmigos').append('<li>' + amigo.nombre  + '</li>');
				});
			}
			function cargarFormulario(){
				console.debug('cargar formulario');
			}
	</script>