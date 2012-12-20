package um.canario.grupo1.frontWeb.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try {
            String uri = request.getRequestURI();
            if (!uri.endsWith("/usuario/iniciarSesion") && !uri.endsWith("/es/") && !uri.endsWith("usuario/registrar") && !uri.contains("resources/") && !uri.contains("/ws/")) {

                    if (request.getSession().getAttribute("nombre") == null) {
                        System.err.println("NO HAY SESSIÓN");
                        response.sendRedirect(request.getContextPath() + "/es/");
                        return false;
                    }
            }
        } catch (Exception e) {
            System.err.println("ERROR INTERCEPTOR:" + e);
        }
        return true;
    }
}