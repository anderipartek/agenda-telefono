<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="com.ipartek.agenda.bean.Contacto"%>
    <%@page import="java.util.ArrayList"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Incluir JQuery y data table -->
<script src="js/jquery.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="js/css/jquery.dataTables.css">
</head>
<body>
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
			<th>operaciones</th>
		</tr>
		
		<%
 			ArrayList <Contacto> lContactos = (ArrayList<Contacto>) request.getAttribute("listaContactos");
			if ( lContactos != null ){
					Contacto c;
			  		for (int i=0; i<lContactos.size();i++){
						c = lContactos.get(i);
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
					    	 <td><a href="main?seccion=modificar&id=<%=c.getId()%>">modificar</a>&nbsp;&nbsp;<a href="eliminar.jsp">eliminar</a></td>
					    </tr>   
						<%
					
					}//end for
				}else{
					%>
					  <tr>
				     	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
				    	 <td>vacio</td>
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