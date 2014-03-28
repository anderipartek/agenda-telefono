<%@page import="java.util.ArrayList"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			
			<%
			ArrayList<String> listaAmigos = new ArrayList<String>();
			
			for (int i = 0 ; i < listaAmigos.size(); i++) { %>
				<li>
					<form action="agenda" method="post">
					
						<input type="submit" name="amigo" value="<%=listaAmigos.get(i)%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="">
						<input type="hidden" name="id" value="<%=i%>">
					</form>
				</li>
				<%} %>
			
			</ul>
		</div>
		
		<form id="formulario" method="post" action="agenda">				
				<input type="text" placeholder="nombre (minimo 2 caracteres)" required="required" name="nombre" value="nombre">
				<input type="text" placeholder="apellido" name="apellido" value="apellido">
				<input type="text" placeholder="calle" name="calle" value="calle">
				<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="cp">
				<input type="text" placeholder="localidad" name="localidad" value="localidad">
				<input type="text" placeholder="provincia" name="provincia" value="provincia">
				<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="movil">
				<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="telefono">
				<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
				
				<input type="hidden" name="id" value="id">
				
				<div class="botones">
					<a title="" href="index.jsp">cancelar</a>
					<input type="submit" value="modificar" name="op" class="boton modificar">
				</div>
		</form>
		
		<script src="js/jquery-2.1.0.min.js"></script>
		<script>
		 
		 var url = 'servletAjax';
		 var amigos; //array de Amigos recuperados de la llamada Ajax
	
		 $(document).ready(function(){

			 console.debug('ready...');
			 //seleccionar campo texto
			 var asearch = $( "#asearch" );
			//LLamada a Ajax sobre el evento keyup
			aseach.keyup(function() {
				  console.debug(asearch.val());

				  $.ajax(url, {
				  "type": "get", // usualmente post o get
				  "success": function(data) {
				  console.log("Llego el contenido y no hubo error" +  data);
				  amigos(data)
				  cargarLista(data);
				  
				  },
				  "error": function(error) {
				  console.error("Este callback maneja los errores" + error);
				  },
				  "data": {search: asearch.val()},
				  "async": true,
				  });
				 });
			
			//capturar evento click sobre lista busqueda
			$('#listaAmigos').on('click','li',function(){
				cargarFormulario($(this));
				//obtenemos el amigo selecionado
				var amigo =amigos[$(this).index()];
				console.debug(amigo.nombre);
				console.log($(this).text());
				//rellenar formulario
				 $('#formulario input[name=nombre]').val(amigo.nombre);
				 $('#formulario input[name=apellido]').val(amigo.apellido);
				 $('#formulario input[name=cp]').val(amigo.cp);
				 $('#formulario input[name=poblacion]').val(amigo.poblacion);
				 
				 $('#formulario input[name=calle]').val(amigo.calle);
				 $('#formulario input[name=provincia]').val(amigo.provincia);
				 $('#formulario input[name=movil]').val(amigo.movil);
				 $('#formulario input[name=fijo]').val(amigo.fijo);
				 $('#formulario input[name=anotaciones]').val(amigo.anotaciones);
			});
		 
		 
		 
		 function cargarLsta (data){
			 
			 console.log("Comenzamos a cargar la lista con: "+data);
			 
			 //limpiar lista
			 
			 $('#listaAmigos').empty(); 
			 
			 //iteramos sobre los datos recibidos
			 if (jQuery.isEmptyObject){
				 
			 }else{
			 
			 $.each(data, function(index,amigo){
				 
				 console.debug(index +" "+amigo.id+" "+amigo.nombre);
				 
				 //añadir en la lista un LI
				 
				 $('#listaAmigos').append('<li>'+amigo.nombre+'</li>')
				 
			 });
			 }
		 }
		 
		
		
		</script>
<%@ include file="core/model/forms/modificar.jsp"%>