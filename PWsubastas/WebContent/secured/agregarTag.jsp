<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import='java.util.Date' %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/uploads.js"></script> 
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery.countdown.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/subastas.css">
</head>
<style type="text/css">
      .producto{width: 600px;margin-left: 100px}
      .btn-block{width: 50%}
  </style>
<body>
<jsp:include page="../nav.jsp"/>
<br/><br/><br/>
<hr/>
<div class="container producto">

	<legend>Ingresar Tag</legend>
	<!--  <form  method="POST" id="form1" action="ServletAgregarProducto">-->
	 <form:form method="POST" commandName="tags" action="${pageContext.request.contextPath}/secured/doCrearTags.htm">	
		<div class="form-group">
		<form:input path="tagText" class="form-control"  placeholder="Nombre del Tag" />
		</div>
		<form:hidden class="form-control" path="stemmedText" value="${tags.tagText}" />
		<form:hidden class="form-control" path="productoId" value="${tags.productoId}" />
		<div class="form-group">
			<button type="submit" name="submit" class="btn btn-primary btn-block">Guardar</button>
		</div>
	</form:form>
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