package um.canario.grupo1.models.dao;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.utils.HibernateUtil;

public class TweetDao extends HibernateDaoSupport{

    String sesion_key = "usuario";

    public TweetBean guardarTweet(TweetBean tweetBean) {
        try {
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
            t = session.beginTransaction();
            
            tweetBean.setTweet(tweetBean.getTweet().replace(System.getProperty("line.separator"), ""));
            if(tweetBean.getAutor()==null) //Sino viene de retweetear autor es cero=idUsuario
                tweetBean.setAutor("0");
            
            session.persist(tweetBean);
            
            session.flush(); 
            Integer idTweet = tweetBean.getId();
            t.commit();
            
            System.err.println("NuevoTWEET: " + idTweet.toString());

            return tweetBean;

        } catch (Exception e) {
            System.err.println("ViejoTWEET: " + tweetBean.getTweet());
            System.err.println("Viejo: " + e);
            System.err.println("uffff: " + tweetBean.getAutor());
            tweetBean.setTweet("error#1004");
            return tweetBean;
        }

    }
     
      public TweetBean getTweet(Integer idTweet){
          try {

              SessionFactory sf = HibernateUtil.getSessionFactory();
              Transaction t = null;
              Session s = sf.openSession();
              t = s.beginTransaction(); // start a new transaction
              Query query = s.createQuery("FROM TweetBean tweet where tweet.id = :id");
              query.setParameter("id", idTweet);
              t.commit();
              return (TweetBean) query.list().get(0);

          } catch (Exception ex) {
              System.err.println("Error !-->" + ex.getMessage());

              return null;
          }
    } 
    
    
    public List<TweetBean> getTweets(String Usuario){
     try {
                        UsuarioDao usuarioDao = new UsuarioDao();
			SessionFactory sf = HibernateUtil.getSessionFactory();
                        Transaction t = null;
                        Session s = sf.openSession();
			t = s.beginTransaction(); // start a new transaction
			 Query query = s.createQuery("FROM TweetBean tweet where tweet.idUsuario = :id order by tweet.fecha desc");
                         query.setParameter("id", usuarioDao.getUsuario(Usuario).getId());            
                         t.commit();
                         return (List<TweetBean>) query.list();
		
		} catch (Exception ex) {
			System.err.println("Error !-->" + ex.getMessage());
			
			return null;
		}
    }    
    
   
}  
    

