<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import='java.util.Date' %>
<!DOCTYPE html>
<html lang="es">
<head>
	<title>Subir Imagen</title>
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
<%
if(session.getAttribute("user") == null){
    response.sendRedirect("login.jsp");
}
String nombre = (String)request.getAttribute("j_productonombre");
%>
<jsp:include page="../nav.jsp"/>

<input type="hidden"  name="j_imageurl" value ="<%=nombre%>"/>


<br/><br/><br/>
<hr/>
<div class="container container-body">


<h3>File Upload:</h3>
Select a file to upload: <br />
<form action="uploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>

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