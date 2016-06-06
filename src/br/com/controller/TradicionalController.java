package br.com.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Cardapio;
import br.com.model.Funcionario;
import br.com.model.ItemPedido;
import br.com.model.Mesa;
import br.com.model.Tradicional;
import br.com.service.CardapioService;
import br.com.service.FuncionarioService;
import br.com.service.MesaService;

@RequestMapping(value="tradicional")
@Controller
public class TradicionalController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CardapioService cardapioService;
	
	@Autowired
	private MesaService mesaService;
	
	List<ItemPedido> itensPedidos = null;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		List<Tradicional> tradicionais = funcionarioService.listarTradicional();
		map.addAttribute("usuarioBD", funcionario);
		map.addAttribute("tradicionais", tradicionais);
		return "tradicional/listarTradicional";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Cardapio filtro, ModelMap map){
		
		List<Cardapio> cardapios = cardapioService.buscar(filtro);
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", filtro);
		return "tradicional/listarTradicional";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setCardapio(new Cardapio());
		itemPedido.setPedido(new Tradicional());
		
		map.addAttribute("itemPedido", itemPedido);
		map.addAttribute("listarItens", itensPedidos);
		map.addAttribute("usuarioBD", funcionario);
		map.addAttribute("cardapioSelect",  selectCardapio());
		map.addAttribute("mesaSelect", selectMesa());
		return "tradicional/novoTradicional";
	}
	
	@RequestMapping(value="carrinho", method=RequestMethod.POST)
	public String addCarrinho(@ModelAttribute("itemPedido") ItemPedido itemPedido, BindingResult result, ModelMap map, HttpSession session){
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		Tradicional tradicional = new Tradicional(funcionario);
		
		itemPedido.setPedido(tradicional);
		System.out.println("-------------->" + itemPedido);
		itensPedidos.add(itemPedido);
		
		map.addAttribute("listarItens", itensPedidos);
		return "tradicional/novoTradicional";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(ModelMap map, HttpSession session){
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		funcionarioService.cadastrarPedidoTradicional(funcionario, itensPedidos);
		
	return "redirect:/tradicioal/listarTradicional";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		cardapioService.remover(new Cardapio(id));
		return "redirect:/tradicional/listarTradicional";
	}
	
	public Map<Long, String> selectCardapio(){
		List<Cardapio> cardapios  = cardapioService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (Cardapio cardapio : cardapios) {
			mapa.put(cardapio.getId(), cardapio.getNome() + " - " + cardapio.getPreco());
		}
		return mapa;
	}
	
	public Map<Long, String> selectMesa(){
		List<Mesa> mesas  = mesaService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (Mesa mesa : mesas) {
			mapa.put(mesa.getId(), "Mesa - " + mesa.getNumero());
		}
		return mapa;
	}
	
}
