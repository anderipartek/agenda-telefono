
<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
	<p class="titulo">Busca a tu amigo:</p>

	<!--<?php if($error != false){ ?>-->
	<!-- 	<ul class="errores"> -->
	<!--<?php if($_POST['nombre'] == '') ?>-->
	<!-- 		<li><p>El campo nombre lo necesitamos</p></li> -->
	<!-- 	</ul> -->
	<!--<?php } ?>-->

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