package um.canario.grupo1.frontWeb.Controllers;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.FollowDao;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;



@Controller
@RequestMapping("/ws")
public class WSController {
     
    List<String> apps = new ArrayList<String>();

    public String iOS = "FGH345";
    public String Android = "TKL526";
    public String Wphone = "POL789";

        @RequestMapping(value="/config", method = RequestMethod.GET)
	public String config() {
 
		return "ws/config";
 
	}
    
	@RequestMapping(value="/gettweets/{USERKEY}/{APPKEY}", method = RequestMethod.GET)
	@ResponseBody
        public List<TweetBean> getTweets(@PathVariable String USERKEY, @PathVariable String APPKEY) {
                 
                List<TweetBean> tweets = new ArrayList<TweetBean>();
		UsuarioBean usuario = new UsuarioBean();
                TweetDao tweetDao = new TweetDao();
		UsuarioDao usuarioDao = new UsuarioDao();
                usuario = usuarioDao.getUsuarioKey(USERKEY);
                 
                    apps.add(iOS);
                    apps.add(Android);
                    apps.add(Wphone);
                                    
                if( (usuario.getId() != -1)  && (apps.contains(APPKEY))){   //Si la USERKEY no corresponde con ningún usuario
                    tweets = tweetDao.getTweets(usuario.getNombre());
                    return tweets;
                }
		return null;
	}
        
        
	@RequestMapping(value="/getfollowers/{USERKEYa}/{APPKEYa}", method = RequestMethod.GET)
	@ResponseBody
        public List<UsuarioBean> getFollowers(@PathVariable String USERKEYa, @PathVariable String APPKEYa) {
                 
                List<UsuarioBean> followers = new ArrayList<UsuarioBean>();
		UsuarioBean usuario = new UsuarioBean();
		FollowDao followDao = new FollowDao();
		UsuarioDao usuarioDao = new UsuarioDao();
                usuario = usuarioDao.getUsuarioKey(USERKEYa);
                    apps.add(iOS);
                    apps.add(Android);
                    apps.add(Wphone);
                
                if( (usuario.getId() != -1)  && (apps.contains(APPKEYa))){   //Si la USERKEY no corresponde con ningún usuario
                    
                    followers = followDao.getFollowers(usuario.getId().toString());
                    
                    return followers;
                }
		return null;
	}        
        

        @RequestMapping(value="/getfollowings/{USERKEYb}/{APPKEYb}", method = RequestMethod.GET)
	@ResponseBody
        public List<UsuarioBean> getFollowings(@PathVariable String USERKEYb, @PathVariable String APPKEYb) {
                 
                List<UsuarioBean> followings = new ArrayList<UsuarioBean>();
		UsuarioBean usuario = new UsuarioBean();
		FollowDao followDao = new FollowDao();
		UsuarioDao usuarioDao = new UsuarioDao();
                usuario = usuarioDao.getUsuarioKey(USERKEYb);
                    apps.add(iOS);
                    apps.add(Android);
                    apps.add(Wphone);
                
                if( (usuario.getId() != -1)  && (apps.contains(APPKEYb))){   //Si la USERKEY no corresponde con ningún usuario
                    
                    followings = followDao.getFollowings(usuario.getId().toString());
                    
                    return followings;
                }
		return null;
	}        
        
        @RequestMapping(value="/settweet/{USERKEYb}/{APPKEYb}/{tweet}", method = RequestMethod.GET)
	@ResponseBody
        public String setTweet(@PathVariable String USERKEYb, @PathVariable String APPKEYb, @PathVariable String tweet) {
                 
                String OK = "200 OK";
		UsuarioBean usuario = new UsuarioBean();
		
                TweetDao tweetDao = new TweetDao();
		UsuarioDao usuarioDao = new UsuarioDao();
                usuario = usuarioDao.getUsuarioKey(USERKEYb);
                apps.add(iOS);
                apps.add(Android);
                apps.add(Wphone);
                System.err.println(USERKEYb);
                    System.err.println(APPKEYb);    
                    System.err.println(usuario.getNombre());
                    
                if( (usuario.getId() != -1)  && (apps.contains(APPKEYb))){   //Si la USERKEY no corresponde con ningún usuario
                   
                    TweetBean tweetBean = new TweetBean();
                    tweetBean.setTweet(tweet);
                    tweetBean.setIdUsuario(usuario.getId());
                    tweetBean.setAutor("0");
                    
                    tweetBean = tweetDao.guardarTweet(tweetBean);
                    
                    return OK;
                }
                    
		return "500 Internal Server Error";
	} 
        
        
       
}