<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
			ArrayList <Amigo> lAmigos = (ArrayList<Amigo>) request.getAttribute("listaAmigos");
  			Amigo a; 
			
  			if (lAmigos.isEmpty()){
  				%><h3>Lo siento no tienes amigos :-(</h3><% 
  			}else{
  				%><h3></h3><% 
  			}
%>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'es_ES'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.agenda.controller.i18n" /> 



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
			if (!lAmigos.isEmpty()){ %>
		<%

			for ( int i=0; i<lAmigos.size();i++){
				a = lAmigos.get(i);
		
		%>
		
		<tr>
			<td><%=a.getNombre() %></td>
			<td><%=a.getApellido() %></td>
			<td><%=a.getCalle() %></td>
			<td><%=a.getCp() %></td>
			<td><%=a.getLocalidad() %></td>
			<td><%=a.getProvincia() %></td>
			<td><%=a.getMovil() %></td>
			<td><%=a.getFijo() %></td>
			<td><%=a.getAnotaciones() %></td>
		</tr>
		<%}%>
		<%}%>
	
	</table>
