
<%
	String msg = "";
	
	if (request.getAttribute("msg") != null) {
		 msg = (String)request.getAttribute("msg");
	
		
%><script type="text/javascript">
<%-- 					 alert('<%=msgValue%>'); --%>
				</script>
<%
	}
	out.print("<span>" + msg + "</span>");
%>