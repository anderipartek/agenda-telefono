<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%
	if(request.getAttribute("amigo") != null) {
		Amigo amigo = (Amigo) request.getAttribute("amigoDatos");
		%> <input type="text" name="id" value="<%=amigo.getId()%>"> <%
	}
%>
<p>MENSAJE MOSTRAR</p>