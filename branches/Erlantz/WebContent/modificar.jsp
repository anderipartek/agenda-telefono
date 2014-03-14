<%@page import="java.util.ArrayList"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			<!-- ?php
			// mostramos los datos de la query
			while($result_row = mysql_fetch_array($result)){
			
			?-->
			<%
			ArrayList<String> lista = new ArrayList<String>();
			lista.add("Erlantz Romero");
			lista.add("Manolo Gisasola");
			lista.add("Manola Gisasola");
			lista.add("Manolito Abertxale");
			for (int i = 0 ; i < lista.size(); i++) { %>
				<li>
					<form action="<?php htmlentities($_SERVER['PHP_SELF']); ?>" method="post">
					
						<input type="submit" name="amigo" value="<%=lista.get(i)%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="Erlantz">
						<input type="hidden" name="id" value="<%=i %>>">
					</form>
				</li>
				<%} %>
			<!-- ?php
			}
			?-->
			</ul>
		</div>
<%@ include file="core/model/forms/modificar.jsp"%>
<%@ include file="todoOk.jsp"%>