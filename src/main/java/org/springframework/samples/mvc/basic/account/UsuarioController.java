package org.springframework.samples.mvc.basic.account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	private Map<Long, Usuario> usuarios = new ConcurrentHashMap<Long, Usuario>();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
                model.addAttribute("usuario", new Usuario());
		return "usuario/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@ModelAttribute("usuario") Usuario usuario) {
		this.usuarios.put(usuario.assignId(), usuario);
		return "redirect:/usuario/" + usuario.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Usuario usuario = this.usuarios.get(id);
		if (usuario == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(usuario);
		return "usuario/view";
	}

}
