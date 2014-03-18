<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
	<p class="titulo">Cuales son los datos de tu amigo:</p>

		<div class="contain" id="listContainer">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify" id="listaAmigosModificar">
<!-- 				<li> -->
<%-- 					<form action="<?php htmlentities($_SERVER['PHP_SELF']); ?>" method="post"> --%>
<%-- 						<input type="submit" name="amigo" value="<?php echo $result_row[1] . ' ' . $result_row[2]; ?>"> --%>
<!-- 						<input type="hidden" name="buscar" value="ok"> -->
<%-- 						<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>"> --%>
<%-- 						<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>"> --%>
<!-- 					</form> -->
<!-- 				</li> -->
			</ul>
		</div>
	<%@include file="buscador.jsp"%>
	<c:set var="alumno" value='<%=request.getAttribute(MainServlet.OPERACION_MODIFICAR)%>' />

	<form method="post">
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
</div>



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
			$("#listaAmigosModificar").append('<li><form method="post" onSubmit="return loadAmigoInfo(this)">')
				.append('<input type="submit" name="amigo" value="' + data.nombre + ' ' + data.apellido  + '">')
				.append('<input type="hidden" name="buscar" value="ok">')
				.append('<input type="hidden" name="nombre" value="' + data.nombre + '">')
				.append('<input type="hidden" name="id" value="' + data.id + '">')
			.append('</form></li>');
		}
		
		function loadAmigoInfo(form){
			console.log("loadAmigoInfo " + form);
			console.log(form.id.value);
			return false;
		}
	});
</script>

