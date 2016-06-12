package br.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.model.Usuario;
import br.com.service.UsuarioService;
import br.com.util.Status;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
	public String form(ModelMap map){
		Usuario usuario = new Usuario();
		map.addAttribute("usuario", usuario);
		return "login/login";
	}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") Usuario usuario, BindingResult result,HttpSession sessao, ModelMap map){
		if(usuario.getLogin().equals("") || usuario.getSenha().equals("") ){
			map.addAttribute("usuario", usuario);
			return  "login/login";
		}
		
		Usuario usuarioBD = usuarioService.logar(usuario.getLogin(), usuario.getSenha());
		
		if(usuarioBD == null){
			usuario.setSenha("");
			map.addAttribute("usuario", usuarioBD);
			return  "login/login";
		}

		if(usuarioBD.getStatus() == Status.INATIVO){
			usuario.setLogin("");
			usuario.setSenha("");
			return  "login/login";
		}
		
		if(usuarioBD.getTipo().name() == "CLIENTE") {
			sessao.setAttribute("usuario", usuarioBD);
			map.addAttribute("usuarioBD", usuarioBD);
			return "cliente/indexCliente";
		} else if (usuarioBD.getTipo().name() == ("FUNCIONARIO")) {
			sessao.setAttribute("usuario", usuarioBD);
			map.addAttribute("usuarioBD", usuarioBD);
			return "funcionario/indexFuncionario";
		} else if(usuarioBD.getTipo().name() == "GERENTE") {
				sessao.setAttribute("usuario", usuarioBD);
				map.addAttribute("usuarioBD", usuarioBD);
				return "gerente/indexGerente";
		}
		

		return null;
		
	}
	
}
