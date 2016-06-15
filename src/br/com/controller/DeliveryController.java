package br.com.controller;

import java.util.ArrayList;
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
import br.com.model.Cliente;
import br.com.model.Delivery;
import br.com.model.ItemPedido;
import br.com.model.Pedido;
import br.com.model.Usuario;
import br.com.service.CardapioService;
import br.com.service.ClienteService;
import br.com.service.FuncionarioService;
import br.com.util.Tipo;

@RequestMapping(value="delivery")
@Controller
public class DeliveryController {
	
	@Autowired
	private CardapioService cardapioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	private List<ItemPedido> carrinho = null;
	private Double total = 0.0;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		
		List<Pedido> deliverys = clienteService.listarTodos();
		map.addAttribute("usuarioBD", cliente);
		map.addAttribute("pedidos", deliverys);
		map.addAttribute("filtro", new Pedido());
		return "delivery/listarPedidoDelivery";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Pedido filtro, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}	
		
		if(filtro.getId() == null && filtro.getStatus() == null && filtro.getTipo() == null){
			return "redirect:/delivery/listar";
		}
		
		List<Pedido> pedidos = funcionarioService.filtrarPedidos(filtro);
		map.addAttribute("pedidos", pedidos);
		map.addAttribute("filtro", filtro);
		return "delivery/listarPedidoDelivery";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		
		ItemPedido itemPedido = new ItemPedido();
		Delivery delivery = new Delivery();
		
		itemPedido.setCardapio(new Cardapio());
		itemPedido.setPedido(delivery);
		
		map.addAttribute("itemPedido", itemPedido);
		map.addAttribute("carrinho", carrinho);
		map.addAttribute("usuarioBD", cliente);
		map.addAttribute("cardapioSelect", selectCardapio());
		return "delivery/novoDelivery";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");			
		
		clienteService.cadastrarPedidoDelivery(cliente, carrinho);
		
		carrinho.clear();
		return "redirect:/delivery/listar";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addCarrinho")
	public String addCarrinho(@ModelAttribute("itemPedido") ItemPedido itemPedido, BindingResult result, ModelMap map, HttpSession session)  {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		itemPedido.setCardapio(cardapioService.buscarPorId(itemPedido.getCardapio().getId()));
		itemPedido.setPedido(new Delivery()); 

		
		if(carrinho == null) {
			carrinho = new ArrayList<ItemPedido>();
			session.setAttribute("itemCarrinho", carrinho);
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
		map.addAttribute("itemCarrinho", carrinho);
		
		return "redirect:/delivery/form";
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{index}/removeCar")
	public String removerCarrinho(@PathVariable int index, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		
		total -= carrinho.get(index).getQuantidade() * carrinho.get(index).getCardapio().getPreco();
		carrinho.remove(index);
		
		map.addAttribute("itemCarrinho", carrinho);
		map.addAttribute("total", total);
		
		return "redirect:/delivery/form";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/detalhar")
	public String detalharPedido(@PathVariable Long id, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		List<ItemPedido> itemPedidos = (List<ItemPedido>) clienteService.listarItemPedido(id);
		Pedido pedido = clienteService.buscarPedidoDelivery(id);
		map.addAttribute("itemPedidos", itemPedidos);
		map.addAttribute("pedido", pedido);
		return "detalharPedido/detalhePedidoDelivery";
	}

	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		cardapioService.remover(new Cardapio(id));
		return "redirect:/cardapio/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		Cardapio cardapio = cardapioService.buscarPorId(id);
		map.addAttribute("cardapio", cardapio);
		map.addAttribute("categoriasSelect",  selectCardapio());
		return "cardapio/editaCardapio";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("cardapio") Cardapio cardapio, BindingResult result, ModelMap map, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo() != Tipo.CLIENTE ) {
			return "redirect:/";
		}
		
		if(cardapio.hasValidId()){
			cardapioService.atualizar(cardapio);
		}
		
		return "redirect:/cardapio/listar";
	}
	
	public Map<Long, String> selectCardapio(){
		List<Cardapio> cardapios  = cardapioService.listar();
		Map<Long, String> mapa = new TreeMap<Long, String>();
		for (Cardapio cardapio : cardapios) {
			mapa.put(cardapio.getId(), cardapio.getNome());
		}
		return mapa;
	}

}
