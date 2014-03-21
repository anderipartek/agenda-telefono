<!--  Muestra los mensajes  -->

<%@page import="com.ipartek.agenda.bean.Mensaje"%>
<%
	Mensaje msg = (Mensaje)request.getAttribute("msg");
	if (msg != null){
		out.println("<ul class='errores'>");
		out.println("<li><p class='txt'>"+msg.getMsg()+"</li></p>");
		out.println("</ul>");
	}	
	
%>