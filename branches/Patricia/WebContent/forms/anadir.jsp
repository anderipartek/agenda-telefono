	<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

<%-- 		<% if($error != false){ %> --%>
			<!-- <ul class="errores"> -->
<%-- 			<% if($_POST['nombre'] == '') %> --%>
				<!-- <li><p>Necesitamos saber su nombre</p></li> -->
<%-- 			<% if($_POST['movil'] == '') %> --%>
				<!--  <li><p>Necesitamos saber su tel�fono m�vil</p></li>-->
			</ul>
<%-- 		<% } %> --%>
		
		<form method="post" action="">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="m�vil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="a�adir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>

	