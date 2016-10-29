package br.edu.utfpr.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.spring.mvc.model.Produto;

@Controller
public class IndexController {

	//@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping("/")
	public String home(Model model){
		model.addAttribute("valor",39.90);
		return "index";
	}
	@GetMapping("/concatenaNome/{nome}")
	public String concatenaNome(@PathVariable String nome, Model model){
		model.addAttribute("novoNome", nome+" Servidor");
		return "index";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto, Model model, 
			RedirectAttributes redirect){
		System.out.println("Salvando... "+produto.getNome());
		redirect.addFlashAttribute(produto);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
