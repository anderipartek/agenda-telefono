<%@include file="inc/head.jsp"%>
<%@page import="com.ipartek.agenda.controller.MainServlet"%>

<h3>Estos son tus amigos:</h3>

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
					<th>${(amigo.cp == -1) ? '': amigo.cp}</th>
					<th>${amigo.localidad}</th>
					<th>${amigo.provincia}</th>
					<th>${(amigo.movil == -1) ? '':amigo.movil}</th>
					<th>${(amigo.fijo == -1) ? '':amigo.fijo}</th>
					<th>
						<p>${amigo.anotaciones}</p>
						<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>&id=${amigo.id}"><input type="button" class="imgUpdateClass"></a>
						<a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>&id=${amigo.id}"><input type="button" class="imgDeleteClass"></a>
					</th>
				</tr>
			</c:forEach>
		</ul>
	</tbody>
</table>

<%@include file="inc/footer.jsp"%>

	<script type="text/javascript">
	
		$(document).ready(function() {
			$('#tabla').dataTable();
		});
		
		
	</script>