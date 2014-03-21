<%@page import="com.ipartek.agenda.database.DAOAmigo"%>

<div class="contain">
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

	<%@include file="buscador.jsp"%>
	
	<div class="contain" id="listContainer">
		<p id="listContainerTitle" class="txt"></p>
		<ul class="amigos modify" id="listaAmigosModificar">
		</ul>
	</div>

	<form method="post" onSubmit="checkForm(this)" id="formEliminar"
		action="main?<%=MainServlet.OPERACION%>=<%=MainServlet.OPERACION_ELIMINAR%>">
		<input type="hidden" name="<%=DAOAmigo.NOMBRE %>"
			value="${amigo.nombre}"> <input type="hidden"
			name="<%=DAOAmigo.ID %>" value="${amigo.id}"> <input
			type="hidden" name="<%=DAOAmigo.APELLIDO%>" value="${amigo.apellido}">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="eliminar" name="eliminar" class="boton eliminar">
		</div>
	</form>

</div>

<script>
	var list;
	$(document).ready(function() { // When the HTML DOM is ready loading, then execute the following function...
		$('#btnbuscar').click(function() { // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
			search();
		});
	
		$('#textbuscar').keyup(function() {
		    search();
		});
		
		function search(){
			$.get('main?<%=MainServlet.SECCION%>=<%=MainServlet.MODIFICAR%>&<%=MainServlet.NOMBRE_A_BUSCAR%>=' + $('#textbuscar').val(), function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...	
				fillList(responseText)
			});
		}
		
		function fillList(data) {
			$("#listaAmigosModificar").empty();
			list = jQuery.parseJSON(data);
			if (list.length > 0) {
				$("#listContainerTitle").empty().append('Seleccionalo de la lista');
				for (var i=0; i < list.length; i++){
					fillItem(list[i], i);
				}
			} else {
				$("#listContainerTitle").empty().append('Lista vacia');
			}
		};
		
		function drawContainer(){
			$('#listContainer').append('<p class="txt">Seleccionalo de la lista</p>')
				.append('<ul class="amigos modify" id="listaAmigosModificar">')
				.append('</ul');
		}
		
		function fillItem(data, pos) {
			$("#listaAmigosModificar").append('<li><form method="post" onSubmit="return loadForm(this)"></li>');
			$('#listaAmigosModificar li:last-child form')
				.append('<input type="submit" name="amigo" value="' + data.nombre + ' ' + data.apellido  + '">')
				.append('<input type="hidden" name="buscar" value="ok">')
				.append('<input type="hidden" name="nombre" value="' + data.nombre + '">')
				.append('<input type="hidden" name="id" value="' +  + '">')
				.append('<input type="hidden" name="pos" value="' + pos + '">');
		}
		
	});
	
	function loadForm(form) {
		console.log(form.pos.value);
		
		var data = list[form.pos.value];
		$("#formBuscador input[name=nombre]").val(data.nombre);
		
		$("#formEliminar input[name=nombre]").val(data.nombre);
		$("#formEliminar input[name=apellido]").val(data.apellido);
		$("#formEliminar input[name=id]").val(data.id);

		return false;
	}
	
	function checkForm(form) {
		var isComplete = true;
		$("#errores").empty();
		console.log(form.id.value);
		if (!form.<%=DAOAmigo.ID%>.value)
		{
			$("#errores").append('<li><p>Tiene que seleccionar el amigo de la lista</p></li>');
			isComplete = false;			
		}
		return isComplete;
	}
	
</script>