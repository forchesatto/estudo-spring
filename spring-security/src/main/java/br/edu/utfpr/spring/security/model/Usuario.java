package br.edu.utfpr.spring.security.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity
public class Usuario implements UserDetails {

	private static final long serialVersionUID = -6814600362790849624L;
	
	private static final BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nome;
	
	private String username;
	private String password;
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Permissao> permissoes;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auto = new ArrayList<GrantedAuthority>();
		auto.addAll(getPermissoes());
		return auto;
	}
	
	public void addPermissao(Permissao permissao){
		if(permissoes == null){
			permissoes = new HashSet<Permissao>();
		}
		permissoes.add(permissao);
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario)){
			return false;
		}
		Usuario bean = (Usuario)obj;
		return new EqualsBuilder().append(bean.getUsername(), this.getUsername()).isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getUsername()).toHashCode();
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	public String getEncodePassword(String pass){
		if(StringUtils.isNotEmpty(pass)){
			return bcry.encode(pass);
		}
		return pass;
	}
}
