<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp" />




      <!-- Example row of columns -->
   <div class="hero-unit">
        <h2>Bienvenido al proyecto CANARIO!</h2>
        <p>Regístrese ahora y únase al mundo de los canarios.</p>
      <div class="row">
        <div class="span6"> 
            
		<form:form modelAttribute="usuario" action="usuario" method="post">
		  	<fieldset>		
				<legend>Formulario de registro</legend>
				<p>
					<form:label for="name" path="name" cssErrorClass="error">Nombre</form:label>
					<form:input path="name" /> <form:errors path="name" />			
				</p>
				<p>	
					<form:label for="balance" path="balance" cssErrorClass="error">Balance</form:label>
					<form:input path="balance" /> <form:errors path="balance" />
				</p>
				<p>
					<form:label for="equityAllocation" path="equityAllocation" cssErrorClass="error">Equity Allocation</form:label>
					<form:input path="equityAllocation" /> <form:errors path="equityAllocation" />
				</p>
				<p>	
					<form:label for="renewalDate" path="renewalDate" cssErrorClass="error">Renewal Date</form:label>
					<form:input path="renewalDate" /> <form:errors path="renewalDate" />
				</p>
				<p>	
					<input type="submit" />
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
         <br><img src="./resources/img/logor.png"  width="286" height="310">        </div>
      </div>
      
      </div>

        

<jsp:include page="../footer.jsp" />
