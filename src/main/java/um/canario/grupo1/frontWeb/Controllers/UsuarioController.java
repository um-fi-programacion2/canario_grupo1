package um.canario.grupo1.frontWeb.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import um.canario.grupo1.models.beans.Userconfig;
import um.canario.grupo1.models.beans.UsuarioBean;
import um.canario.grupo1.models.dao.FollowDao;
import um.canario.grupo1.models.dao.TweetDao;
import um.canario.grupo1.models.dao.UsuarioDao;
import um.canario.grupo1.models.logic.UsuarioLogic;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private Map<Long, UsuarioBean> users = new ConcurrentHashMap<Long, UsuarioBean>();

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public String registrar(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request, Model model) {


        UsuarioLogic registro = new UsuarioLogic();

        if (registro.validarRegister(usuario, request)) {

            UsuarioDao usuarioDao = new UsuarioDao();
            Userconfig userConfig = new Userconfig();

            userConfig.setNotificacionesFollow(true);
            userConfig.setNotificacionesMentions(true);
            userConfig.setNotificacionesRetweet(true);

            UsuarioBean usuarioBean = usuarioDao.registrar(usuario);
            userConfig.setIdUsuario(usuarioBean.getId());

            if (usuarioDao.setNotificaciones(userConfig) && usuarioDao.iniciarSesion(usuario, request)) {
                return "redirect:/usuario/" + request.getSession().getAttribute("nombre");
            } else {

                return "index";
            }

        }
        return "redirect:/";
    }

    @RequestMapping(value = "/{nombreDeUsuario}", method = RequestMethod.GET)
    public String home(@PathVariable String nombreDeUsuario, HttpServletRequest request, Model model, UsuarioDao usuarioDao, TweetDao tweetDao, FollowDao followDao) {

        request.getSession().setAttribute("offsetTweets", "0"); //Setea a cero el offset de la paginacion
        request.getSession().setAttribute("offsetFollowers", "0"); // en el home para tweets y mentions
        request.getSession().setAttribute("offsetFollowings", "0"); // en el home para tweets y mentions
        request.getSession().setAttribute("offsetMentions", "0"); // en el home para tweets y mentions

        String follower;

        try {
            follower = request.getSession().getAttribute("id").toString();
        } catch (Exception e) {
            System.err.println("Exception cerrar session" + e);
            return "redirect:/usuario/cerrarSesion";
        }


        UsuarioBean usuario = usuarioDao.getUsuario(nombreDeUsuario);

        model.addAttribute("tweets", tweetDao.getTweets(nombreDeUsuario));
        model.addAttribute("user", usuario);
        model.addAttribute("relaciones", followDao.getRelaciones(follower));
        model.addAttribute("sessionId", request.getSession().getAttribute("id"));
        System.err.println("FollowerID: " + follower);

        if (usuario.getId() == -1) {
            return "usuario/notFound";
        }


        return "usuario/home";

        // return mav;
    }

    @RequestMapping(value = "/perfil", method = RequestMethod.GET)
    public String perfil(Model model, HttpServletRequest request) {

        model.addAttribute("usuario", (UsuarioBean) request.getSession().getAttribute("usuario"));
        return "usuario/perfil";
    }

    @RequestMapping(value = "/perfil/modificar", method = RequestMethod.POST)
    public String modificarPerfil(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request) {
        UsuarioDao usuarioDao = new UsuarioDao();
        request.getSession().setAttribute("usuario", usuario);
        if (usuarioDao.modificarPerfil(usuario, request)) {
            return "redirect:/usuario/perfil";
        }
        return "redirect:/usuario/perfil";

    }

    @RequestMapping(value = "/perfil/imagen", method = RequestMethod.GET)
    public String imagen() {
        return "usuario/imagen";
    }

    @RequestMapping(value = "/notificaciones", method = RequestMethod.GET)
    public String modificarNotificaciones(Model model, UsuarioDao usuarioDao, HttpServletRequest request) {

        model.addAttribute("Userconfig", usuarioDao.getNotificaciones((Integer) request.getSession().getAttribute("id")));
        return "usuario/notificaciones";
    }

    @RequestMapping(value = "/notificaciones/procesar", method = RequestMethod.POST)
    public String notificaciones(@ModelAttribute("Userconfig") Userconfig userConfig, Model model, HttpServletRequest request) {

        userConfig.setIdUsuario((Integer) (request.getSession().getAttribute("id")));

        UsuarioDao usuario = new UsuarioDao();
        usuario.actualizarNotificaciones(userConfig);
        return "usuario/notificaciones";
    }

    @RequestMapping(value = "/perfil/imagen/procesar", method = RequestMethod.POST)
    public String modificarImagen(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {

        UsuarioLogic imagenUsuario = new UsuarioLogic();

        imagenUsuario.cargarImagenPost(file, request);

        return "redirect:/usuario/perfil";
    }

    @RequestMapping(value = "/busqueda", method = RequestMethod.POST)
    public String buscarUsuario(@RequestParam("busqueda") String busqueda, Model model, FollowDao followDao, UsuarioDao usuarioDao, HttpServletRequest request) {

        String follower = request.getSession().getAttribute("id").toString();
        model.addAttribute("usuarios", usuarioDao.getUsuarios(busqueda));
        model.addAttribute("relaciones", followDao.getRelaciones(follower));
        model.addAttribute("sessionId", request.getSession().getAttribute("id"));

        return "usuario/busqueda";
    }

    @RequestMapping(value = "/cerrarSesion", method = RequestMethod.GET)
    public String cerrarSession(HttpServletRequest request, HttpServletResponse response, UsuarioLogic usuarioLogic) throws IOException {

        usuarioLogic.cerrarSesion(request, response);

        return "redirect:/es/";
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public String registrar2(Model model) {
        model.addAttribute("usuario", new UsuarioBean());
        return "usuario/formularioRegistro";
    }

    @RequestMapping(value = "/iniciarSesion", method = RequestMethod.POST)
    public String iniciarSesion(@ModelAttribute("usuario") UsuarioBean usuario, HttpServletRequest request) {

        UsuarioLogic login = new UsuarioLogic();

        if (login.validarLogin(usuario, request)) {
            return "redirect:/usuario/" + request.getSession().getAttribute("nombre");
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/TOP10", method = RequestMethod.GET)
    public String getTOP10(Model model, UsuarioDao usuarioDao) {

        model.addAttribute("usuarios", usuarioDao.getTOP());

        return ("usuario/TOP10");
    }

    @RequestMapping(value = "/TOP10/{ciudad}", method = RequestMethod.GET)
    public String getTOP10Ciudad(@PathVariable("ciudad") String ciudad, Model model, UsuarioDao usuarioDao) {

        model.addAttribute("usuarios", usuarioDao.getTOPCiudad(ciudad));

        return ("usuario/TOP10");
    }
}