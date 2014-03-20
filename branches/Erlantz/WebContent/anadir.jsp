
<% 
//Si es nuevo todOk = 0, si se ha agregado un amigo todOk = 1 y recogemos los valores del amigo
	int todOk = 0;
	if (request.getAttribute("todoOk")!= null)
		todOk = (Integer) request.getAttribute("todoOk");
		
%><div class="contain">
		
		<%	if (todOk == 1) {
 		String amigo = (String) request.getAttribute("amigo");
 		%><p class="txt">Se ha añadido correctamente a <%=amigo %> a la agenda</p><%
 		} %>		
		<p class="titulo">Cuales son los datos de tu amigo:</p>		
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre (minimo 2 caracteres)" name="nombre" value="nombre" required pattern="[A-Z][a-z]{2,}">
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
				<input type="submit" value="añadir" name="op" class="boton anadir">
			</div>
		</form>
	</div>
		
	