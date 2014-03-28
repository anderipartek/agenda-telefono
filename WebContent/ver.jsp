
<%@ include file="core/model/forms/mensaje.jsp"%>
<p class="errores"><%=msg%></p>
<%
	
	ArrayList<Amigo> amigos = (ArrayList<Amigo>) request.getAttribute("listaAmigos");
%>

<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bbdd.ModeloAmigo"%>
<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp"%>
<body>

	<%if (amigos!=null){%>
	<p class="txt">Estos son tus amigos:</p>



	<div id="anotaciones">
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

			</tbody>
		</table>
	</div>
	<%} %>



	<!-- FOOTER -->

	<%@include file="inc/footer.jsp"%>