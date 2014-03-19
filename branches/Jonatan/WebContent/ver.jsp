<%@include file="inc/head.jsp"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>

<h3>Estos son tus amigos:</h3>
<!-- <?php
	// insertamos las funciones del site
	include('../abstract/functions.php');

	// realizamos la insercion en la BBDD
	$connection = connectDB($db_host, $db_username, $db_password,$db_database);

	// enviamos la query
	$query = 'SELECT * FROM amigos';

	$result = mysql_query($query);
	//comprobamos si la query ha ido bien
	if(!$result){
		die('No se pudo ejecutar la consulta sobre la BBDD' . mysql_error() . '<br>');
	}
	?> -->

<table id="tabla">
	<caption>Lista de Alumnos</caption>
	<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Nombre</th>
			<th scope="col">Apellido</th>
			<th scope="col">Calle</th>
			<th scope="col">CP</th>
			<th scope="col">Localidad</th>
			<th scope="col">Provincia</th>
			<th scope="col">Movil</th>
			<th scope="col">Fijo</th>
			<th scope="col">Anotaciones</th>
		</tr>
	</thead>
	<tbody>
		<ul>
			<c:forEach var="amigo" items="${requestScope.lista_amigos}">
				<tr>
					<th>${amigo.id}</th>
					<th>${amigo.nombre}</th>
					<th>${amigo.apellido}</th>
					<th>${amigo.calle}</th>
					<th>${amigo.cp}</th>
					<th>${amigo.localidad}</th>
					<th>${amigo.provincia}</th>
					<th>${amigo.movil}</th>
					<th>${amigo.fijo}</th>
<%-- 					<th>${amigo.anotaciones} <img src="theme/img/update.png" onSubmitonClick="onUpdate(this)"><img src="theme/img/delete.png" onClick="onDelete(this)"></th> --%>
					<th>
						${amigo.anotaciones}<
						<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>&id=${amigo.id}"><img class="imgUpdateClass"></a>
						<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>&id=${amigo.id}"><img class="imgDeleteClass"></a>
					</th>
				</tr>
			</c:forEach>
		</ul>
	</tbody>
</table>

<%@include file="inc/footer.jsp"%>

	<script type="text/javascript">
	
		function setOperacion(id, operacion) {
			if (operacion == 'update')
			{
				console.log(id);
				var href = 
				$.get(href);
<%-- 				form.action = "main?" + <%=MainServlet.OPERACION%> + "=" + <%=MainServlet.MODIFICAR%>; --%>
<%-- 				form.operacion.value = "<%=MainServlet.OPERACION_MODIFICAR%>"; --%>
<%-- 				form.seccion.value = "<%=MainServlet.MODIFICAR%>"; --%>
			}
			else if (operacion == 'delete')
			{
				form.action = "main?" + <%=MainServlet.OPERACION%> + "=" + <%=MainServlet.ELIMINAR%>;
				form.operacion.value = <%=MainServlet.OPERACION_ELIMINAR%>
				form.seccion.value = <%=MainServlet.ELIMINAR%>
			}
		}
	
		$(document).ready(function() {
			$('#tabla').dataTable();
		});
	</script>