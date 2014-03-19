<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
		

		<%
		if(request.getAttribute("amigo") != null){
			String amigo = (String) request.getAttribute("amigo");
			int id = (Integer)request.getAttribute("id");
			%>
			<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
			<form method="post" action="agenda">				
				<input type="hidden" name="nombre" value=<%=amigo%>>
				<input type="hidden" name="id" value=<%=id%>>			
				<!--input type="hidden" name="apellido" value=<%--=amigo[2].toString()--%>-->
				
				<div class="botones">
					<a title="" href="index.jsp">cancelar</a>
					<!--a title="" href="todoOk.jsp"-->
					<input type="submit" value="eliminar" name="op" class="boton eliminar">
					</a>
				</div>
			</form>
		<%} %>
	</div>

