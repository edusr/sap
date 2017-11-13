package br.com.pxt.sap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tsisoperacional")
public class SistemaOperacional implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3875164390959869105L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "versao")
	@Enumerated(EnumType.STRING)
	private VersaoSO versaoSO;
	private String arquitetura;
	@Column(name = "chvlicenca", length = 29)
	private String chaveLicenca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VersaoSO getVersaoSO() {
		return versaoSO;
	}

	public void setVersaoSO(VersaoSO versaoSO) {
		this.versaoSO = versaoSO;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public String getChaveLicenca() {
		return chaveLicenca;
	}

	public void setChaveLicenca(String chaveLicenca) {
		this.chaveLicenca = chaveLicenca;
	}

}