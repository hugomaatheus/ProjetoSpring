package br.com.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

import br.com.model.Cardapio;
import br.com.model.Categoria;
import br.com.service.CardapioService;
import br.com.service.CategoriaService;

@RequestMapping(value="cardapio")
@Controller
public class CardapioController {
	
	@Autowired
	private CardapioService cardapioService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		List<Cardapio> cardapios = cardapioService.listar();
		
		map.addAttribute("categorias", categoriaService.listar());
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", new Cardapio());
		return "cardapio/listarCardapio";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Cardapio filtro, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		List<Cardapio> cardapios = cardapioService.buscar(filtro);
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", filtro);
		return "cardapio/listarCardapio";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		Cardapio cardapio = new Cardapio();
		cardapio.setCategoria(new Categoria());
		map.addAttribute("cardapio", cardapio);
		map.addAttribute("categoriasSelect",  selectCategoria());
		return "cardapio/novoCardapio";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cardapio") @Valid Cardapio cardapio, BindingResult result, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		cardapioService.inserir(cardapio);
		
		return "redirect:/cardapio/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		cardapioService.cancelar(id);
		return "redirect:/cardapio/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		Cardapio cardapio = cardapioService.buscarPorId(id);
		map.addAttribute("cardapio", cardapio);
		map.addAttribute("categoriasSelect",  selectCategoria());
		return "cardapio/editaCardapio";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("cardapio") Cardapio cardapio, BindingResult result, ModelMap map, HttpSession session) {
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		if(cardapio.hasValidId()){
			cardapioService.atualizar(cardapio);
		}
		
		return "redirect:/cardapio/listar";
	}
	
	public Map<Long, String> selectCategoria(){
		List<Categoria> categorias  = categoriaService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (Categoria categoria : categorias) {
			mapa.put(categoria.getId(), categoria.getNome());
		}
		return mapa;
	}

}
