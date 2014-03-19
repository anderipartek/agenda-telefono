<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
			<ul class="errores">
				<c:if test="${not empty requestScope.operacion_anadir}">
					<c:if test="${requestScope.operacion_anadir == '-1'}">
						<li><p>Error al guardar el amigo</p></li>
						<li><p>Necesitamos saber su nombre</p></li>
						<li><p>Necesitamos saber su teléfono móvil</p></li>
					</c:if>
					<c:if test="${requestScope.operacion_anadir != -'1'}">
						<li><p>Amigo añadido</p></li>
					</c:if>
				</c:if>
			</ul>
		<%
			Amigo amigo = (Amigo)request.getAttribute("amigo");

		   	if (amigo == null){
		   		amigo = new Amigo();
		   	}
		%>
		<form method="post" action="main">				
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="nombre" name="nombre" value="<%=amigo.getNombre()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="apellido" name="apellido" value="<%=amigo.getApellido()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="calle" name="calle" value="<%=amigo.getCalle()%>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="<%=amigo.getCp()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="localidad" name="localidad" value="<%=amigo.getLocalidad()%>">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="provincia" name="provincia" value="<%=amigo.getProvincia()%>">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="<%=amigo.getMovil()%>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=amigo.getFijo()%>">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="añadir" name="operacion" class="boton anadir">
			</div>
		</form>
	</div>

	