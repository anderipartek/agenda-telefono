<%@include file="inc/head.jsp"%>

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
					<th>${a.getId}</th>
					<th>${a.getNombre}</th>
					<th>${a.getApellido}</th>
					<th>${a.getCalle}</th>
					<th>${a.getCodigoPostal}</th>
					<th>${a.getLocalidad}</th>
					<th>${a.getProvincia}</th>
					<th>${a.getMTelefono}</th>
					<th>${a.getFTelefono}</th>
					<th>${a.getAnotaciones}</th>
				</tr>
			</c:forEach>
		</ul>
	</tbody>
</table>

<%@include file="inc/footer.jsp"%>