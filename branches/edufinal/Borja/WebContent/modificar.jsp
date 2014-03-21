<%@page import="java.util.ArrayList"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			
			<%
			ArrayList<String> listaAmigos = new ArrayList<String>();
			
			for (int i = 0 ; i < listaAmigos.size(); i++) { %>
				<li>
					<form action="agenda" method="post">
					
						<input type="submit" name="amigo" value="<%=listaAmigos.get(i)%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="Erlantz">
						<input type="hidden" name="id" value="<%=i %>>">
					</form>
				</li>
				<%} %>
			
			</ul>
		</div>
<%@ include file="core/model/forms/modificar.jsp"%>