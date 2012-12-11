package um.canario.grupo1.frontWeb.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import um.canario.grupo1.models.beans.UsuarioBean;
//import um.canario.grupo1.models.beans.ImageBean;
import um.canario.grupo1.models.dao.UsuarioDao;


@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	private Map<Long, UsuarioBean> users = new ConcurrentHashMap<Long, UsuarioBean>();
        
        @RequestMapping(value="/registrar" , method=RequestMethod.POST)
        public String registrar(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request) {
               
             UsuarioDao usuarioDao = new UsuarioDao();               
               if(usuarioDao.registrar(usuario) && usuarioDao.iniciarSesion(usuario, request)){
                   return "redirect:/usuario/home";
               }
               else{
                   return "redirect:/index";
               }
        }   
        
        @RequestMapping(value="/home" , method=RequestMethod.GET)
        public String home(Model model) {                  
             model.addAttribute("usuario", new UsuarioBean());
             return "usuario/home";
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
        public String modificarImagen(@RequestParam("file") MultipartFile file) {
          
            /*
              try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                        String fieldname = item.getFieldName();
                        String fieldvalue = item.getString();
                        // ... (do your job here)
                    } else {
                        // Process form file field (input type="file").
                        String fieldname = item.getFieldName();
                        String filename = FilenameUtils.getName(item.getName());
                        InputStream filecontent = item.getInputStream();
                        // ... (do your job here)
                    }
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request.", e);
            }
            
          /*ImageBean imagen = new ImageBean();
            UsuarioDao usuarioDao = new UsuarioDao();
            byte[] bytes;
            if (!file.isEmpty()) {
                try {
                    bytes = file.getBytes();
                } catch (IOException ex) {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (usuarioDao.modificarImagen(imagen, file)) {
                return "redirect:/usuario/perfil";
            }
            return "redirect:/usuario/imagen";*/
            return "redirect:/usuario/perfil";

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
