package br.edu.utfpr.spring.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;

@Entity
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
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Permissao)){
			return false;
		}
		Permissao bean = (Permissao)obj;
		return new EqualsBuilder().append(bean.getPermissao(), this.getPermissao()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getPermissao()).toHashCode();
	}
	
}
