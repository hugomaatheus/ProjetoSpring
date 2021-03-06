package br.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Mesa;
import br.com.model.Usuario;
import br.com.service.MesaService;
import br.com.util.Tipo;

@RequestMapping(value="mesa")
@Controller
public class MesaController {
	
	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		map.addAttribute("mesas",mesaService.listar());
		map.addAttribute("filtro", new Mesa());
		return "mesa/listarMesa";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Mesa filtro, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		if(filtro.getNumero() == null && filtro.getStatus() == null){
			return "redirect:/mesa/listar";
		}
		
		List<Mesa> mesas = mesaService.buscar(filtro);
		map.addAttribute("mesas", mesas);
		map.addAttribute("filtro", filtro);
		return "mesa/listarMesa";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		map.addAttribute("mesa", new Mesa());
		return "mesa/novaMesa";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("mesa") Mesa mesa, BindingResult result, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		mesaService.inserir(mesa);
		
		return "redirect:/mesa/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		mesaService.cancelar(id);
		return "redirect:/mesa/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		Mesa mesa = mesaService.buscarPorId(id);
		map.addAttribute("mesa", mesa);
		return "mesa/editarMesa";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("mesa") Mesa mesa, BindingResult result, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.GERENTE ) {
			return "redirect:/";
		}
		
		if(mesa.hasValidId()){
			mesaService.atualizar(mesa);
		}
		
		return "redirect:/mesa/listar";
	}
	

}
