<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


<div class="container-fluid" >
    <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">USER KEY</li>
              <li style="font-size: 10px; color: #3a87ad">
                  Si desea usar la API del proyecto CANARIO use el USERKEY para autentificar la identidad de su usuario con cada request.</li>
            </ul>
            </div>
            <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">APP KEYS</li>
              <li  style="font-size: 10px; color: #3a87ad">
                  Las aplicaciones permitidas en el sistema, son fijadas por los administradores.
              </li>
            </ul>
            </div>
        </div>

         <div class="span9">
            <div class="hero-unit" style="padding:15px;">
                <div class="row-fluid">
                    <div class="span12">
                      <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                          <li class="nav-header">USER KEY</li>
                          <li><button type="button" class="btn btn-large btn-primary disabled" disabled="disabled"><%= session.getAttribute("key") %></button></li>
                        </ul>
                        </div>
                        <div class="well sidebar-nav">
                        <ul class="nav nav-list">
                          <li class="nav-header">APP KEYS</li>
                          <li>
                          <div class="span3">
                             iOS<br />
                              <button type="button" class="btn btn-large btn-primary disabled" disabled="disabled"><%= session.getAttribute("iOS") %></button>
                          </div>
                          <div class="span3">    
                          Android<br />
                          <button type="button" class="btn btn-large btn-primary disabled" disabled="disabled"><%= session.getAttribute("Android") %></button>
                          </div>
                        <div class="span3">
                          Windows Phone<br />
                          <button type="button" class="btn btn-large btn-primary disabled" disabled="disabled"><%= session.getAttribute("Windows Phone") %></button>
                                                   </div>
                              <br /><br /><br /><br /><br />
                         </ul>
                        </div>
                       <div class="well sidebar-nav">
                        <fieldset><legend>Obtener tweets de un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/gettweets/{USERKEY}/{APPKEY}
                        </fieldset>
                        </div>
                        <div class="well sidebar-nav">
                        <fieldset><legend>Enviar un tweet</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/settweet/{USERKEY}/{APPKEY}/{tweet}
                        </fieldset>
                        </div>
                        <div class="well sidebar-nav">
                        <fieldset><legend>Obtener seguidores de un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/getfollowers/{USERKEY}/{APPKEY}
                        </fieldset>
                        </div>
                        <div class="well sidebar-nav">
                        <fieldset><legend>Obtener a quien sigue un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/getfollowings/{USERKEY}/{APPKEY}
                        </fieldset>
                        </div>
                        </div>
                    </div>
                </div><!--/row-->
           </div>             
        </div><!--/span-->
    </div><!--/row-->

    <jsp:include page="../footer.jsp" />
