
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

	<%

		// enviamos la query
// 		$id = comillas_inteligentes($_POST['id']);
// 		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

// 		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
// 		if(!$result){
// 			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
// 		}

// 		while($result_row = mysql_fetch_array($result)){
		%>
	
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
				<form method="post">
					<input disabled type="text" placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
					<input disabled type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
					<input disabled type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
					<input disabled type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp"
						value="<%=amigo.getCp()%>"> <input disabled type="text" placeholder="localidad"
						name="localidad" value="<%=amigo.getLocalidad()%>"> <input disabled type="text"
						placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>"> <input
						disabled type="text" pattern="[0-9]{9}" placeholder="móvil 999999999"
						name="movil" value="<%=amigo.getMovil()%>"> <input disabled type="text" pattern="[0-9]{9}"
						placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo()%>">
					<textarea disabled name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones()%></textarea>
					<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
						type="hidden" name="id" value="<%=amigo.getId()%>">
			
					<div class="botones">
						<a title="" href="main">cancelar</a> <input type="submit"
							value="eliminar" name="operacion" class="boton modificar"
							onClick="if(!confirm('¿Seguro que deseas eliminar el amigo?')){return false;}">
					</div>
				</form>		
			<%
		}
	%>
	

<script>
	$(document).ready(function() { // When the HTML DOM is ready loading, then execute the following function...
		$('#btnbuscar').click(function() { // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
			search();
		});
	
		$('#textbuscar').keyup(function() {
		    search();
		});
		
		function search(){
			$.get('main?<%=MainServlet.SECCION%>=<%=MainServlet.MODIFICAR%>&<%=MainServlet.NOMBRE_A_BUSCAR%>=' + $('#textbuscar').val(), function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...	
				console.log(responseText);
				fillList(responseText)
			});
		}
		
		var list;
		function fillList(data) {
			$("#listaAmigosModificar").empty();

			list = jQuery.parseJSON(data);
			for (var i=0; i < list.length; i++){
				fillItem(list[i]);
			}
		};
		
		function drawContainer(){
			$('#listContainer').append('<p class="txt">Seleccionalo de la lista</p>')
				.append('<ul class="amigos modify" id="listaAmigosModificar">')
				.append('</ul');
		}
		
		function fillItem(data) {
			$("#listaAmigosModificar").append('<li><form method="post" action="main"></form></li>');
			$('#listaAmigosModificar li:last-child form')
				.append('<input type="submit" name="amigo" value="' + data.nombre + ' ' + data.apellido  + '">')
				.append('<input type="hidden" name="operacion" value="mostrarEliminar">')
				.append('<input type="hidden" name="nombre" value="' + data.nombre + '">')
				.append('<input type="hidden" name="id" value="' + data.id + '">');
		}
		

	});
</script>


</div>