<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@include file="inc/head.jsp"%>


<h3>Estos son tus amigos:</h3>
<!-- <?php
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
	?> -->

<table>
		<colgroup>
			<col width="10%" span="2">
			<col width="20%">
			<col width="5%">
			<col width="10%" span="4">
			<col width="15%">
		</colgroup>
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
			<th>modificar</th>
		</tr>

		
	<%
		ArrayList <Amigo> lAmigos = (ArrayList<Amigo>) request.getAttribute("listaAmigos");
  		Amigo a; 
		for ( int i=0; i<lAmigos.size();i++){
			a = lAmigos.get(i);
			%>
			
			  <tr>
		     	 <td align="center"><%=a.getNombre()%></td>
		    	 <td align="center"><%=a.getApellido()%></td>
		   	 	 <td align="center"><%=a.getCalle()%></td>
		   	 	 <td align="center"><%=a.getCp()%></td>
		    	 <td align="center"><%=a.getLocalidad()%></td>
		   	 	 <td align="center"><%=a.getProvincia()%></td>
		   	 	 <td align="center"><%=a.getMovil()%></td>
		    	 <td align="center"><%=a.getFijo()%></td>
		   	 	 <td align="center"><%=a.getAnotaciones()%></td>
				 <td><a href="main?seccion=modificar&id=<%=a.getId()%>" title="">Modificar</a></td>
		    </tr>   
		    
			<%		
				
  		}
	%>

</table>

<%@include file="inc/footer.jsp"%>