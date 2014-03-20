
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
		<%String mensaje = (String)request.getAttribute("mensaje"); 
			String nombre = (String)request.getAttribute("nombre");
			String telefono =  (String)request.getAttribute("telefono");
		%>
		<div>
		<ul class="errores">
			<%
				if(nombre == " " && telefono == " "){%>
					<li><p><%=mensaje %></p></li>
					<li><p><%=nombre %></p></li>
					<li><p><%=telefono %></p></li>
					
					%>
				<% }%>
			
			</ul>
			</div>
		<%
			Amigo a = (Amigo)request.getAttribute("amigo");
			
		   	if (a == null){
		   		a = new Amigo();
		   	}
		%>
		
		<form method="post" action="main">				
			<input type="text" placeholder="nombre" name="nombre" value=<%=a.getNombre() %>>
			<input type="text" placeholder="apellido" name="apellido" value="<%=a.getApellido() %>">
			<input type="text" placeholder="calle" name="calle" value="<%=a.getCalle() %>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="<%=a.getCp()%>">
			<input type="text" placeholder="localidad" name="localidad" value="<%=a.getLocalidad() %>">
			<input type="text" placeholder="provincia" name="provincia" value="<%=a.getProvincia() %>">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999" name="movil" value="<%=a.gettMovil() %>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=a.gettFijo() %>">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="anadir" name="accion" class="boton anadir">
			</div>
		</form>
				
	</div>
	
	
	
