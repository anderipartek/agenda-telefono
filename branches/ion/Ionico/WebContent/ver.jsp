<%@include file="inc/head.jsp"%>

<h3>Estos son tus amigos:</h3>

<!--  <?php
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
	?>
	-->
		<!--  Incluir librerias jsQuery -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>
	
	<link type="text/css" rel="stylesheet" href="js/css/jquery.dataTables.css">
	
	<table id="amigos">
	
	<table>
		<colgroup><col width="10%" span="2"><col width="20%"><col width="5%"><col width="10%" span="4"><col width="15%"></colgroup>
		<tr>
			<th>nombre</th>
			<th>apellido</th>
			<th>calle</th>
			<th>cp</th>
			<th>localidad</th>
			<th>provincia</th>
			<th>movil</th>
			<th>fijo</th>
			<th>anotaciones</th>
		</tr>

 
	<!-- // mostramos los datos de la query
	while($result_row = mysql_fetch_array($result)){
	 -->
		<tr>
			<td>${amigo.getnombre}</td>
			<td>${amigo.getapellido}</td>
			<td>${amigo.getcalle}</td>
			<td>${amigo.getcp}</td>
			<td>${amigo.getlocalidad}</td>
			<td>${amigo.getprovincia}</td>
			<td>${amigo.getmovil}</td>
			<td>${amigo.getfijo}</td>
			<td>${amigo.getanotaciones}</td>
		</tr>

	<!-- }
	-->

		</table>
<!-- cerramos db -->

	



<%@include file="inc/footer.jsp"%>