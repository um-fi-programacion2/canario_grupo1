<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


  <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Tweets publicados por mi</li>
              <li><a href="#" onclick="cargar('#cuerpo','http://localhost:8080/Canario-Primavera-1/tweet/tweets')">Tweets</a></li>
              <li class="nav-header">Personas a las que sigo</li>
              <li><a href="#">Following</a></li>
              <li class="nav-header">Personas que me siguen</li>
              <li><a href="#">Followers</a></li>
            </ul>
          </div><!--/.well -->
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Tweets en los que aparezco</li>
              <li><a href="#">Mentions</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->
        
        <div class="span9">
            <div class="hero-unit" style="padding:15px;">
              
              
              
              <table cellspacing="0" style="width: 100%;">
  <tr>
    <td rowspan="4" valign="top" style=" white-space: nowrap; width: 1px;">
        <a href="${pageContext.request.contextPath}/usuario/perfil">
            <img src="${pageContext.request.contextPath}/resources/img/usuarios/<%= session.getAttribute("imagen") %>" class="img-rounded" width="140" style="margin-right: 15px;" > 
        </a>
    </td>
    <td><a href="${pageContext.request.contextPath}/usuario/perfil">
            <h3 style="margin-top: 0px; padding-top: 0px">@ <%= session.getAttribute("nombre") %> </h3></td>
        </a>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td style="height:30px;">&nbsp;</td>
    <td>

            <div style="float:right; width:100%; text-align: right; border-bottom: 1px solid #ccc ; color: #0077b3; font-size: 12px; ">
              <span style="font-size: large;font-weight: bold;color:#000">2 </span>
                Tweets
            </div>
    </td>
  </tr>
  <tr>
    <td style="height:30px;">&nbsp;</td>
    <td>
            <div style="float:right; width:100%; text-align: right; border-bottom: 1px solid #ccc; color: #0077b3; font-size: 12px; ">
            <span style="font-size: large;font-weight: bold; color:#000">13 </span>
        Following
        </div>
    </td>
  </tr>
  <tr>
      <td style="height:30px;">&nbsp;</td>
    <td>
           <div style="float:right; width:100%; text-align: right; border-bottom: 1px solid #ccc; color: #0077b3; font-size: 12px; ">
            <span style="font-size: large;font-weight: bold; color:#000">13 </span>
        Following
        </div> 
    </td>
  </tr>
</table>
</div>
          <div class="row-fluid">
              <div class="well" id="cuerpo" style="background-color: #f7f7f7">asdasd</div>
          </div><!--/row-->
        </div><!--/span-->
      </div><!--/row-->

        

<jsp:include page="../footer.jsp" />
