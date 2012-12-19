/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package um.canario.grupo1.models.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import um.canario.grupo1.models.beans.Tags;
import um.canario.grupo1.models.beans.TweetBean;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.utils.HibernateUtil;

public class HashtagDao {

//LISTA
    public boolean guardar(List<String> hashtags, Integer idTweet) {

        Tags tag;
        try {

            for (String tago : hashtags) {
                tag = new Tags();
                tag.setIdTweet(idTweet);
                tag.setTag(tago);

                System.err.println("Hashtag: " + tag.getTag());

                SessionFactory sesion = HibernateUtil.getSessionFactory();
                Transaction t = null;
                Session session = sesion.openSession();
                t = session.beginTransaction();
                session.persist(tag);
                t.commit();
                System.err.println("Hashtagged #" + tag.getTag());
            }
        } catch (Exception e) {
            System.err.println("ERROR Hashtagged #guardar" + e);
        }
        return true;
    }

//LISTA    
    public List<Tags> getHashtags(String tag) { //Devuelve las menciones (idTweet+idUsuario) de un idUsuario

        System.err.println("FROM Tags tago where tago.tag = " + tag);
        try {
            List<Tags> tags = new ArrayList<Tags>();

            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction(); // start a new transaction
            Query query = s.createQuery("FROM Tags tago where tago.tag = '" + tag + "'");
            t.commit();
            tags = query.list();



            return tags;

        } catch (Exception ex) {
            System.err.println("Error  getHashtags()!-->" + ex.getMessage());

            return null;

        }
    }

//LISTA
    public List<UsuarioBean> getUsuarios(String tag) { //Devuelve los usuarios que escriben los tweets donde
        //se menciona a nombreDeUsuario
        List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();

            String IN = this.getUsuariosIdsString(tag); //Trae usuarios 

            Query query = s.createQuery("FROM UsuarioBean t where t.id IN " + IN);

            usuarios = (List<UsuarioBean>) query.list();
            t.commit();

            return usuarios;

        } catch (Exception e) {
            System.err.println("getUsuarios MentionDAO !-->" + e.getMessage());
            return usuarios;
        }
    }

//LISTA
    public List<TweetBean> getTweets(String tag) { //Devuelve los tweets donde se menciona a nombreDeUsuario

        List<TweetBean> tweets = new ArrayList<TweetBean>();

        String IN = this.getTweetsIdsString(tag);
        System.err.println("FROM TweetBean t where t.id IN " + IN);

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction();
            Query query = s.createQuery("FROM TweetBean t where t.id IN " + IN);
            tweets = (List<TweetBean>) query.list();
            t.commit();

            return tweets;

        } catch (Exception e) {
            System.err.println("Error1003 !-->" + e.getMessage());
            return tweets;
        }
    }

//LISTA
    private String getUsuariosIdsString(String tag) { //Devuelve los ID´s de los usuarios que estan tagueados
        //con el String tag

        List<TweetBean> tweetsIds = new ArrayList<TweetBean>();

        tweetsIds = this.getTweets(tag);

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
        System.err.println("usuariosIds !-->" + IN);

        return IN; //devuelve algo como (12,232,42,24)
    }

//LISTA
    public String getTweetsIdsString(String tag) { //Devuelve los ID´s de los tweets donde se menciona a idUsuario

        List<Tags> tags = new ArrayList<Tags>();

        tags = this.getHashtags(tag);

        Iterator iter = tags.iterator();

        Tags tago;
        String IN;

        if (iter.hasNext()) {
            IN = "(";
            while (iter.hasNext()) {
                tago = (Tags) iter.next();
                IN = IN + tago.getIdTweet();
                if (iter.hasNext()) {
                    IN = IN + " , ";
                }
            }
            IN = IN + ")";
        } else {
            IN = "(null)";
        }
        System.err.println("tagsId !-->" + IN);

        return IN; //devuelve algo como (12,232,42,24)
    }

    public List<Tags> getTOP() {

        List<Tags> tags = new ArrayList<Tags>();

        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Transaction t = null;
            Session s = sf.openSession();
            t = s.beginTransaction(); // start a new transaction
            Query query = s.createQuery("FROM Tags  Group by tag order by count(*) desc ");
            query.setFirstResult(0);
            query.setMaxResults(10);
            t.commit();
            tags = query.list();

            return tags;

        } catch (Exception ex) {
            System.err.println("Error  getTOP()!-->" + ex.getMessage());

            return null;
        }
    }
}
