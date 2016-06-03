package br.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Cliente;
import br.com.service.ClienteService;

@RequestMapping(value="cliente")
@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Cliente cliente = new Cliente();
		map.addAttribute("cliente", cliente);
		return "cliente/cadastroCliente";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, ModelMap map) {
		clienteService.cadastrarUsuario(cliente);
	return "redirect:/login";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Cliente cliente = clienteService.buscarUsuario(id);
		map.addAttribute("cliente", cliente);
		return "cliente/editarCliente";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap map) {
		if(cliente.hasValidId()){
			clienteService.atualizarUsuario(cliente);
		}
	return "redirect:/cliente/login";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="{id}/deactivate")
	public String deactivate(@ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap map) {
		if(cliente.hasValidId()) {
			clienteService.desativarUsuario(cliente);
		}
		return "redirect:/cliente/login";
	}
	
	

}
