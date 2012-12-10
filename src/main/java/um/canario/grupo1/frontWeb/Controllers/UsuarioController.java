package um.canario.grupo1.frontWeb.Controllers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.UsuariosBean;
import um.canario.grupo1.models.dao.UsuariosDao;


@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	private Map<Long, UsuariosBean> users = new ConcurrentHashMap<Long, UsuariosBean>();
        
        @RequestMapping(value="/registrar" , method=RequestMethod.POST)
        public String registrar(@ModelAttribute("usuario") UsuariosBean usuario, HttpServletRequest request) {
               
             UsuariosDao usuarioDao = new UsuariosDao();               
               if(usuarioDao.registrar(usuario) && usuarioDao.iniciarSesion(usuario, request)){
                   return "redirect:/usuario/home";
               }
               else{
                   return "redirect:/index";
               }
        }   
        
        @RequestMapping(value="/home" , method=RequestMethod.GET)
        public String home(Model model) {                  
             model.addAttribute("usuario", new UsuariosBean());
             return "usuario/home";
        }

        @RequestMapping(value="/perfil" , method=RequestMethod.GET)
        public String perfil(Model model) {                  
             model.addAttribute("usuario", new UsuariosBean());
             return "usuario/perfil";
        }
        
        @RequestMapping(value="/cerrarSesion" , method=RequestMethod.GET)
        public String cerrarSession(Model model, HttpServletRequest request) {                  
             UsuariosDao usuarioDao = new UsuariosDao();
             usuarioDao.cerrarSesion(request);
             model.addAttribute("usuario", new UsuariosBean());
             return "redirect:/";
        }
        
       @RequestMapping(value="/registrar" , method=RequestMethod.GET)
        public String registrar2(Model model) {                  
             model.addAttribute("usuario", new UsuariosBean());
             return "usuario/formularioRegistro";
        }
        
        @RequestMapping(value="/iniciarSesion" , method=RequestMethod.POST)
        public String iniciarSesion(@ModelAttribute("usuario") UsuariosBean usuario, HttpServletRequest request) {
               UsuariosDao usuarioDao = new UsuariosDao();
               if(usuarioDao.iniciarSesion(usuario,request)){
                  
                   return "redirect:/timeline";
               }
               else{
                   return "redirect:/";
               }
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
