package br.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Categoria;
import br.com.service.CategoriaService;

@RequestMapping(value="categoria")
@Transactional
@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map){
		map.addAttribute("categorias", categoriaService.listar());
		map.addAttribute("filtro", new Categoria());
		return "categoria/listarCategoria";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Categoria filtro, ModelMap map){
		List<Categoria> categorias = categoriaService.buscar(filtro);
		map.addAttribute("cardapios", categorias);
		map.addAttribute("filtro", filtro);
		return "categoria/listarCategoria";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		map.addAttribute("categoria", new Categoria());
		return "categoria/novaCategoria";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("categoria") Categoria categoria, ModelMap modelMap){
		categoriaService.inserir(categoria);
		return "redirect:/categoria/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		categoriaService.remover(new Categoria(id));
		return "redirect:/categoria/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Categoria categoria = categoriaService.buscarPorId(id);
		map.addAttribute("categoria", categoria);
		return "categoria/editarCategoria";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("categoria") Categoria categoria, BindingResult result, ModelMap map) {
		if(categoria.hasValidId()){
			categoriaService.atualizar(categoria);
		}
	return "redirect:/categoria/listar";
	}

}