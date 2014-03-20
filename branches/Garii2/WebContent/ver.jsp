<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- HEAD -->
<%--!public static String seccion; --%>

<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>
<section class="wrapper content">


<%@page import="com.ipartek.agenda.bean.Amigo"%>
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
<div id="anotaciones">
	<table>
		<colgroup><col width="10%" span="2"><col width="20%"><col width="5%"><col width="10%" span="4"><col width="15%"></colgroup>
		<tr>
			<th>NOMBRE</th>
			<th>APELLIDO</th>
			<th>CALLE</th>
			<th>C.POSTAL</th>
			<th>LOCALIDAD</th>
			<th>PROVINCIA</th>
			<th>TELEFONO MOVIL</th>
			<th>TELEFONO FIJO</th>
			<th>ANOTACIONES</th>
			
			
		</tr>
  		<tbody>
			<%
				ArrayList<Amigo> lista = (ArrayList<Amigo>) request.getAttribute("listaAmigo");
				if (lista.size() > 0){
					for(int i = 0 ; i < lista.size() ; i++ ) {
						%>
						
						  <tr>
					    	  <td><%=lista.get(i).getNombre() %></td>
					   	 	  <td><%=lista.get(i).getApellido() %></td>
					   	 	  <td><%=lista.get(i).getCalle() %></td>
					   	 	  <td><%=lista.get(i).getCp()%></td>
					   	 	  <td><%=lista.get(i).getLocalidad() %></td>
					   	 	  <td><%=lista.get(i).getProvincia()%></td>
					   	 	  <td><%=lista.get(i).getMovil() %></td>
					   	 	  <td><%=lista.get(i).getFijo() %></td>
					   	 	  <td><%=lista.get(i).getAnotaciones() %> 
					   	 	  <a href="agenda?IDEL=<%=lista.get(i).getId()%>"><img src="C:/Desarrollo/AgendaTelefonicaGari/WebContent/theme/img/btnEliminar.gif" height="20" width="20" alt="eliminar" ></a>
					   	 	  <a href="agenda?IMOD=<%=lista.get(i).getId()%>"><img src="../theme/img/modificar.gif" height="20" width="20" alt="modificar" ></a>	</td>		   	 	   
					   	 	
					   	 	 

					   	 	 
					    </tr>   
						<%	
					}
				} else {
					out.println("No hay datos en la base de datos");
				}
			%>	
	
  		</tbody>
		</table>
		</div>
<!--
	// cerramos la conexion
	closeDB($connection);
-->

</section>

<!-- FOOTER -->
<%@ include file="inc/footer.jsp"%>