package um.canario.grupo1.frontWeb.Controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;
import um.canario.grupo1.models.logic.TweetLogic;

@Controller
@RequestMapping(value = "/tweet")
public class TweetController {

    public TweetController() {
        //ifNOTSessionCHAO....
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("tweet", new TweetBean());
        return "tweet/nuevo";
    }

    @RequestMapping(value = "/nuevo/{usuario}", method = RequestMethod.GET)
    public String nuevoReply(Model model, @PathVariable String usuario) {
        TweetBean tweetBean = new TweetBean();
        tweetBean.setTweet("@" + usuario); //Seteamos como default tweet @usuario para hacer el reply

        model.addAttribute("tweet", tweetBean);
        return "tweet/nuevo";
    }

    @RequestMapping(value = "/nuevo/procesar", method = RequestMethod.POST)
    public String nuevoTweet(@ModelAttribute("tweet") TweetBean tweetBean, HttpServletRequest request) {
        TweetLogic tweetLogic = new TweetLogic();
        if(tweetLogic.procesarTweet(tweetBean, request)){
            return "redirect:../../timeline/";
        }
        else
            return "tweet/nuevo";
    }

    @RequestMapping(value = "/{nombreDeUsuario}", method = RequestMethod.GET)
    public String tweets(@PathVariable String nombreDeUsuario, HttpServletRequest request, TweetDao tweetDao, Model model, UsuarioDao usuarioDao) {
        List<TweetBean> tweets = new ArrayList<TweetBean>(); // = tweetDao.load(null, null);

        request.getSession().setAttribute("offsetTweets", "0");
        request.getSession().setAttribute("offsetFollowers", "0");
        request.getSession().setAttribute("offsetFollowings", "0");
        request.getSession().setAttribute("offsetMentions", "0");

        tweets = tweetDao.getTweetsRefresh(nombreDeUsuario, "0");

        model.addAttribute("tweets", tweets);
        model.addAttribute("usuario", usuarioDao.getUsuario(nombreDeUsuario));

        return "tweet/tweets";
    }

    @RequestMapping(value = "/refresh/{nombreDeUsuario}", method = RequestMethod.GET)
    public String tweetsRefresh(@PathVariable String nombreDeUsuario, TweetDao tweetDao, HttpServletRequest request, Model model, UsuarioDao usuarioDao) {

        String offset = (String) request.getSession().getAttribute("offsetTweets");
        Integer offsetInt = Integer.parseInt(offset);
        offsetInt = offsetInt + 5;
        request.getSession().setAttribute("offsetTweets", offsetInt.toString());


        List<TweetBean> tweets = new ArrayList<TweetBean>(); // = tweetDao.load(null, null);       
        tweets = tweetDao.getTweetsRefresh(nombreDeUsuario, offsetInt.toString());

        System.err.println("OFFSET STRING:" + offsetInt.toString());

        model.addAttribute("tweets", tweets);
        model.addAttribute("usuario", usuarioDao.getUsuario(nombreDeUsuario));

        return "tweet/tweets";
    }

    @RequestMapping(value = "/retweet/{tweetId}", method = RequestMethod.GET)
    public String retweet(@PathVariable Integer tweetId, TweetDao tweetDao, HttpServletRequest request, UsuarioDao usuarioDao, UsuarioBean usuarioBean, TweetBean retweet) {

        TweetBean tweetBean = tweetDao.getTweet(tweetId);
        usuarioBean = usuarioDao.getUsuarioConID(tweetBean.getIdUsuario());

        retweet.setAutor(usuarioBean.getNombre());
        retweet.setIdUsuario((Integer) request.getSession().getAttribute("id"));
        retweet.setTweet(tweetBean.getTweet());

        TweetLogic tweety = new TweetLogic();
        tweety.procesarTweet(retweet, request);


        return "redirect:../../timeline";
    }
}
