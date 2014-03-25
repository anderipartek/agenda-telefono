<%@include file="inc/head.jsp"%>

<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<!-- Div para Google maps -->
<div id="map-canvas"></div>
<script>
	var map;
	function initialize() {
		// Objeto de opciones del mapa

		var latitud = 43.916;
		var longitud = -2.4167;
		var zoom = 16;
		var mapOptions = {
			zoom : zoom,
			// En donde quieres que se centre el mapa nada más abrir
			// Hay que cambiar las coordenadas latitud longitud para cambiar
			// el foco inicial
			center : new google.maps.LatLng(longitud, latitud),
			mapTypeId : google.maps.MapTypeId.SATELLITE
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		// Try HTML5 geolocation
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = new google.maps.LatLng(position.coords.latitude,
						position.coords.longitude);

				var infowindow = new google.maps.InfoWindow({
					map : map,
					position : pos,
					content : 'Te hemos geolocalizado, estas en: [<b>latitud</b>'+ position.coords.latitude+',<b>longitud</b>'+ position.coords.longitude +']'
				});
				
				var marker = new google.maps.Marker({
				      position: pos,
				      map: map,
				      title: 'Ongi Etorri!'
				  });

				map.setCenter(pos);
			}, function() {
				handleNoGeolocation(true);
			});
		} else {
			// Browser doesn't support Geolocation
			handleNoGeolocation(false);
		}
	}

	// Cuando esta cargada la api se carga, como el document ready de jquery
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<%@include file="/inc/navBar.jsp"%>



<%@include file="inc/footer.jsp"%>