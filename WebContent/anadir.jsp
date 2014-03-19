
<% 
//Si es nuevo todOk = 0, si se ha agregado un amigo todOk = 1 y recogemos los valores del amigo
	int todOk = 0;
	if (request.getAttribute("todoOk")!= null)
		todOk = (Integer) request.getAttribute("todoOk");
		
 	if (todOk != 1) {
	%>
		<%@ include file="core/model/forms/anadir.jsp"%>
		
	<%} else { 
		String amigo = (String) request.getAttribute("amigo");
	%>	
		<p>Se ha añadido correctamente a <%=amigo %> a la agenda</p>
		<%@ include file="core/model/forms/anadir.jsp"%>
		<%--<%@ include file="todoOk.jsp"%>
		<span>todoOK = <%=todOk%></span>
			--%>
		<%} %>