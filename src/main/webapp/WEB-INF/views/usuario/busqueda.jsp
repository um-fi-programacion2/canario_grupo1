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
                        <button class="btn btn-success" type="button" style="margin-right: 25px"><i class="icon-ok icon-white" ></i> Follow</button>
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
