package br.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="funcionario")
public class FuncionarioController {
	
	@RequestMapping(value="indexFuncionario", method=RequestMethod.GET)
	public String index() {	
		return "funcionario/indexFuncionario";
		
	}
	
}
