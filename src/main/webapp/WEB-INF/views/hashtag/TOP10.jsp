<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="nav nav-list">
    <li class="nav-header" onclick="cargar('#hashTop', '${pageContext.request.contextPath}/hashtag/TOP10');" style="cursor: pointer;">
        <i class="icon-refresh"></i>
            #TRENDTOPICS
    </li><hr style="padding: 0px; margin: 0px; margin-bottom: 15px;" />
    <c:forEach items="${tags}" var="tago">
        <li>
            <a href="${pageContext.request.contextPath}/hashtag/${tago.tag}">#${tago.tag}</a>
        </li>
    </c:forEach>
</ul>