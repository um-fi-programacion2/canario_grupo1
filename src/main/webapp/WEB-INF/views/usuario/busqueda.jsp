<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


<div class="container-fluid" >
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">1</li>
              <li>2</li>
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
                <c:forEach items="${usuarios}" var="usuario">
                    <div style="border-bottom: 1px #bce8f1 solid; margin-bottom: 15px; padding-bottom: 15px;">
                        <div style="padding: 0px; float:left; padding-top: 5px;">
                            
                            <c:if test="${ empty relaciones}">
                                        <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 100px"><i class="icon-ok icon-white" ></i> Follow</button>
                                        <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 100px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                            </c:if>
                                                      
                            <c:set var="banderaB" value="true" />
                            <c:forEach items="${relaciones}" var="follow">
                                <c:if test="${banderaB}">
                                    <c:if test="${follow.followed == usuario.id}">
                                        <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; width: 100px;"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                        <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; display: none; width: 100px"><i class="icon-ok icon-white" ></i> Follow</button>
                                        <c:set var="banderaB" value="false" />
                                    </c:if>
                                </c:if>
                            </c:forEach>
                            
                            <c:if test="${banderaB}">
                               <c:set var="banderaA" value="true" />
                               <c:forEach items="${relaciones}" var="follow">
                                   <c:if test="${banderaA}">
                                        <c:if test="${follow.followed!=usuario.id}">
                                            <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 100px"><i class="icon-ok icon-white" ></i> Follow</button>
                                            <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 100px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                            <c:set var="banderaA" value="false" />
                                        </c:if>
                                   </c:if>
                                </c:forEach>
                            </c:if>
                       

                            <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}" style="font-size:x-small">
                                <img src="${pageContext.request.contextPath}/resources/img/usuarios/${usuario.imagen}" class="img-rounded" style="margin-right: 25px;width: 50px;" >
                            </a>
                        </div>
                        <div style="padding: 0px; float: right; font-size: x-small;">
                        </div>
                        <div style="padding: 0px; ">
                            <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}" style="font-size:x-small">
                                @ ${usuario.nombre}
                            </a>
                        </div>
                        <div style="padding: 0px;">
                            ${usuario.biografia}
                        </div>
                    </div>
                </c:forEach>
                  
                  
              </div>
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->


<jsp:include page="../footer.jsp" />
