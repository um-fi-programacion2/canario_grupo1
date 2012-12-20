package um.canario.grupo1.frontWeb.Controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.dao.MencionesDao;

@Controller
@RequestMapping(value = "/menciones")
public class MencionController {

    @RequestMapping(value = "/{usuario}", method = RequestMethod.GET)
    public String getMenciones(@PathVariable String usuario, Model model, MencionesDao mencionesDao, HttpServletRequest request) {
        
        request.getSession().setAttribute("offsetMentions", "0");
        request.getSession().setAttribute("offsetTweets", "0");
        request.getSession().setAttribute("offsetFollowers", "0");
        request.getSession().setAttribute("offsetFollowings", "0");

        model.addAttribute("tweets", mencionesDao.getTweetsRefresh(usuario, "0"));
        model.addAttribute("usuarios", mencionesDao.getUsuarios(usuario));
        model.addAttribute("user", usuario);

        return ("mencion/menciones");
    }

    @RequestMapping(value = "/refresh/{usuario}", method = RequestMethod.GET)
    public String getMencionesRefresh(@PathVariable String usuario, Model model, MencionesDao mencionesDao, HttpServletRequest request) {

        String offset = request.getSession().getAttribute("offsetMentions").toString();
        Integer offsetInt = Integer.parseInt(offset);
        offsetInt = offsetInt + 5;

        request.getSession().setAttribute("offsetMentions", offsetInt.toString());
        
        model.addAttribute("tweets", mencionesDao.getTweetsRefresh(usuario, offsetInt.toString()));
        model.addAttribute("usuarios", mencionesDao.getUsuarios(usuario));
        model.addAttribute("user", usuario);
        
        return ("mencion/menciones");
    }
}
