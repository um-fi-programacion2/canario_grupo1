<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


      <!-- Main hero unit for a primary marketing message or call to action -->
 

    
         <!-- Example row of columns -->
   <div class="hero-unit">
           <h2>Bienvenido al proyecto CANARIO! (INDEX)</h2>
        <p>Regístrese ahora y únase al mundo de los canarios.</p>
      <div class="row">
        <div class="span6"> 
        <form>
                <legend>Formulario de registro</legend>
                    <label>Nombre</label>
                    <input type="text" placeholder="Nombre">

                    <label>Apellidos</label>
                    <input type="text" placeholder="Apellidos">
                    
                   	<label>Correo Electronico</label>
                    <input type="text" placeholder="Email">
                    
                    <label>Contraseña</label>
                    <input type="password" placeholder="Password">
 
               
                    <span class="help-block">Example block-level help text here.</span>
                    <label class="checkbox">
                    <input type="checkbox"> Check me out
                    </label>

                <button type="submit" class="btn">Registrarse!</button>
        </form>   
      </div>
        
        <div class="span4">
        
       </div>
        <div class="span4">
         <br><img src="./resources/img/logor.png"  width="286" height="310">        </div>
      </div>
      
      </div>



<%@include file="footer.jsp" %>