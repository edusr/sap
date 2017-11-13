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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "thost")
public class Host implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2188198492264626916L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(length = 9)
	private String hostname;

	@Column(name = "tipo")
	@NotBlank
	@Enumerated(EnumType.STRING)
	private TipoHost tipoHost;

	@Column(name = "depto")
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Departamento departamento;

	@Column(name = "utilizador")
	private String utilizador;

	@Column(name = "mac", length = 17)
	@NotBlank
	private String enderecoMac;

	@Column(name = "vrssisoperacional")
	@Enumerated(EnumType.STRING)
	@NotBlank
	private VersaoSO versaoSO;

	@Column(name = "arquiteturaso")
	@NotBlank
	private ArquiteturaSO arquiteturaSO;

	@Column(name = "chvlicso", length = 29)
	private String chaveLicenca;

	@Column(name = "memram")
	@Enumerated(EnumType.STRING)
	@NotBlank
	private MemoriaRam memoriaRam;

	@NotBlank
	private Processador processador;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusHost statusHost;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public TipoHost getTipoHost() {
		return tipoHost;
	}

	public void setTipoHost(TipoHost tipoHost) {
		this.tipoHost = tipoHost;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(String utilizador) {
		this.utilizador = utilizador;
	}

	public String getEnderecoMac() {
		return enderecoMac;
	}

	public void setEnderecoMac(String enderecoMac) {
		this.enderecoMac = enderecoMac;
	}

	public VersaoSO getVersaoSO() {
		return versaoSO;
	}

	public void setVersaoSO(VersaoSO versaoSO) {
		this.versaoSO = versaoSO;
	}

	public ArquiteturaSO getArquiteturaSO() {
		return arquiteturaSO;
	}

	public void setArquiteturaSO(ArquiteturaSO arquiteturaSO) {
		this.arquiteturaSO = arquiteturaSO;
	}

	public String getChaveLicenca() {
		return chaveLicenca;
	}

	public void setChaveLicenca(String chaveLicenca) {
		this.chaveLicenca = chaveLicenca;
	}

	public MemoriaRam getMemoriaRam() {
		return memoriaRam;
	}

	public void setMemoriaRam(MemoriaRam memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public Processador getProcessador() {
		return processador;
	}

	public void setProcessador(Processador processador) {
		this.processador = processador;
	}

	public StatusHost getStatusHost() {
		return statusHost;
	}

	public void setStatusHost(StatusHost statusHost) {
		this.statusHost = statusHost;
	}

}