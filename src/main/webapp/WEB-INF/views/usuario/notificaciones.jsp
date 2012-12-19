<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp" />




      <!-- Example row of columns -->
   <div class="hero-unit">

        <h1>Configurar notificaciones</h1>
      <div class="row">
        <div class="span10"> 
            
            <c:set var="action" value="${pageContext.request.contextPath}/usuario/notificaciones/procesar" />
            <form:form modelAttribute="Userconfig"  action="${pageContext.request.contextPath}/usuario/notificaciones/procesar" method="post">
		  	<fieldset>		
                            <legend><br />Configure cuando desea recibir un email:</legend>
                            <table style="width:350px">
                                <tr style="height: 50px;">
                                    <td style="text-align: right; ">Cuando alguien me mencione en un tweet: </td>
                                    <td>&nbsp;&nbsp;<form:checkbox path="notificacionesMentions" value="${Userconfig.notificacionesMentions}" /></td>
                                </tr>
                                 <tr style="height: 50px;">
                                    <td style="text-align: right;" >Cuando alguien me me siga: </td>
                                    <td>&nbsp;&nbsp;<form:checkbox path="notificacionesFollow" value="${Userconfig.notificacionesFollow}"  /></td>
                                </tr>
                                 <tr style="height: 50px;">
                                    <td style="text-align: right;" >Cuando alguien retweeté uno de mis tweets: </td>
                                    <td>&nbsp;&nbsp;<form:checkbox path="notificacionesRetweet" value="${Userconfig.notificacionesRetweet}" /></td>
                                </tr>
                                <tr style="height: 50px;">
                                    <td colspan="2" style="text-align: center;"><br /><input type="submit" value="Cambiar!" /></td>
                                </tr>
                            </table>
                            
                        </fieldset>
            </form:form><br />
	<!--	<hr>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
-->

      </div>
        
        <div class="span4">
        
       </div>
      </div></div>
      
        

<jsp:include page="../footer.jsp" />

