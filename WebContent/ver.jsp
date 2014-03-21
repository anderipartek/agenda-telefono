<%@page import="java.util.ArrayList"%>
<%@include file="inc/head.jsp"%>

<%@include file="inc/header.jsp"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>

<h3>Estos son tus amigos:</h3>

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
	</tr>

	<%
		ArrayList<Amigo> listaAmigos = (ArrayList<Amigo>) request
				.getAttribute("listaAmigos");
		if (listaAmigos.size() > 0) {
			for (int i = 0; i < listaAmigos.size(); i++) {
	%>
	<tr>
		<td><%=listaAmigos.get(i).getNombre()%></td>
		<td><%=listaAmigos.get(i).getApellido()%></td>
		<td><%=listaAmigos.get(i).getCalle()%></td>
		<td><%=listaAmigos.get(i).getCp()%></td>
		<td><%=listaAmigos.get(i).getLocalidad()%></td>
		<td><%=listaAmigos.get(i).getProvincia()%></td>
		<td><%=listaAmigos.get(i).gettMovil()%></td>
		<td><%=listaAmigos.get(i).gettFijo()%></td>
		<td><%=listaAmigos.get(i).getAnotaciones()%></td>

	</tr>
	<%
		}
		} else {
			out.println("No hay datos en la base de datos");
		}
	%>
</table>

<%@include file="inc/footer.jsp"%>