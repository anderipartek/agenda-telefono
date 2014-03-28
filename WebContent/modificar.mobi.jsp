<%@page import="com.ipartek.agenda.database.DAOAmigo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado Amigos | Version Movil</title>
	
	<link rel="stylesheet"  href="js/themes/default/jquery.mobile-1.4.2.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
    
	<script src="js/jquery.js"></script>
	<script src="js/jquery.mobile-1.4.2.min.js"></script>
</head>
<body>
	<!-- Home -->
	<div data-role="page" id="home">
		<%@include file="header.mobi.jsp"%>
		
		<%@include file="forms/buscador.jsp"%>
		<div class="contain" id="listContainer">
			<p id="listContainerTitle" class="txt"></p>
			<ul class="amigos modify" id="listaAmigosModificar">
			</ul>
		</div>
	
		<div role="main" data-role="content">
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
		
			<form method="post" id="modificacion" onSubmit="return checkForm(this)">
				<input type="text" placeholder="nombre" name=<%=DAOAmigo.NOMBRE%> value="${alumno.nombre}">
				<input type="text" placeholder="apellido" name=<%=DAOAmigo.APELLIDO%> value="${alumno.apellido}">
				<input type="text" placeholder="calle" name=<%=DAOAmigo.CALLE%> value="${alumno.calle}">
				<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name=<%=DAOAmigo.CP%> value="${(alumno.cp < 1) ? '':alumno.cp}">
				<input type="text" placeholder="localidad" name=<%=DAOAmigo.LOCALIDAD%> value="${alumno.localidad}">
				<input type="text" placeholder="provincia" name="provincia" value="${alumno.provincia}">
				<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name=<%=DAOAmigo.MOVIL%> value="${(alumno.movil < 1) ? '':alumno.movil}">
				<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name=<%=DAOAmigo.FIJO%> value="${(alumno.fijo < 1) ? '':alumno.fijo}">
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
		


		<div data-role="footer">
			<h4>IparSex servicios Informaticos 2014</h4>
			<p><a href="#politica" >Politica Privacidad</a></p>
		</div>
	</div><!-- /page -->
	
	<!--  Politica Privacidad -->
	<div data-role="page" id="politica">
		<div data-role="header">
			<h1>Politica Privacidad</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>

		<div data-role="content">
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ac neque sed diam vulputate accumsan. Donec lacinia aliquet justo, ac convallis nunc tristique ut. In hac habitasse platea dictumst. Sed euismod malesuada nunc, eget venenatis turpis sodales ac. Aliquam aliquet dui quam. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ultrices urna eu erat placerat pellentesque. Phasellus tincidunt porttitor laoreet. Donec suscipit magna vitae turpis elementum quis facilisis metus congue. </p>
		</div>
		<div data-role="footer">
			<h4>IparSex servicios Informaticos 2014</h4>
			
		</div>
	</div><!-- /page -->
</body>

<script type="text/javascript">
	var list;
	$(document).ready(function(){
		$.mobile.defaultPageTransition = 'slide';
		$.mobile.defaultDialogTransition = 'slideup';

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
	
</script>

</html>
