package um.canario.grupo1.models.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.models.beans.Relaciones;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.utils.HibernateUtil;

public class FollowDao extends HibernateDaoSupport {

    String sesion_key = "usuario";

    public boolean follow(String followed, HttpServletRequest request) {
        try {
            Relaciones followBean = new Relaciones();
            followBean.setFollowed(Integer.parseInt(followed));
            followBean.setFollower(Integer.parseInt(request.getSession().getAttribute("id").toString()));
            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
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
            Relaciones followBean = new Relaciones();

            SessionFactory sesion = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session session = sesion.openSession();
            Query query = session.createQuery("delete from Relaciones where follower = :name and followed= :name2");
            t = session.beginTransaction();
            query.setString("name", request.getSession().getAttribute("id").toString());
            query.setString("name2", unfollowed);
            int rowCount = query.executeUpdate();
            t.commit();

            System.out.println("Rows affected: " + rowCount);


            return true;

        } catch (Exception e) {
            System.err.println("Error !-->" + e.getMessage());
            return false;
        }
    }

    public List<Relaciones> getRelaciones(String follower) {
        List<Relaciones> lista = new ArrayList<Relaciones>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();

            Query query = s.createQuery("FROM Relaciones t where t.follower = :follower");
            query.setParameter("follower", Integer.parseInt(follower));
            lista = (List<Relaciones>) query.list();
            t.commit();

            return lista;

        } catch (Exception e) {
            System.err.println("Errorasd !-->" + e.getMessage());
            return lista;
        }
    }

        public List<Relaciones> getRelaciones2(String follower) {
        List<Relaciones> lista = new ArrayList<Relaciones>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();

            Query query = s.createQuery("FROM Relaciones t where t.followed = :follower");
            query.setParameter("follower", Integer.parseInt(follower));
            lista = (List<Relaciones>) query.list();
            t.commit();

            return lista;

        } catch (Exception e) {
            System.err.println("Errorasd !-->" + e.getMessage());
            return lista;
        }
    }
        
    public String getFollowingsString(String id) {

        List<Relaciones> relaciones = new ArrayList<Relaciones>();
        FollowDao followDao = new FollowDao();

        relaciones = followDao.getRelaciones(id);
        Iterator iter = relaciones.iterator();

        Relaciones relacion;
        String IN;

        if (iter.hasNext()) {
            IN = "(";
            while (iter.hasNext()) {
                relacion = (Relaciones) iter.next();
                IN = IN + relacion.getFollowed();
                if (iter.hasNext()) {
                    IN = IN + " , ";
                }
            }
            IN = IN + ")";
        } else {
            IN = "(null)";
        }

        System.err.println("getFollowingsString !-->" + IN);
        
        return IN; //devuelve algo como (12,232,42,24)
    }
    public String getFollowersString(String id) {

        List<Relaciones> relaciones = new ArrayList<Relaciones>();
        FollowDao followDao = new FollowDao();

        relaciones = followDao.getRelaciones2(id);
        Iterator iter = relaciones.iterator();

        Relaciones relacion;
        String IN;

        if (iter.hasNext()) {
            IN = "(";
            while (iter.hasNext()) {
                relacion = (Relaciones) iter.next();
                IN = IN + relacion.getFollower();
                if (iter.hasNext()) {
                    IN = IN + " , ";
                }
            }
            IN = IN + ")";
        } else {
            IN = "(null)";
        }

        System.err.println("getFollowingsString !-->" + IN);
        
        return IN; //devuelve algo como (12,232,42,24)
    }
    
    public List<UsuarioBean> getFollowings(String id) {

        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        String ONO = getFollowingsString(id);

        Query query = s.createQuery("FROM UsuarioBean u where u.id IN  " + ONO);

        try {
            usuarios = (List<UsuarioBean>) query.list();
        } catch (Exception e) {
            System.err.println("ErrorHIBERNATE !-->" + e);
        }
        s.close();

        return usuarios;
    }

    public List<UsuarioBean> getFollowers(String id) {

        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        String ONO = getFollowersString(id);

        Query query = s.createQuery("FROM UsuarioBean u where u.id IN  " + ONO);

        try {
            usuarios = (List<UsuarioBean>) query.list();
        } catch (Exception e) {
            System.err.println("ErrorHIBERNATE !-->" + e);
        }
        s.close();

        return usuarios;
    }
}