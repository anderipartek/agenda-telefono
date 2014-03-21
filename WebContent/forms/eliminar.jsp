<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
	<p class="titulo">Borrar amigo</p>

	<%@include file="buscador.jsp"%>
	<div class="contain" id="listContainer">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify" id="listaAmigosModificar">

			</ul>
		</div>
		
	<%
		if (request.getAttribute("amigo") != null){
			Amigo amigo = (Amigo)request.getAttribute("amigo");
			%>		
				<form method="post" action="main">
					<input disabled type="text" placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
					<input disabled type="text" placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
					<input disabled type="text" placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
					<input disabled type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp"	value="<%=amigo.getCp()%>"> 
					<input disabled type="text" placeholder="localidad"	name="localidad" value="<%=amigo.getLocalidad()%>"> 
					<input disabled type="text"	placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>"> 
					<input	disabled type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=amigo.getMovil()%>"> 
					<input disabled type="text" pattern="[0-9]{9}"	placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo()%>">
					<textarea disabled name="anotaciones" placeholder="anotaciones"><%=amigo.getAnotaciones()%></textarea>
					<input type="hidden" name="nombre" value="<%=amigo.getNombre()%>"> <input
						type="hidden" name="id" value="<%=amigo.getId()%>">
			
					<div class="botones">
						<a title="" href="main">cancelar</a> 
						<input type="submit" value="eliminar" name="operacion" class="boton modificar" onClick="if(!confirm('¿Seguro que deseas eliminar el amigo?')){return false;}">
					</div>
				</form>		
			<%
		}
	%>



</div>