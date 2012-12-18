<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../header.jsp" />


<div class="container-fluid" >
    <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">USER KEY</li>
              <li><button type="button" class="btn btn-large btn-primary disabled" disabled="disabled">HF8AAB</button></li>
            </ul>
            </div>
            <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">APP KEYS</li>
              <li><button type="button" class="btn btn-large btn-primary disabled" disabled="disabled">HF8AAB</button></li>
            </ul>
            </div>
        </div>

         <div class="span9">
            <div class="hero-unit" style="padding:15px;">
                <div class="row-fluid">
                    <div class="span12">
                         
                        <fieldset><legend>Obtener datos de un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/getuser/ + {usuario} + / + {USERKEY} + / + {APPKEY}
                        </fieldset><br /><br />
                        <fieldset><legend>Obtener tweets de un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/gettweets/ + {usuario} + / + {USERKEY} + / + {APPKEY}
                        </fieldset><br /><br />
                        <fieldset><legend>Obtener seguidores de un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/getfollowers/ + {usuario} + / + {USERKEY} + / + {APPKEY}
                        </fieldset><br /><br />
                        <fieldset><legend>Obtener a quien sigue un usuario</legend>
                            http://localhost:8080/Canario-Primavera-1/ws/getfollowings/ + {usuario} + / + {USERKEY} + / + {APPKEY}
                        </fieldset><br /><br />
                    </div>

                </div><!--/row-->
           </div>

             <div class="row-fluid">
                 <div class="well" id="cuerpo" style="background-color: #fff; display: none;"></div>
            </div><!--/row-->
        </div><!--/span-->
    </div><!--/row-->
    <script>
                    cargar('#cuerpo','http://localhost:8080/Canario-Primavera-1/tweet/${user.nombre}');
    </script>

    <jsp:include page="../footer.jsp" />
