<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${ empty relaciones}">
                                        <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 100px"><i class="icon-ok icon-white" ></i> Follow</button>
                                        <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 100px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                            </c:if>
                                                      
                            <c:set var="banderaB" value="true" />
                            <c:forEach items="${relaciones}" var="follow">
                                <c:if test="${banderaB}">
                                    <c:if test="${follow.followed == usuario.id}">
                                        <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; width: 100px;"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                        <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; display: none; width: 100px"><i class="icon-ok icon-white" ></i> Follow</button>
                                        <c:set var="banderaB" value="false" />
                                    </c:if>
                                </c:if>
                            </c:forEach>
                            
                            <c:if test="${banderaB}">
                               <c:set var="banderaA" value="true" />
                               <c:forEach items="${relaciones}" var="follow">
                                   <c:if test="${banderaA}">
                                        <c:if test="${follow.followed!=usuario.id}">
                                            <button id="${usuario.id}follow" onclick="follow('#${usuario.id}','${pageContext.request.contextPath}/follow/${usuario.id}')" class="btn btn-success" type="button" style="margin-right: 25px; width: 100px"><i class="icon-ok icon-white" ></i> Follow</button>
                                            <button id="${usuario.id}unfollow" onclick="unfollow('#${usuario.id}','${pageContext.request.contextPath}/follow/unfollow/${usuario.id}')" class="btn btn-danger" type="button" style="margin-right: 25px; display: none; width: 100px"><i class="icon-remove icon-white" ></i> Unfollow</button>
                                            <c:set var="banderaA" value="false" />
                                        </c:if>
                                   </c:if>
                                </c:forEach>
</c:if>