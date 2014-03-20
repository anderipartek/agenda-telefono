<%@page import="com.ipartek.agenda.bean.Mensajes"%>
<%
	Mensajes msg = (Mensajes) request.getAttribute("msg");

	if (msg != null) {
		out.print("<div class="+msg.getTipo() +">"+msg.getMensaje()+"</div>");
	}
%>