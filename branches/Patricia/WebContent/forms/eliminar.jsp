
<!-- Obtener el id del alumno -->
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">

	<%@include file="buscar.jsp"%>

	<%@include file="/inc/mensajes.jsp"%>

	<%
		int eliminar = 0;
		if (request.getAttribute("eliminando") != null) {
			eliminar = Integer.parseInt((String) request.getAttribute("eliminando"));
		}
	
	if(eliminar>0){
	%>
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
	<form method="post" action="agenda">
		<input type="hidden" name="id" value="<%=eliminar%>">

		<div class="botones">
			<a title="" href="main">cancelar</a> <input type="submit"
				value="<%=MainServlet.OP_ELIMINAR%>" name="op"
				class="boton eliminar">
		</div>
	</form>

	<%} %>
</div>