package br.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import br.com.model.Pedido;
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
	
	private List<ItemPedido> carrinho = null;
	
	private Double total = 0.0;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		List<Pedido> pedidos = funcionarioService.listarPedidos();
		map.addAttribute("usuarioBD", funcionario);
		map.addAttribute("pedidos", pedidos);
		map.addAttribute("filtro", new Pedido());
		return "tradicional/listarTradicional";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Pedido filtro, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		if(filtro.getId() == null && filtro.getStatus() == null && filtro.getTipo() == null){
			return "redirect:/tradicional/listar";
		}
		
		List<Pedido> pedidos = funcionarioService.filtrarPedidos(filtro);
		map.addAttribute("pedidos", pedidos);
		map.addAttribute("filtro", filtro);
		return "tradicional/listarTradicional";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setCardapio(new Cardapio());
		itemPedido.setPedido(new Tradicional());
		
		map.addAttribute("itemPedido", itemPedido);
		map.addAttribute("listarItens", carrinho);
		map.addAttribute("usuarioBD", funcionario);
		map.addAttribute("cardapioSelect",  selectCardapio());
		map.addAttribute("mesaSelect", selectMesa());
		return "tradicional/novoTradicional";
	}
	
	@RequestMapping(value="carrinho", method=RequestMethod.POST)
	public String addCarrinho(@ModelAttribute("itemPedido") ItemPedido itemPedido, BindingResult result, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		itemPedido.setCardapio(cardapioService.buscarPorId(itemPedido.getCardapio().getId())); 
		itemPedido.getTradicional().setTotal(total);
		if(carrinho == null) {
			carrinho = new ArrayList<ItemPedido>();
			session.setAttribute("carrinho", carrinho);
		}
		
		boolean existe = false;
		for (ItemPedido item : carrinho) {
			if(item.getCardapio().getId() == itemPedido.getCardapio().getId()){
				item.setQuantidade(item.getQuantidade() + itemPedido.getQuantidade());
				existe = true;
			}
		}
		total += itemPedido.getQuantidade() * itemPedido.getCardapio().getPreco();

		if(!existe){
			carrinho.add(itemPedido);
		}
		
		map.addAttribute("total", total);
		map.addAttribute("carrinho", carrinho);
		
		return "redirect:/tradicional/form";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		funcionarioService.cadastrarPedidoTradicional(funcionario, carrinho);
		
		carrinho.clear();
		
		return "redirect:/tradicional/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/detalhar")
	public String detalharPedido(@PathVariable Long id, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		List<ItemPedido> itemPedidos = funcionarioService.listarItemPedido(id);
		Pedido pedido = funcionarioService.buscarPedidoTradicional(id);
		map.addAttribute("itemPedidos", itemPedidos);
		map.addAttribute("pedido", pedido);
		return "detalharPedido/detalhePedido";
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/cancelar")
	public String cancelar(@PathVariable Long id, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		funcionarioService.cancelar(id);
		return "redirect:/tradicional/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/atender")
	public String atender(@PathVariable Long id, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		funcionarioService.atender(id);
		return "redirect:/tradicional/listar";
	}
	
	
	public Map<Long, String> selectCardapio(){
		List<Cardapio> cardapios  = cardapioService.listar();
		Map<Long, String> mapa = new HashMap<Long, String>();
		mapa.put(0L, "selecione");
		for (Cardapio cardapio : cardapios) {
			mapa.put(cardapio.getId(), cardapio.getNome() + " - " + cardapio.getPreco());
		}
		return mapa;
	}
	
	public Map<Long, String> selectMesa(){
		List<Mesa> mesas  = mesaService.listar();
		Map<Long, String> mapa = new HashMap<Long, String>();
		mapa.put(0L, "selecione");
		for (Mesa mesa : mesas) {
			mapa.put(mesa.getId(), "Mesa - " + mesa.getNumero());
		}
		return mapa;
	}
	
}
