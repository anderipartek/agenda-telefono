<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>

<%@ include file="../../../inc/head.jsp"%>
<!-- HEADER -->
<body>
<%@ include file="../../../inc/header.jsp" %>

<%@ include file="buscador.jsp"%>
<div class="contain">
            <%String msg=(String)request.getAttribute("Mensaje");
              if (msg==null){
            	  msg="";
              }
              String nombre="";
    		  String apellido="";
    		  String calle="";
    		  String cp="";
    		  String localidad="";
    		  String provincia="";
    		  String movil="";
    		  String fijo="";
    		  String anotaciones="";
    		  String nombreApe="";
              String idM="";
            Amigo a=(Amigo)request.getAttribute("Amigo");
            if (a!=null){
            	nombre=a.getNombre();
            	apellido=a.getApellido();
            	calle=a.getCalle();
            	cp=String.valueOf(a.getCp());
            	localidad=a.getLocalidad();
            	provincia=a.getProvincia();
            	movil=String.valueOf(a.getMovil());
            	fijo=String.valueOf(a.getFijo());
            	anotaciones=a.getAnotaciones();
            	idM=String.valueOf(a.getId());
            }
            ArrayList<Amigo> amigos=(ArrayList<Amigo>)request.getAttribute("Amigos");
  			
            
            %>
            <p class="errores"><%=msg%></p>	
            
			
			<ul class="amigos modify">
			<li>
			<%
		if (amigos!=null){%>
		    <p class="txt">Seleccionalo de la lista</p>
			
			<form action="agenda?operacion=datos" method="post">
			<% for (int i = 0 ; i < amigos.size(); i++) {%> 
				
				<% Amigo amigo = amigos.get(i);
				nombreApe = amigo.getNombre() + " " + amigo.getApellido();
				%>
			    
				<input type="submit" name="amigo" value="<%=nombreApe%>">
				<input type="hidden" name="id" value="<%=amigo.getId()%>">
						
			
				
			<%} // END FOR%>
			</form>
			<%}//END IF%>
			</li>
			</ul>
		
			
			
			
			   
			 
		 
		
</div>


<%
	  
	  


%>
<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		
		<form method="post" action="agenda?operacion=modificar">
		    				
			<input type="text" placeholder="nombre" name="nombre" value="<%=nombre %>">
			<input type="text" placeholder="apellido" name="apellido" value="<%=apellido %>">
			<input type="text" placeholder="calle" name="calle" value="<%=calle %>">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="cp" value="<%=cp %>">
			<input type="text" placeholder="localidad" name="localidad" value="<%=localidad %>">
			<input type="text" placeholder="provincia" name="provincia" value="<%=provincia %>">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999" name="movil" value="<%=movil %>">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="<%=fijo %>">
			<textarea name="anotaciones" placeholder="anotaciones">"<%=anotaciones %>"</textarea>
			<input type="hidden" name="id" value="<%=idM %>">
			
			
			<div class="botones">
				
				<input type="submit" value="modificar" name="modificar" class="boton modificar">
			</div>
		</form>

		<?php
		}
		?>
	</div>