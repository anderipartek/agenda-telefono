<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- HEAD -->
		 <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>


<%@ include file="inc/head.jsp"%>
 
<body id="home">
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>
<section class="wrapper content">
<div id="map-canvas">
<script>
		var map;
		//localizacion inicial
		var latitude=43.3167;
		var longitude=-2.4167;
		var zoom=18;
		
		function initialize() {
			var mapOptions = {
				zoom : zoom,
				center : new google.maps.LatLng(latitude, longitude),
			mapTypeId: google.maps.MapTypeId.SATELLITE
			};
			map = new google.maps.Map(document.getElementById('map-canvas'),
					mapOptions);
		}
		// Try HTML5 geolocation
		  if(navigator.geolocation) {
		    navigator.geolocation.getCurrentPosition(function(position) {
		      var pos = new google.maps.LatLng(position.coords.latitude,
		                                       position.coords.longitude);

		      var infowindow = new google.maps.InfoWindow({
		        map: map,
		        position: pos,
		        content: 'Te hemos geolocalizado estas en la latitud['+position.coords.latitude +'] y longitud ['+
                        position.coords.longitude+']'
		      });
		      var marker = new google.maps.Marker({
		          position: pos,
		          map: map,
		          title: 'Ongi etorri'
		      });


		      map.setCenter(pos);
		    }, function() {
		      handleNoGeolocation(true);
		    });
		  } else {
		    // Browser doesn't support Geolocation
		    handleNoGeolocation(false);
		  }



		google.maps.event.addDomListener(window, 'load', initialize);
	</script>
</div>



</section>
<!-- FOOTER -->
<%@ include file="inc/footer.jsp"%>