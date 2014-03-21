<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<div class="contain">
	<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

	<!--  ?php

		// enviamos la query
		$id = comillas_inteligentes($_POST['id']);
		$query = "SELECT * FROM amigos WHERE nombre LIKE $nombre and id = $id";

		$result = mysql_query($query);
		//comprobamos si la query ha ido bien
		if(!$result){
			die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
		}

		while($result_row = mysql_fetch_array($result)){
		?-->
		
	<%
		Amigo amigo = (Amigo) request.getAttribute("amigoeliminar");
	if(amigo!=null){

	%>
	<%=amigo.getNombre() %> <%=amigo.getApellido() %></td>
	
	

	<form method="post" action="agenda">
		<input type="hidden" name="id" value="<%=amigo.getId()%>"> <input
			type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
			type="hidden" name="apellido" value="<%=amigo.getApellido()%>">
		<input type="hidden" name="op" value="eliminar">
		
	
	<%}%>
	
	<%Amigo mensaje = (Amigo) request.getAttribute("amigoeliminado");
	if(mensaje!=null){%>
	<%@ include file="../../../mensaje.jsp" %>
	
	<%} %>

		<div class="botones">
			<a title="" href="index.jsp">cancelar</a> <a title=""
				href="todoOk.jsp"> 
				<input type="submit" value="eliminar" name="eliminar" class="boton eliminar" onClick="if(!confirm('¿Seguro que deseas eliminar el registro?')){return false;}"  >
			</a>
		</div>
	</form>
	<!-- ?php
		}
		?-->
</div>

