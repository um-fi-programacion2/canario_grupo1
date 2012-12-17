package um.canario.grupo1.frontWeb.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import um.canario.grupo1.models.beans.UsuarioBean;


@Controller
@RequestMapping(value="/")
public class indexController {

	@RequestMapping(method=RequestMethod.GET)
        public String index(Model model) {
            model.addAttribute("usuario", new UsuarioBean());
            
            return "index";
                    
        }
               
        @RequestMapping(value="/timeline" , method=RequestMethod.GET)
        public String timeline(Model model) {
            model.addAttribute("usuario", new UsuarioBean());
                    return "timeline";
        }
        
        
        
/*	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
                model.addAttribute("usuario", new Usuario());
		return "usuario/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@ModelAttribute("usuario") Usuario usuario, BindingResult binding) {
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
