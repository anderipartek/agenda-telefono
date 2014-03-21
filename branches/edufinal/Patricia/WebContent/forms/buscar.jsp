	<%@page import="com.ipartek.agenda.controller.MainServlet"%>
<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="">
			
			<div class="botones">
				<input type="submit" value="<%=MainServlet.OP_BUSCAR %>" name="op" class="boton buscar">
			</div>
		</form>
	</div>