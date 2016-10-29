package br.edu.utfpr.spring.mvc.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.spring.mvc.model.Produto;
import br.edu.utfpr.spring.mvc.model.Usuario;
import br.edu.utfpr.spring.mvc.repository.ProdutoRepository;
import br.edu.utfpr.spring.mvc.repository.TipoProdutoRepository;
import br.edu.utfpr.spring.mvc.seguranca.UsuarioLogado;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@Autowired
	private UsuarioLogado usuarioLogado;
	
	
	@GetMapping("/")
	public String lista(Model model){
		List<Produto> produtos = produtoRepository.findAllEager();
		model.addAttribute("produtos",produtos);
		usuarioLogado.get().ifPresent(usuario->{
			model.addAttribute("nomeUsuario", usuario.getNome());
		});
		return "/produto/lista";
	}
	
	@GetMapping("/pesquisa/{nome}")
	public String filtraPorNome(@PathVariable String nome, Model model){
		List<Produto> produtos = produtoRepository.findByNome(nome);
		model.addAttribute("produtos",produtos);
		return "/produto/lista";
	}
	
	@PostMapping("/")
	public String salvar(@Valid Produto produto, BindingResult erros,
			Model model){
		if(erros.hasErrors()){
			return "/produto/novo";	
		}
		produtoRepository.save(produto);
		return "redirect:/produto/";
	}
	
	@GetMapping("/novo")
	public String novo(Model model){
		model.addAttribute("tiposProdutos", tipoProdutoRepository.findAll());
		return "/produto/novo";
	}
	
	@GetMapping("/{codigo}")
	public String visualizar(@PathVariable Long codigo, Model model){
		Produto produto = produtoRepository.findOne(codigo);
		model.addAttribute("produto",produto);
		model.addAttribute("tiposProdutos", tipoProdutoRepository.findAll());
		return "/produto/novo";
	}
	
	@GetMapping("/{codigo}/delete")
	public String delete(@PathVariable Long codigo){
		produtoRepository.delete(codigo);
		return "redirect:/produto/";
	}
	
}










