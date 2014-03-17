	<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.database.DAOAmigo"%>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

<%-- 		<% if($error != false){ %> --%>
			<ul class="errores">
<%-- 			<% if($_POST['nombre'] == '') %> --%>
				<li><p>Necesitamos saber su nombre</p></li>
<%-- 			<% if($_POST['movil'] == '') %> --%>
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>
<%-- 		<% } %> --%>
		
		
		<form method="post">
		<input type="hidden" name=<%=MainServlet.OPERACION%> value=<%=MainServlet.OPERACION_ANADIR%>>			
			<input type="text" placeholder="nombre" name=<%=DAOAmigo.NOMBRE%> value="" size="25">
			<input type="text" placeholder="apellido" name=<%=DAOAmigo.APELLIDO%> value="" size="50">
			<input type="text" placeholder="calle" name=<%=DAOAmigo.CALLE%> value="" size="50">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name=<%=DAOAmigo.CP%> value="" size="5">
			<input type="text" placeholder="localidad" name=<%=DAOAmigo.LOCALIDAD%> value="" size="50">
			<input type="text" placeholder="provincia" name=<%=DAOAmigo.PROVINCIA%> value="" size="50">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name=<%=DAOAmigo.MOVIL%> value="" size="9">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name=<%=DAOAmigo.FIJO%> value="" size="9">
			<textarea name=<%=DAOAmigo.ANOTACIONES%> placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>

	