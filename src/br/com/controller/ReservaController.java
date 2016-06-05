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

import br.com.model.Funcionario;
import br.com.model.Mesa;
import br.com.model.Reserva;
import br.com.service.FuncionarioService;
import br.com.service.MesaService;

@RequestMapping(value="reserva")
@Controller
public class ReservaController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		List<Reserva> reservas = funcionarioService.listarTodasReservas();
		
		Funcionario  func = (Funcionario) session.getAttribute("usuario");
		
		map.addAttribute("usuarioBD", func);
		map.addAttribute("mesas", mesaService.listar());
		map.addAttribute("reservas", reservas);
		map.addAttribute("filtro", new Reserva());
		return "reserva/listarReserva";
	}
	
//	@RequestMapping(value="filtrar", method=RequestMethod.GET)
//	public String filtrar(@ModelAttribute("filtro") Cardapio filtro, ModelMap map){
//		
//		List<Cardapio> cardapios = funcionarioService.buscar(filtro);
//		map.addAttribute("cardapios", cardapios);
//		map.addAttribute("filtro", filtro);
//		return "cardapio/listarCardapio";
//	}
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		
		Funcionario  func = (Funcionario) session.getAttribute("usuario");
		
		map.addAttribute("usuarioBD", func);
		Reserva reserva = new Reserva();
		reserva.setMesa(new Mesa());
		map.addAttribute("reserva", reserva);
		map.addAttribute("mesaSelect", selectMesa());
		return "reserva/novaReserva";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("reserva") Reserva reserva, BindingResult result, HttpSession session, ModelMap map) {
		Funcionario f = (Funcionario) session.getAttribute("usuario");
		System.out.println(reserva);
		funcionarioService.cadastrarReserva(reserva, f);
	return "redirect:/reserva/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id){
		funcionarioService.cancelarReserva(id);
		return "redirect:/reserva/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map){
		Reserva reserva = funcionarioService.buscarReserva(id);
		map.addAttribute("reserva", reserva);
		map.addAttribute("mesaSelect",  selectMesa());
		return "reserva/editarReserva";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("reserva") Reserva reserva, BindingResult result, ModelMap map) {
		if(reserva.hasValidId()){
			funcionarioService.atualizarReserva(reserva);
		}
	return "redirect:/reserva/listar";
	}
	
	public Map<Long, Integer> selectMesa(){
		List<Mesa> mesas  = mesaService.listar();
		Map<Long, Integer> mapa = new TreeMap<Long, Integer>();
		for (Mesa mesa : mesas) {
			mapa.put(mesa.getId(), mesa.getNumero());
			System.out.println(mapa);
		}
		return mapa;
	}

}
