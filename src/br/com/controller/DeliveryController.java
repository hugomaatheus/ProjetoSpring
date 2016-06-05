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
import br.com.model.Carrinho;
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
		Carrinho carrinho = new Carrinho();
		
		itemPedido.setCardapio(new Cardapio());
		
		session.setAttribute("carrinho", carrinho);
		
		map.addAttribute("carrinho", carrinho);
		map.addAttribute("usuarioBD", cliente);
		map.addAttribute("cardapioSelect",  selectCardapio());
		return "delivery/addCarrinho";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cliente") Delivery delivery, BindingResult result, ModelMap map) {
		
	return "redirect:/delivery/listarPedidosDelivery";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addCarrinho")
	public String addCarrinho(@ModelAttribute("carrinho") Carrinho carrinho, HttpSession sessao,BindingResult result, ModelMap map)  {
		
		ItemPedido itemPedido = new ItemPedido();
		
//		if(itemPedido == null) {
//			carrinho.setQtd(new Integer(qtd));
//			carrinho.addItem(new Long(itemId));
//		}
//		
		return "delivery/listarCarrinho";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="listarCarrinho")
	public String addCarrinho(HttpSession sessao, ModelMap map)  {
		
		sessao.getAttribute("carrinho");
		
		return "delivery/listarCarrinho";
		
	}
	
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
