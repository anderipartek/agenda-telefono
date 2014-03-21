<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>


<%
	int todOk = 0;
	int id = -1;
	String amigoB ="";
	// RECOGER PARAMETROS DE TODOOK E ID
	if (request.getAttribute("todoOk") != null) {
		todOk = (Integer) request.getAttribute("todoOk");
	}
	if (request.getAttribute("id") != null) {
		id = (Integer) request.getAttribute("id");
	}
	
	%>
<div class="contain">
	<p class="titulo">Busca a tu amigo:</p>
	<form method="post" action="agenda">				
		<input type="text" placeholder="nombre que buscas..." name="nombreBusqueda" value="nombre">
		<div class="botones">
			<input type="submit" value="buscar" name="op" class="boton buscar">
				<input type="hidden" value="modificar" name="busqueda">
		</div>
	</form>
</div>
	
	
<div class="contain">
		<%// SI HA SIDO MODIIFCADO MOSTRAMOS MENSAJE DE QUE HA SIDO ELIMINADO
	if(request.getAttribute("modificadoSi") != null) {
		amigoB = (String) request.getAttribute("amigo");
		%><p class='txt'>Se ha modificado a <%=amigoB.toUpperCase() %> con éxito</p><%
	}			
	// SI TODOOK ES DISTINTO DE 0 SE HAN ENCONTRADO CONTACTOS Y NO SE HA SELECCIONADO A QUIEN MODIFICAR
	if (todOk > 0 && id == -1){
		if(todOk == 1) { // PARA SELECCIONAR A UN AMIGO DE LA LISTA	ENCONTRADO
		HashMap<Integer,Amigo> listaAmigos = (HashMap<Integer,Amigo>) request.getAttribute("listaAmigos");
		%>
		<p class="txt">Seleccionalo de la lista</p>
		<ul class="amigos modify">
		<%
			for (int i = 1 ; i <= listaAmigos.size(); i++) { 
				Amigo amigo = listaAmigos.get(i);
				String nombreApe = amigo.getNombre() + " " + amigo.getApellido();
			%>
				<li>
					<form action="agenda" method="get">
						<input type="submit" name="amigo" value="<%=nombreApe%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>">
						<input type="hidden" name="id" value="<%=amigo.getId()%>">
						<!-- input type="hidden" name="amigoUpdate" value="<%--=amigo --%>"-->
						<input type="hidden" name="op" value="modificar">
					</form>
				</li>
			<%} // END FOR%>
			</ul>
		<%} else if (todOk == 2) { // NO SE HA ENCONTRADO A CONTACTOS EN LA LISTA
			%><p class="txt">No se han encontrado contactos</p><%
		} 
	
	} else if (id != -1) {%>
		<p class="titulo">Cuales son los nuevos datos de tu amigo:</p>
			<%Amigo amigo = (Amigo) request.getAttribute("amigoDatos");%>
			<form method="post" action="agenda">				
				<input type="text" placeholder="nombre (minimo 2 caracteres)" required="required" name="nombre" value="<%=amigo.getNombre()%>">
				<input type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
				<input type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
				<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<%=amigo.getCodigoPostal()%>">
				<input type="text" placeholder="localidad" name="localidad" value="<%=amigo.getLocalidad()%>">
				<input type="text" placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>">
				<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=amigo.getMTelefono()%>">
				<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFTelefono()%>">
				<textarea name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones()%></textarea>
				<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>">
				<input type="hidden" name="id" value="<%=amigo.getId()%>">
				
				<div class="botones">
					<a title="" href="index.jsp">cancelar</a>
					<input type="submit" value="modificar" name="op" class="boton modificar">
				</div>
			</form>
		<%} %>
</div>