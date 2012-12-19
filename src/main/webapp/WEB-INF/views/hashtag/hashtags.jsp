<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


<div class="container-fluid" >
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Actualidad con el mundo</li>
              <li><div style="padding: 0px;" id="123">
                            <script type="text/javascript">
                            var tweet = "#${tag}";
                            prueba = document.getElementById("123");
                            prueba.innerHTML = tweet.parseHashtag();
                          </script>
                        </div>
              </li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        
        <div class="span9">
            
          
          <div class="row-fluid">
              <div class="well" id="cuerpo" style="background-color: #fff; display: none;">
                  
                  
                  
                  <h5>Resultado de la búsqueda</h5></div>
        </div>

        <div class="row-fluid">
            <div class="well" id="h" style="">
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

                            </div>
                        </c:if>
                    </c:forEach>
               </c:forEach>
                
                  
              </div>
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->


<jsp:include page="../footer.jsp" />
