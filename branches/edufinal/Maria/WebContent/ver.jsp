<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
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
				HashMap<Integer,Amigo> listaAmigos = (HashMap<Integer,Amigo>) request.getAttribute("listaTodos");
			
				for(int i = 1; i <= listaAmigos.size() ; i++) {
					Amigo a = listaAmigos.get(i);
		
			%>
			<tr>
				<td><%=a.getNombre()%></td>
				<td><%=a.getApellido()%></td>
				<td><%=a.getCalle()%></td>
				<td><%=a.getCp()%></td>
				<td><%=a.getLocalidad()%></td>
				<td><%=a.getProvincia()%></td>
				<td><%=a.getMovil()%></td>
				<td><%=a.getFijo()%></td>
				<td><%=a.getAnotaciones()%></td>
					   	 	  
			</tr>   
			<%} //END FOR %>		

		</table>
