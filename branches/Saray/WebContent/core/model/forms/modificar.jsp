<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="buscador.jsp"%>
<div class="contain">
	<%
		String msg = (String) request.getAttribute("mensaje");
		if (msg == null) {
			msg = "";
		}
	%>
	<p class="errores"><%=msg%></p>
	<p class="txt">Seleccionalo de la lista</p>
	<ul class="amigos modify">



		<li>
			<form action="main" method="post">
			
			<% 
			
ArrayList<Amigo> listaAmigosBuscador = (ArrayList<Amigo>) request.getAttribute("listaAmigosBuscador");
			if(listaAmigosBuscador != null){
			if (listaAmigosBuscador.size() > 0) {
				for (int i = 0; i < listaAmigosBuscador.size(); i++) {
	%>
	<input type="submit" name="accion" value="<%=listaAmigosBuscador.get(i).getNombre()%>" onclick="mostrarDetalle()">
			
				
			</form>
		</li>

	</ul>
</div>




<div class="contain">
	<p class="titulo">Cuales son los datos de tu amigo:</p>


	<form method="post" action="main?seccion=modificar">

		<input type="text" placeholder="nombre" name="nombre"
			value="<%=listaAmigosBuscador.get(i).getNombre()%>"> <input type="text"
			placeholder="apellido" name="apellido" value="<%=listaAmigosBuscador.get(i).getApellido()%>">
		<input type="text" placeholder="calle" name="calle"
			value="<%=listaAmigosBuscador.get(i).getCalle()%>"> <input type="text" pattern="[0-9]{5}"
			placeholder="cp 48004" name="cp" value="<%=listaAmigosBuscador.get(i).getCp()%>"> 
			<input type="text" placeholder="localidad" name="localidad"
			value="<%=listaAmigosBuscador.get(i).getLocalidad()%>"> <input type="text"
			placeholder="provincia" name="provincia" value="<%=listaAmigosBuscador.get(i).getProvincia()%>">
		<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999"
			name="movil" value="<%=listaAmigosBuscador.get(i).gettMovil()%>"> <input type="text"
			pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo"
			value="<%=listaAmigosBuscador.get(i).gettFijo()%>">
		<textarea name="anotaciones" placeholder="anotaciones">"<%=listaAmigosBuscador.get(i).getAnotaciones()%>"</textarea>
		<input type="hidden" name="id" value="<%=listaAmigosBuscador.get(i).getId()%>">



		<div class="botones">

			<input type="submit" value="modificar" name="accion"
				class="boton modificar">
				<input type="hidden" name="seccion" value="buscar">
		</div>
		
	
		<%
				}}else{
			out.println("no hay datos del amigo");
		}
		
	}%>
	</form>
</div>
