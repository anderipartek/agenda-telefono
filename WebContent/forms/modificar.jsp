<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.database.DAOAmigo"%>

<div class="contain">

	<c:set var="isAlumno"
		value='<%=request.getAttribute(MainServlet.OPERACION_MODIFICAR)%>' />
	<c:set var="alumno"
		value='<%=request.getAttribute(MainServlet.AMIGO)%>' />
	<c:set var="error" value='<%=request.getAttribute(MainServlet.ERROR)%>' />

	<c:if test="${not empty isAlumno}">
		<ul>
			<li><p>Ha modificado al amigo ${alumno.nombre}</p></li>
		</ul>
	</c:if>

	<c:if test="${not empty error}">
		<ul>
			<li><p>${error}</p></li>
		</ul>
	</c:if>

	<ul class="errores" id="errores">
	</ul>


	<p class="titulo">Cuales son los datos de tu amigo:</p>

	<%@include file="buscador.jsp"%>
	<div class="contain" id="listContainer">
		<p id="listContainerTitle" class="txt"></p>
		<ul class="amigos modify" id="listaAmigosModificar">
		</ul>
	</div>

	<form method="post" id="modificacion" onSubmit="return checkForm(this)">
		<input type="text" placeholder="nombre" name=<%=DAOAmigo.NOMBRE%> value="${alumno.nombre}">
		<input type="text" placeholder="apellido" name=<%=DAOAmigo.APELLIDO%> value="${alumno.apellido}">
		<input type="text" placeholder="calle" name=<%=DAOAmigo.CALLE%> value="${alumno.calle}">
		<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name=<%=DAOAmigo.CP%> value="${(alumno.cp > 0) ? '':alumno.cp}">
		<input type="text" placeholder="localidad" name=<%=DAOAmigo.LOCALIDAD%> value="${alumno.localidad}">
		<input type="text" placeholder="provincia" name="provincia" value="${alumno.provincia}">
		<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name=<%=DAOAmigo.MOVIL%> value="${(alumno.movil > 0) ? '':alumno.movil}">
		<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name=<%=DAOAmigo.FIJO%> value="${(alumno.fijo > 0) ? '':alumno.fijo}">
		<textarea name=<%=DAOAmigo.ANOTACIONES%> placeholder="anotaciones">${alumno.anotaciones}</textarea>
		<!-- 		<input type="hidden" name="nombre" value=""> -->
		<input type="hidden" name="id" value="">
		<input type="hidden" name=<%=MainServlet.OPERACION%> value=<%=MainServlet.OPERACION_MODIFICAR%>>
		<div class="botones">
			<a title="" href="main">cancelar</a>
		<input type="submit" value="modificar" name="modificar" class="boton modificar">
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
				fillList(responseText);
			});
		}
		
		function fillList(data) {
			$("#listaAmigosModificar").empty();

			list = jQuery.parseJSON(data);
			if (list.length > 0) {
				$("#listContainerTitle").empty().append('Seleccionalo de la lista');
				
				$.each(list, function(pos, data) {
					$("#listaAmigosModificar").append('<li></li>');
					$('#listaAmigosModificar li:last-child')
						.append('<input type="submit" name="amigo" value="' + data.nombre + ' ' + data.apellido  + '">')
						.append('<input type="hidden" name="pos" value="' + pos + '">');
				});
				
			} else {
				$("#listContainerTitle").empty().append('<p style="color:red">No tuvo exito su busqueda, por favor intentelo con otro nombre</p>');
			}
		};
		
		$("#listaAmigosModificar").on('click', 'li', function(){
			loadData($(this).index());
		});
		
		function drawContainer(){
			$('#listContainer').append('<p class="txt">Seleccionalo de la lista</p>')
				.append('<ul class="amigos modify" id="listaAmigosModificar">')
				.append('</ul');
		}
		
		function drawListEmpty(){
			
		}
	});
	
	function loadData(index) {
		console.log(index);
		
		var data = list[index];
		$("#modificacion input[name=id]").val(data.id);
		$("#modificacion input[name=nombre]").val(data.nombre);
		$("#modificacion input[name=apellido]").val(data.apellido);
		$("#modificacion input[name=calle]").val(data.calle);
		if (data.cp != -1)
			$("#modificacion input[name=CP]").val(data.cp);
		$("#modificacion input[name=localidad]").val(data.localidad);
		$("#modificacion input[name=provincia]").val(data.provincia);
		if (data.movil != -1)
			$("#modificacion input[name=movil]").val(data.movil);
		if (data.fijo != -1)
			$("#modificacion input[name=fijo]").val(data.fijo);
		$("#modificacion textarea[name=anotaciones]").val(data.anotaciones);

		return false;
	}
	
	function checkForm(form) {
		var isComplete = true;
		$("#errores").empty();
		if (!form.<%=DAOAmigo.NOMBRE%>.value)
		{
			$("#errores").append('<li><p>Necesitamos saber su nombre</p></li>');
			isComplete = false;			
		}
		console.log(form.movil.value)
		if (!form.<%=DAOAmigo.MOVIL%>.value) {
			$("#errores").append(
					'<li><p>Necesitamos saber su teléfono móvil</p></li>');
			isComplete = false;
		}
		return isComplete;
	}
	

// 	Inicializar tinyMCE
	tinymce.init({
	    selector: "textarea",
	    theme: "modern",
	    plugins: [
	        "advlist autolink lists link image charmap print preview hr anchor pagebreak",
	        "searchreplace wordcount visualblocks visualchars code fullscreen",
	        "insertdatetime media nonbreaking save table contextmenu directionality",
	        "emoticons template paste textcolor"
	    ],
	    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
	    toolbar2: "print preview media | forecolor backcolor emoticons",
	    image_advtab: true,
	    templates: [
	        {title: 'Test template 1', content: 'Test 1'},
	        {title: 'Test template 2', content: 'Test 2'}
	    ]
	});
</script>