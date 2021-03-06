package br.com.controller;

import javax.servlet.http.HttpSession;
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
import br.com.model.Usuario;
import br.com.service.ClienteService;
import br.com.util.Tipo;

@RequestMapping(value="cliente")
@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="indexCliente", method=RequestMethod.GET)
	public String index(ModelMap map, HttpSession sessao ) {
		Usuario user  = (Usuario) sessao.getAttribute("usuario");
		map.addAttribute("usuarioBD", user);
		if(user.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		return "cliente/indexCliente";
		
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		
	 	Cliente cliente = new Cliente();
		map.addAttribute("cliente", cliente);
		return "cliente/cadastroCliente";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, ModelMap map) {	
		
		if(result.hasErrors()) {
			return "/cliente/cadastroCliente";
		}
		
		clienteService.cadastrarUsuario(cliente);
		
		return "redirect:/login";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		Cliente cliente = clienteService.buscarUsuario(id);
		map.addAttribute("cliente", cliente);
		return "cliente/editarCliente";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("cliente") Cliente cliente, BindingResult result, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(cliente == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		if(cliente.hasValidId()){
			clienteService.atualizarUsuario(cliente);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/desativar")
	public String deactivate(@ModelAttribute("cliente") Cliente cliente, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		Cliente c = clienteService.buscarUsuario(cliente.getId());
		
		if(c == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		if(c.hasValidId()) {
			clienteService.desativarUsuario(c);
			session.removeAttribute("usuario");
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="ativarForm", method=RequestMethod.GET)
	public String activateForm(ModelMap map) {
		
		Cliente cliente = new Cliente();
		
		map.addAttribute("cliente", cliente);
		
		return "cliente/ativarForm";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="ativar")
	public String activate(@ModelAttribute("cliente") Cliente cliente, ModelMap map) {
		
		System.out.println(cliente.getEmail());
		Cliente c = clienteService.buscarPorEmail(cliente.getEmail());
		
		if(c == null) {
			return "redirect:/";
		}	
		
		
		if(c.hasValidId()) {
			clienteService.ativarUsuario(c);
		}
		
		return "redirect:/";
	}

}
