<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado amigo||Version Mobile</title>

	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.min.css">
	
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
	<script  type="text/javascript" src="js/jquery.mobile-1.4.2.min.js"></script>
	<script>
	$(document).ready(function(){
		$.mobile.defaultPageTransition='slideup';
		$.mobile.defaultDialogTransition='slideup';
	});
	</script>
</head>
<body>
<div data-role="page" class="" id="home">
<div data-role="header" class="">
<h1>Listado Amigos</h1>
</div>

<div data-role="content" class="">
<a href="#" data-role="button" data-inline="true" data-theme="a">Añadir</a>
<a href="#" data-role="button"  data-inline="true" data-theme="b">Modificar</a>
<a href="#" data-role="button" data-inline="true" data-theme="c">Eliminar</a>
<a href="#" data-role="button"  data-inline="true" data-theme="d">Ver todos</a>

	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer volutpat est justo, eget imperdiet est 
	   dapibus eu. Duis feugiat, nisl nec pretium pulvinar, magna odio varius metus, nec vehicula libero metus vitae
	   dolor. Donec sollicitudin rhoncus purus at aliquet. Pellentesque et gravida enim. Ut ornare pharetra turpis,
	   sed tempor turpis luctus sed. Phasellus at urna vel leo ullamcorper dapibus. Curabitur fermentum massa non 
	   nunc pellentesque, at euismod arcu bibendum.
	</p>
</div><!-- /content -->
<div data-role="footer">
<h4>IparSex servicios informaticos 2014</h4>
<a href="#politica" data-transition="flip">Politica de privacidad</a>
</div>
	
</div><!-- /page -->
<div data-role="page"  class="" id="politica">
<div data-role="header" class="">
<a href="#home" data-role="button" data-icon="back" >Home</a>
<h1>Politica de privacidad</h1>

</div>
<div data-role="content" class="">
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer volutpat est justo, eget imperdiet est 
	   dapibus eu. Duis feugiat, nisl nec pretium pulvinar, magna odio varius metus, nec vehicula libero metus vitae
	   dolor. Donec sollicitudin rhoncus purus at aliquet. Pellentesque et gravida enim. Ut ornare pharetra turpis,
	   sed tempor turpis luctus sed. Phasellus at urna vel leo ullamcorper dapibus. Curabitur fermentum massa non 
	   nunc pellentesque, at euismod arcu bibendum.
	</p>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer volutpat est justo, eget imperdiet est 
	   dapibus eu. Duis feugiat, nisl nec pretium pulvinar, magna odio varius metus, nec vehicula libero metus vitae
	   dolor. Donec sollicitudin rhoncus purus at aliquet. Pellentesque et gravida enim. Ut ornare pharetra turpis,
	   sed tempor turpis luctus sed. Phasellus at urna vel leo ullamcorper dapibus. Curabitur fermentum massa non 
	   nunc pellentesque, at euismod arcu bibendum.
	</p>
</div><!-- /content -->
<div data-role="footer">
IparSex  servicios informaticos 2014
</div>
	
</div><!-- /page -->

</body>
</html>
