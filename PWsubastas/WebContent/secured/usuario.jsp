<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<hr/>
<div class="container container-body">
<p>Hola, <span>${user}</span> Bienvenido a tu Perfil</p>
<div class="row">
  <div class="col-md-8">Mis intis</div>
  <div class="col-md-4">S/<span>${saldo}</span></div>
</div>
<div class="row">
  <div class="col-md-8"></div>
  <div class="col-md-4"><a class="btn btn-primary" href="${pageContext.request.contextPath}/secured/comprarmoneda.htm" role="button" id="comprarmoneda">Comprar Intis</a></div>
</div>
<br>
<br>
<div class="row">
  <div class="col-md-8">Mis Productos</div>
  <div class="col-md-4"><span>${numProductos}</span></div>
</div>
<div class="row">
  <div class="col-md-8"></div>
  <div class="col-md-4"><a class="btn btn-primary" href="${pageContext.request.contextPath}/secured/producto.htm"" role="button" id="comprarmoneda">Agregar Producto</a></div>
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
</body>
</html>