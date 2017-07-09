<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Subastas</title>
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.countdown.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/subastas.js"></script>
<!--     <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/map.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.countdown.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/subastas.css">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="<%=response.encodeURL("/PWsubastas/home.jsp") %>"><strong>Subastas</strong></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li><a href="#">El Pasado</a></li>
            <li><a href="#">El Presente</a></li>
            <li><a href="#">El Futuro</a></li>
            <li><a href="#">Mis Intis</a></li>
            <li><a href="/PWsubastas/ubicacion.jsp">Ubicacion Usuario</a></li>
            <li><a href="/PWsubastas/contactar.htm">Contactanos</a></li>
        </ul>
        <div class="nav navbar-nav navbar-right">
        <ul class="nav navbar-nav">
        <li><a href="/PWsubastas/login.htm">Login</a></li>
        </ul>
        </div>
    </div>
</nav>
<br/><br/><br/>
<div class="container container-body">
	<div id="map-canvas"></div>
</div>
<br/>
<div id="footer">
      <div class="container">
      	<div class="row">
        	<div class="col-md-6 credit text-left">Subastas@2014</div>
            <div class="col-md-6 credit text-right">Release 1.0.0</div>
        </div>
      </div>
</div>
<script>
	var map;
	function initialize() {
		var mapOptions = {
			zoom : 6
		};
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
		if (navigator.geolocation) {
			navigator.geolocation.getCurrentPosition(function(position) {
				var pos = new google.maps.LatLng(position.coords.latitude,
						position.coords.longitude);

				var infowindow = new google.maps.InfoWindow({
					content : 'Hola, aqui es mi tienda, ven a ver mis productos en subasta :).'
				});
				var marker = new google.maps.Marker({
				      position: pos,
				      map: map,
				      title: 'Tienda de Subastas de Laura'
				});
				google.maps.event.addListener(marker, 'click', function() {
				    infowindow.open(map,marker);
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
	function handleNoGeolocation(errorFlag) {
		if (errorFlag) {
			var content = 'Error: The Geolocation service failed.';
		} else {
			var content = 'Error: Your browser doesn\'t support geolocation.';
		}
		var options = {
			map : map,
			position : new google.maps.LatLng(60, 105),
			content : content
		};
		var infowindow = new google.maps.InfoWindow(options);
		map.setCenter(options.position);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</body>
</html>