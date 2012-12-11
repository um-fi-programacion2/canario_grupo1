<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../header.jsp" />




      <!-- Example row of columns -->
   <div class="hero-unit">

        <h1>Modificar perfil</h1>
      <div class="row">
        <div class="span6"> 
            
		<form:form modelAttribute="usuario" action="${pageContext.request.contextPath}/usuario/perfil/modificar" method="post">
		  	<fieldset>		
				<legend> </legend>
                                                                             <form:hidden path="id" />
				<p>
					<form:label for="nombre" path="nombre"  cssErrorClass="error">Nombre de usuario:</form:label>
                                
                                          <div class="controls">
                                            <div class="input-prepend">
                                              <span class="add-on">@</span>
                                              <form:input path="nombre" style="width:200px" cssClass="span2"  id="inputIcon"/>                                            
                                            </div>
                                          </div>
                                				
				</p>
				<p>
					<form:label for="email" path="email" cssErrorClass="error">E-mail </form:label>
					<form:input path="email"  style="width:350px"/>			
				</p>
                                <p>
                                        <form:label for="password" path="password" cssErrorClass="error">Contraseña</form:label>
    					<form:password path="password"  style="width:350px"/>			
				</p>
                                <p>
                                   <form:label for="localidad" path="localidad" cssErrorClass="error" style="width:350px">Localidad</form:label>
                                   <form:select path="localidad">
                                        <form:option value="Carrodilla" label="Carrodilla" />
                                        <form:option value="Chacras de Coria" label="Chacras de Coria" />
                                        <form:option value="Ciudad" label="Ciudad" />
                                        <form:option value="General alvear" label="General alvear" />
                                        <form:option value="Godoy Cruz" label="Godoy Cruz" />
                                        <form:option value="Guaymallen" label="Guaymallen" />
                                        <form:option value="Junin" label="Junin" />
                                        <form:option value="La Consulta" label="La Consulta" />
                                        <form:option value="La Paz" label="La Paz" />
                                        <form:option value="La Puntilla" label="La Puntilla" />
                                        <form:option value="Las Heras" label="Las Heras" />
                                        <form:option value="Lavalle" label="Lavalle" />
                                        <form:option value="Lujan de Cuyo" label="Lujan de Cuyo" />
                                        <form:option value="Maipu" label="Maipu" />
                                        <form:option value="Malargue" label="Malargue" />
                                        <form:option value="Mayor Drummond" label="Mayor Drummond" />
                                        <form:option value="Palmira" label="Palmira" />
                                        <form:option value="Perdriel" label="Perdriel" />
                                        <form:option value="Rivadavia" label="Rivadavia" />
                                        <form:option value="San Carlos" label="San Carlos" />
                                        <form:option value="San Martin" label="San Martin" />
                                        <form:option value="San Rafael" label="San Rafael" />
                                        <form:option value="Santa Rosa" label="Santa Rosa" />
                                        <form:option value="Tunuyan" label="Tunuyan" />
                                        <form:option value="Tupungato" label="Tupungato" />
                                        <form:option value="Vistalba" label="Vistalba" />
                                    </form:select>
                                </p>
                                <p>
                                        <form:label for="biografia" path="biografia" cssErrorClass="error">Biografía</form:label>
                                        <form:textarea path="biografia" cols="30" rows="4" style="width:980px" />			
				</p>
                                
                                <p>&nbsp;	
                                    <input type="submit" value="Guardar cambios" />
				</p>
			</fieldset>
		</form:form>
	<!--	<hr>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
-->

      </div>
        
        <div class="span4">
        
       </div>
        <div class="span4">
            <br><img  style="width: 180px;" class="img-polaroid" src="${pageContext.request.contextPath}/resources/img/usuarios/<%= session.getAttribute("imagen") %>"  width="286" height="310">       
            <br><a href="${pageContext.request.contextPath}/usuario/perfil/imagen">Cambiar foto de perfil</a>
        </div>
      </div>
      
      </div>

        

<jsp:include page="../footer.jsp" />
