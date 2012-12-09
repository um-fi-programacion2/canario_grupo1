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
            
		<form:form modelAttribute="usuario" action="${usuario.id}" method="post">
		  	<fieldset>		
				<legend>View Account</legend>
				<p>
					<form:label for="name" path="name">Name</form:label><br/>
					<form:input path="name" readonly="true"/>		
				</p>
				<p>	
					<form:label for="balance" path="balance">Balance</form:label><br/>
					<form:input path="balance" readonly="true"/>
				</p>
				<p>
					<form:label for="equityAllocation" path="equityAllocation">Equity Allocation</form:label><br/>
					<form:input path="equityAllocation" readonly="true"/>
				</p>
				<p>	
					<form:label for="renewalDate" path="renewalDate">Renewal Date</form:label><br/>
					<form:input path="renewalDate" readonly="true"/>
				</p>
			</fieldset>
		</form:form>
	</div>
        
        <div class="span4">
        
       </div>
        <div class="span4">
            <br><img src="<c:url value="/resources/img/logor.png" />" width="286" height="310">        </div>
      </div>
      
      </div>


<jsp:include page="../footer.jsp" />
