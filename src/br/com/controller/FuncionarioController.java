package br.com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Reserva;
import br.com.service.FuncionarioService;

@Controller
@RequestMapping(value="funcionario")
public class FuncionarioController {
	
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String createForm(ModelMap map){
		Reserva reserva = new Reserva();
		map.addAttribute("reserva", reserva);
		return "reserva/novaReserva";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="save")
	public String save(@ModelAttribute("reserva") @Valid Reserva reserva, BindingResult result, ModelMap map) {
		//funcionarioService.cadastrarReserva(reserva, funcionario);
	return "redirect:/listarReserva";
	}
	
	
	
}
