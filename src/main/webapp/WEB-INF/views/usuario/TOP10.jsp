<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="nav nav-list">
    <li class="nav-header" onclick="cargar('#usersTop', '${pageContext.request.contextPath}/usuario/TOP10');" style="cursor: pointer;">
        <i class="icon-refresh"></i>
        @TOP-10 CANARIOS
    </li><hr style="padding: 0px; margin: 0px; margin-bottom: 15px;" />
    <li><select id="localidad" name="localidad" style="font-size: 10px; width:80%; height: 40%;" onchange="cargar('#usersTop', '${pageContext.request.contextPath}/usuario/TOP10/' + this.value)">
            <option value="" selected="selected">Filtrar por ciudad</option>
            <option value="">MOSTRAR TODOS</option>
            <option value="Carrodilla">Carrodilla</option>
            <option value="ChacrasDeCoria">Chacras de Coria</option>
            <option value="Ciudad">Ciudad</option>
            <option value="GeneralAlvear">General alvear</option>
            <option value="GodoyCruz">Godoy Cruz</option>
            <option value="Guaymallen">Guaymallen</option>
            <option value="Junin">Junin</option>
            <option value="LaConsulta">La Consulta</option>
            <option value="LaPaz">La Paz</option>
            <option value="LaPuntilla">La Puntilla</option>
            <option value="LasHeras">Las Heras</option>
            <option value="Lavalle">Lavalle</option>
            <option value="LujandeCuyo">Lujan de Cuyo</option>
            <option value="Maipu">Maipu</option>
            <option value="Malargue">Malargue</option>
            <option value="MayorDrummond">Mayor Drummond</option>
            <option value="Palmira">Palmira</option>
            <option value="Perdriel">Perdriel</option>
            <option value="Rivadavia">Rivadavia</option>
            <option value="SanCarlos">San Carlos</option>
            <option value="SanMartin">San Martin</option>
            <option value="SanRafael">San Rafael</option>
            <option value="SantaRosa">Santa Rosa</option>
            <option value="Tunuyan">Tunuyan</option>
            <option value="Tupungato">Tupungato</option>
            <option value="Vistalba">Vistalba</option>
        </select></li>
        <c:forEach items="${usuarios}" var="usuario">
        <li>
            <a href="${pageContext.request.contextPath}/usuario/${usuario.nombre}">@${usuario.nombre}</a>
        </li>
    </c:forEach>
</ul>
