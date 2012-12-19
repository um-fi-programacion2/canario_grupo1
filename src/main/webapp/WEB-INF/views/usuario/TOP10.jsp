<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="nav nav-list">
    <li class="nav-header" onclick="cargar('#usersTop', '${pageContext.request.contextPath}/usuario/TOP10');" style="cursor: pointer;">
        <i class="icon-refresh"></i>
            @TOP-10 CANARIOS
    </li><hr style="padding: 0px; margin: 0px; margin-bottom: 15px;" />
    <c:forEach items="${usuarios}" var="usuario">
        <li>
            <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}">@${usuario.nombre}</a>
        </li>
    </c:forEach>
</ul>
