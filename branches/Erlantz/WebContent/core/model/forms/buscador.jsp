<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.HashMap"%>
<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombreBusqueda" value="nombre">
			<div class="botones">
				<input type="submit" value="buscar" name="op" class="boton buscar">
			</div>
		</form>
	</div>