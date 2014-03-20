
<!-- HEAD -->
<%--!public static String seccion; --%>

<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>
<section class="wrapper content">

<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="core/model/forms/buscador.jsp"%>
<div class="contain">
			<p class="txt">Seleccionalo de la lista</p>
			<ul class="amigos modify">
			<!-- ?php
			// mostramos los datos de la query
			while($result_row = mysql_fetch_array($result)){
			
			?-->
		
			
				<li>
					
					
						<input type="submit" name="amigo" value="">
						<input type="hidden" name="buscar" value="ok">
						<input type="hidden" name="nombre" value="Erlantz">
						<input type="hidden" name="id" value="kaka">
				
				</li>
				
			
			<!-- ?php
			}
			?-->
			</ul>
		</div>
<%@ include file="core/model/forms/eliminar.jsp"%>
<%@ include file="todoOk.jsp"%>