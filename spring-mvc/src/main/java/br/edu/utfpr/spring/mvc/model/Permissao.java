package br.edu.utfpr.spring.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@EqualsAndHashCode(of="permissao")
@Getter
@Setter
public class Permissao implements GrantedAuthority {

	private static final long serialVersionUID = 7293312633753924402L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codigo;
	@Column(length=50, nullable=false)
	private String permissao;
	
	@Override
	public String getAuthority() {
		return getPermissao();
	}
}
