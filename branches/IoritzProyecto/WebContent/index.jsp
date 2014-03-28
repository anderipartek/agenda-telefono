<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- HEAD -->
<%--!public static String seccion; --%>

<%@ include file="inc/head.jsp"%>
<fmt:message key="navmenu.op1"/>
<!-- HEADER -->
<%@ include file="inc/header.jsp" %>
<section class="wrapper content">
	
	<!-- Div para Google Maps -->
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	 <script>
	var map;
	//localizacion inicial
	var latitude = 43.1628954;
	var longitude = -2.63065389;
	var zoom = 18;
	
	function initialize() {
  	var mapOptions = {
    	zoom: zoom,
    	center: new google.maps.LatLng(latitude, longitude),
    	mapTypeId: google.maps.MapTypeId.SATELLITE
  	};
  	map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  	
 // Try HTML5 geolocation
   if(navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function(position) {
        var pos = new google.maps.LatLng(position.coords.latitude,
                                         position.coords.longitude);
		
        //te geolocaliza
      /* var infowindow = new google.maps.InfoWindow({
          map: map,
          position: pos,
          content: 'te hemos geolocalizado, estas en: ['+position.coords.latitude+','+position.coords.longitude+']' 
        });*/
       
        //añadir un marker
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
	
	<div id="map-canvas"></div>
	
 
	<%//seccion = (String) session.getAttribute("seccion")
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