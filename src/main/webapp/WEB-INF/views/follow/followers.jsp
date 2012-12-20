<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach items="${usuarios}" var="followers">

    <div style="border-bottom: 1px #bce8f1 solid; margin-bottom: 15px; padding-bottom: 15px;">
        <div style="padding: 0px; float:left; padding-top: 5px;">
            <a href="${pageContext.request.contextPath}/usuario/${followers.nombre}" style="font-size:x-small">
                <img src="${pageContext.request.contextPath}/resources/img/usuarios/${followers.imagen}" class="img-rounded" width="50" style="margin-right: 15px;" >
            </a>
        </div>
        <div style="padding: 0px; float: right; font-size: x-small;">
            ${tweet.fecha} 
        </div>
        <div style="padding: 0px; ">
            <a href="${pageContext.request.contextPath}/usuario/${followers.nombre}" style="font-size:x-small">
                @ ${followers.nombre}
            </a>
        </div>
        <div style="padding: 0px;">
            ${followers.biografia}                        
        </div>
    </div>

</c:forEach>

<div id="followers"></div>