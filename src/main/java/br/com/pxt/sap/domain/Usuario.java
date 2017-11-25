package br.com.pxt.sap.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "tusuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3181797029803831924L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codusr")
	private Long id;
	@Column(name = "idtlogusr")
	@Length(min = 5, message = "*Favor informar um login com mais de 5 caracteres!")
	@NotEmpty(message = "*Favor informar um login")
	private String identificacaoLogin;
	@Column(name = "nomusr")
	@NotEmpty(message = "*Favor informar seu nome completo")
	private String nome;
	@Email(message = "*Favor informar um email válido!")
	@NotEmpty(message = "*Favor informar um email!")
	private String email;
	@Length(min = 7, message = "*Sua senha deve conter no mínimo 7 caracteres")
	@NotEmpty(message = "*Favor informar uma senha")
	@Transient
	private String senha;
	private String cargo;
	private boolean ativo;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tusuario_role", joinColumns = @JoinColumn(name = "codusr"), inverseJoinColumns = @JoinColumn(name = "codrole"))
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacaoLogin() {
		return identificacaoLogin;
	}

	public void setIdentificacaoLogin(String identificacaoLogin) {
		this.identificacaoLogin = identificacaoLogin;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
