package um.canario.grupo1.frontWeb.Controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.dao.MencionesDao;


@Controller
@RequestMapping(value="/menciones")
public class MencionController {

        @RequestMapping(value="/{usuario}" , method=RequestMethod.GET)
        public String getMenciones(@PathVariable String usuario, Model model, MencionesDao mencionesDao) {
            
            model.addAttribute("tweets", mencionesDao.getTweets(usuario));
            model.addAttribute("usuarios", mencionesDao.getUsuarios(usuario));
            model.addAttribute("user", usuario);
             
            return ("mencion/menciones");
        }
        
}
