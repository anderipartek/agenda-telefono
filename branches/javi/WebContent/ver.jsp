<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="com.ipartek.agenda.bean.Amigo" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="inc/head.jsp"%>
<title>Insert title here</title>

</head>
<body>


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
	ArrayList<Amigo> lista = (ArrayList<Amigo>)request.getAttribute("lista");
	// mostramos los datos de la query	
	if(lista != null){
		for(int i = 0; i<lista.size(); i++){%>
		
		 <tr>
			<td><%=lista.get(i).getNombre() %></td>
			<td><%=lista.get(i).getApellido() %></td>
			<td><%=lista.get(i).getCalle() %></td>
			<td><%=lista.get(i).getCp() %></td>
			<td><%=lista.get(i).getLocalidad() %></td>
			<td><%=lista.get(i).getProvincia() %></td>
			<td><%=lista.get(i).getNumMovil() %></td>
			<td><%=lista.get(i).getNumFijo() %></td>				
			<td><%=lista.get(i).getAnotaciones() %></td>
		</tr>
		<%} %>
	<%} %>
		</table>
	<button ></button>
</body>
</html>