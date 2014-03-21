<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="com.ipartek.agenda.controller.AgendaServlet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>

<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombreBusqueda" value="nombre">
			<div class="botones">
				<input type="submit" value="buscar" name="op" class="boton buscar">
				<input type="hidden" value="eliminar" name="busqueda">
			</div>
		</form>
	</div>
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
	
	%><div class="contain"><%
 	// SI HA SIDO BORRADO MOSTRAMOS MENSAJE DE QUE HA SIDO ELIMINADO
	if(request.getAttribute("borradoSi") != null) {
		amigoB = (String) request.getAttribute("amigo");
		%><p class='txt'>Borrado realizado con éxito</p><%
	}			
	// SI TODOOK ES DISTINTO DE 0 SE HAN ENCONTRADO CONTACTOS Y NO SE HA SELECCIONADO A QUIEN BORRAR
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
						<input type="hidden" name="nombre" value="Erlantz">
						<input type="hidden" name="id" value="<%=listaAmigos.get(i).getId() %>">
						<input type="hidden" name="op" value="eliminar">
					</form>
				</li>
			<%} // END FOR%>
			</ul>
		<%} else if (todOk == 2){ // NO SE HA ENCONTRADO A CONTACTOS EN LA LISTA
				%><p class="txt">No se han encontrado contactos</p><%
			}
		} else if (id != -1) {
			// PARA MOSTRAR LAS OPCIONES DE BORRAR SEGURO
			if(request.getAttribute("amigo") != null){			
					%>
					
						<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
						<form method="post" action="agenda">	
							<p><%=amigoB%></p>			
							<input type="hidden" name="nombre" value=<%=amigoB%>>
							<input type="hidden" name="id" value=<%=id%>>
							
							<div class="botones">
								<a title="" href="index.jsp">cancelar</a>
								<input type="submit" value="eliminar" name="op" class="boton eliminar">
							</div>
						</form>
					
				<%} 
				%>
		</div>
	<%} //END ELSEIF ID!=-1%>	