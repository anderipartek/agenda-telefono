<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.HashMap"%>
<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="Maria">
			
			<div class="botones">
				<input type="submit" value="buscar" name="op" class="boton buscar">
				<input type="hidden" name="buscador" value="modificar">
			</div>
		</form>
</div>

<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">


			<%
			if (request.getAttribute("listaNombre")!=null){
				HashMap<Integer,Amigo> listaAmigos = (HashMap<Integer,Amigo>) request.getAttribute("listaNombre");
			
				for(int i = 1; i <= listaAmigos.size() ; i++) {
					Amigo a = listaAmigos.get(i);%>
				<li>
					<form action="agenda" method="get">
					
						<input type="submit" name="amigo" value="<%=a.getNombre()+" "+a.getApellido()%>">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="<%=a.getNombre() %>>">
						<input type="hidden" name="id" value="<%=a.getId() %>>">
					</form>
				</li>
				<%} 
			}%>

			</ul>
</div>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		
		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre" name="nombre" value="Maria">
			<input type="text" placeholder="apellido" name="apellido" value="Berasaluce">
			<input type="text" placeholder="calle" name="calle" value="kamiñazpi 10 1">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="48700">
			<input type="text" placeholder="localidad" name="localidad" value="ondarroa">
			<input type="text" placeholder="provincia" name="provincia" value="bizkaia">
			<input type="text" pattern="[0-9]{9}" placeholder="mÃ³vil 999999999" name="movil" value="666666666">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="999999999">
			<textarea name="anotaciones" placeholder="anotaciones">maria</textarea>
			<input type="hidden" name="nombre" value="maria">
			<input type="hidden" name="id" value="0">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="modificar" name="op" class="boton modificar">
			</div>
		</form>

	</div>