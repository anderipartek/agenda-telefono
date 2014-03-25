<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- HEAD -->

<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp"%>
<section class="wrapper content">

	<!--  GOOGLE MAPS  -->
	<!-- Importamos primero la libreria / servicio -->
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	<!-- Div donde va el contenido del mapa -->
	<div id="map-canvas"></div>
	<script>
		var map;
		// localizacion inicial Ondarru
		var latitude   = 43.3167;
		var longitude  = -2.4167;
		var zoom       = 18;
		var pos;
		function initialize() {
			var mapOptions = {
				zoom : zoom,
				center : new google.maps.LatLng(latitude, longitude),
				 mapTypeId: google.maps.MapTypeId.HYBRID  
			};
			map = new google.maps.Map(document.getElementById('map-canvas'),
					mapOptions);
			
			if(navigator.geolocation) {
			    navigator.geolocation.getCurrentPosition(function(position) {
			      pos = new google.maps.LatLng(position.coords.latitude,
			                                       position.coords.longitude);

			      var infowindow = new google.maps.InfoWindow({
			        map: map,
			        position: pos,
			        content: 'Location found using HTML5.'
			      });

			      map.setCenter(pos);
			    }, function() {
			      handleNoGeolocation(true);
			    });
			  } else {
			    // Browser doesn't support Geolocation
			    handleNoGeolocation(false);
			  }
			
			var marker = new google.maps.Marker({
			      position: pos,
			      map: map,
			      title: 'Ongi Etorri'
			  });


		}

		google.maps.event.addDomListener(window, 'load', initialize);
		
		

		
	</script>
	


	<%
		session.getAttribute("todoOk");
	%>
	<%
		//seccion = (String) session.getAttribute("seccion")
		if ("anadir".equalsIgnoreCase(request.getParameter("seccion"))) {
	%>
	<%@ include file="anadir.jsp"%>
	<%
		} else if ("modificar".equalsIgnoreCase(request.getParameter("seccion"))) {
	%>
	<%@ include file="modificar.jsp"%>
	<%
		} else if ("eliminar".equalsIgnoreCase(request.getParameter("seccion"))) {
	%>
	<%@ include file="eliminar.jsp"%>
	<%
		} else if ("ver".equalsIgnoreCase(request.getParameter("seccion"))) {
	%>
	<%@ include file="ver.jsp"%>
	<%
		} else if (request.getParameter("seccion") == null){
	%>
	<%@ include file="inc/navBar.jsp"%>
	<%
		}
	%>
</section>


	

<!-- FOOTER -->
<%@ include file="inc/footer.jsp"%>