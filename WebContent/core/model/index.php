<?php
	// recogemos donde estamos
	if(isset($_GET['seccion'])){
		$seccion = $_GET['seccion'];
	}
	else{
		$seccion = 'index';
	}

	// head del DOCTYPE
	include('inc/head.php'); 

?>
	<!-- contenido central -->
	<section class="wrapper content">
		<?php
		// si es la home
		if($seccion == 'index')
			include('inc/navBar.php');

		// si es añadir
		if($seccion == 'anadir')
			include('anadir.php');

		// si es modificar
		if($seccion == 'modificar')
			include('modificar.php');

		// si es eliminar
		if($seccion == 'eliminar')
			include('eliminar.php');

		// si es todos
		if($seccion == 'ver')
			include('ver.php');
		?>
	</section>

<?php
	// footer del DOCTYPE
	include('inc/footer.php'); 
?>