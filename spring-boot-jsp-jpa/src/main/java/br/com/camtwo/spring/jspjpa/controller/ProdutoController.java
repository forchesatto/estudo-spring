package br.com.camtwo.spring.jspjpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.camtwo.spring.jspjpa.domain.Produto;
import br.com.camtwo.spring.jspjpa.repository.ProdutoRepository;
import br.com.camtwo.spring.jspjpa.validator.ValidadorPreco;

@Controller
@RequestMapping(value ="/produto")
public class ProdutoController {

	private ProdutoRepository produtoRepository;

	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new ValidadorPreco());
    }
	
	@Autowired
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@RequestMapping(value ="/", method=RequestMethod.POST)
	public String salvar(@Valid Produto produto, BindingResult erros, Model model, 
			RedirectAttributes redirect){
		if(erros.hasErrors()){
			return "produto/form";
		}
		redirect.addFlashAttribute("mensagem", "Registro salvo com sucesso");
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
