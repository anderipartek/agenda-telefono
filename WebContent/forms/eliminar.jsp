
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">

	<%@include file="../mensaje.jsp"%>	
	
	<%@include file="buscador.jsp"%>
	<div class="contain" id="listContainer">

		</div>
		
		<%
		if (request.getAttribute("amigo") != null){
			Amigo amigo = (Amigo)request.getAttribute("amigo");
			if (amigo != null){
			%>		
				<form method="post">
					<p>¿Desea eliminar realmente a su amigo?</p>
					<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
						type="hidden" name="id" value="<%=amigo.getId()%>">
			
					<div class="botones">
						<a title="" href="main">cancelar</a> <input type="submit"
							value="eliminar" name="operacion" class="boton modificar">
					</div>
				</form>		
			<%}
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
			$.get('main?<%=MainServlet.SECCION%>=<%=MainServlet.BUSCAR%>&<%=MainServlet.NOMBRE_A_BUSCAR%>=' + $('#textbuscar').val(), function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...	
				console.log(responseText);
				fillList(responseText)
			});
		}
		
		var list;
		function fillList(data) {
			$("#listContainer").empty();
			
			list = jQuery.parseJSON(data);
			drawContainer();
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