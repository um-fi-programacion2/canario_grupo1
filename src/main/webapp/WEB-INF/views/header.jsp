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
          
            <a class="brand" href="#"><img src="<c:url value="/resources/img/logo.png" />" width="20"> Proyecto CANARIO</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="<c:url value="/usuario/home" />">Home</a></li>
              <li><a href="<c:url value="/timeline" />">Timeline</a></li>
              <li><a href="#about">Quiénes somos</a></li>
            </ul>
                <div style="float: right; text-align: right; display: inline-block; padding-top: 10px; color: #FFF; padding-right: 15px">
                    <a href="<c:url value="/Canario-Primavera-1/usuario/perfil" />" style="color:#FFF;"> <%= session.getAttribute("email") %></a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    
                    <a href="<fmt:message key="url.app"/>usuario/cerrarSesion" style=" font-weight: bold;">Cerrar sesión</a>
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