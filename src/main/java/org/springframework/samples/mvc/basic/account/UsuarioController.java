package org.springframework.samples.mvc.basic.account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

	private Map<Long, Account> accounts = new ConcurrentHashMap<Long, Account>();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Account());
		return "usuario/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Account account, BindingResult result) {
		if (result.hasErrors()) {
			return "usuario/createForm";
		}
		this.accounts.put(account.assignId(), account);
		return "redirect:/usuario/" + account.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Account account = this.accounts.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(account);
		return "usuario/view";
	}

}
