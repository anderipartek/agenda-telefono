<%@include file="inc/head.jsp"%>

<%@include file="inc/navBar.jsp"%>


<script
	src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
	var map;
	var latitude = 43.3167;
	var longitude = -2.4167;
	var zoom = 16;
	function initialize() {
		var mapOptions = {
			zoom : zoom
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);

		handleNoGeolocation("test");

		// Try HTML5 geolocation
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = new google.maps.LatLng(position.coords.latitude,
						position.coords.longitude);
				var infowindow = new google.maps.InfoWindow({
					map : map,
					position : pos,
					content : 'Te hemos geolocalizado, estas en: ' + pos
				});

				// To add the marker to the map, use the 'map' property
				var marker = new google.maps.Marker({
					position : pos,
					map : map,
					title : "Hello World!"
				});

				map.setCenter(pos);
			}, function() {
				handleNoGeolocation(true);
			});
		} else {
			// Browser doesn't support Geolocation
			handleNoGeolocation(false);
		}

		google.maps.event.addListener(map, "click", function(event) {
			var lat = event.latLng.lat();
			var lng = event.latLng.lng();
			// populate yor box/field with lat, lng
			console.log("Lat=" + lat + "; Lng=" + lng);
		});
	}

	function handleNoGeolocation(errorFlag) {
		if (errorFlag) {
			var content = 'Error al obtener direccion desde ip.';
		} else {
			var content = 'Error: Your browser doesn\'t support geolocation.';
		}

		var options = {
			map : map,
			position : new google.maps.LatLng(latitude, longitude),
			content : content
		};

		var infowindow = new google.maps.InfoWindow(options);
		map.setCenter(options.position);
	}
	
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<!--  Div para Google Maps -->
<div id="map-canvas"></div>

<%@include file="inc/footer.jsp"%>
