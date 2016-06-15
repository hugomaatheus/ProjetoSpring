package br.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="logout")
@Controller
public class LogoutController {
	
	@RequestMapping(value="/")
	public String logout(HttpSession session, HttpServletRequest req) {
		
		session = req.getSession(false);
		
		
		if(!(session == null)) {
			session.removeAttribute("usuario");
			session.invalidate();
		}
		return "redirect:/";
		
	}

}
