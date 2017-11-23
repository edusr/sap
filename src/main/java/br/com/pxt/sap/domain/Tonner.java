package br.com.pxt.sap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ttonner")
public class Tonner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3837988628948706597L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	@Column(name="qtdeTotal")
	private Integer quantidadeTotal;
	@Column(name="qtdeCheio")
	private Integer quantidadeCheio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(Integer quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public Integer getQuantidadeCheio() {
		return quantidadeCheio;
	}

	public void setQuantidadeCheio(Integer quantidadeCheio) {
		this.quantidadeCheio = quantidadeCheio;
	}
}
