<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- HEAD -->
<%--!public static String seccion; --%>

<%@ include file="inc/head.jsp"%>
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>

<!-- Div para GOOGLE MAPS -->
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>

<div id="map-canvas"></div>



<script>
var map;

var latitude = 43.3167;
var longitude = -2.4167;
var zoom = 19;
function initialize() {
  var mapOptions = {
    zoom: zoom,
    center: new google.maps.LatLng(latitude, longitude),
    mapTypeId: google.maps.MapTypeId.SATELLITE
    
    
  };
  

  
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  
  if(navigator.geolocation) {
	    navigator.geolocation.getCurrentPosition(function(position) {
	      var pos = new google.maps.LatLng(position.coords.latitude,
	                                       position.coords.longitude);

	      var infowindow = new google.maps.InfoWindow({
	        map: map,
	        position: pos,
	        content: 'Location found using HTML5.'
	      });
	      
	      var marker = new google.maps.Marker({
	          position: pos,
	          map: pos,
	          title: 'Hello World!'
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

google.maps.event.addListener(map, 'click', function(e) {
    placeMarker(e.latLng, map);
  });

function placeMarker(position, map) {
	  var marker = new google.maps.Marker({
	    position: position,
	    map: map
	  });
	  map.panTo(position);
	}

function handleNoGeolocation(errorFlag) {
	  if (errorFlag) {
	    var content = 'Error: The Geolocation service failed.';
	  } else {
	    var content = 'Error: Your browser doesn\'t support geolocation.';
	  }

	  var options = {
	    map: map,
	    position: new google.maps.LatLng(60, 105),
	    content: content
	  };

	  var infowindow = new google.maps.InfoWindow(options);
	  map.setCenter(options.position);
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>


<section class="wrapper content">
 
	<%
	if ("anadir".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="anadir.jsp"%>	
	<% } else if ("modificar".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="modificar.jsp"%>
	<% } else if ("eliminar".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="eliminar.jsp"%>
	<% } else if ("ver".equalsIgnoreCase(request.getParameter("seccion"))) { %>
		<%@ include file="ver.jsp"%>
	<%} else if (request.getParameter("seccion") == null){ %>
		<%@ include file="inc/navBar.jsp"%>
	<%}%>
</section>



<!-- FOOTER -->
<%@ include file="inc/footer.jsp"%>