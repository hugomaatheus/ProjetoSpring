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
import br.com.model.Mesa;
import br.com.model.Reserva;
import br.com.model.Usuario;
import br.com.service.FuncionarioService;
import br.com.service.MesaService;
import br.com.util.Tipo;

@RequestMapping(value="reserva")
@Controller
public class ReservaController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private MesaService mesaService;
	
	@RequestMapping(value="listar", method=RequestMethod.GET)
	public String list(ModelMap map, HttpSession session){
		
		Usuario  usuario = (Usuario) session.getAttribute("usuario");
		if(usuario == null || usuario.getTipo().equals(Tipo.CLIENTE)) {
			return "redirect:/";
		}
		
		List<Reserva> reservas = funcionarioService.listarTodasReservas();
		
		map.addAttribute("usuarioBD", usuario);
		map.addAttribute("mesas", mesaService.listar());
		map.addAttribute("reservas", reservas);
		map.addAttribute("filtro", new Reserva());
		return "reserva/listarReserva";
	}
	
	@RequestMapping(value="filtrar", method=RequestMethod.GET)
	public String filtrar(@ModelAttribute("filtro") Reserva filtro, ModelMap map, HttpSession session){
		
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		}
		
		System.out.println("------------------------------->" + filtro);
		
		if(filtro.getDataInicial().equals("") && filtro.getDataFinal().equals("") && filtro.getMesa().getId() == null && filtro.getNome_Responsavel().equals("")){
			return "redirect:/reserva/listar";
		}
		
		List<Reserva> reservas = funcionarioService.filtrarReservas(filtro);
		map.addAttribute("reservas", reservas);
		map.addAttribute("mesas", mesaService.listar());
		map.addAttribute("filtro", filtro);
		return "reserva/listarReserva";
	}

	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map, HttpSession session){
		
		Usuario  usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario == null || usuario.getTipo().equals(Tipo.CLIENTE)) {
			return "redirect:/";
		}		
				
		Reserva reserva = new Reserva();
		reserva.setMesa(new Mesa());
		
		map.addAttribute("reserva", reserva);
		map.addAttribute("usuarioBD", usuario);
		map.addAttribute("mesaSelect", selectMesa());
		return "reserva/novaReserva";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("reserva") Reserva reserva, BindingResult result, ModelMap map, HttpSession session) {
		
		Usuario  usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario == null || usuario.getTipo().equals(Tipo.CLIENTE)) {
			return "redirect:/";
		}
		
//		if(result.hasErrors()){
//			map.addAttribute("reserva", reserva);
//			map.addAttribute("mesaSelect",  selectMesa());
//			return "cardapio/form";
//		}
		
		reserva.setUsuario(usuario);
		funcionarioService.cadastrarReserva(reserva);
		
		return "redirect:/reserva/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/remove")
	public String remove(@PathVariable Long id, HttpSession session){
		
		Usuario  usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario == null || usuario.getTipo().equals(Tipo.CLIENTE)) {
			return "redirect:/";
		}	
		
		funcionarioService.cancelarReserva(id);
		return "redirect:/reserva/listar";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}/formUpdate")
	public String updateForm(@PathVariable Long id, ModelMap map, HttpSession session){
		Usuario  usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario == null || usuario.getTipo().equals(Tipo.CLIENTE)) {
			return "redirect:/";
		}
		
		Reserva reserva = funcionarioService.buscarReserva(id);
		map.addAttribute("reserva", reserva);
		map.addAttribute("mesaSelect", selectMesa());
		return "/reserva/editarReserva";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="update")
	public String update(@ModelAttribute("reserva") Reserva reserva, BindingResult result, ModelMap map, HttpSession session) {
		Usuario  usuario = (Usuario) session.getAttribute("usuario");
		
		if(usuario == null || usuario.getTipo().equals(Tipo.CLIENTE)) {
			return "redirect:/";
		}
		
		if(reserva.hasValidId()){
			funcionarioService.atualizarReserva(reserva);
		}
		
		return "redirect:/reserva/listar";
	}
	
	public Map<Long, String> selectMesa(){
		List<Mesa> mesas  = mesaService.listar();
		Map<Long, String> mapa = new TreeMap<>();
		mapa.put(0L, "Selecione");
		for (Mesa mesa : mesas) {
			mapa.put(mesa.getId(), "Mesa - " + mesa.getNumero());
		}
		return mapa;
	}

}
