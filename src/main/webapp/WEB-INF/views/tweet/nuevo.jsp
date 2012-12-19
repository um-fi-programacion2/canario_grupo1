<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp" />




      <!-- Example row of columns -->
   <div class="hero-unit">
        
      <div class="row">
        <div class="span6"> 
            <h1>Nuevo tweet </h1><br>
            
        <form:form action="${pageContext.request.contextPath}/tweet/nuevo/procesar" modelAttribute="tweet" method="post">
            <form:textarea path="tweet" style="width:400px;height:100px;"></form:textarea>
                <form:hidden path="idUsuario" value='<%= session.getAttribute("id") %>'></form:hidden>
                <br><input type="submit" value="Tweetear!">
        </form:form>
      </div>
        
        <div class="span4">

       </div>
        <div class="span4">
         <img src="<c:url value="/resources/img/logor.png" />"  width="286" height="310">        </div>
      </div>
      
      </div>

        

<jsp:include page="../footer.jsp" />
