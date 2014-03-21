
<%@ include file="../inc/head.jsp"%>
<body>
<!-- HEADER -->
<%@ include file="../inc/header.jsp" %>
<div class="contain">
<%String seccion = (String) session.getAttribute("seccion"); %>
	<p>Se ha añadido correctamente a la agenda </p>

	
		
	<h3>¿Que puedes hacer ahora?</h3>
	<ul class="links">
		<li><a href="main?seccion=anadir" class="boton anadir">añadir a un amigo</a></li>
		<li><a href="main?seccion=modificar" class="boton modificar">modificar a un amigo</a></li>
		<li><a href="main?seccion=eliminar" class="boton eliminar">eliminar a un amigo</a></li>
	</ul>
</div>
<%@ include file="../inc/footer.jsp" %>