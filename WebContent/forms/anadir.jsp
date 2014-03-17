<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

			<ul class="errores">
				<c:if test="${requestScope.operacion_anadir} == false">
					<li><p>Error al guardar el amigo</p></li>
				</c:if>
				<c:if test="${requestScope.operacion_anadir} == true">
					<li><p>Amigo añadido</p></li>
				</c:if>
				<li><p>Necesitamos saber su nombre</p></li>
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>


		
		<form method="post" action="main">				
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="nombre" name="nombre" value="">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="apellido" name="apellido" value="">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="localidad" name="localidad" value="">
			<input type="text" pattern=[A-Za-z]{2,25} placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="main">cancelar</a>
				<input type="submit" value="añadir" name="operacion" class="boton anadir">
			</div>
		</form>
	</div>

	