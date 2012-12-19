<%@include file="includes.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


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
          
            <a class="brand" href="#"><img src="<c:url value="/resources/img/logo.png" />" width="20"> Proyecto CANARIO</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
               <li class="active"><a href="<c:url value="/" />">Home</a></li>
              <li><a href="#about">Quiénes somos</a></li>
              <li><a href="#contact">Contacto</a></li>
            </ul>
           <form:form modelAttribute="usuario" action="usuario/iniciarSesion"  method="post" cssClass="navbar-form pull-right" >
                    <form:input path="email" placeholder="Email" cssClass="span2"/>	
                    <form:password path="password"  placeholder="Contraseña" cssClass="span2"/>	
                    <input type="submit" value="Iniciar sesión" class="btn" />
           </form:form>     
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

      <!-- Main hero unit for a primary marketing message or call to action -->






      <!-- Example row of columns -->
   <div class="hero-unit">
        <h2>Bienvenido al proyecto CANARIO!</h2>
        <p>Regístrese ahora y únase al mundo de los canarios.</p>
      <div class="row">
        <div class="span6"> 
            
		<form:form modelAttribute="usuario" action="usuario/registrar" method="post">
		  	<fieldset>		
				<legend>Formulario de registro</legend>
                                                                             <form:hidden path="id" />
				<p>
					<form:label for="nombre" path="nombre"  cssErrorClass="error">Nombre de usuario:</form:label>
                                
                                         <div class="controls">
                                            <div class="input-prepend">
                                              <span class="add-on">@</span>
                                              <form:input path="nombre" style="width:200px" cssClass="span2"  id="inputIcon"/>                                            
                                            </div>
                                          </div>				
                                
                                
				<p>	<form:label for="email" path="email" cssErrorClass="error">E-mail</form:label>
                                        <form:input path="email" cssStyle="width:350px" id="email" name="email" type="text" cssClass=":email :required :ajax;${pageContext.request.contextPath}/validacion/usuario : only_on_blur"/>
				</p>
                                <p>
                                        <form:label for="password" path="password" cssErrorClass="error">Contraseña</form:label>
    					<form:password path="password"  style="width:350px"/>			
				</p>
                                <p>
                                   <form:label for="localidad" path="localidad" cssErrorClass="error" style="width:350px">Localidad</form:label>
                                   <form:select path="localidad">
                                        <form:option value="Carrodilla" label="Carrodilla" />
                                        <form:option value="Chacras de Coria" label="Chacras de Coria" />
                                        <form:option value="Ciudad" label="Ciudad" />
                                        <form:option value="General alvear" label="General alvear" />
                                        <form:option value="Godoy Cruz" label="Godoy Cruz" />
                                        <form:option value="Guaymallen" label="Guaymallen" />
                                        <form:option value="Junin" label="Junin" />
                                        <form:option value="La Consulta" label="La Consulta" />
                                        <form:option value="La Paz" label="La Paz" />
                                        <form:option value="La Puntilla" label="La Puntilla" />
                                        <form:option value="Las Heras" label="Las Heras" />
                                        <form:option value="Lavalle" label="Lavalle" />
                                        <form:option value="Lujan de Cuyo" label="Lujan de Cuyo" />
                                        <form:option value="Maipu" label="Maipu" />
                                        <form:option value="Malargue" label="Malargue" />
                                        <form:option value="Mayor Drummond" label="Mayor Drummond" />
                                        <form:option value="Palmira" label="Palmira" />
                                        <form:option value="Perdriel" label="Perdriel" />
                                        <form:option value="Rivadavia" label="Rivadavia" />
                                        <form:option value="San Carlos" label="San Carlos" />
                                        <form:option value="San Martin" label="San Martin" />
                                        <form:option value="San Rafael" label="San Rafael" />
                                        <form:option value="Santa Rosa" label="Santa Rosa" />
                                        <form:option value="Tunuyan" label="Tunuyan" />
                                        <form:option value="Tupungato" label="Tupungato" />
                                        <form:option value="Vistalba" label="Vistalba" />
                                    </form:select>
                                </p>
                                <p>
                                        <form:label for="biografia" path="biografia" cssErrorClass="error">Biografía</form:label>
                                        <form:textarea path="biografia" cols="30" rows="4" style="width:980px" />			
				</p>
                                
                                <p>&nbsp;	
                                    <input type="submit" value="Registrarse" />
				</p>
			</fieldset>
		</form:form>
	<!--	<hr>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
-->

      </div>
        
        <div class="span4">
        
       </div>
        <div class="span4">
         <br><img src="<c:url value="/resources/img/logor.png" />"  width="286" height="310">        </div>
      </div>
      
      </div>

        

<jsp:include page="footer.jsp" />
