<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


<div class="container-fluid" >
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Tweets publicados</li>
                    <li><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/tweet/${user.nombre}')" style="cursor: pointer">Tweets</a></li>
                    <li class="nav-header">Personas a las que sigo</li>
                    <li><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/follow/following/${user.nombre}')" style="cursor: pointer">Following</a></li>
                    <li class="nav-header">Personas que me siguen</li>
                    <li><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/follow/followers/${user.nombre}')" style="cursor: pointer">Followers</a></li>
                </ul>
            </div><!--/.well -->
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Tweets en los que aparezco</li>
                    <li><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/menciones/${user.nombre}')" style="cursor: pointer">Mentions</a></li>
                </ul>
            </div><!--/.well -->
        </div><!--/span-->

        <div class="span9">
            <div class="hero-unit" style="padding:15px;">
                <div class="row-fluid">
                    <div class="span12"><!--aaaaaaaaaaaaaaaaaaaaaaaaaaaaa-->
                         <div style="float: left" >
                         <a href="${pageContext.request.contextPath}/usuario/perfil">
                         <img src="${pageContext.request.contextPath}/resources/img/usuarios/${user.imagen}" class="img-rounded" width="140" style="margin-right: 15px;" > 
                         </a>
                         <br /><br />
                            <c:if test="${ empty relaciones}">
                                        <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 140px"><i class="icon-ok icon-white" ></i> Follow</button>
                                        <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 140px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                            </c:if>
                                                      
                            <c:set var="banderaB" value="true" />
                            <c:forEach items="${relaciones}" var="follow">
                                <c:if test="${banderaB}">
                                    <c:if test="${follow.followed == usuario.id}">
                                        <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; width: 140px;"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                        <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; display: none; width: 140px"><i class="icon-ok icon-white" ></i> Follow</button>
                                        <c:set var="banderaB" value="false" />
                                    </c:if>
                                </c:if>
                            </c:forEach>
                            
                            <c:if test="${banderaB}">
                               <c:set var="banderaA" value="true" />
                               <c:forEach items="${relaciones}" var="follow">
                                   <c:if test="${banderaA}">
                                        <c:if test="${follow.followed!=usuario.id}">
                                            <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 140px"><i class="icon-ok icon-white" ></i> Follow</button>
                                            <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 140px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                            <c:set var="banderaA" value="false" />
                                        </c:if>
                                   </c:if>
                                </c:forEach>
                            </c:if>
                         
                        </div>
                        <div  style="float: left" >
                            <h2>
                              <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}">@${usuario.nombre}</a>
                           </h2>

                            <br />
                            <h5>${usuario.biografia}</h5>
                        </div>

                    </div>
                     <!--/span-->
     <!--       <div class="span2" style="float: right; vertical-align: bottom; height: 100%; background-color: #fff;">
                <div style="float:right; width:100%; text-align: right; border-bottom: 1px solid #ccc ; color: #0077b3; font-size: 12px; ">
                    <span style="font-size: large;font-weight: bold;color:#000">2 </span>
                    Tweets
                </div>
                <div style="float:right; width:100%; text-align: right; border-bottom: 1px solid #ccc ; color: #0077b3; font-size: 12px; ">
                    <span style="font-size: large;font-weight: bold;color:#000">2 </span>
                    Followings
                </div>
                <div style="float:right; width:100%; text-align: right; border-bottom: 1px solid #ccc ; color: #0077b3; font-size: 12px; ">
                    <span style="font-size: large;font-weight: bold;color:#000">2 </span>
                    Followers
                </div>
            </div><!--/span-->
          </div><!--/row-->



            </div>

            <div class="row-fluid">
                <div class="well" id="cuerpo" style="background-color: #fff; display: none;"></div>
            </div><!--/row-->
        </div><!--/span-->
    </div><!--/row-->
    <script>
                    cargar('#cuerpo','http://localhost:8080/Canario-Primavera-1/tweet/${user.nombre}');
    </script>

    <jsp:include page="../footer.jsp" />
