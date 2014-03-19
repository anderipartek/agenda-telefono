<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="com.ipartek.agenda.bean.Contacto"%>
    <%@page import="java.util.ArrayList"%>
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
		
		<%
 			ArrayList <Contacto> lContacto = (ArrayList<Contacto>) request.getAttribute("listaContactos");		
			Contacto c;
	  		for ( int i=0; i<lContacto.size();i++){
				c = lContacto.get(i);
				%>
				  <tr>
			     	 <td><%=c.getNombre()%></td>
			    	 <td><%=c.getApellido()%></td>
			    	 <td><%=c.getCalle()%></td>
			    	 <td><%=c.getCp()%></td>
			    	 <td><%=c.getLocalidad()%></td>
			    	 <td><%=c.getProvincia()%></td>
			    	 <td><%=c.getMovil()%></td>
			    	 <td><%=c.getFijo()%></td>
			    	 <td><%=c.getAnotaciones()%></td>
			    </tr>   
				<%
			
			}
			
		
		%>

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
		</table>
<!--
	// cerramos la conexion
	closeDB($connection);
-->