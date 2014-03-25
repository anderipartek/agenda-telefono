<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
	<p class="titulo">Borrar amigo</p>

	<%@include file="buscador.jsp"%>
	<div class="contain" id="listContainer">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify" id="listaAmigosModificar">

			</ul>
		</div>
		
	<%
		if (request.getAttribute("amigo") != null){
			Amigo amigo = (Amigo)request.getAttribute("amigo");
			%>		
				<form method="post" action="main">
					<input disabled type="text" placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
					<input disabled type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
					<input disabled type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
					<input disabled type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp"	value="<%=amigo.getCp()%>"> 
					<input disabled type="text" placeholder="localidad"	name="localidad" value="<%=amigo.getLocalidad()%>"> 
					<input disabled type="text"	placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>"> 
					<input	disabled type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=amigo.getMovil()%>"> 
					<input disabled type="text" pattern="[0-9]{9}"	placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo()%>">
					<textarea disabled name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones()%></textarea>
					<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
						type="hidden" name="id" value="<%=amigo.getId()%>">
			
					<div class="botones">
						<a title="" href="main">cancelar</a> 
						<input type="submit" value="eliminar" name="operacion" class="boton modificar" onClick="if(!confirm('¿Seguro que deseas eliminar el amigo?')){return false;}">
					</div>
				</form>		
			<%
		}
	%>
	
</div>

<script src="js/jquery-2.1.0.min.js"></script>	
	
<script>

var url = 'servletAjax';
var amigos; //Array de Amigos recuperados de la llamada Ajax

$(document).ready(function() {
	console.debug('ready....');	
	//selecionar campo texto
	var asearch = $('#asearch');

	//Llamada Ajax sobre el evento KEYUP 
	asearch.keyup(function() {			
		console.debug( asearch.val() );
		//TODO llamar Ajax
		$.ajax( url , {
			"type": "get", // usualmente post o get
			"success": function(data) {
				amigos=data;					
				cargarLista(data);
			},
			"error": function(error) {
				console.error("Este callback maneja los errores " + error);
			},
			"data": { search: asearch.val() },
			"async": true,
		});						
	});


	//Capturar evento click sobre lista busqueda
	$('#listaAmigos').on('click','li',function(){
		console.log($(this).index() );
		//obtenmos el amigo seleccionado
		var amigo = amigos[$(this).index()];				
		
		//rellenar formulario
		$('#formulario input[name=nombre]').val( amigo.nombre );
		$('#formolario input[name=apellido]').val(amigo.apellido);
		
	});
			
});	

function cargarLista( data ){
	console.log("Comenzamos a cargar las lista con: " + data);
			
	//limpiar lista
	$('#listaAmigos').empty();

	//TODO cotrolar si no existen resultados
	
	//iteramos sobre los datos recividos
	$.each( data, function(index, amigo ){
		console.debug( index + " " + amigo.id + " " + amigo.nombre );			
		//añadir en la lista un LI
		$('#listaAmigos').append('<li>' + amigo.nombre + ' ' + amigo.apellido +'</li>');
		
	});
}	


function cargarFormulario(){
		console.debug('cargarFormulario');
}
</script>