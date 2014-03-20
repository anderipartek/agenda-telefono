






<%@page import="com.ipartek.agenda.bean.Amigo"%>


<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>
	<%-- 
		<?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>Necesitamos saber su nombre</p></li>
			<?php if($_POST['movil'] == '') ?>
				<li><p>Necesitamos saber su tel√©fono m√≥vil</p></li>
			</ul>
		<?php } ?>--%>
		
		<%Amigo amigo =(Amigo) request.getAttribute("anadido");
		
		if(amigo!=null){%>
		
		<%@ include file="../../../inc/head.jsp"%>
			<!-- HEADER -->
		<%@ include file="../../../inc/header.jsp" %>

		<table>
		<tr>
		 <td><%=amigo.getNombre() %></td>
		 <td><%=amigo.getApellido() %></td>
		 <td><%=amigo.getCalle() %></td>
		 <td><%=amigo.getCp() %></td>
		 <td><%=amigo.getLocalidad() %></td>
		 <td><%=amigo.getProvincia() %></td>
		 <td><%=amigo.getMovil() %></td>	
		 <td><%=amigo.getFijo() %></td>	
		 <td><%=amigo.getAnotaciones() %></td>	
			
			</tr>
			
			</table>
		<%}else{%>
				
		<form method="post" action="agenda?op=nuevo">				
			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido" value="apellido">
			<input type="text" placeholder="calle" name="calle" value="calle">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="CP">
			<input type="text" placeholder="localidad" name="localidad" value="localidad">
			<input type="text" placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999" name="movil" value="telÈfono movil">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="telÈfono fijo">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>
			
			<div class="botones">
				<a title="" href="index.jsp">cancelar</a>
				<input type="submit" value="aÒadir" name="anadir" class="boton anadir" onClick="if(!confirm('øSeguro que deseas aÒadir el registro?')){return false;}" >
			</div>
		</form>
		<%} %>
		<script> 

</script> 

	</div>