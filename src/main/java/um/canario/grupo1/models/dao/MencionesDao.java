package um.canario.grupo1.models.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.models.beans.Menciones;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.utils.HibernateUtil;

public class MencionesDao extends HibernateDaoSupport {

    public boolean guardar(List<String> mentions, Integer idTweet) {

        Menciones mencion = new Menciones();
        UsuarioDao usuarioDao = new UsuarioDao();
        UsuarioBean usuarioBean;
        try {

            for (String name : mentions) {
                usuarioBean = usuarioDao.getUsuario(name);
                mencion.setIdUsuario(usuarioBean.getId());

                System.err.println("Mención: " + usuarioBean.getEmail());

                if (usuarioBean.getId() == -1) {  //Significa que la cadena @.... no corresponde a ningun usuario.
                    System.err.println("ISEMPTY" + usuarioBean.getEmail());
                    continue;
                }
                mencion.setIdTweet(idTweet);


                SessionFactory sesion = HibernateUtil.getSessionFactory();
                Transaction t = null;
                Session session = sesion.openSession();
                t = session.beginTransaction();
                session.persist(mencion);
                t.commit();
                System.err.println("Mentioned @" + name);
            }
        } catch (Exception e) {
            System.err.println("ERROR Mentioned @guardar" + e);
        }
        return true;
    }

    public List<Menciones> getMenciones(String idUsuario) { //Devuelve las menciones (idTweet+idUsuario) de un idUsuario

        try {
            List<Menciones> menciones = new ArrayList<Menciones>();

            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction(); // start a new transaction
            Query query = s.createQuery("FROM Menciones mencion where mencion.idUsuario = " + idUsuario);
            t.commit();
            menciones = query.list();



            return menciones;

        } catch (Exception ex) {
            System.err.println("Error  getMenciones()!-->" + ex.getMessage());

            return null;

        }
    }

    public List<UsuarioBean> getUsuarios(String nombreDeUsuario) { //Devuelve los usuarios que escriben los tweets donde
        //se menciona a nombreDeUsuario
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();

            UsuarioDao usuarioDao = new UsuarioDao();
            UsuarioBean usuario = usuarioDao.getUsuario(nombreDeUsuario);

            String IN = this.getUsuariosIdsString(usuario); //Trae usuarios 

            Query query = s.createQuery("FROM UsuarioBean t where t.id IN " + IN);

            usuarios = (List<UsuarioBean>) query.list();
            t.commit();

            return usuarios;

        } catch (Exception e) {
            System.err.println("getUsuarios MentionDAO !-->" + e.getMessage());
            return usuarios;
        }
    }

    public List<TweetBean> getTweets(String nombreDeUsuario) { //Devuelve los tweets donde se menciona a nombreDeUsuario

        List<TweetBean> tweets = new ArrayList<TweetBean>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();

            UsuarioDao usuarioDao = new UsuarioDao();
            UsuarioBean usuario = usuarioDao.getUsuario(nombreDeUsuario);

            String IN = this.getTweetsIdsString(usuario.getId().toString());

            Query query = s.createQuery("FROM TweetBean t where t.id IN " + IN);

            tweets = (List<TweetBean>) query.list();
            t.commit();

            return tweets;

        } catch (Exception e) {
            System.err.println("Errorasd !-->" + e.getMessage());
            return tweets;
        }
    }

    public List<TweetBean> getTweetsRefresh(String nombreDeUsuario, String offset) { //Devuelve los tweets donde se menciona a nombreDeUsuario

        List<TweetBean> tweets = new ArrayList<TweetBean>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();

            UsuarioDao usuarioDao = new UsuarioDao();
            UsuarioBean usuario = usuarioDao.getUsuario(nombreDeUsuario);

            String IN = this.getTweetsIdsString(usuario.getId().toString());

            Query query = s.createQuery("FROM TweetBean t where t.id IN " + IN);

            query.setFirstResult(Integer.parseInt(offset));
            query.setMaxResults(5);
            t.commit();

            tweets = (List<TweetBean>) query.list();
            
            
            return tweets;

        } catch (Exception e) {
            System.err.println("Errorasd !-->" + e.getMessage());
            return tweets;
        }
    }

    private String getUsuariosIdsString(UsuarioBean usuario) { //Devuelve los ID´s de los usuarios que escriben los tweets
        //donde se menciona a idUsuario

        List<TweetBean> tweetsIds = new ArrayList<TweetBean>();

        tweetsIds = this.getTweets(usuario.getNombre());

        Iterator iter = tweetsIds.iterator();

        TweetBean tweet;
        String IN;

        if (iter.hasNext()) {
            IN = "(";
            while (iter.hasNext()) {
                tweet = (TweetBean) iter.next();
                IN = IN + tweet.getIdUsuario();
                if (iter.hasNext()) {
                    IN = IN + " , ";
                }
            }
            IN = IN + ")";
        } else {
            IN = "(null)";
        }
        System.err.println("tweetsIds !-->" + IN);

        return IN; //devuelve algo como (12,232,42,24)
    }

    public String getTweetsIdsString(String idUsuario) { //Devuelve los ID´s de los tweets donde se menciona a idUsuario

        List<Menciones> tweetsIds = new ArrayList<Menciones>();

        tweetsIds = this.getMenciones(idUsuario);

        Iterator iter = tweetsIds.iterator();

        Menciones mencion;
        String IN;

        if (iter.hasNext()) {
            IN = "(";
            while (iter.hasNext()) {
                mencion = (Menciones) iter.next();
                IN = IN + mencion.getIdTweet();
                if (iter.hasNext()) {
                    IN = IN + " , ";
                }
            }
            IN = IN + ")";
        } else {
            IN = "(null)";
        }
        System.err.println("tweetsIds !-->" + IN);

        return IN; //devuelve algo como (12,232,42,24)
    }
}