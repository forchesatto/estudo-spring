package br.com.camtwo.spring.boot.microservice.produto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.camtwo.spring.boot.microservice.produto.model.TipoProduto;
import br.com.camtwo.spring.boot.microservice.produto.repository.TipoProdutoRepository;

@RestController
@RequestMapping("/tipoProduto")
public class TipoProdutoRest {

	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@GetMapping("/{codigo}")
	public TipoProduto visualizar(@PathVariable Long codigo){
		return tipoProdutoRepository.findOne(codigo);
		
//		TipoProduto tp = new TipoProduto();
//		tp.setNome("teste");
//		return tp;
	}
}
