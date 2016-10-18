package br.edu.utfpr.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.spring.mvc.model.LabelValue;
import br.edu.utfpr.spring.mvc.model.TipoProduto;
import br.edu.utfpr.spring.mvc.repository.TipoProdutoRepository;

@RestController
@RequestMapping("/tipoProduto/rest")
public class TipoProdutoRestController {

	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@GetMapping("/{codigo}")
	public TipoProduto visualizar(@PathVariable Long codigo){
		return tipoProdutoRepository.findOne(codigo);
	}
	@GetMapping("/")
	public List<TipoProduto> todos(){
		return tipoProdutoRepository.findAll();
	}
	@DeleteMapping("/{codigo}")
	public void delete(@PathVariable Long codigo){
		tipoProdutoRepository.delete(codigo);
	}
	@PostMapping(path="/")
	public void inserir(@RequestBody TipoProduto tipoProduto){
		tipoProdutoRepository.save(tipoProduto);
	}
	
	@PutMapping(path="/")
	public void alterar(@RequestBody TipoProduto tipoProduto){
		tipoProdutoRepository.save(tipoProduto);
	}
	
	@GetMapping("/autocomplete")
	public List<LabelValue> autoComplete(@RequestParam("term") String term){
		return tipoProdutoRepository.findAutoComplete("%"+term+"%");
	}
	
	
	
	
}
