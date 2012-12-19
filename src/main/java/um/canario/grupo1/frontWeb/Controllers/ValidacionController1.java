package um.canario.grupo1.frontWeb.Controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.FollowDao;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;

@Controller
@RequestMapping(value = "/validacion")
public class ValidacionController1 {

    
    @RequestMapping(value = "/usuario", method = RequestMethod.POST)
    public String validarUsuario(@PathVariable String usuario, HttpServletRequest request) {
        
        //request.get;

        System.err.println("usuario: " + usuario);
        request.getSession().setAttribute("offsetTimeline","0");
        return "timeline";
    }
    
   

}
