package br.com.camtwo.spring.jspjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.camtwo.spring.jspjpa.domain.Produto;
import br.com.camtwo.spring.jspjpa.repository.ProdutoRepository;

@Controller
@RequestMapping(value ="/produto")
public class ProdutoController {

	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@RequestMapping(value ="/", method=RequestMethod.POST)
	public String salvar(Produto produto){
		produtoRepository.save(produto);
		return "redirect:/produto/";
	}
	
	@RequestMapping(value ="/", method=RequestMethod.GET)
	public String lista(Model model){
		model.addAttribute("produtos", produtoRepository.findAll());
		return "/produto/lista";
	}
	
	@RequestMapping(value ="/novo", method=RequestMethod.GET)
	public String novo(Model model){
		return "/produto/form";
	}
	
	@RequestMapping(value ="/{codigo}", method=RequestMethod.GET)
	public String editar(@PathVariable Long codigo, Model model){
		model.addAttribute(produtoRepository.findOne(codigo));
		return "/produto/form";
	}
}
