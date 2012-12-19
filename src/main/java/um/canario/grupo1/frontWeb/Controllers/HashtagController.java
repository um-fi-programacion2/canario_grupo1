/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um.canario.grupo1.frontWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.dao.HashtagDao;


@Controller
@RequestMapping(value="/hashtag")
public class HashtagController {
    
        @RequestMapping(value="/{tag}" , method=RequestMethod.GET)
        public String getHashtags(@PathVariable String tag, Model model, HashtagDao hashtagDao) {
            
            model.addAttribute("tweets", hashtagDao.getTweets(tag)); //LISTA
            model.addAttribute("usuarios", hashtagDao.getUsuarios(tag));
            model.addAttribute("tag",tag);
             
            return ("hashtag/hashtags");
        }
        
        
        @RequestMapping(value="/TOP10" , method=RequestMethod.GET)
        public String getTOP10(Model model, HashtagDao hashtagDao) {
            
            model.addAttribute("tags",hashtagDao.getTOP());
             
            return ("hashtag/TOP10");
        }
        
}

