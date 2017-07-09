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
<jsp:include page="../nav.jsp"/>
<br/><br/><br/>
<div class="search-bar row">
    <form>
        <div id="label-search" class="col-lg-3">
           &nbsp; 
        </div>
        <div id="input-search" class="col-lg-6">
            <input type="text" name="search" placeholder="buscar..." class="search-text" id="searchWord"/>
        </div>
        <div id="button-search" class="col-lg-3">
            <button type="button" class="btn btn-primary" onclick="buscarProductos()">Buscar</button>
        </div>
    </form>
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
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <br>
    <ol class="breadcrumb">
      <li><a href="#">Home</a></li>
      <li><a href="#">Category</a></li>
      <li class="active">Item</li>
    </ol>
		<div id="contenido">
			<div class="row">
				<div class="row">
				<div class="col-sm-6 col-md-4">
					<h1>${producto.productoNombre}
					<a href="${pageContext.request.contextPath}/secured/agregarTag.htm?id=${producto.productoId}">
                    <span class="glyphicon glyphicon-star" data-toggle="tooltip" data-placement="left" title="Marcar este Producto"></span>
                	</a>
                	</h1>
                </div>
                </div>
                <div class="row">
					<div class="col-sm-6 col-md-4">
						<div class="thumbnail">
							<div class="imagen">
								<a href="#"><img
									src="<%=request.getContextPath()%>/image?id=${producto.productoId}"
									width="300" alt="..."></a>
							</div>
						</div>
						<c:if test="${not empty tags}">
						<c:forEach var="t" items="${tags}">
							<a href="#">${t.tagText}</a>&nbsp;
				        </c:forEach>
						</c:if>
						<%
							String id = request.getParameter("id");
						%>
						<input type="hidden" value="<%out.println(id);%>" name="id" />
	                    <center><p><a class='subastar btn btn-primary' data-index='1' role='button' onclick='ofertar(${producto.productoId})'  >   ofertar  </a></p></center>					
					</div>
					<div class='col-sm-6 col-md-4'>
						<div class='caption'>
	                    <p class='alert alert-warning'><span class="tiempocount" id='tiempo_${producto.productoId}' onload='contador("tiempo_${producto.productoId}")'></span></p>
	                    <p class='alert alert-info'>S/. <span id='precio_"${producto.productoId}'>${producto.productoPrecioVirtual}</span></p>								
	                    				<h3><small>Nombre del Producto </small> ${producto.productoNombre}</h3>
										<h3><small>Precio Real S/. </small> ${producto.productoPrecioReal}</h3>
										<div class='.col-xs-6 .col-sm-3'>
										<h3><small>Descripcion </small></h3>
											${producto.productoDescripcion}
										</div>
										<H2>${producto.productoEstado}</H2>
										<p>
									</p>
						</div>
					</div>
				</div>
			</div>
			<div  class="row">			
			<div class="fb-comments" data-href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.localPort}${pageContext.request.contextPath}/producto.jsp?id=${producto.productoId}" data-numposts="5" data-colorscheme="light"></div>
			</div>
		<c:if test="${not empty productosSimilares}">
		<h3>Echa un vistazo a estos productos <span class="glyphicon glyphicon-flag"></span></h3>
		<div class="row">
		<c:forEach var="p" items="${productosSimilares}">
    		<div class='col-sm-6 col-md-4'>
                <div class='thumbnail'>
                    <div class='imagen' id='${p.productoId}'>
                        <a href='/PWsubastas/secured/productoDescripcion.htm?id=${p.productoId}' id='${p.productoId}'>
                        	<img src='/PWsubastas/image?id=${p.productoId}'  alt='...'></a>
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
		</c:if>
		</div>
		<br/>
</div>

<div id="footer">
      <div class="container">
      	<div class="row">
        	<div class="col-md-6 credit text-left">Subastas@2014</div>
            <div class="col-md-6 credit text-right">Release 1.0.0</div>
        </div>
      </div>
</div>

<!--  script type="text/javascript">
$(function(){
	var date = new Date();
	$('#tiempo').countdown({until: date}); 
	mostrarProducto();
	$('#subastar').on("click", function() {
		  subastar();
	});
});
</script>-->



<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<script type="text/javascript">
$(function(){
	producto();
});
</script>

<script type="text/javascript">
function buscarProductos(){
	var word = document.getElementById("searchWord").value;
	$.ajax({
		  type: "POST",
		  url: "./obtenerProductos.htm",
		  data: { word: word , accion: "buscar" }
		}).done(function( data ) {
			var dataarray = data.split(",");
			var contenido = dataarray[1];
			document.getElementById('contenido').innerHTML = contenido;
	});
}
</script> 

<script>
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