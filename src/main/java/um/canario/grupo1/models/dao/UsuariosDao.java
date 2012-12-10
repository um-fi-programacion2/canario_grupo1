package um.canario.grupo1.models.dao;




import um.canario.grupo1.models.beans.UsuariosBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UsuariosDao extends HibernateDaoSupport  {
    
    public void save(UsuariosBean usuario){
        
            getHibernateTemplate().save(usuario);

    }
    
    
   // 
    
}
