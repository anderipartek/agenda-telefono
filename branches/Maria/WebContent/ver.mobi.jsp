<!DOCTYPE html>
<%@page import="com.ipartek.agenda.bean.Amigo"%>
<%@page import="java.util.HashMap"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Ver listado Amigos ! Version Movil</title>
<link rel="stylesheet" href="theme/css/jquery.mobile-1.4.2.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/jquery.mobile-1.4.2.min.js"></script>

<script>
	$(document).ready(function(){
		
		$.mobile.defaultPageTransition='slide';
		$.mobile.defaultDialogTransition='slideup';
		
	});
</script>

</head>
<body>
	<div data-role="page" id="home">

		<div data-role="header" class="">
			<h1>Listado Amigos</h1>
			<a href="#nav-panel" data-icon="bars" data-iconpos="notext">Menu</a>
		</div>
		<!-- /header-->
		<div data-role="content">
			<div data-role="panel" data-display="push" data-theme="b" id="nav-panel">
        <ul data-role="listview">
            <li data-icon="delete"><a href="#" data-rel="close">Close menu</a></li>
                <li><a href="#">Accordion</a></li>
                <li><a href="#">Ajax Navigation</a></li>
                <li><a href="#">Autocomplete</a></li>
                <li><a href="#">Buttons</a></li>
            
        </ul>
    </div><!-- /panel -->
			<a href="#" data-role="button" data-inline="true" data-theme="b">A�adir</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Modificarr</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Eliminar</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Ver</a>
			
			<ul data-role="listview" data-filter="true" data-filter-placeholder="Busca a tu Amigo" data-autodivider="true">
			<%
			HashMap<Integer,Amigo> listaAmigos = (HashMap<Integer,Amigo>) request.getAttribute("listaTodos");
			
			for(int i = 1; i <= listaAmigos.size() ; i++) {
				Amigo a = listaAmigos.get(i);
			 			
			%>
			<li><a href='#detalle'><%=a.getNombre()+ " "+ a.getApellido()%></a></li>
			<%} %>
			</ul>
			
		</div>
		<!-- /content -->
		<div data-role="footer">
			<h4>IparSex servicios Informaticos 2014</h4>
			<p><a href="#politica" data-transition="slide">Politica Privacidad</a></p>
		</div><!-- /footer -->

	</div>
	<!-- /page home-->
	
	<div data-role="page" id="detalle">

		<div data-role="header" class="">
			<h1>Listado Amigos</h1>
		</div>
		<!-- /header-->
		<div data-role="content">
			
			<a href="#" data-role="button" data-inline="true" data-theme="b">A�adir</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Modificarr</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Eliminar</a>
			<a href="#" data-role="button" data-inline="true" data-theme="b">Ver</a>
			
			<ul data-role="listview" data-filter="true" data-filter-placeholder="Busca a tu Amigo" data-autodivider="true">
			
			Mostrar Detalle amigo
			
			</ul>
			
		</div>
		<!-- /content -->
		<div data-role="footer">
			<h4>IparSex servicios Informaticos 2014</h4>
			<p><a href="#politica" data-transition="slide">Politica Privacidad</a></p>
		</div><!-- /footer -->

	</div>
	<!-- /page detalle-->
	

	<div data-role="page" id="politica">

		<div data-role="header" class="">
			<h1>Listado Amigos</h1>
			<a href="#home" data-role="button" data-icon="back">Home</a>
		</div>
		<!-- /header-->
		<div data-role="content">
			<p>Lorem Ipsum es simplemente el texto de relleno de las
				imprentas y archivos de texto. Lorem Ipsum ha sido el texto de
				relleno est�ndar de las industrias desde el a�o 1500, cuando un
				impresor (N. del T. persona que se dedica a la imprenta) desconocido
				us� una galer�a de textos y los mezcl� de tal manera que logr� hacer
				un libro de textos especimen. No s�lo sobrevivi� 500 a�os, sino que
				tambien ingres� como texto de relleno en documentos electr�nicos,
				quedando esencialmente igual al original. Fue popularizado en los
				60s con la creaci�n de las hojas "Letraset", las cuales contenian
				pasajes de Lorem Ipsum, y m�s recientemente con software de
				autoedici�n, como por ejemplo Aldus PageMaker, el cual incluye
				versiones de Lorem Ipsum. Es un hecho establecido hace demasiado
				tiempo que un lector se distraer� con el contenido del texto de un
				sitio mientras que mira su dise�o. El punto de usar Lorem Ipsum es
				que tiene una distribuci�n m�s o menos normal de las letras, al
				contrario de usar textos como por ejemplo "Contenido aqu�, contenido
				aqu�". Estos textos hacen parecerlo un espa�ol que se puede leer.
				Muchos paquetes de autoedici�n y editores de p�ginas web usan el
				Lorem Ipsum como su texto por defecto, y al hacer una b�squeda de
				"Lorem Ipsum" va a dar por resultado muchos sitios web que usan este
				texto si se encuentran en estado de desarrollo. Muchas versiones han
				evolucionado a trav�s de los a�os, algunas veces por accidente,
				otras veces a prop�sito (por ejemplo insert�ndole humor y cosas por
				el estilo). Al contrario del pensamiento popular, el texto de Lorem
				Ipsum no es simplemente texto aleatorio. Tiene sus raices en una
				pieza cl�sica de la literatura del Latin, que data del a�o 45 antes
				de Cristo, haciendo que este adquiera mas de 2000 a�os de
				antiguedad. Richard McClintock, un profesor de Latin de la
				Universidad de Hampden-Sydney en Virginia, encontr� una de las
				palabras m�s oscuras de la lengua del lat�n, "consecteur", en un
				pasaje de Lorem Ipsum, y al seguir leyendo distintos textos del
				lat�n, descubri� la fuente indudable. Lorem Ipsum viene de las
				secciones 1.10.32 y 1.10.33 de "de Finnibus Bonorum et Malorum" (Los
				Extremos del Bien y El Mal) por Cicero, escrito en el a�o 45 antes
				de Cristo. Este libro es un tratado de teor�a de �ticas, muy popular
				durante el Renacimiento. La primera linea del Lorem Ipsum, "Lorem
				ipsum dolor sit amet..", viene de una linea en la secci�n 1.10.32 El
				trozo de texto est�ndar de Lorem Ipsum usado desde el a�o 1500 es
				reproducido debajo para aquellos interesados. Las secciones 1.10.32
				y 1.10.33 de "de Finibus Bonorum et Malorum" por Cicero son tambi�n
				reproducidas en su forma original exacta, acompa�adas por versiones
				en Ingl�s de la traducci�n realizada en 1914 por H. Rackham.</p>
		</div>
		<!-- /content -->
		<div data-role="footer">IparSex servicios Informaticos 2014</div>
		<!-- /footer -->

	</div>
	<!-- /page politica-->

</body>
</html>
