<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
  <form:form method="POST" commandName="moneda" action="${pageContext.request.contextPath}/secured/doComprarMoneda.htm" accept-charset="UTF-8">
  <form:hidden path="monedaId"/>
  <div class="form-group">
  <div class="col-md-9">
    <h2>Selecciona el paquete de Intis que deseas comprar</h2>
    <br></br>
    <h2>Elija su tipo de moneda:</h2>
    <select name="currency" onChange="javascript:exchangeRate(this.value);">
    <option value="EUR">Euro</option>
    <option value="USD">Dollar</option>
    <option value="PEN" selected >Soles</option>
    </select> 
    <br></br>
    <div class="row">
      <div class="col-md-4">
      	<div class="pack thumbnail">
			<input name="moneda_id" type="hidden" value="1">
			<h3>Pihui Churi</h3>
			<h3>10 Intis</h3>
			<h3 class="currencyChange">S/. 16.00</h3>
			<input class="moneda_type" type="hidden" value="16.00">			
			<p class="unitary_text"style="color:#AAA">(Costo por Inti aprox: S/. 1.60)</p>
		</div>
	  </div>
      <div class="col-md-4">
      	<div class="pack thumbnail">
			<input name="moneda_id" type="hidden" value="2">
			<h3>Auqui</h3>
			<h3>100 Intis</h3>
			<h3  class="currencyChange">S/. 14.00</h3>
			<input class="moneda_type" type="hidden" value="14.00">			
			<p  class="unitary_text" style="color:#AAA">(Costo por Inti aprox: S/. 1.40)</p>
		</div>
	  </div>
      <div class="col-md-4">
      	<div class="pack thumbnail">
			<input name="moneda_id" type="hidden" value="3">
			<h3>Inca</h3>
			<h3>500 Intis</h3>
			<h3  class="currencyChange">S/. 675.00</h3>	
			<input class="moneda_type" type="hidden" value="675.00">		
			<p  class="unitary_text" style="color:#AAA">(Costo por Inti aprox: S/. 1.35)</p>
		</div>
	  </div>
    </div>
    <br></br>
    <div class="form-group">
           <button type="submit" name="submit" class="btn btn-primary btn-block">Comprar</button>
  	</div>
  </div>
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
<script type="text/javascript">
$(function(){
	$('.pack').hover(
         function () {
            $(this).addClass("alert alert-info");
         }, 
         function () {
        	$(this).removeClass("alert alert-info");
         }
	);
	$('.pack').on("click", function() {
		 $(this).addClass("select");
		 $.each($('.pack'), function(){
			 if($(this).hasClass("select")){
				 $(this).removeClass("alert alert-success");
			 };
		 });
		 $(this).addClass("alert alert-success");
		 $('input[name=monedaId]').val($('input[name=moneda_id]', this).val());
	});
	
});
</script>
</body>
</html>