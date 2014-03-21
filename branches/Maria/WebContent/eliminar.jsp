<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="Maria">
			
			<div class="botones">
				<input type="submit" value="buscar" name="op" class="boton buscar">
				<input type="hidden" name="buscador" value="eliminar">
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
		<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

		
		<form method="post" action="agenda">				
			<input type="hidden" name="nombre" value="<?php echo $result_row[1]; ?>">
			<input type="hidden" name="id" value="<?php echo $result_row[0]; ?>">			
			<input type="hidden" name="apellido" value="<?php echo $result_row[2]; ?>">
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="eliminar" name="op" class="boton eliminar">
			</div>
		</form>

		
	</div>