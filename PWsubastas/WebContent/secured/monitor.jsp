<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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
<body>
<jsp:include page="../nav.jsp"/>
<br/><br/><br/>
<hr/>
<div class="container container-body">
	<legend>Monitor</legend>
	<c:if test="${not empty objects}">
    <table class="table table-striped table-condensed">
    	<tr>
    		<th>Nombre Clase</th>
    		<th>Nombre Metodo</th>
			<th>Fecha de Ejecucion</th>
			<th>Ultima Ejecucion</th>
			<th>Numero de LLamadas</th>
			<th>Promedio</th>
			<th>Tiempo Total</th>
			<th>Ejecucion Minima</th>
			<th>Ejecucion Maxima</th>
			<th>Usuario</th>
    	</tr>
        <c:forEach var="o" items="${objects}">
	         <tr>
				<td>${o.className}</td>
				<td>${o.methodName}</td>
				<td>${o.executionDate}</td>
				<td>${o.lastExecutionTime}</td>
				<td>${o.serviceCalls}</td>
				<td>${o.avgExecutionTime}</td>
				<td>${o.totalExecutionTime}</td>
				<td>${o.minExecutionTime}</td>
				<td>${o.maxExecutionTime}</td>
				<td>${o.usuarioNombre}</td>   
            </tr>
        </c:forEach>
    </table>
	</c:if>
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