package um.canario.grupo1.models.dao;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import um.canario.grupo1.models.beans.UsuarioBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.models.beans.Userconfig;
import um.canario.grupo1.utils.HibernateUtil;

public class UsuarioDao extends HibernateDaoSupport  {
    
    String sesion_key = "usuario";
    
    public UsuarioBean registrar(UsuarioBean usuario){
        
        
        try {
        usuario.setImagen("user.png");
        SessionFactory sesion = HibernateUtil.getSessionFactory();
        Transaction t = null;
        Session session = sesion.openSession();

        t = session.beginTransaction();
        usuario.setNombre(usuario.getNombre().toLowerCase());
        usuario.setEmail(usuario.getEmail().toLowerCase());

        session.persist(usuario);
        
        session.flush(); 
        t.commit();
        return usuario;

        } catch (Exception e) {
            System.err.println("Error !-->" + e.getMessage()); 
            return usuario;
        }
        
            

    }
    
    public boolean iniciarSesion(UsuarioBean usuario, HttpServletRequest request){
        
       List<UsuarioBean> listaUsuarios = null;
       
       SessionFactory sf = HibernateUtil.getSessionFactory();
		
       Session s = sf.openSession();
	
       Query query = s.createQuery("FROM UsuarioBean u where u.email = :mail and u.password = :pass");
       query.setParameter("mail", usuario.getEmail());
       query.setParameter("pass", usuario.getPassword());

       try {
          listaUsuarios = query.list();
        } catch (Exception e) {
          System.err.println("ErrorHIBERNATE !-->" + e);
        }
       s.close();
        
        if(listaUsuarios.isEmpty()) {
                return false;
            }
            else {
                usuario = listaUsuarios.get(0);
                request.getSession().setAttribute("usuario", usuario);
                request.getSession().setAttribute("nombre", usuario.getNombre());
                request.getSession().setAttribute( "email", usuario.getEmail() );
                request.getSession().setAttribute( "imagen", usuario.getImagen() );
                request.getSession().setAttribute( "id", usuario.getId() );
                
                 
                return true;
            }
    }
    
public UsuarioBean getUsuario(String nombreUsuario){
        
       UsuarioBean usuarioBean = new UsuarioBean();       
       SessionFactory sf = HibernateUtil.getSessionFactory();
       
       
       Session s = sf.openSession();
	
       Query query = s.createQuery("FROM UsuarioBean u where u.nombre = :nombre");
       query.setParameter("nombre", nombreUsuario);
         
       //System.err.println("nooooo->" + nombreUsuario);

       try {
          usuarioBean = (UsuarioBean) query.list().get(0);
        } catch (Exception e) {
          System.err.println("getUsuario, nombreUsuario=null (noexisteelusuario) !-->" + e);
          usuarioBean.setId(-1);
        }
       s.close();
       
                return usuarioBean;
}
    
public UsuarioBean getUsuarioConID(Integer idUsuario){
        
       UsuarioBean usuarioBean = new UsuarioBean();       
       SessionFactory sf = HibernateUtil.getSessionFactory();
       
       
       Session s = sf.openSession();
	
       Query query = s.createQuery("FROM UsuarioBean u where u.id = :iduser");
       query.setParameter("iduser", idUsuario);

       try {
          usuarioBean = (UsuarioBean) query.list().get(0);
        } catch (Exception e) {
          System.err.println("FROM UsuarioBean u where u.id =-->" + idUsuario + " ||||| " + e);
          usuarioBean.setId(-1);
        }
       s.close();
       
                return usuarioBean;
}

public List<UsuarioBean> getUsuarios(String busqueda){
        
       List<UsuarioBean> usuarios = new ArrayList<UsuarioBean>();
       
       SessionFactory sf = HibernateUtil.getSessionFactory();
       Session s = sf.openSession();
	
       busqueda = "%" + busqueda.toLowerCase() + "%"; 
       
       Query query = s.createQuery("FROM UsuarioBean u where u.nombre LIKE '" + busqueda + "'");

       try {
          usuarios = (List<UsuarioBean>) query.list();
        } catch (Exception e) {
          System.err.println("ErrorHIBERNATE !-->" + e);
        }
       s.close();
       
                return usuarios;
}



    public boolean cerrarSesion(HttpServletRequest request){
        
            request.getSession().removeAttribute( "email");
            request.getSession().removeAttribute( "id" );
            request.getSession().invalidate();

            return true;
    }
    
    public boolean modificarPerfil(UsuarioBean usuario, HttpServletRequest request) {
           
                try {
                    SessionFactory sesion = HibernateUtil.getSessionFactory();
                    Transaction t = null;
                    Session session = sesion.openSession();
                    t = session.beginTransaction();
                    Query query = session.createQuery("update UsuarioBean u set u.nombre = :nombre, u.email = :email, u.password = :password, u.localidad = :localidad, u.biografia = :biografia " 
                            + " where u.id = :id");
                    query.setParameter("nombre", usuario.getNombre().toLowerCase());
                    query.setParameter("email", usuario.getEmail().toLowerCase());
                    //query.setParameter("imagen", usuario.getImagen());
                    query.setParameter("password", usuario.getPassword());
                    query.setParameter("localidad", usuario.getLocalidad());
                    query.setParameter("biografia", usuario.getBiografia());
                    query.setParameter("id", usuario.getId());
                    query.executeUpdate();
                    session.getTransaction().commit();
                    session.close();
                    
                    return true;

                } catch (Exception e) {
                    System.err.println("Error !-->" + e.getMessage()); 
                    return false;
                }
    }
    
    public boolean actualizarImagen(String filename, HttpServletRequest request){
           try {
                    SessionFactory sesion = HibernateUtil.getSessionFactory();
                    Transaction t = null;
                    Session session = sesion.openSession();
                    t = session.beginTransaction();
                    Query query = session.createQuery("update UsuarioBean u set u.imagen = :imagen " 
                            + " where u.id = :id");
                    query.setParameter("imagen", filename);
                    query.setParameter("id", request.getSession().getAttribute("id"));
                    query.executeUpdate();
                    session.getTransaction().commit();
                    session.close();
                    
                    return true;

                } catch (Exception e) {
                    System.err.println("Error !-->" + e.getMessage()); 
                    return false;
                }
    }
    
    
        public boolean actualizarNotificaciones(Userconfig usuario){
           try {
                    SessionFactory sesion = HibernateUtil.getSessionFactory();
                    Transaction t = null;
                    Session session = sesion.openSession();
                    t = session.beginTransaction();
                    Query query = session.createQuery("update Userconfig u set u.notificacionesMentions = :mencion, u.notificacionesFollow= :follow, "
                            + "u.notificacionesRetweet = :retweet  " 
                            + " where u.idUsuario = :id");
                    query.setParameter("mencion", usuario.getNotificacionesMentions());
                    query.setParameter("follow", usuario.getNotificacionesFollow());
                    query.setParameter("retweet", usuario.getNotificacionesRetweet());
                    query.setParameter("id", usuario.getIdUsuario());
                    query.executeUpdate();
                    session.getTransaction().commit();
                    session.close();
                    
                    return true;

                } catch (Exception e) {
                    System.err.println("Error actualizarNotificaciones !-->" + e.getMessage()); 
                    return false;
                }
    
        
        
    }
        public boolean setNotificaciones(Userconfig usuario){
           
           try {
                SessionFactory sesion = HibernateUtil.getSessionFactory();
                Transaction t = null;
                Session session = sesion.openSession();
                t = session.beginTransaction();
                session.persist(usuario);
                t.commit();
                
                return true;
                    
                } catch (Exception e) {
                    System.err.println("Error !-->" + e.getMessage()); 
                    return false;
                }
    }
    
    public Userconfig getNotificaciones(Integer idUsuario){
        
       Userconfig userConfig = new Userconfig();       
       SessionFactory sf = HibernateUtil.getSessionFactory();
       
       
       Session s = sf.openSession();
	
       Query query = s.createQuery("FROM Userconfig u where u.idUsuario = :iduser");
       query.setParameter("iduser", idUsuario);

 
       
       try {
          userConfig = (Userconfig) query.list().get(0);
          System.err.println("TRY FROM Userconfig u where u.id =-->" + idUsuario + " ||||| ");
        } catch (Exception e) {
          System.err.println("CATCH FROM Userconfig u where u.id =-->" + idUsuario + " ||||| " + e);
        }
       s.close();
       
                return userConfig;
    }
   
}
