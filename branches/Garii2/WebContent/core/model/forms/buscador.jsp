<div class="contain">
		<p class="titulo">Busca a tu amigo:</p>

		<!-- ?php if($error != false){ ?>
			<ul class="errores">
			<?php if($_POST['nombre'] == '') ?>
				<li><p>El campo nombre lo necesitamos</p></li>
			</ul>
		<?php } ?-->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
 </script>
<script type="text/javascript">
function showData(value){ 
$.ajax({
    url : "agenda?NAME=nombre",
    type : "POST",
    async : false,
    success : function(data) {
//Do something with the data here
    }
});
}
</script>

		<form method="post" action="agenda">				
			<input type="text" placeholder="nombre que buscas..." name="nombre" value="" onkeyup="showData(this.value);">
			
			<div class="botones">
				<input type="submit" value="buscar" name="buscar" class="boton buscar" >
			</div>
		</form>
	</div>