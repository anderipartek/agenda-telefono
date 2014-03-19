<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bbdd.ModeloAmigo"%>
<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>
<section class="wrapper content">

<h3>Estos son tus amigos:</h3>
<!--  ?php
	// insertamos las funciones del site
	include('../abstract/functions.php');

	// realizamos la insercion en la BBDD
	$connection = connectDB($db_host, $db_username, $db_password,$db_database);

	// enviamos la query
	$query = 'SELECT * FROM amigos';

	$result = mysql_query($query);
	//comprobamos si la query ha ido bien
	if(!$result){
		die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
	}
-->
    <%
      ArrayList<Amigo> amigos=(ArrayList<Amigo>)request.getAttribute("listaAmigos");
      
      
    %>
    <div id="anotaciones">
	<table>
		<colgroup><col width="10%" span="2"><col width="20%"><col width="5%"><col width="10%" span="4"><col width="15%"></colgroup>
		<tr>
			<th>nombre</th>
			<th>apellido</th>
			<th>calle</th>
			<th>cp</th>
			<th>localidad</th>
			<th>provincia</th>
			<th>movil</th>
			<th>fijo</th>
			<th>anotaciones</th>
		</tr>
		<tbody>
		  <%
		    for (int i=0;i<amigos.size();i++){
		    	%>
		    	<tr>
		    	  
		    	   <td><%=amigos.get(i).getNombre() %></td>
		    	   <td><%=amigos.get(i).getApellido() %></td>
		    	   <td><%=amigos.get(i).getCalle() %></td>
		    	   <td><%=amigos.get(i).getCp() %></td>
		    	   <td><%=amigos.get(i).getLocalidad() %></td>
		    	   <td><%=amigos.get(i).getProvincia() %></td>
		    	   <td><%=amigos.get(i).getMovil() %></td>
		    	   <td><%=amigos.get(i).getFijo() %></td>
		    	   <td><%=amigos.get(i).getAnotaciones() %></td>
		    	</tr>   
		    <% }%>
		    
		  
		 
		  


<!--  ?php
	// mostramos los datos de la query
	while($result_row = mysql_fetch_array($result)){

		<tr>
			<td><?php echo $result_row[1]; ?></td>
			<td><?php echo $result_row[2]; ?></td>
			<td><?php echo $result_row[3]; ?></td>
			<td><?php echo $result_row[4]; ?></td>
			<td><?php echo $result_row[5]; ?></td>
			<td><?php echo $result_row[6]; ?></td>
			<td><?php echo $result_row[7]; ?></td>
			<td><?php echo $result_row[8]; ?></td>
			<td><?php echo $result_row[9]; ?></td>
		</tr>
	<?php
	}
-->     
        </tbody>
		</table>
		</div>
		
		
<!--
	// cerramos la conexion
	closeDB($connection);
-->