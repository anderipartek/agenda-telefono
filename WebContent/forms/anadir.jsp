	
	<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@include file="/inc/head.jsp" %>

<%@include file="/inc/navBar.jsp" %>
<!-- contenido central -->
<body>
<section class="wrapper content">	

<div class="contain">
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<!-- Cuando se producn errores en los formularios
			<ul class="errores">
			
				<li><p>Necesitamos saber su nombre</p></li>
			
				<li><p>Necesitamos saber su teléfono móvil</p></li>
			</ul>
		 -->
		
		<form method="post" action=" ">				
			<input type="text" placeholder="nombre" name="nombre" value="">
			<input type="text" placeholder="apellido" name="apellido" value="">
			<input type="text" placeholder="calle" name="calle" value="">
			<input type="text" pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="">
			<input type="text" placeholder="localidad" name="localidad" value="">
			<input type="text" placeholder="provincia" name="provincia" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="móvil 999999999" name="movil" value="">
			<input type="text" pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo" value="">
			<textarea name="anotaciones" placeholder="anotaciones"></textarea>
			
			<div class="botones">
				<a title="" href="index.php">cancelar</a>
				<input type="submit" value="añadir" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>
	
	</section>
	
	<%@include file="/inc/footer.jsp"%>
