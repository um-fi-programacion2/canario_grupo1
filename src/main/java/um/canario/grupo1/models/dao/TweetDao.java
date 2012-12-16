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

    public TweetBean guardarTweet(TweetBean tweetBean, HttpServletRequest request) {
        try {
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
            t = session.beginTransaction();
            
            tweetBean.setTweet(tweetBean.getTweet().replace(System.getProperty("line.separator"), ""));
            
            session.persist(tweetBean);
            
            session.flush(); 
            Integer idTweet = tweetBean.getId();
            t.commit();
            
            System.err.println("NuevoTWEET: " + idTweet.toString());

            return tweetBean;

        } catch (Exception e) {
            System.err.println("ViejoTWEET: " + tweetBean.getTweet());
            tweetBean.setTweet("error#1004");
            return tweetBean;
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
/*    public void SpringHibernateDao(SessionFactory sessionFactory) {  
        super.setSessionFactory(sessionFactory);  
    }  
  
    @Transactional  
    public void persist(Object entity) {  
        getHibernateTemplate().saveOrUpdate(entity);  
    }  
  
    @Transactional  
    public void persist(Object[] entities) {  
        for (int i = 0; i < entities.length; i++) {  
            persist(entities[i]);  
        }  
    }  
  
    @Transactional(readOnly = true)  
    public <T> List<T> find(Class<T> entityClass) {  
        final List<T> entities = getHibernateTemplate().loadAll(entityClass);  
        return entities;  
    }  
  
    @Transactional(readOnly = true)  
    public <T> T load(Class<T> entityClass, Serializable id) {  
        final T entity = (T)getHibernateTemplate().load(entityClass, id);  
        return entity;  
    }  
  
    @Transactional(readOnly = true)  
    public <T> List<T> find(String hql) {  
        final List<T> entities = getHibernateTemplate().find(hql);  
        return entities;  
    }  
  */
}  
    

