	
	<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@include file="/inc/head.jsp" %>

<%@include file="/inc/navBar.jsp" %>
<!-- contenido central -->
<body>
<section class="wrapper content">	
	
	<div class="contain">
		<p class="titulo">&iquest;Deseas realmente eliminar a tu amigo?</p>

				
		<form method="post" action="">				
			<input type="hidden" name="nombre" value="">
			<input type="hidden" name="id" value="">			
			<input type="hidden" name="apellido" value="">
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="eliminar" name="eliminar" class="boton eliminar">
			</div>
		</form>

		<?php
		}
		?>
	</div>
</section>
<%@include file="/inc/footer.jsp"%>