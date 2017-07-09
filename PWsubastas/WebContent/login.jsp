<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Subastas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/subastas.css">
  </head>
<body>
<section>
<div class="container login">
    <div class="row ">
        <div class="center well">
            <legend>Iniciar Sesión</legend>
		 	<c:if test="${'fail' eq param.auth}">
		        <div style="color:red">
		                Login Failed!!!<br />
		                Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		         </div>
		    </c:if>
            <form:form method="POST" commandName="usuario" action="${pageContext.request.contextPath}/doLogin.htm" accept-charset="UTF-8">
            <fieldset>
            <div class="form-group">
              <form:input class="form-control" path="usuarioNombre" placeholder="Usuario" />
            </div>
            <div class="form-group">
              <form:password class="form-control" path="usuarioPassword" placeholder="Contraseña" />
            </div>
            <div class="form-group">
            <label class="checkbox">
                <input type="checkbox" name="remember" value="1" /> Recordar mi cuenta
            </label>
            </div>
            <div class="form-group">
            <button type="submit" name="submit" class="btn btn-primary btn-block">Entrar</button>
            </div>
            <div class="form-group" align="right">
            	<span><b>¿no estas registrado? registrate <a href="/PWsubastas/registro.htm">aqui</a>
            	<br>o entra con: </b></span>
            	<a href="#"><img alt="facebook" src="<%=request.getContextPath()%>/resources/img/facebook.jpg" width="20px" height="20px"></a>
            	<a href="#"><img alt="google" src="<%=request.getContextPath()%>/resources/img/google.jpg" width="30px" height="30px"></a>
            </div>
            </fieldset>
            </form:form>
        </div>
    </div>
</div>
<p class="text-center muted ">Subastas@2014</p>
</section>
</body>
</html>