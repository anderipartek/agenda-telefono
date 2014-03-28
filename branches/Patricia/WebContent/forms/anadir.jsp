<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
		
		<%@include file="/inc/mensajes.jsp" %>
		
		<form method="POST" action="agenda">				
			<input type="hidden" placeholder="id" name="id" value="${requestScope.amigo.id}">		
			<input type="text" placeholder="nombre" name="nombre" value="${requestScope.amigo.nombre}">
			<input type="text" placeholder="apellido" name="apellido" value="${requestScope.amigo.apellido }">
			<input type="text" placeholder="calle" name="calle" value="${requestScope.amigo.calle}">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="${requestScope.amigo.cp}">
			<input type="text" placeholder="localidad" name="localidad" value="${requestScope.amigo.localidad}">
			<input type="text" placeholder="provincia" name="provincia" value="${requestScope.amigo.provincia}">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 666666666" name="movil" value="${requestScope.amigo.movil}">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="${requestScope.amigo.fijo}">
			<textarea name="anotaciones" placeholder="anotaciones">${requestScope.amigo.anotaciones}</textarea>
			
			<div class="botones">
				<a title="" href="index.jsp"><fmt:message key="boton.Cancelar" /></a>
				<input type="submit" value="<fmt:message key="boton.Aniadir" />" name="op" class="boton anadir">
			</div>
		</form>
	</div>

	