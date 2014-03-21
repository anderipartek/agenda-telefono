	<%@include file="inc/head.jsp"%>
	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
		
		<form method="post" action="agendaAñadirServlet">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text"  placeholder="cp 48004" name="cp" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" placeholder="movil 999999999" name="movil" value="">
			<input type="text" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="anadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>
<%@ include file="inc/footer.jsp"%>
	