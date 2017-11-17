package br.com.pxt.sap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tprocessador")
public class Processador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1405213350683896812L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descproc")
	private String descricaoProcessador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoProcessador() {
		return descricaoProcessador;
	}

	public void setDescricaoProcessador(String descricaoProcessador) {
		this.descricaoProcessador = descricaoProcessador;
	}

}