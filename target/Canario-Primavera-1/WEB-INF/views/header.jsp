<%@include file="includes.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Proyecto CANARIO</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="La red social de 140 caracteres">
    <meta name="author" content="Grupo1 UNIVERSIDAD DE MENDOZA">

    <!-- Le styles -->
    
    <link  href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
         background-image: url("<c:url value="/resources/img/bg.png" />");
         background-position: left 40px;
         background-attachment: fixed;
         background-repeat: no-repeat;
         background-color: #C0DEED;
      }
    </style>

    
    
    <link href="<c:url value="/resources/css/bootstrap-responsive.css" />" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/img/resources/favicon.ico" />" type="image/x-icon" />
    <link rel="icon" href="<c:url value="/resources/img/favicon.ico" />" type="image/x-icon" />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          
            <a class="brand" href="${pageContext.request.contextPath}/timeline"><img src="${pageContext.request.contextPath}/resources/img/logo.png" width="20"> Proyecto CANARIO</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
               <li><a href="${pageContext.request.contextPath}/usuario/home"><i class="icon-home icon-white"></i> Home</a></li>
              <li><a href="${pageContext.request.contextPath}/timeline"><i class="icon-indent-left icon-white"></i> Timeline</a></li>
              <li><a href="${pageContext.request.contextPath}/tweet/nuevo"><i class="icon-edit icon-white"></i> Nuevo tweet</a></li>
            </ul>
                <div style="float: right; display: inline-block; padding-top: 10px; color: #FFF;">
                    <a href="${pageContext.request.contextPath}/usuario/perfil" style="color:#FFF;"></a>

                        
                    <div class="btn-group" style="margin-top: -3px;">
                          <a class="btn btn-primary" href="${pageContext.request.contextPath}/usuario/perfil">
                              <i class="icon-user icon-white"></i> 
                              <%= session.getAttribute("email") %>
                          </a>
                          <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
                          <ul class="dropdown-menu">
                              <li>
                                  <a href="${pageContext.request.contextPath}/usuario/perfil">
                                       <img src="${pageContext.request.contextPath}/resources/img/usuarios/<%= session.getAttribute("imagen") %>" class="img-circle" width="30" > 
                                       <span style="font-weight: bold">
                                           <%= session.getAttribute("nombre") %>
                                       </span>
                               </li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/usuario/perfil/modificar/imagen" > <i class="icon-picture"></i> Cambiar imagen de perfil</a></li>
                            <li><a href="#"><i class="icon-bell"></i> Configurar notificaciones</a></li>
                            <li><a href="#"><i class="icon-eye-open"></i> Ver mi página de usuario pública</a></li>
                            <li class="divider"></li>
                            <li><a href="${pageContext.request.contextPath}/usuario/cerrarSesion"><i class="icon-off"></i> Cerrar sesión</a></li>
                          </ul>
                        </div>
                </div> 
                            
<!-- 
            <form class="navbar-form pull-right">
              <input class="span2" type="text" placeholder="Email">
              <input class="span2" type="password" placeholder="Password">
              <button type="submit" class="btn">Iniciar sesión</button>
            </form>
-->               
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">