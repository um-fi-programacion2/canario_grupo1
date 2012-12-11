package um.canario.grupo1.models.dao;


import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.utils.HibernateUtil;


public class TweetDao extends HibernateDaoSupport {

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
}
