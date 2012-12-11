package um.canario.grupo1.frontWeb.Controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.TweetBean;


@Controller
@RequestMapping(value="/tweet")
public class TweetController {

        @RequestMapping(value="/nuevo" , method=RequestMethod.GET)
        public String nuevo(Model model) {   
            //@ModelAttribute("usuario") 
             model.addAttribute("tweet", new TweetBean());
             return "tweet/nuevo";
        }
        
        

}
