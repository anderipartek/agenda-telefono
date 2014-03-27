<!DOCTYPE html>
<%@page import="com.ipartek.agenda.bean.Contacto"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Ver listado Amigos | Version Movil</title>
	<link rel="stylesheet"  href="theme/css/jquery.mobile-1.4.2.min.css">
	
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<script src="js/jquery-2.1.0.min.js"></script>
	<script src="js/jquery.mobile-1.4.2.js"></script>
	<script>
		$(document).ready(function()){
			
			$.mobile.defaultPageTransition="slideup";
			$.mobile.defaultDialogTransition="slideup";
			
		});
	
	
	</script>
</head>
<body>
<div data-role="page" id="home">

	<div data-role="panel" id="mypanel" data-position="left" data-display="overlay">
    <!-- panel content goes here -->
    	
	</div><!-- /panel -->
	
	<div data-role="header" class="">
		<h1>Listado Amigos</h1>
		<a href="#" data-role="button" data-icon="back">Home</a>
	</div>
	
	<div data-role="content">
	<a href="#" data-role="button" data-inline="true" data-theme="a">Añadir</a>
	<a href="#" data-role="button" data-inline="true" data-theme="b">Modificar</a>
	<a href="#" data-role="button" data-inline="true" data-theme="c">Ver</a>
	<a href="#" data-role="button" data-inline="true" data-theme="d">Eliminar</a>
	
	<ul data-role="listview" data-filter="true" data-filter-placeholder="Busca a tu colega..." data-autodividers="true">
	<%
		ArrayList<Contacto> lista = (ArrayList<Contacto>)request.getAttribute("listaContactos");
		for (int i=0; i < lista.size(); i++){
			out.print("<li><a href='#'><h2>" + ((Contacto)lista.get(i)).getNombre()+ "</h2><p> " + ((Contacto)lista.get(i)).getApellido() + "</p></a></li>");
		}
	
	%>
	</ul>
	</div>
	
	<div data-role="footer">
		Ipartek Servicios Informaticos 2014
		<p><a href="#politica" data-transition="flip">Politica Privacidad</a></p>
	</div>
	
</div><!-- /page -->

<div data-role="page" id="politica">
	
	<div data-role="header" class="">
		<h1>Politica Privacidad</h1>
		<a href="#home" data-role="button" data-icon="back">Home</a>
	</div>
	
	<div data-role="content">
	<p>
		"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
	</p>
	<p>
		Sección 1.10.32 de "de Finibus Bonorum et Malorum", escrito por Cicero en el 45 antes de Cristo

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"
	</p>
	<p>
		Traducción hecha por H. Rackham en 1914

"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?"
	</p>
	<p>
		Sección 1.10.33 de "de Finibus Bonorum et Malorum", escrito por Cicero en el 45 antes de Cristo

"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat."
	</p>
	<p>
		Traducción hecha por H. Rackham en 1914

"On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains."
	</p>
	</div>
	
	<div data-role="footer">
		Ipartek Servicios Informaticos 2014
		
	</div>
	
</div><!-- /page politica -->


</body>
</html>
