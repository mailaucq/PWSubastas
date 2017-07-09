<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
  <style type="text/css">
      body{background-color: #F7F7F6;}
      .login{padding-top: 10%; width: 320px;}
      .center{float: none; margin-left: auto; margin-right: auto;}
  </style>
<body>
<section>
<div class="container login">
    <div class="row ">
        <div class="center well">
            <legend>Registro de usuario</legend>
            <form:form method="POST" commandName="usuario" action="/PWsubastas/addUsuario.htm">
            <fieldset>
            <div class="form-group">
              <form:input path="usuarioNombre" class="form-control" placeholder="Usuario" />
            </div>
            <div class="form-group">
              <form:password path="usuarioPassword" class="form-control" placeholder="Contraseña" />
            </div>
            <div class="form-group">
              <input type="password" id="passwordValidation" class="form-control" name="j_passwordValidation" placeholder="Reingrese Contraseña" />
            </div>
            <div class="form-group">
              <form:input path="usuarioDireccion" class="form-control" placeholder="Direccion de domicilio" />
            </div>
            <div class="form-group">
            <label class="checkbox">
              <input type="checkbox" name="remember" value="1" /> Recordar mi cuenta
            </label>
            </div>
            <div class="form-group">
            <button type="submit" name="submit" class="btn btn-primary btn-block">Registrar</button>
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