package um.canario.grupo1.frontWeb.Controllers;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.FollowDao;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;
import um.canario.grupo1.models.logic.UsuarioLogic;


@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	private Map<Long, UsuarioBean> users = new ConcurrentHashMap<Long, UsuarioBean>();
        
        @RequestMapping(value="/registrar" , method=RequestMethod.POST)
        public String registrar(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request) {
               
             UsuarioDao usuarioDao = new UsuarioDao();               
               if(usuarioDao.registrar(usuario) && usuarioDao.iniciarSesion(usuario, request)){
                   return "redirect:/usuario/" + request.getSession().getAttribute("nombre");
               }
               else{
                   return "redirect:/index";
               }
        }   
        
        @RequestMapping(value="/{nombreDeUsuario}" , method=RequestMethod.GET)
        public String home(@PathVariable String nombreDeUsuario, HttpServletRequest request, Model model, ModelAndView mav, UsuarioDao usuarioDao, TweetDao tweetDao, FollowDao followDao) {    
            
            
            UsuarioBean usuarioBean = usuarioDao.getUsuario(nombreDeUsuario);
            String follower = request.getSession().getAttribute("id").toString();
            
            model.addAttribute("tweets", tweetDao.getTweets(nombreDeUsuario));
            model.addAttribute("user", usuarioDao.getUsuario(nombreDeUsuario));
            model.addAttribute("relaciones", followDao.getRelaciones(follower));
            model.addAttribute("sessionId", request.getSession().getAttribute("id"));
            System.err.println("FollowerID: " + follower);
            
            
            mav.setViewName("usuario/home");
            
            //mav.
            
            return "usuario/home";
            
            // return mav;
        }

        
        @RequestMapping(value="/perfil" , method=RequestMethod.GET)
        public String perfil(Model model,  HttpServletRequest request) { 
            
             model.addAttribute("usuario", (UsuarioBean) request.getSession().getAttribute("usuario"));
             return "usuario/perfil";
        }
        
        @RequestMapping(value="/perfil/modificar" , method=RequestMethod.POST)
        public String modificarPerfil(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request) {                  
             UsuarioDao usuarioDao = new UsuarioDao();    
             request.getSession().setAttribute("usuario", usuario);
               if(usuarioDao.modificarPerfil(usuario, request)){
                   return "redirect:/usuario/perfil";
               }
               return "redirect:/usuario/perfil";

        }
           
        
        @RequestMapping(value="/perfil/imagen" , method=RequestMethod.GET)
        public String imagen() { 
            return "usuario/imagen";
        }
        
        
        @RequestMapping(value = "/perfil/imagen/procesar", method = RequestMethod.POST)
        public String modificarImagen(@RequestParam("file") MultipartFile file, HttpServletRequest request ) throws Exception {

           UsuarioLogic imagenUsuario = new UsuarioLogic();
           
           imagenUsuario.cargarImagenPost(file, request);
		
           return "redirect:/usuario/perfil";
    }
        
        @RequestMapping(value = "/busqueda", method=RequestMethod.POST)
        public String buscarUsuario(@RequestParam("busqueda")String busqueda, Model model, FollowDao followDao, UsuarioDao usuarioDao, HttpServletRequest request) {
            
            String follower = request.getSession().getAttribute("id").toString();
            model.addAttribute("usuarios", usuarioDao.getUsuarios(busqueda));
            model.addAttribute("relaciones", followDao.getRelaciones(follower));
            model.addAttribute("sessionId", request.getSession().getAttribute("id"));
            
            return "usuario/busqueda";
        }
        
        
        @RequestMapping(value="/cerrarSesion" , method=RequestMethod.GET)
        public String cerrarSession(Model model, HttpServletRequest request) {                  
             UsuarioDao usuarioDao = new UsuarioDao();
             usuarioDao.cerrarSesion(request);
             model.addAttribute("usuario", new UsuarioBean());
             return "redirect:/";
        }
        
       @RequestMapping(value="/registrar" , method=RequestMethod.GET)
        public String registrar2(Model model) {                  
             model.addAttribute("usuario", new UsuarioBean());
             return "usuario/formularioRegistro";
        }
        
        @RequestMapping(value="/iniciarSesion" , method=RequestMethod.POST)
        public String iniciarSesion(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request) {
               UsuarioDao usuarioDao = new UsuarioDao();
               if(usuarioDao.iniciarSesion(usuario,request)){
                  
                   return "redirect:/usuario/" + request.getSession().getAttribute("nombre");
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
