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
import br.com.model.Cliente;
import br.com.model.Delivery;
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
		
		Cliente cliente = (Cliente) session.getAttribute("usuario");
		
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setCardapio(new Cardapio());
		itemPedido.setPedido(new Tradicional());
		
		map.addAttribute("itemPedido", itemPedido);
		map.addAttribute("listarItens", listarCarrinho(new ItemPedido()));
		map.addAttribute("usuarioBD", cliente);
		map.addAttribute("cardapioSelect",  selectCardapio());
		map.addAttribute("mesaSelect", selectMesa());
		return "delivery/carrinho";
	}
	
	@RequestMapping(value="carrinho", method=RequestMethod.GET)
	public String addCarrinho(@ModelAttribute("itemPedido") ItemPedido itemPedido, BindingResult result, ModelMap map, HttpSession session){
		
		Funcionario funcionario = (Funcionario) session.getAttribute("usuario");
		
		Tradicional tradicional = new Tradicional(funcionario);
		
		itemPedido.setPedido(tradicional);
		
		map.addAttribute("listarItens", listarCarrinho(itemPedido));
		return "delivery/carrinho";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("cliente") Delivery delivery, BindingResult result, ModelMap map) {
		
	return "redirect:/delivery/listarPedidosDelivery";
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
	
	public Map<Long, Integer> selectMesa(){
		List<Mesa> mesas  = mesaService.listar();
		Map<Long, Integer> mapa = new TreeMap<Long, Integer>();
		for (Mesa mesa : mesas) {
			mapa.put(mesa.getId(), mesa.getNumero());
		}
		return mapa;
	}

	public List<ItemPedido> listarCarrinho(ItemPedido itemPedido){
		
		itensPedidos.add(itemPedido);

		return itensPedidos;
	}
	
}
