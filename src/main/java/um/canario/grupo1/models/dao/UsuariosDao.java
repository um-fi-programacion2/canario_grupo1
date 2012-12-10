package um.canario.grupo1.models.dao;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import um.canario.grupo1.models.beans.UsuariosBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import um.canario.grupo1.utils.HibernateUtil;

public class UsuariosDao extends HibernateDaoSupport  {
    
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
    
    public boolean iniciarSesion(UsuariosBean usuario){
        
              
                
                return true;
                    
             
        
            

    }
    
   // 
    
}
