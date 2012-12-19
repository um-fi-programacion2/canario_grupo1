package um.canario.grupo1.models.logic;

import com.twitter.Extractor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.Userconfig;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.HashtagDao;
import um.canario.grupo1.models.dao.MencionesDao;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;
import um.canario.grupo1.utils.MailTemplates;

public class TweetLogic {

    public boolean procesarTweet(TweetBean tweetBean, HttpServletRequest request) {
        
        TweetDao tweetDao = new TweetDao();
        tweetBean = tweetDao.guardarTweet(tweetBean); //Aquí tenemos el tweetBean con ID y todo...
        
        List<String> mentions = this.getMentionsFromTweet(tweetBean);
        List<String> hashtags = this.getHashtagsFromTweet(tweetBean);
    
        if(!mentions.isEmpty()){
            MencionesDao mencionesDao = new MencionesDao();
            if(mencionesDao.guardar(mentions,tweetBean.getId())){
                for (String destinatario : mentions) {
                   UsuarioDao usuarioDao = new UsuarioDao(); 
                   Userconfig userConfig = new Userconfig();
                   UsuarioBean usuarioBean = usuarioDao.getUsuario(destinatario);
                   userConfig = usuarioDao.getNotificaciones(usuarioBean.getId());
                   
                       MailTemplates enviarMail = new MailTemplates(usuarioBean.getEmail());
                              System.err.println("Enviado a: " + usuarioBean.getEmail());
                       if(userConfig.getNotificacionesMentions()){
                           try {
                               enviarMail.mencionado(tweetBean.getTweet(),request.getSession().getAttribute("nombre").toString());
                               System.err.println("EmailMencionado enviado a: " + usuarioBean.getEmail());
                           } catch (Exception e) {
                            System.err.println("Error enviando mail:" + destinatario + " |||||||||| " + e );
                           }
                       }
                   }
            }
        }
              
        return true;
    }
    
    
    
    public List<String> getMentionsFromTweet(TweetBean tweetBean){
                        
        List<String> mentions;
        Extractor extractor = new Extractor();
        mentions = extractor.extractMentionedScreennames(tweetBean.getTweet());
       
        for (String name : mentions) {
            System.err.println("Mentioned @" + name);
        }
        return mentions;
    }
    
    public List<String> getHashtagsFromTweet(TweetBean tweetBean){
                        
        List<String> hashtags;
        Extractor extractor = new Extractor();
        hashtags = extractor.extractHashtags(tweetBean.getTweet());
       
        for (String tag : hashtags) {
            System.err.println("Hashtagged #" + tag);
        }
        return hashtags;
    }
    
            
}
