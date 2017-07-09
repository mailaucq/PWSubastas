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
<%


String imageUrl =(String)request.getAttribute("imageUrl");
//String productoNombre = (String)request.getAttribute("productoNombre");
//String productoTiempoInicio = (String)request.getAttribute("productoTiempoInicio");
//String productoTiempoFinal = (String)request.getAttribute("productoTiempoFinal");
//double precioReal = Double.parseDouble(request.getAttribute("productoTPrecioReal"));
//double precioVirtual = (String)request.getAttribute("productPrecioVirtual");


%>
<jsp:include page="../nav.jsp"/>
<br/><br/><br/>
<hr/>
<div class="container producto">

	<legend>Ingresar Producto</legend>
	<!--  <form  method="POST" id="form1" action="ServletAgregarProducto">-->
	 <form:form method="POST" commandName="producto" action="${pageContext.request.contextPath}/secured/addProducto.htm">	
		<div class="form-group">
		Ingrese nombre del producto:
		<form:input path="productoNombre" class="form-control"  placeholder="Nombre del producto" />
		</div>

		<div class="form-group">
		Inicio de la subasta:
		<form:input path="s_productoTiempoInicial" class="form-control"  placeholder="Tiempo de Inicio" value="1990-01-01 00:00:00"/>
		</div>

		<div class="form-group">
		Fin de la subasta(aproximadamente):
		<form:input path="s_productoTiempoFinal" class="form-control"  placeholder="Tiempo de Fin" value="1990-01-01 00:00:00"/>
		</div>

		<div class="form-group">
		Ingrese precio real (precio actual en el mercado)del producto:
		<form:input path="productoPrecioReal" class="form-control"  placeholder="Precio en el mercado" value="0.0"/>
		</div>
		
		<div class="form-group">
		Ingrese una descripcion:
		<form:textarea path="productoDescripcion" rows="4" cols="70" class="form-control" placeholder="Descripcion del producto" />
		</div>
		
		<div>                                
		<input type="file" name="datafile" />  
		<div id="upload" style="display:none;">Uploading..</div>
<!-- 		<button type="submit" name="submit" onClick="performAjaxSubmit();" class="btn btn-primary btn-block">Upload File</button> -->
<!-- 		<div id="uplImage" onClick="cargarImagen();" > Upload File </div> -->

<!-- 		<button type="submit" onclick="cargarImagen()" class="btn btn-primary btn-block">Subir foto</button> -->
<%-- 		<a tabindex="-1" href="<%=response.encodeURL("/PWsubastas/uploadImage.jsp")%>">Subir foto</a> --%>
		<form:hidden class="form-control" path="productoImagen" />
		
		</div>

		<input type="hidden" class="form-control" name="j_productoVendedor" value = ""/>
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
<script>
$(document).ready(function(){

	  $('input[type="file"]').ajaxfileupload({

	       'action': '/PWsubastas/uploadImage.htm',           

	   'onComplete': function(response) {        

	         $('#upload').hide();
	         $('input[name="productoImagen"]').val(response);

	         //alert( response);

	       },

	       'onStart': function() {

	         $('#upload').show();

	       }

	  });

	});
</script>
</body>
</html>