<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


<div class="container-fluid" >
    <div class="row-fluid">
        <div class="span3" >
            <div class="well sidebar-nav" style="position: fixed;">
                <ul class="nav nav-list">
                    <li class="nav-header">Tweets publicados</li>
                    <li id="liTweets"><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/tweet/${user.nombre}');tweets();" style="cursor: pointer">Tweets</a></li>
                    <li class="nav-header">Personas a las que sigo</li>
                    <li id="liFollowings"><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/follow/following/${user.nombre}');followings();" style="cursor: pointer">Following</a></li>
                    <li class="nav-header">Personas que me siguen</li>
                    <li id="liFollowers"><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/follow/followers/${user.nombre}');followers();" style="cursor: pointer">Followers</a></li>
                    <li class="nav-header">Tweets en los que aparezco</li>
                    <li id="liMentions"><a onclick="cargar('#cuerpo','${pageContext.request.contextPath}/menciones/${user.nombre}');mentions();" style="cursor: pointer">Mentions</a></li>
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
                            <c:if test="${user.id != sessionId}">
                                <c:if test="${ empty relaciones}">
                                    <button id="${user.id}follow" onclick="follow('#${user.id}','${pageContext.request.contextPath}/follow/${user.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 140px"><i class="icon-ok icon-white" ></i> Follow</button>
                                    <button id="${user.id}unfollow" onclick="unfollow('#${user.id}','${pageContext.request.contextPath}/follow/unfollow/${user.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 140px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                </c:if>
                                <c:set var="banderaB" value="true" />
                                <c:forEach items="${relaciones}" var="follow">
                                    <c:if test="${banderaB}">
                                        <c:if test="${follow.followed == user.id}">
                                            <button id="${user.id}unfollow" onclick="unfollow('#${user.id}','${pageContext.request.contextPath}/follow/unfollow/${user.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; width: 140px;"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                            <button id="${user.id}follow" onclick="follow('#${user.id}','${pageContext.request.contextPath}/follow/${user.id}')" class="btn btn-success" type="button" style="margin-right: 25px; display: none; width: 140px"><i class="icon-ok icon-white" ></i> Follow</button>
                                            <c:set var="banderaB" value="false" />
                                        </c:if>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${banderaB}">
                                    <c:set var="banderaA" value="true" />
                                    <c:forEach items="${relaciones}" var="follow">
                                        <c:if test="${banderaA}">
                                            <c:if test="${follow.followed!=user.id}">
                                                <button id="${user.id}follow" onclick="follow('#${user.id}','${pageContext.request.contextPath}/follow/${user.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 140px"><i class="icon-ok icon-white" ></i> Follow</button>
                                                <button id="${user.id}unfollow" onclick="unfollow('#${user.id}','${pageContext.request.contextPath}/follow/unfollow/${user.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 140px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                                <c:set var="banderaA" value="false" />
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:if>
                        </div>
                        <div  style="float: left" >
                            <h2>
                                <a href="${pageContext.request.contextPath}/usuario/${user.nombre}">@${user.nombre}</a>
                            </h2>
                            <br />
                            <h5>${user.biografia}</h5>
                        </div>
                    </div>
                </div><!--/row-->

            </div>

            <div class="hero-unit" style="padding:15px;">
                <div class="row-fluid">
                    <div class="well" id="cuerpo">
                    </div>
                </div><!--/row-->
            </div>

            <div class="hero-unit" style="padding: 5px;">
                <div class="row-fluid" >
                    <div style="display: none" id="tweetsButton">
                        <button onclick="append('#tweets','${pageContext.request.contextPath}/tweet/refresh/${user.nombre}');" class="btn btn-large btn-block btn-primary" type="button" ><i class=" icon-plus icon-white"></i> Cargar más...</button>
                    </div>
                    <div style="display: none" id="mentionsButton">
                        <button onclick="append('#mentions','${pageContext.request.contextPath}/menciones/refresh/${user.nombre}')" class="btn btn-large btn-block btn-primary" type="button" ><i class=" icon-plus icon-white"></i> Cargar más...</button>
                    </div>
                    <div style="display: none" id="followersButton">
                        <button onclick="append('#followers','${pageContext.request.contextPath}/follow/followers/refresh/${user.nombre}')" class="btn btn-large btn-block btn-primary" type="button" ><i class=" icon-plus icon-white"></i> Cargar más...</button>
                    </div>
                    <div style="display: none" id="followingsButton">
                        <button onclick="append('#followings','${pageContext.request.contextPath}/follow/following/refresh/${user.nombre}')" class="btn btn-large btn-block btn-primary" type="button" ><i class=" icon-plus icon-white"></i> Cargar más...</button>
                    </div>             
                </div>
            </div>
            </div><!--/span-->
        </div><!--/row-->
        <script>   
                    cargar('#cuerpo','${pageContext.request.contextPath}/tweet/${user.nombre}');
                    tweets();
        </script>

        <jsp:include page="../footer.jsp" />
