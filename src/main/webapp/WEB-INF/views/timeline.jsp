<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp" />

<div class="container-fluid" >
    <div class="row-fluid">
        <div class="span3">
                    <div class="well sidebar-nav" id="hashTop">
                    </div>
                    <div class="well sidebar-nav" id="usersTop">
                    </div>
        </div>

        <div class="span9">
            <div class="hero-unit" style="padding:15px;">
                <div class="row-fluid">
                    <ul class="nav nav-list">
                        <li class="nav-header" 
                            onclick="cargar('#timeline', '${pageContext.request.contextPath}/timeline/reset');" 
                            style="cursor: pointer;">
                            <i class="icon-refresh"></i>
                            Actualizar
                            <hr style="padding: 0px; margin: 0px; margin-bottom: 15px;" />
                        </li>
                    </ul>
                    <div class="well" id="timeline">
                    </div>
                </div>
            </div>
            <div class="hero-unit" style="padding: 5px;">
                <div class="row-fluid" >
                    <button onclick="append('#offset','${pageContext.request.contextPath}/timeline/refresh');" class="btn btn-large btn-block btn-primary" type="button"><i class=" icon-plus icon-white"></i> Cargar más...</button>


                </div><!--/span-->
            </div><!--/row-->
        </div>
    </div>
</div>                    
<script>
    cargar('#cuerpo',   '${pageContext.request.contextPath}/tweet/${user.nombre}');
    cargar('#hashTop',  '${pageContext.request.contextPath}/hashtag/TOP10');
    cargar('#usersTop', '${pageContext.request.contextPath}/usuario/TOP10');
    cargar('#timeline', '${pageContext.request.contextPath}/timeline/refresh');
</script>

<jsp:include page="footer.jsp" />