/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um.canario.grupo1.frontWeb.WS;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import um.canario.grupo1.models.beans.UsuarioBean;
import org.springframework.ws.server.endpoint.annotation.*;


import org.w3c.dom.Element;

import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.utils.HibernateUtil;

/**
 *
 * @author juampi
 */
@Endpoint
public class CanarioServices {
   

@PayloadRoot(namespace="http://localhost:8080/Canario-Primavera-1/WEB-INF/schema", localPart="TweetRequest")    
public List<TweetBean> getTweets(@RequestPayload Element domelement){
    
    String user = domelement.getAttributeNS("http://localhost:8080/Canario-Primavera-1/WEB-INF/schema", "usuario");
    TweetDao tweetdao = new TweetDao();
    List<TweetBean> tweetlist = new ArrayList<TweetBean>();
    tweetlist = tweetdao.getTweets(user);
    
    return tweetlist;
    
     

}    

/*
@PayloadRoot(namespace="http://localhost/WEB-INF/schema", localPart="MentionResponse")    
public String getMentions(@RequestPayload Element domelement){
       
       String user = domelement.getAttributeNS("http://localhost/WEB-INF/schema", "usuario");
      
       
       List<UsuarioBean> tweets = null;
       
       SessionFactory sf = HibernateUtil.getSessionFactory();
		
       Session s = sf.openSession();
	
       Query query = s.createQuery("select id_usuario FROM UsuariosBean u where u.nombre = :${user}");
       String id = query.getQueryString();
       
       Query query2 = s.createQuery("select id_tweet FROM MentionsBean t where t.id_usuario = :${id}");
       List<UsuarioBean> mentionlist = query2.list();
       
       String response = mentionlist.toString();
       
    //return "UserID: " + usuario.getId() + "TweetID: 1234";
    return response;
    

} 

@PayloadRoot(namespace="http://localhost/WEB-INF/schema", localPart="TagResponse")    
public String getTag(@RequestPayload Element domelement){
       
       String user = domelement.getAttributeNS("http://localhost/WEB-INF/schema", "usuario");
      
       
       List<UsuarioBean> tweets = null;
       
       SessionFactory sf = HibernateUtil.getSessionFactory();
		
       Session s = sf.openSession();
	
       Query query = s.createQuery("select id_usuario FROM UsuariosBean u where u.nombre = :${user}");
       String id = query.getQueryString();
       
       Query query2 = s.createQuery("select tag FROM TagsBean t where t.id_usuario = :${id}");
       List<UsuarioBean> taglist = query2.list();
       
       String response = taglist.toString();
       
    //return "UserID: " + usuario.getId() + "TweetID: 1234";
    return response;
    

} 
*/
}
