package br.com.pxt.sap.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="timpressora")
public class Impressora implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6630936221771985984L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String modelo;
	private String ip;
	@ElementCollection(targetClass = Departamento.class) 
	@CollectionTable(name = "timpdepto",
	    joinColumns = @JoinColumn(name = "id_imp"))
	@Column(name = "id_depto")
	private Set<Departamento> departamento;
	private Tonner Tonner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Set<Departamento> getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Set<Departamento> departamento) {
		this.departamento = departamento;
	}

	public Tonner getTonner() {
		return Tonner;
	}

	public void setTonner(Tonner tonner) {
		Tonner = tonner;
	}

}