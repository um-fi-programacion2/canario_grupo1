package um.canario.grupo1.models.dao;


import javax.servlet.http.HttpServletRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.models.beans.FollowBean;
import um.canario.grupo1.utils.HibernateUtil;

public class FollowDao extends HibernateDaoSupport{

    String sesion_key = "usuario";

    public boolean follow(String followed, HttpServletRequest request) {
        try {
            FollowBean followBean = new FollowBean();
            followBean.setFollowed(Integer.parseInt(followed));
            followBean.setFollower(Integer.parseInt(request.getSession().getAttribute("id").toString()));
            followBean.setId(followBean);
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
            //Query query = session.createQuery("FROM UsuariosBean t where t.id=1");
            t = session.beginTransaction();
            session.persist(followBean);
            t.commit();

            return true;

        } catch (Exception e) {
            System.err.println("Error !-->" + e.getMessage());
            return false;
        }

    }
     
        public boolean unfollow(String unfollowed, HttpServletRequest request) {
        
            try {
            FollowBean followBean = new FollowBean();
            followBean.setFollowed(Integer.parseInt(unfollowed));
            followBean.setFollower(Integer.parseInt(request.getSession().getAttribute("id").toString()));
            followBean.setId(followBean);
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
            t = session.beginTransaction();
            session.delete(followBean);
            t.commit();

            return true;

        } catch (Exception e) {
            System.err.println("Error !-->" + e.getMessage());
            return false;
        }

    }
}