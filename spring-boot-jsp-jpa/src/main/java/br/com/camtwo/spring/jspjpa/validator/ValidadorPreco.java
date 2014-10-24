package br.com.camtwo.spring.jspjpa.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.camtwo.spring.jspjpa.domain.Produto;

public class ValidadorPreco implements Validator {

	@Override
	public boolean supports(Class<?> classProduto) {
		return Produto.class == classProduto;
	}

	@Override
	public void validate(Object objeto, Errors errors) {
		Produto produto = (Produto)objeto;
		
		ValidationUtils.rejectIfEmpty(errors, "valor", "obrigatorio");
		
		if(produto.getValor() != null && produto.getValor() > 1000){
			errors.rejectValue("valor", "muito.alto");
		}
	}
}
