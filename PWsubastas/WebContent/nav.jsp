<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication var="user" property="principal" />
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle Navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/secured/homeusuario.htm"><strong>Subastas</strong></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav">
            <li><a href="#">El Pasado</a></li>
            <li><a href="#">El Presente</a></li>
            <li><a href="#">El Futuro</a></li>
            <li><a href="#">Mis Intis</a></li>
            <li><a href="${pageContext.request.contextPath}/secured/showMyTags.htm">Mis Marcadores</a></li>
            <li><a href="${pageContext.request.contextPath}/secured/recomendarProductosUsuario.htm">Lo que te recomendamos</a></li>
            <li><a href="${pageContext.request.contextPath}/secured/showmonitor.htm">Monitor</a></li>
            <li><a href="${pageContext.request.contextPath}/contactar.htm">Contactanos</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown text-right">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span>&nbsp;${user}<b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/secured/usuario.htm">Mis Datos&nbsp;<span class="glyphicon glyphicon-th-large"></span></a></li>
                    <li><a tabindex="-1" href="${pageContext.request.contextPath}/logout.htm">Salir&nbsp;<span class="glyphicon glyphicon-off"></span></a></li>
                </ul>
            </li>
            <li>&nbsp;&nbsp;</li>
        </ul>
    </div>
</nav>