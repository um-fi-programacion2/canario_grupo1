/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um.canario.grupo1.frontWeb.Controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.FollowDao;
import um.canario.grupo1.models.dao.UsuarioDao;
import um.canario.grupo1.utils.MailTemplates;

@Controller
@RequestMapping(value = "/follow")
public class FollowController {

    @RequestMapping(value = "/{followed}", method = RequestMethod.GET)
    public String follow(@PathVariable String followed, Model model, FollowDao followDao, HttpServletRequest request, UsuarioBean usuarioBean, UsuarioDao usuarioDao) {

        if (followDao.follow(followed, request)) {
            usuarioBean = usuarioDao.getUsuario(followed);

            if (usuarioDao.getNotificaciones(usuarioBean.getId()).getNotificacionesFollow()) {
                MailTemplates enviarMail = new MailTemplates(usuarioBean.getEmail());
                enviarMail.follow(usuarioBean.getNombre(), request.getSession().getAttribute("nombre").toString());
            }
        }

        return null;
    }

    @RequestMapping(value = "/unfollow/{unfollowed}", method = RequestMethod.GET)
    public String unfollow(@PathVariable String unfollowed, Model model, FollowDao followDao, HttpServletRequest request) {


        followDao.unfollow(unfollowed, request);

        return null;
    }

    @RequestMapping(value = "/following/{nombre}", method = RequestMethod.GET)
    public String followings(@PathVariable String nombre, FollowDao followDao, Model model, UsuarioDao usuarioDao, HttpServletRequest request) {
        
        request.getSession().setAttribute("offsetFollowings", "0");
        request.getSession().setAttribute("offsetTweets", "0");
        request.getSession().setAttribute("offsetFollowers", "0");
        request.getSession().setAttribute("offsetMentions", "0");
        
        String idUsuario = usuarioDao.getUsuario(nombre).getId().toString();

        model.addAttribute("usuarios", followDao.getFollowingsRefresh(idUsuario, "0"));
        model.addAttribute("user", nombre);

        return "follow/following";
    }

    @RequestMapping(value = "/following/refresh/{nombre}", method = RequestMethod.GET)
    public String followingsRefresh(@PathVariable String nombre, FollowDao followDao, Model model, UsuarioDao usuarioDao, HttpServletRequest request) {

        String offset = request.getSession().getAttribute("offsetFollowings").toString();
        Integer offsetInt = Integer.parseInt(offset);
        offsetInt = offsetInt + 5;

        request.getSession().setAttribute("offsetFollowings", offsetInt.toString());
        String idUsuario = usuarioDao.getUsuario(nombre).getId().toString();

        model.addAttribute("usuarios", followDao.getFollowingsRefresh(idUsuario, offsetInt.toString()));
        model.addAttribute("user", nombre);
        
        return "follow/following";
    }

    @RequestMapping(value = "/followers/{nombre}", method = RequestMethod.GET)
    public String followers(@PathVariable String nombre, FollowDao followDao, Model model, UsuarioDao usuarioDao, HttpServletRequest request) {

        request.getSession().setAttribute("offsetTweets", "0");
        request.getSession().setAttribute("offsetFollowers", "0");
        request.getSession().setAttribute("offsetFollowings", "0");
        request.getSession().setAttribute("offsetMentions", "0");

        String idUsuario = usuarioDao.getUsuario(nombre).getId().toString();

        model.addAttribute("usuarios", followDao.getFollowersRefresh(idUsuario, "0"));
        model.addAttribute("user", nombre);

        return "follow/followers";
    }

    @RequestMapping(value = "/followers/refresh/{nombre}", method = RequestMethod.GET)
    public String followersRefresh(@PathVariable String nombre, HttpServletRequest request, FollowDao followDao, Model model, UsuarioDao usuarioDao) {

        String offset = request.getSession().getAttribute("offsetFollowers").toString();
        Integer offsetInt = Integer.parseInt(offset);
        offsetInt = offsetInt + 5;

        request.getSession().setAttribute("offsetFollowers", offsetInt.toString());

        String idUsuario = usuarioDao.getUsuario(nombre).getId().toString();


        model.addAttribute("usuarios", followDao.getFollowersRefresh(idUsuario, offsetInt.toString()));
        model.addAttribute("user", nombre);

        return "follow/followers";
    }
}
