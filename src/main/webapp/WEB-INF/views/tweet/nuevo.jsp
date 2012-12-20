<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp" />



<div style="display: none"><%= request.getSession().getAttribute("errorTweet") %> </div>
<!-- Example row of columns -->
<div class="hero-unit">

    <div class="row">
        <div class="span6"> 
            <h1>Nuevo tweet </h1><br>

            <form:form action="${pageContext.request.contextPath}/tweet/nuevo/procesar"  modelAttribute="tweet" method="post">
                <span id="sprytextarea1">
                    <form:textarea path="tweet"  name="texto"  id="tuit" style="width:400px;height:100px;" onKeyDown="cuenta()" onKeyUp="cuenta()" ></form:textarea>
                    <span class="textareaRequiredMsg">Escriba algo...</span>
                    <span class="textareaMaxCharsMsg">Ha superado los 200 caracteres permitidos</span>
                </span>
                <form:hidden path="idUsuario" value='<%= session.getAttribute("id")%>'></form:hidden>
                <div id="caracteres"></div>
                <br><input type="submit" value="Tweetear!">
            </form:form>
        </div>

        <div class="span4">

        </div>
        <div class="span4">
            <img src="<c:url value="/resources/img/logor.png" />"  width="286" height="310">        </div>
    </div>

</div>

<script> 
    function cuenta(){ 
    
        $("#caracteres").empty();

        nroCaracteres = document.getElementById('tuit').value.length;
    
        caracteresRestantes = 200 - nroCaracteres;
    
        if(caracteresRestantes<0){
            $("#caracteres").css('color','red');       
        }
        else{
            $("#caracteres").css('color','black');       
        }
        
        $("#caracteres").append("Caracteres restantes: " + caracteresRestantes);

    
    } 
</script>

<script type="text/javascript">
    <!--
    var sprytextarea1 = new Spry.Widget.ValidationTextarea("sprytextarea1", {maxChars:200});
    //-->
</script>

<jsp:include page="../footer.jsp" />
