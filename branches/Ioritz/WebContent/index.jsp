<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/styles.css" type="text/css" rel="stylesheet">
	<title>Insert title here</title>
</head>
<body id="home">

<!--  
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
-->
	<!-- contenido central --><!--  
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

-->
	<header class="header">
		<div class="wrapper">
			<?php if($seccion != 'index'){ 
				include('inc/navBar.php');
			} ?>
			<div class="logo">
				<span>Agenda</span>
				<span>online</span>			
			</div>
		</div>
	</header>
	
	<nav class="navBar">
			<ul>
				<li id="anadir"><a href="anadir.jsp?seccion=anadir" title="">A&ntilde;adir amigo</a></li>
				<li id="modificar"><a href="modificar.jsp?seccion=modificar" title="">Modificar amigo</a></li>
				<li id="eliminar"><a href="eliminar.jsp?seccion=eliminar" title="">Eliminar amigo</a></li>
				<li id="ver"><a href="ver.jsp?seccion=ver" title="">Ver todos</a></li>
			</ul>				
	</nav>

</body>
</html>