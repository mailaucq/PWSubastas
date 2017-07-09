<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Subastas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subastas.css">
  </head>
<body>
<section>
<div class="container consulta">
    <div class="row ">
        <div class="center well">
            <legend>Envíe su Consulta</legend>
			<form:form method="POST" commandName="consulta" action="/PWsubastas/addConsulta.htm">
				<fieldset>
					<div class="form-group">
						<form:input path="nombre" class="form-control" placeholder="Nombre" />
					</div>

					<div class="form-group">
						<form:input path="telefono" class="form-control" placeholder="Telefono" />
						</div>

					<div class="form-group">
						<form:input path="email" class="form-control" placeholder="Email" />
					</div>

					<div class="form-group">
						<form:textarea path="comentario" class="form-control" placeholder="Comentario" cols="40" rows="10" />
					</div>
							
					<div class="form-group">
					<button type="submit" name="submit" class="btn btn-primary btn-block">Enviar</button>
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