package br.com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import br.com.util.Tipo;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	private String message;
	
	@RequestMapping(value={"/", "/login"}, method=RequestMethod.GET)
	public String form(ModelMap map, HttpSession sessao){
		
		Usuario usuer = (Usuario) sessao.getAttribute("usuario");
		
				if(usuer != null){
					if(usuer.getTipo().name() == "CLIENTE") {
						sessao.setAttribute("usuario", usuer);
						map.addAttribute("usuarioBD", usuer);
						return "cliente/indexCliente";
					} else if (usuer.getTipo().name() == "FUNCIONARIO") {
						sessao.setAttribute("usuario", usuer);
						map.addAttribute("usuarioBD", usuer);
						return "funcionario/indexFuncionario";
					} else if(usuer.getTipo().name() == "GERENTE") {
							sessao.setAttribute("usuario", usuer);
							map.addAttribute("usuarioBD", usuer);
							return "gerente/indexGerente";
					}
				}else{
					Usuario usuario = new Usuario();
					map.addAttribute("usuario", usuario);
				}
				return "login/login";
		}
	
	@RequestMapping(value="logar", method=RequestMethod.POST)
	public String logar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result,HttpSession sessao, ModelMap map){
		if(result.hasErrors()){	
			System.out.println(result.getAllErrors());
			map.addAttribute("usuario", usuario);
			return  "login/login";
		}
		
		Usuario usuarioBD = usuarioService.logar(usuario.getLogin(), usuario.getSenha());
		
		if(usuarioBD == null){
			usuario.setSenha("");
			System.out.println("usuarioBD null" + usuarioBD);
			map.addAttribute("usuario", usuarioBD);
			return  "login/login";
		}

		if(usuarioBD.getStatus() == Status.INATIVO){
			usuario.setLogin("");
			usuario.setSenha("");
			if(usuarioBD.getTipo() == Tipo.CLIENTE) {
				message = "Ops! Parece que voc� desativou sua conta :# ";
				map.addAttribute("message", message);
			}
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
