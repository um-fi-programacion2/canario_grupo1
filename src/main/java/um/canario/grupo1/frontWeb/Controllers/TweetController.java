package um.canario.grupo1.frontWeb.Controllers;



import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.logic.TweetLogic;


@Controller
@RequestMapping(value="/tweet")
public class TweetController {

        @RequestMapping(value="/nuevo" , method=RequestMethod.GET)
        public String nuevo(Model model) {   

             model.addAttribute("tweet", new TweetBean());
             return "tweet/nuevo";
        }
        
        @RequestMapping(value="/nuevo/procesar" , method=RequestMethod.POST)
        public String nuevoTweet(@ModelAttribute("tweet") TweetBean tweetBean, HttpServletRequest request) {   
             TweetLogic tweetLogic = new TweetLogic();
             tweetLogic.procesarTweet(tweetBean, request);
             return "redirect:../../usuario/home";
        }

}
