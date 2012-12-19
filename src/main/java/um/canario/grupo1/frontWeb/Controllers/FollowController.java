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
@RequestMapping(value="/follow")
public class FollowController {

        @RequestMapping(value="/{followed}" , method=RequestMethod.GET)
        public String follow(@PathVariable String followed, Model model, FollowDao followDao, HttpServletRequest request, UsuarioBean usuarioBean, UsuarioDao usuarioDao) {
            
            if(followDao.follow(followed,request)){
                usuarioBean = usuarioDao.getUsuario(followed);
                
                if(usuarioDao.getNotificaciones(usuarioBean.getId()).getNotificacionesFollow()){
                    MailTemplates enviarMail = new MailTemplates(usuarioBean.getEmail());
                    enviarMail.follow(usuarioBean.getNombre(), request.getSession().getAttribute("nombre").toString());
                }
            }
             
            return null;
        }
        
        @RequestMapping(value="/unfollow/{unfollowed}" , method=RequestMethod.GET)
        public String unfollow(@PathVariable String unfollowed, Model model, FollowDao followDao, HttpServletRequest request) {
            
            
            followDao.unfollow(unfollowed,request);
             
            return null;
        }
        
        @RequestMapping(value="/following/{nombre}" , method=RequestMethod.GET)
        public String followings(@PathVariable String nombre,FollowDao followDao, Model model, UsuarioDao usuarioDao) {
            
            model.addAttribute("usuarios", followDao.getFollowings(usuarioDao.getUsuario(nombre).getId().toString()));
            model.addAttribute("user", nombre);
             
            return "follow/following";
        }
        
        @RequestMapping(value="/followers/{nombre}" , method=RequestMethod.GET)
        public String followers(@PathVariable String nombre,FollowDao followDao, Model model, UsuarioDao usuarioDao) {
            
            model.addAttribute("usuarios", followDao.getFollowers(usuarioDao.getUsuario(nombre).getId().toString()));
            model.addAttribute("user", nombre);
             
            return "follow/followers";
        }
}
