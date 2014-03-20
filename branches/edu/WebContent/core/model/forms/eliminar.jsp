<%@page import="com.ipartek.agenda.bbdd.ModeloAmigo"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<%@ include file="../../../inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="../../../inc/header.jsp" %>
<body>
<%@ include file="buscador.jsp"%>
<%String msg=(String)request.getAttribute("Mensaje");
              if (msg==null){
            	  msg="";
              }
            
            %>
<p class="errores"><%=msg%></p>	
<div class="contain">
     
            
            
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos del">
			
			<%
			Amigo a=(Amigo)request.getAttribute("Amigo");
			String nombre="";
			String apellidos="";
			String nombreApe=nombre+"  "+ apellidos;
			if (a==null){
			  nombreApe="";
			}
			else{
				nombreApe=a.getNombre() + " " + a.getApellido();
				request.setAttribute("Amigo", a);
				
			}
				
			
			%>
				<li>
					<form action="agenda?operacion=borrar" method="post">
					
						<input type="submit" name="amigo" value='<%=nombreApe%>'>
						
						
					</form>
				</li>
				
			
			</ul>
</div>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<div class="contain">
		

		<%
		
			if (request.getAttribute("Amigo")!=null){
				
			%>
			<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>
			<form method="post" action="agenda?operacion=eliminar">				
				<input type="hidden" name="nombre" value=<%=a.getNombre()%>>
				<input type="hidden" name="id" value=<%=a.getId()%>>			
				
				
				<div class="botones">
					<a title="" href="">cancelar</a>
					<input type="submit" value="eliminar" name="op" class="boton eliminar">
					</a>
				</div>
			</form>
		<%} %>
	</div>


<!-- FOOTER -->

<%@include file="../../../inc/footer.jsp"%>

