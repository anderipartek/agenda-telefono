
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.database.DAOAmigo"%>
<div class="contain">
	<p class="titulo">Cuales son los datos de tu amigo:</p>

	<c:set var="alumno" value='<%=request.getAttribute(MainServlet.OPERACION_ANADIR)%>' />
	<c:set var="error" value='<%=request.getAttribute(MainServlet.ERROR)%>' />
	
	<c:if test="${not empty alumno}">
	<ul>
		<li><p>Ha añadido al amigo ${alumno.nombre}</p></li>
	</ul>
	</c:if>
	
	<c:if test="${not empty error}">
	<ul>
		<li><p>${error} </p></li>
	</ul>
	</c:if>
	
	<ul class="errores" id="errores">
	</ul>


	<form method="post" onSubmit="return checkForm(this)">
		<input type="hidden" name=<%=MainServlet.OPERACION%>
			value=<%=MainServlet.OPERACION_ANADIR%>> <input type="text"
			placeholder="nombre" name=<%=DAOAmigo.NOMBRE%> value="" size="25">
		<input type="text" placeholder="apellido" name=<%=DAOAmigo.APELLIDO%>
			value="" size="50"> <input type="text" placeholder="calle"
			name=<%=DAOAmigo.CALLE%> value="" size="50"> <input
			type="text" pattern="[0-9]{5}" placeholder="cp 48004"
			name=<%=DAOAmigo.CP%> value="" size="5"> <input type="text"
			placeholder="localidad" name=<%=DAOAmigo.LOCALIDAD%> value=""
			size="50"> <input type="text" placeholder="provincia"
			name=<%=DAOAmigo.PROVINCIA%> value="" size="50"> <input
			type="text" pattern="[0-9]{9}" placeholder="móvil 999999999"
			name=<%=DAOAmigo.MOVIL%> value="" size="9"> <input
			type="text" pattern="[0-9]{9}" placeholder="fijo 999999999"
			name=<%=DAOAmigo.FIJO%> value="" size="9">
		<textarea name=<%=DAOAmigo.ANOTACIONES%> placeholder="anotaciones"></textarea>

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="añadir" name="anadir" class="boton anadir">
		</div>
	</form>
</div>
<script type="text/javascript">
	function checkForm(form) {
		var isComplete = true;
		$("#errores").empty();
		if (!form.<%=DAOAmigo.NOMBRE%>.value)
		{
			$("#errores").append('<li><p>Necesitamos saber su nombre</p></li>');
			isComplete = false;			
		}
		if (!form.<%=DAOAmigo.MOVIL%>.value)
		{
			$("#errores").append('<li><p>Necesitamos saber su teléfono móvil</p></li>');
			isComplete = false;			
		}
		return isComplete;
	}
</script>
