<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

<div class="container-fluid" >
    <div class="row-fluid">
        <div class="span3">
            <div style="text-align: center">
                <h1>
                    <a onclick="cargar('#timeline', '${pageContext.request.contextPath}/timeline/refresh/0');">TIMELINE</a>
                </h1>
            </div>
            <div class="well sidebar-nav" id="hashTop">
                
            </div>
            <div class="well sidebar-nav" id="usersTop">
               
            </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">
            <div class="hero-unit" style="padding:15px;">
                <div class="row-fluid">
                    <div class="span12" id="timeline">
                    </div>
                </div>
            </div>
            <div class="hero-unit" style="padding: 5px;">
                <div class="row-fluid" >
                   <button onclick="append('#offset','${pageContext.request.contextPath}/timeline/refresh');" class="btn btn-large btn-block btn-primary" type="button"><i class=" icon-plus icon-white"></i> Cargar más...</button>
                </div>             
                
            </div>
        </div><!--/span-->
    </div><!--/row-->
    <script>
        cargar('#cuerpo','${pageContext.request.contextPath}/tweet/${user.nombre}');
        cargar('#hashTop', '${pageContext.request.contextPath}/hashtag/TOP10');
        cargar('#usersTop', '${pageContext.request.contextPath}/usuario/TOP10');
        cargar('#timeline', '${pageContext.request.contextPath}/timeline/refresh');
    </script>

    <jsp:include page="footer.jsp" />


