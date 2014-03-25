
<%String form=(String)request.getAttribute("form");
  

%>
<div class="contain">
	<p class="titulo">Busca a tu amigo:</p>



	<form method="post" action="agenda?operacion=buscar">
		<input id="aSearch" type="text" placeholder="nombre que buscas..." name="nombre"
			value=""> <input type="hidden" name="op" value="<%=form%>">
		<div class="botones">

			<input type="submit" value="buscar" name="buscar"
				class="boton buscar">
		</div>
	</form>
</div>