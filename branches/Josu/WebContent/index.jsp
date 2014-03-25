<%@page import="com.ipartek.agenda.controller.MainServlet"%>

<%@include file="inc/head.jsp"%>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<div id="map-canvas"></div>
<script>
var map;
var latitude = 43.3167;
var longitude = -2.4167;
var zoom = 16;
function initialize() {
	var mapOptions = {
   		zoom: zoom,
   		center: new google.maps.LatLng(latitude, longitude),
   		mapTypeId: 'satellite'
 	};
 	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
 	
 // Try HTML5 geolocation
 	  if(navigator.geolocation) {
 	    navigator.geolocation.getCurrentPosition(function(position) {
 	      var pos = new google.maps.LatLng(position.coords.latitude,
 	                                       position.coords.longitude);

 	      var infowindow = new google.maps.InfoWindow({
 	        map: map,
 	        position: pos,
 	        content: 'te hemos geolocalizado, estas en: ['+position.coords.latitude+','+position.coords.longitude+']'
 	      });
 	      
 	     var marker = new google.maps.Marker({
 	        position: pos,
 	        map: map,
 	        title: 'Ongi Etorri'
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

//evento para inicializar nuestra funcion, cuando este todo listo
google.maps.event.addDomListener(window, 'load', initialize);
</script>
    
    

<nav class="navBar">
	<ul>
		<li id="anadir" <%if(MainServlet.ANADIR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ANADIR %>" title="">Añadir
				amigo</a></li>
		<li id="modificar" <%if(MainServlet.MODIFICAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.MODIFICAR %>" title="">Modificar
				amigo</a></li>
		<li id="eliminar" <%if(MainServlet.ELIMINAR.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.ELIMINAR %>" title="">Eliminar
				amigo</a></li>
		<li id="ver" <%if(MainServlet.VER.equals(request.getAttribute("seccion"))){%> class="sel" <%}%>><a href="main?<%=MainServlet.SECCION %>=<%=MainServlet.VER %>" title="">Ver
				todos</a></li>
	</ul>
</nav>

<%@include file="inc/footer.jsp"%>