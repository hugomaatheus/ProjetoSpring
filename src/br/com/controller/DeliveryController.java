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
import br.com.service.CardapioService;
import br.com.service.ClienteService;

@RequestMapping(value="delivery")
@Controller
public class DeliveryController {
	
	@Autowired
	private CardapioService cardapioService;
	
	@Autowired
	private ClienteService clienteService;
	
	private List<ItemPedido> carrinho = null;
	private Double total = 0.0;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		
		List<Delivery> deliverys = clienteService.listarTodos();
		map.addAttribute("usuarioBD", cliente);
		map.addAttribute("deliverys", deliverys);
		return "delivery/listarPedidoDelivery";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Cardapio filtro, ModelMap map){
		
		List<Cardapio> cardapios = cardapioService.buscar(filtro);
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", filtro);
		return "delivery/listarPedidoDelivery";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		
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
	public String save(ModelMap map, HttpSession sessao) {
		
		Cliente cliente = (Cliente) sessao.getAttribute("usuario");
		clienteService.cadastrarPedidoDelivery(cliente, carrinho);
		
		carrinho.clear();
		return "redirect:/delivery/listarPedidosDelivery";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addCarrinho")
	public String addCarrinho(@ModelAttribute("itemPedido") ItemPedido itemPedido, BindingResult result, ModelMap map, HttpSession sessao)  {
		
		itemPedido.setCardapio(cardapioService.buscarPorId(itemPedido.getCardapio().getId()));
		itemPedido.setPedido(new Delivery()); //gambiarra para Delivery vindo nulo
		itemPedido.getPedido().setTotal(total);
		
		if(carrinho == null) {
			carrinho = new ArrayList<ItemPedido>();
			sessao.setAttribute("carrinho", carrinho);
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
		
		return "redirect:/delivery/form";
		
	}
	
//	@RequestMapping(method=RequestMethod.POST, value="listarCarrinho")
//	public String addCarrinho(HttpSession sessao, ModelMap map)  {
//		
//		sessao.getAttribute("carrinho");
//		
//		return "delivery/listarCarrinho";
//		
//	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		cardapioService.remover(new Cardapio(id));
		return "redirect:/cardapio/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Cardapio cardapio = cardapioService.buscarPorId(id);
		map.addAttribute("cardapio", cardapio);
		map.addAttribute("categoriasSelect",  selectCardapio());
		return "cardapio/editaCardapio";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("cardapio") Cardapio cardapio, BindingResult result, ModelMap map) {
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
