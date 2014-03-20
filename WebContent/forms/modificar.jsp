<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
	<%
		if (request.getAttribute("operacion_modificar")!= null && request.getAttribute("operacion_modificar") == "ok"){
			%><p class="titulo">Amigo modificado</p><%
		}
	
	%>
		<%@include file="buscador.jsp"%>
		<div class="contain" id="listContainer">

		</div>
	
	<%
		if (request.getAttribute("amigo") != null){
			Amigo amigo = (Amigo)request.getAttribute("amigo");
			%>		
				<p class="titulo">Modifica sus datos:</p>
				<form method="post">
					<input type="text" placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
					<input type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
					<input type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
					<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp"
						value="<%=amigo.getCp()%>"> <input type="text" placeholder="localidad"
						name="localidad" value="<%=amigo.getLocalidad()%>"> <input type="text"
						placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>"> <input
						type="text" pattern="[0-9]{9}" placeholder="móvil 999999999"
						name="movil" value="<%=amigo.getMovil()%>"> <input type="text" pattern="[0-9]{9}"
						placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo()%>">
					<textarea name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones()%></textarea>
					<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
						type="hidden" name="id" value="<%=amigo.getId()%>">
			
					<div class="botones">
						<a title="" href="main">cancelar</a> <input type="submit"
							value="modificar" name="operacion" class="boton modificar">
					</div>
				</form>		
			<%
		}
	
	
	%>

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
				.append('</ul>');
		}
		
		function fillItem(data) {
			$("#listaAmigosModificar").append('<li><form method="post" action="main"></form></li>');
			$('#listaAmigosModificar li:last-child form')
				.append('<input type="submit" name="amigo" value="' + data.nombre + ' ' + data.apellido  + '">')
				.append('<input type="hidden" name="operacion" value="mostrar">')
				.append('<input type="hidden" name="nombre" value="' + data.nombre + '">')
				.append('<input type="hidden" name="id" value="' + data.id + '">');
		}
		

	});
</script>

