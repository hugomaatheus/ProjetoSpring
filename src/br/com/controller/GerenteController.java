package br.com.controller;

import java.util.List;

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

import br.com.model.Funcionario;
import br.com.model.Usuario;
import br.com.service.FuncionarioService;
import br.com.service.GerenteService;
import br.com.util.Tipo;

@Controller
@RequestMapping(value="gerente")
public class GerenteController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	
	@Autowired
	private GerenteService gerenteService;
	
	@RequestMapping(value="indexGerente", method=RequestMethod.GET)
	public String index(ModelMap map, HttpSession sessao ) {
		Usuario user  = (Usuario) sessao.getAttribute("usuario");
		map.addAttribute("usuarioBD", user);
		if(user.getTipo() == Tipo.GERENTE)
		return "/gerente/indexGerente";
		else{
			return "/funcionario/indexFuncionario";
		}
		
	}
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		List<Funcionario> funcionarios = gerenteService.listarTodosFuncionarios();
		
		map.addAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", new Funcionario());
		return "funcionario/listarFuncionario";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Funcionario filtro, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		if(filtro.getNome().equals("")){
			return "redirect:/gerente/listar";
		}
		
		List<Funcionario> funcionarios = gerenteService.filtrar(filtro);
		map.addAttribute("funcionarios", funcionarios);
		map.addAttribute("filtro", filtro);
		return "funcionario/listarFuncionario";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(Model map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
			
			Funcionario funcionario = new Funcionario();
			map.addAttribute("funcionario", funcionario);
			return "funcionario/novoFuncionario";
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute("funcionario") @Valid Funcionario funcionario, BindingResult result, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}

		funcionarioService.cadastrarUsuario(funcionario);
		
		return "redirect:/gerente/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		Funcionario funcionario = funcionarioService.buscarUsuario(id);
		map.addAttribute("funcionario", funcionario);
		return "funcionario/editarFuncionario";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("funcionario") Funcionario funcionario, BindingResult result, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		if(funcionario.hasValidId()){
			funcionarioService.atualizarUsuario(funcionario);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		gerenteService.cancelarFuncionario(id);
		return "redirect:/gerente/listar";
	}
	
	
}
