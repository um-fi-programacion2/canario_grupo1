<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp" />




      <!-- Example row of columns -->
   <div class="hero-unit">

        <h1>Modificar Foto</h1>
      <div class="row">
        <div class="span6"> 
            
            <form  action="${pageContext.request.contextPath}/usuario/perfil/imagen/procesar" method="post" enctype="multipart/form-data">
		  	<fieldset>		
                            <legend> Es la foto de perfil pública</legend>
                                <input type="file" name="file" /><br><input type="submit" value="Cambiar!" />
                        </fieldset>
		</form>
	<!--	<hr>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
-->

      </div>
        
        <div class="span4">
        
       </div>
        <div class="span4">
         <br>
         <img  style="width: 180px;" class="img-polaroid" src="${pageContext.request.contextPath}/resources/img/usuarios/<%= session.getAttribute("imagen") %>"  width="286" height="310">        </div>
        </div>
      </div>
      
        

<jsp:include page="../footer.jsp" />

