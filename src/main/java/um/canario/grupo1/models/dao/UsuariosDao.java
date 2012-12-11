package um.canario.grupo1.models.dao;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import um.canario.grupo1.models.beans.UsuariosBean;
//import um.canario.grupo1.models.beans.ImageBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.utils.HibernateUtil;

public class UsuariosDao extends HibernateDaoSupport  {
    
    String sesion_key = "usuario";
    
    public boolean registrar(UsuariosBean usuario){
        
                try {
                    //getHibernateTemplate().save(usuario);
                usuario.setImagen("user.png");
                SessionFactory sesion = HibernateUtil.getSessionFactory();
                Transaction t = null;
                Session session = sesion.openSession();
                //Query query = session.createQuery("FROM UsuariosBean t where t.id=1");
                
                t = session.beginTransaction();
                session.persist(usuario);
                t.commit();
                
                return true;
                    
                } catch (Exception e) {
                    System.err.println("Error !-->" + e.getMessage()); 
                    return false;
                }
        
            

    }
    
    public boolean iniciarSesion(UsuariosBean usuario, HttpServletRequest request){
        
       List<UsuariosBean> listaUsuarios = null;
       
       SessionFactory sf = HibernateUtil.getSessionFactory();
		
       Session s = sf.openSession();
	
       Query query = s.createQuery("FROM UsuariosBean u where u.email = :mail and u.password = :pass");
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
                request.getSession().setAttribute( "email", usuario.getEmail() );
                request.getSession().setAttribute( "id", usuario.getId() );
                
                 
                return true;
            }
    }
    
    public boolean cerrarSesion(HttpServletRequest request){
        
            request.getSession().removeAttribute( "email");
            request.getSession().removeAttribute( "id" );
            request.getSession().invalidate();

            return true;
    }
    
    
    public boolean modificarPerfil(UsuariosBean usuario, HttpServletRequest request) {
           
                try {
                    SessionFactory sesion = HibernateUtil.getSessionFactory();
                    Transaction t = null;
                    Session session = sesion.openSession();
                    //Query query = session.createQuery("FROM UsuariosBean t where t.id=1");
                    t = session.beginTransaction();
                            
                    //                   set u.nombre = :nombre u.email = :email u.imagen = :imagen u.password = :password u.localidad = :localidad u.biografia = :biografia" + " where u.id = :id");

                    Query query = session.createQuery("update UsuariosBean u set u.nombre = :nombre, u.email = :email, u.password = :password, u.localidad = :localidad, u.biografia = :biografia " 
                            + " where u.id = :id");
                    query.setParameter("nombre", usuario.getNombre());
                    query.setParameter("email", usuario.getEmail());
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
}
