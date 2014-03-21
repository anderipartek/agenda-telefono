<!-- HEAD -->
<%--!public static String seccion; --%>


<%	Amigo mostrarcabecera = (Amigo) request.getAttribute("amigomodificar");
		if(mostrarcabecera!=null){
%>
<%@ include file="inc/head.jsp"%>	
<!-- HEADER -->

<%@ include file="inc/header.jsp" %>

<%} %>

<section class="wrapper content">

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>

<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			<!-- ?php
			// mostramos los datos de la query
			while($result_row = mysql_fetch_array($result)){
			
			?-->
			
				<li>
									<%	Amigo amigos = (Amigo) request.getAttribute("amigomodificar");
		if(amigos!=null){
		%>

						<input type="submit" name="amigo" value="<%=amigos.getNombre()%>">
						<%} %>
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="">
						<input type="hidden" name="id" value="">
				
				</li>
				
			<!-- ?php
			}
			?-->
			</ul>
		</div>
<%@ include file="core/model/forms/modificar.jsp"%>


