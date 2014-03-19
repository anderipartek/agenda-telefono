<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="inc/head.jsp" %>
<%@ include file="inc/header.jsp" %>

<h3>Estos son tus amigos:</h3>

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
 			ArrayList <Amigo> lAmigo = (ArrayList<Amigo>) request.getAttribute("listaAmigos");		
			Amigo c;
	  		for ( int i=0; i<lAmigo.size();i++){
				c = lAmigo.get(i);
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

</table>

