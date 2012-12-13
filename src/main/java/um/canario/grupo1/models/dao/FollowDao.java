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

public class FollowDao extends HibernateDaoSupport{

    String sesion_key = "usuario";

    public boolean guardarTweet(TweetBean tweetBean, HttpServletRequest request) {
        try {
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
            //Query query = session.createQuery("FROM UsuariosBean t where t.id=1");
            t = session.beginTransaction();
            session.persist(tweetBean);
            t.commit();

            return true;

        } catch (Exception e) {
            System.err.println("Error !-->" + e.getMessage());
            return false;
        }

    }
     
    
    public List<TweetBean> getTweets(String Usuario){
     try {
                        UsuarioDao usuarioDao = new UsuarioDao();
			SessionFactory sf = HibernateUtil.getSessionFactory();
                        Transaction t = null;
                        Session s = sf.openSession();
			t = s.beginTransaction(); // start a new transaction
			 Query query = s.createQuery("FROM TweetBean tweet where tweet.idUsuario = :id");
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

    public void follow(String followed) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}  
    

