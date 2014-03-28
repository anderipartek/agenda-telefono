<%@ include file="mensaje.jsp"%>


<%@ include file="../../../inc/head.jsp"%>
<!-- HEADER -->
<body>
	<%@ include file="../../../inc/header.jsp"%>



	<div class="contain">
		<p class="errores"><%=msg%></p>
		<p class="titulo">Cuales son los datos de tu amigo:</p>

		<form method="post" action="agenda?operacion=anadir">

			<input type="text" placeholder="nombre" name="nombre" value="nombre">
			<input type="text" placeholder="apellido" name="apellido"
				value="apellido"> <input type="text" placeholder="calle"
				name="calle" value="calle"> <input type="text"
				pattern="[0-9]{5}" placeholder="cp 48004" name="CP" value="CP">
			<input type="text" placeholder="localidad" name="localidad"
				value="localidad"> <input type="text"
				placeholder="provincia" name="provincia" value="provincia">
			<input type="text" pattern="[0-9]{9}" placeholder="movil 999999999"
				name="movil" value="telefono movil"> <input type="text"
				pattern="[0-9]{9}" placeholder="fijo 999999999" name="fijo"
				value="telefono fijo">
			<textarea name="anotaciones" placeholder="anotaciones">anotaciones</textarea>

			<div class="botones">
				<a title="" href="index.jsp">cancelar</a> <input type="submit"
					value="insertar" name="anadir" class="boton anadir">
			</div>
		</form>
	</div>
	<!-- FOOTER -->

	<%@include file="../../../inc/footer.jsp"%>