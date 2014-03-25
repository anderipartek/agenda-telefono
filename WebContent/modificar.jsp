<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>


<%
	int todOk = 0;
	int id = -1;
	String amigoB = "";
	// RECOGER PARAMETROS DE TODOOK E ID
	if (request.getAttribute("todoOk") != null) {
		todOk = (Integer) request.getAttribute("todoOk");
	}
	if (request.getAttribute("id") != null) {
		id = (Integer) request.getAttribute("id");
	}
%>
<div class="contain">
	<p class="titulo">Busca a tu amigo:</p>
	<form method="post" action="agenda">
		<input id="asearch" type="text" placeholder="amigo que buscas..."
			name="nombreBusqueda" value="">
		<div class="botones">
			<input type="submit" value="buscar" name="op" class="boton buscar">
			<input type="hidden" value="modificar" name="busqueda">
		</div>
	</form>
</div>


<div class="contain">

	<p class="txt">Seleccionalo de la lista</p>
	<ul id="listaAmigos" class="amigos modify">
		<li>Busca un Amigos para modificar</li>
		<!-- li>
			<form action="agenda" method="get">
				<input type="submit" name="amigo" value="aaa"> <input
					type="hidden" name="buscar" value="ok"> <input
					type="hidden" name="nombre" value="aaa">
				<input type="hidden" name="id" value="aaa">
				<input type="hidden" name="op" value="modificar">
			</form>
		</li -->

	</ul>


	<p class="titulo">Cuales son los nuevos datos de tu amigo:</p>

	<form id="formulario" method="post" action="agenda">
		<input type="text" placeholder="nombre (minimo 2 caracteres)"
			required="required" name="nombre" placeholder="nombre"> <input
			type="text" placeholder="apellido" name="apellido"> <input
			type="text" placeholder="calle" name="calle"> <input
			type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP">
		<input type="text" placeholder="localidad" name="localidad"
			placeholder="localidad"> <input type="text"
			placeholder="provincia" name="provincia"> <input type="text"
			pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil">
		<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999"
			name="fijo">
		<textarea name="anotaciones" placeholder="anotaciones"></textarea>
		<input type="hidden" name="id" value="">

		<div class="botones">
			<a title="" href="index.jsp">cancelar</a> <input type="submit"
				value="modificar" name="op" class="boton modificar">
		</div>
	</form>

</div>


<script src="js/tinymce/tinymce.min.js"></script>
<script src="js/jquery-2.1.0.min.js"></script>
<script>
	//aplicar TinyMce al campo anotaciones
	tinymce.init({
        mode : "textareas",
        editor_selector : "mceSimple",
        selector:'textarea'
	});
	
	var url = 'servletAjax';
	var amigos; //Array de amigos recuperados de la llamada AJAX
	$(document).ready(function() {
		console.info('jquery cargado');
		//selecionar campo texto
		var asearch = $('#asearch');

		// Evento AJAX keyUp
		asearch.keyup(function() {

			console.debug(asearch);
			//TODO llamar AJAX
			$.ajax(url, {
				"type" : "get", // usualmente post o get
				"success" : function(data) {
					amigos = data;
					cargarLista(data);
				},
				"error" : function(error) {
					console.error('Este callback maneja los errores ' + error);
				},
				"data" : {
					search : asearch.val()
				},
				"async" : true,
			});
		});

		$('#listaAmigos').on('click', 'li', function() {
			console.log($(this).index());
			//Obtenemos el amigo seleccionado
			var amigo = amigos[$(this).index() + 1];

			console.debug(amigo);
			$('#formulario input[name=nombre]').val(amigo.nombre);
			$('#formulario input[name=apellido]').val(amigo.apellido);
			$('#formulario input[name=CP]').val(amigo.codigoPostal);
			$('#formulario input[name=calle]').val(amigo.calle);
			$('#formulario input[name=provincia]').val(amigo.provincia);
			$('#formulario input[name=localidad]').val(amigo.localidad);
			$('#formulario input[name=movil]').val(amigo.mTelefono);
			$('#formulario input[name=fijo]').val(amigo.fTelefono);
			$('#formulario input[name=anotaciones]').val(amigo.anotaciones);
			$('#formulario input[name=anotaciones]').val(amigo.anotaciones);
			$('#formulario input[name=id]').val(amigo.id);

		});

	});

	function cargarLista(data) {
		console.log('Comenzamos a cargar la lista con: ' + data);
		//si tiene asignado la clase .txt.error la elimina, sino tiene no hace nada
		$('#listaAmigos').removeClass('txt error');
		//Iteramos sobre los datos recibidos
		$('#listaAmigos').empty();
		$('#listaAmigos li').addClass('lista');
		//TODO controlar si no existen resultados
		var cont = getPropertyCount(amigos);
		// Si hay datos mostramos la lista, en caso contrario mostramos mensaje de error
		if (cont > 0) {
			$('#listaAmigos').addClass('amigos modify');
			$.each(data,
					function(index, amigo) {
						console.debug(index + " " + amigo.id + " "
								+ amigo.nombre);
						// añadir en la lista un li
						$('#listaAmigos').append(
								'<li>' + amigo.nombre + " " + amigo.apellido
										+ '</li>');
					});
		} else {
			$('#listaAmigos').addClass('txt error');
			$('#listaAmigos').append(
					'<p>No se han encontrado contactos</p>');
		}
	}

	// Funcion para contar cuantos objetos hay en el array
	function getPropertyCount(obj) {
		var count = 0, key;

		for (key in obj) {
			if (obj.hasOwnProperty(key)) {
				count++;
			}
		}

		return count;
	}
</script>