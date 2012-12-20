package um.canario.grupo1.frontWeb.Controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.FollowDao;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;

@Controller
@RequestMapping(value = "/")
public class indexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("nombre") != null) {
            return "redirect:/usuario/" + request.getSession().getAttribute("nombre");
        }

        model.addAttribute("usuario", new UsuarioBean());

        return "index";
    }

    @RequestMapping(value = "es/", method = RequestMethod.GET)
    public String es(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("nombre") != null) {
            return "redirect:/usuario/" + request.getSession().getAttribute("nombre");
        }

        model.addAttribute("usuario", new UsuarioBean());

        return "index";
    }

    @RequestMapping(value = "timeline", method = RequestMethod.GET)
    public String timeline(HttpServletRequest request) {

        request.getSession().setAttribute("offsetTimeline", "0");
        return "timeline";
    }

    @RequestMapping(value = "timeline/reset", method = RequestMethod.GET)
    public String timelineReset(HttpServletRequest request) {

        request.getSession().setAttribute("offsetTimeline", "0");

        return "redirect:/timeline/refresh";
    }

    @RequestMapping(value = "timeline/refresh", method = RequestMethod.GET)
    public String timelineRefresh(Model model, UsuarioDao usuarioDao, TweetDao tweetDao, HttpServletRequest request, FollowDao followDao) {

        List<TweetBean> tweets = new ArrayList<TweetBean>();
        Integer id = (Integer) request.getSession().getAttribute("id");
        List<UsuarioBean> usuarios = followDao.getFollowings(id.toString());
        usuarios.add(usuarioDao.getUsuarioConID(id));
        // IN con mis amigos y mi ID
        String amigos = followDao.getFollowingsString(id.toString());
        amigos = amigos.substring(0, amigos.length() - 1);
        amigos = amigos + ", " + id + ")";


        String offset = (String) request.getSession().getAttribute("offsetTimeline");

        tweets = tweetDao.getTimeline(amigos, offset);

        Integer offsetInt = Integer.parseInt(offset);
        offsetInt = offsetInt + 5; //Cada vez que llama al método refresh corro 5 el offset
        offset = offsetInt.toString();

        request.getSession().setAttribute("offsetTimeline", offset);

        model.addAttribute("tweets", tweets);
        model.addAttribute("usuarios", usuarios);

        return "timeline/refresh";
    }
}
