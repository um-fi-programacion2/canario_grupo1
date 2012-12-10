package um.canario.grupo1.frontWeb.Controllers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.frontWeb.ResourceNotFoundException;
import um.canario.grupo1.models.beans.UsuariosBean;
import um.canario.grupo1.models.dao.UsuariosDao;
import um.canario.grupo1.models.logic.UsuariosLogic;
import um.canario.grupo1.utils.HibernateUtil;



@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	private Map<Long, UsuariosBean> users = new ConcurrentHashMap<Long, UsuariosBean>();
        
        
        @RequestMapping(value="/registrar" , method=RequestMethod.POST)
        public String registrar(@ModelAttribute("usuario") UsuariosBean usuario) {
             
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            String SQL_QUERY ="INSERT INTO usuarios VALUES(1,1,1,1,1,1,1,1);";
            Query query = session.createSQLQuery(SQL_QUERY).addEntity(UsuariosBean.class);
;
            UsuariosBean userProfile = (UsuariosBean)query.uniqueResult();
            session.close();
            
            
            /*
//             UsuariosLogic usuarioLogic = (UsuariosLogic)appContext.getBean("usuarioLogic");             
                    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
                    session.beginTransaction();
                    session.save(usuario);
                    session.getTransaction().commit();
             try {
                    System.out.println("HOLAAAAAAAAAAAA");
                } catch (Exception e) {
                    System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
                    e.printStackTrace();
                }
             */
             //usuarioLogic.save(usuario);
                     return "usuario/formularioRegistro";
        }
        
        
       @RequestMapping(value="/registrar" , method=RequestMethod.GET)
        public String registrar2(Model model) {
                           
             model.addAttribute("usuario", new UsuariosBean());
             
             return "usuario/formularioRegistro";
        }
                
        
/*	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
                model.addAttribute("usuario", new Usuario());
		return "usuario/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create() {
                if(binding.hasErrors()){ 
                    return "redirect:/usuario/createForm";
                }

                this.users.put(usuario.assignId(),usuario);
		return "redirect:/usuario/" + usuario.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Usuario usuario = this.users.get(id);
		if (usuario == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(usuario);
		return "usuario/view";
	}
*/
        /*
        @RequestMapping(value="/iniciarSesion")
        public String iniciarSesion() {
            
        return "timeline";
        } 
        
        @RequestMapping(value="/cerrarSesion")
        public String cerrarSesion() {
        
        return "index";
        } */
        
        

        /*
        @RequestMapping(value="/modificarPerfil")
        public String modificarPerfil() {
        } 
        
        @RequestMapping(value="/modificarImagen")
        public String modificarImagen() {
        } 
        
        @RequestMapping(value="/modificarPassword")
        public String modificarPassword() {
        } 
        
        @RequestMapping(value="/tweetear")
        public String tweetear() {
        } 
        
        @RequestMapping(value="/retweetear")
        public String retweetear() {
        } 
                
        @RequestMapping(value="/verPerfil")
        public String verPerfil() {
        } 
                
        @RequestMapping(value="/seguir")
        public String seguir() {
        } 
                
        @RequestMapping(value="/dejarDeSeguir")
        public String dejarDeSeguir() {
        } 

        @RequestMapping(value="/dameSeguidores")
        public String dameSeguidores() {
        } 
                
        @RequestMapping(value="/dameSeguidos")
        public String dameSeguidos() {
        } 
        
         */
}
