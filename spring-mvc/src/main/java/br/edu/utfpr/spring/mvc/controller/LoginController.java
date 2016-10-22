package br.edu.utfpr.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String login(@RequestParam(required=false) String error, Model model){
		if(error != null){
			model.addAttribute("erroLogin", "Usuário ou senha inválido");
		}
		return "login";
	}
}
