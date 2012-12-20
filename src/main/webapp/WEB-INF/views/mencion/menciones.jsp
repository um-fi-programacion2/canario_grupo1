<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            
        <c:forEach items="${tweets}" var="tweet">
            <c:forEach items="${usuarios}" var="usuario">
                <c:if test="${usuario.id == tweet.idUsuario}">
                <div style="border-bottom: 1px #bce8f1 solid; margin-bottom: 15px; padding-bottom: 15px;">
                     <div style="padding: 0px; float:left; padding-top: 5px;">
                            <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}" style="font-size:x-small">
                                <img src="${pageContext.request.contextPath}/resources/img/usuarios/${usuario.imagen}" class="img-rounded" width="50" style="margin-right: 15px;" >
                            </a>
                        </div>
                        <div style="padding: 0px; float: right; font-size: x-small;">
                            ${tweet.fecha} 
                        </div>
                        <div style="padding: 0px; ">
                            <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}" style="font-size:x-small">
                                @ ${usuario.nombre}
                            </a>
                        </div>
                        <div style="padding: 0px;" id="${tweet.id}">
                            <script type="text/javascript">
                            var tweet = "${tweet.tweet}";
                            prueba = document.getElementById("${tweet.id}");
                            prueba.innerHTML = tweet.parseUsername().parseHashtag();
                          </script>
                        </div>
                         <div style="padding: 0px; text-align: right;" >
                        <c:if test="${tweet.autor == 0}">
                            <a href="${pageContext.request.contextPath}/tweet/retweet/${tweet.id}" style="font-size:x-small">
                                <span style="margin-right: 25px"><i class="icon-retweet"></i> retweet</span>
                            </a>
                        </c:if>
                        <c:if test="${tweet.autor != 0}">
                            <a href="${pageContext.request.contextPath}/usuario/${tweet.autor}" style="font-size:x-small">
                                <span style="margin-right: 25px"><i class="icon-fire"></i> retweeted :: @${tweet.autor}</span>
                            </a>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/tweet/nuevo/${usuario.nombre}" style="font-size:x-small">
                            <span style="margin-right: 25px"><i class="icon-share"></i> reply</span>
                        </a>
                    </div>
                </div>
                </c:if>
            </c:forEach>
        </c:forEach>
        <div id="mentions"></div>
