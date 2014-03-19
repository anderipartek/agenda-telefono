
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
	
			<ul class="errores">
			<c:if test="${not empty requestScope.accionAnadir}">
				<c:if test="${requestScope.accionAnadir == '-1'}">
					<li><p>Necesitamos saber su nombre</p></li>
					<li><p>Necesitamos saber su telefono movil</p></li>
				</c:if>
				<c:if test="${requestScope.accionAnadir != -'1'}">
						<li><p>El Amigo ha sido añadido</p></li>
					</c:if>
				</c:if>
			</ul>
		
		
		<form method="post" action="<?php htmlentities($_SERVER['PHP_SELF']); ?>">				
			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido" value="apellido">
			<input type="text" placeholder="calle" name="calle" value="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="CP">
			<input type="text" placeholder="localidad" name="localidad" value="localidad">
			<input type="text" placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999" name="movil" value="teléfono movil">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="teléfono fijo">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>