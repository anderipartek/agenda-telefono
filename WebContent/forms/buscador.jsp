
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
	<p class="titulo">Busca a tu amigo:</p>

	<form method="get" onSubmit="return false">
		<input type="text" placeholder="nombre que buscas..." name="nombre"
			value="" id="textbuscar">
			
		<input type="hidden" name=<%=MainServlet.SECCION%>
			value=<%=MainServlet.OPERACION_MODIFICAR%>> 
			
		<div class="botones">
			<input type="submit" value="buscar" name="buscar"
				class="boton buscar" id="btnbuscar">
		</div>
	</form>
</div>