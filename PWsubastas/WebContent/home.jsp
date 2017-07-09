<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Subastas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.plugin.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.countdown.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/subastas.js"></script>
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
        <a class="navbar-brand" href="<%=response.encodeURL("/PWsubastas/home.htm") %>"><strong>Subastas</strong></a>
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
<div class="search-bar row">
    <form:form accion="${pageContext.request.contextPath}/home.htm" method="POST" accept-charset="UTF-8">
    	<input type="hidden" name="accion" value="buscar"/>
        <div id="label-search" class="col-lg-3">
           &nbsp; 
        </div>
        <div id="input-search" class="col-lg-6">
            <input type="text" id ="searchWord" name="word" placeholder="buscar..." class="search-text" />
        </div>
        <div id="button-search" class="col-lg-3">
            <button id ="searchWord1" type="button" class="btn btn-primary">Buscar</button>
        </div>
    </form:form>
</div>
<hr/>
<div class="container container-body">
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="<%=request.getContextPath()%>/resources/img/1.png" alt="picture one">
                <div class="carousel-caption">
                    this is the first imagen
                </div>
            </div>
            <div class="item">
                <img src="<%=request.getContextPath()%>/resources/img/2.png" alt="picture two">
                <div class="carousel-caption">
                    this is the second imagen
                </div>
            </div>
            <div class="item">
                <img src="<%=request.getContextPath()%>/resources/img/3.png" alt="picture three">
                <div class="carousel-caption">
                    this is the third imagen
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" ></span>
        </a>
    </div>
    <br>
    <ol class="breadcrumb">
      <li><a href="#" id ="clicker" >Home</a></li>
      <li><a href="#">Category</a></li>
      <li class="active">Item</li>
    </ol>
	<div id = "contenido">
		<c:forEach var="p" items="${productos}">
    		<div class='col-sm-6 col-md-4'>
                <div class='thumbnail'>
                    <div class='imagen' id='${p.productoId}'>
                        <a href='/PWsubastas/secured/producto.jsp?id=${p.productoId}' id='${p.productoId}'>
                        	<img src='/PWsubastas/image?id=${p.productoId}' alt='...'></a>
                    </div>
                    <div class='caption'>
                        <h3>${p.productoNombre}</h3>
                        <p class='alert alert-success'>Precio Real S/. <span id='precioreal'>${p.productoPrecioReal}</span></p>
                        <p class='alert alert-warning'><span class="tiempocount" id='tiempo_${p.productoId}' onload='contador("tiempo_${p.productoId}")'></span></p>
                        <p class='alert alert-info'>S/. <span id='precio_${p.productoId}'>${p.productoPrecioVirtual}</span></p>
                        <p>No existen Ofertas</p>
                    </div>
                </div>
            </div>
		</c:forEach>
    </div>
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
<script type="text/javascript">
$(function(){
	$(".tiempocount").each(function() {
		var newYear = new Date(); 
		newYear = new Date(newYear.getFullYear() + 1, 1 - 1, 1); 
		$("#"+$( this ).attr("id")).countdown({until: newYear, compact: true});
	});
	$("#contenido").on("click", "a", function() {
		var $this = $(this);
		var id = $this.attr('id');
		e.preventDefault();
		$.post('url', {
			'id' : id
		}, function() {
			window.location = $this.attr('href');
		});
	});
	$("#searchWord1").on("click", function() {
		$(this).closest("form").submit();
	});
	$("#searchWord").on("keyup", function() {
		$(this).closest("form").submit();
	});
});
</script> 
</body>
</html>