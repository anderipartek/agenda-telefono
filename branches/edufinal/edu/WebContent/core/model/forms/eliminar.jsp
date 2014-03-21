
<%
	String msg = (String) request.getAttribute("Mensaje");
	if (msg == null) {
		msg = "";
	}

	Amigo a = (Amigo) request.getAttribute("Amigo");
	String nombre = "";
	String apellidos = "";
	String nombreApe = nombre + "  " + apellidos;
	if (a == null) {
		nombreApe = "";
	} else {
		nombreApe = a.getNombre() + " " + a.getApellido();
		request.setAttribute("Amigo", a);

	}

	ArrayList<Amigo> amigos = (ArrayList<Amigo>) request.getAttribute("Amigos");
%>
<%@page import="com.ipartek.agenda.bbdd.ModeloAmigo"%>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>


<%@ include file="../../../inc/head.jsp"%>
<!-- HEADER -->
<body>
	<%@ include file="../../../inc/header.jsp"%>

	<%@ include file="buscador.jsp"%>


	<div class="contain">


		<p class="errores"><%=msg%></p>

		<ul class="amigos del">
			<li>
				<%
					if (amigos != null) {
				%>
				<p class="txt">Seleccionalo de la lista</p>

				<form action="agenda?operacion=confirmacion" method="post">
					<%
						for (int i = 0; i < amigos.size(); i++) {

								Amigo amigo = amigos.get(i);
								nombreApe = amigo.getNombre() + " " + amigo.getApellido();
					%>

					<input type="submit" name="amigo" value="<%=nombreApe%>"><br />
					<input type="hidden" name="idB" value="<%=amigo.getId()%>">



					<%
						} // END FOR
					%>
				</form> <%
 	              }//END IF
 %>
			</li>
		</ul>
	</div>

	<div class="contain">


		<%
			if (request.getAttribute("amigo") != null) {
				String idB = (String) request.getAttribute("amigo");
		%>

		<form method="post" action="agenda?operacion=eliminar">
			<input type="hidden" name="id" value=<%=idB%>>


			<div class="botones">

				<input type="submit" value="eliminar" name="op"
					class="boton eliminar"
					onClick="if(!confirm('¿Seguro que deseas eliminar el amigo seleccionado?')){return false;}">
				</a>
			</div>
		</form>
		<%
			}
		%>
	</div>


	<!-- FOOTER -->

	<%@include file="../../../inc/footer.jsp"%>