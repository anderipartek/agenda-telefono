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
					<form action="agenda" method="post">
					
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
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="erlantz">
			<input type="text" placeholder="apellido" name="apellido" value="romero">
			<input type="text" placeholder="calle" name="calle" value="ibarreko">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="48004">
			<input type="text" placeholder="localidad" name="localidad" value="barakaldo">
			<input type="text" placeholder="provincia" name="provincia" value="bizkaia">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="666666666">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="999999999">
			<textarea name="anotaciones" placeholder="anotaciones">erlantz romero</textarea>
			<input type="hidden" name="nombre" value="erlantz">
			<input type="hidden" name="id" value="0">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="op" class="boton modificar">
			</div>
		</form>

	</div>