package br.com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Cliente;
import br.com.model.Funcionario;
import br.com.service.FuncionarioService;

@Controller
@RequestMapping(value="gerente")
public class GerenteController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(Model map, HttpSession session) {
			
			if(session.getAttribute("usuario") == null) {
				return "redirect:/";
			}
			
			Funcionario funcionario = new Funcionario();
			map.addAttribute("funcionario", funcionario);
			return "funcionario/novoFuncionario";
		}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute("funcionario") @Valid Funcionario funcionario, BindingResult result, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		funcionarioService.cadastrarUsuario(funcionario);
		
		return "redirect:/login";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		Funcionario funcionario = funcionarioService.buscarUsuario(id);
		map.addAttribute("funcionario", funcionario);
		return "funcionario/editarFuncionario";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		if(funcionario.hasValidId()){
			funcionarioService.atualizarUsuario(funcionario);
		}
		
		return "redirect:/";
	}
}
