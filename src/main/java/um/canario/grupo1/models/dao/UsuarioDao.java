package um.canario.grupo1.models.dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import um.canario.grupo1.models.beans.UsuarioBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.utils.HibernateUtil;

public class UsuarioDao extends HibernateDaoSupport  {
    
    String sesion_key = "usuario";
    
    public boolean registrar(UsuarioBean usuario){
        
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
                request.getSession().setAttribute( "id",(Number) usuario.getId() );
                
                 
                return true;
            }
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
}
