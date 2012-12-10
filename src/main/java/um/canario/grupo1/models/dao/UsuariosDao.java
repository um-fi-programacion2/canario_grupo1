package um.canario.grupo1.models.dao;




import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import um.canario.grupo1.models.beans.UsuariosBean;
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
    
    public boolean iniciarSesion(UsuariosBean usuario){
        
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
        
        if(listaUsuarios.isEmpty()) {
                return false;
            }
            else {
                usuario = listaUsuarios.get(0);
                //Map auth = ActionContext.getContext().getSession();
                //auth.put("idusuario", usuario.getIdu());
                 
                return true;
            }
    }
}
