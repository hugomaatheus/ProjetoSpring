package br.com.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	public String list(ModelMap map){
		List<Delivery> deliverys = clienteService.listarTodos();
		System.out.println(deliverys);
		map.addAttribute("deliverys", deliverys);
		return "deliverys/listarPedidoDelivery";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Cardapio filtro, ModelMap map){
		
		List<Cardapio> cardapios = cardapioService.buscar(filtro);
		map.addAttribute("cardapios", cardapios);
		map.addAttribute("filtro", filtro);
		return "cardapio/listarCardapio";
	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Delivery delivery = new Delivery();
		map.addAttribute("delivery", delivery);
		map.addAttribute("cardapio", new Cardapio());
		map.addAttribute("cardapioSelect",  selectCardapio());
		return "delivery/novoDelivery";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cliente") @Valid Delivery delivery, BindingResult result, ModelMap map) {
		
	return "redirect:/delivery/listarPedidosDelivery";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="addCarrinho")
	public void addCarrinho(@ModelAttribute("itemPedido") ItemPedido itemPedido, BindingResult result, ModelMap map)  {
		
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
