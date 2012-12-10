<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp" />




      <!-- Example row of columns -->
   <div class="hero-unit">
        <h2>Bienvenido al proyecto CANARIO!</h2>
        <p>Regístrese ahora y únase al mundo de los canarios.</p>
      <div class="row">
        <div class="span6"> 
            
            <h1>TIMELINE</h1>
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
