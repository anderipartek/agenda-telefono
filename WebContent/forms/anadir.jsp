<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<div class="contain">
		<%@include file="../mensaje.jsp"%>	
			
		<%
			Amigo amigo = (Amigo)request.getAttribute("amigo");

		   	if (amigo == null){
		   		amigo = new Amigo();
		   	}else{
		   		%><p class="titulo">Amigo añadido</p><%
		   	}
		%>
	
		<p class="titulo">Cuales son los datos de tu amigo:</p>
	
		
		<form method="post" action="main">				
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp" name="cp" value="<%if(amigo.getCp()!=0){%><%=amigo.getCp() %><%}%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="localidad" name="localidad" value="<%=amigo.getLocalidad()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil " name="movil" value="<%if(amigo.getMovil()!=0){%><%=amigo.getMovil() %><%}%>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo " name="fijo" value="<%if(amigo.getFijo()!=0){%><%=amigo.getFijo() %><%}%>">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="anadir" name="operacion" class="boton anadir">
			</div>
		</form>
	</div>

	