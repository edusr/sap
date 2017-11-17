package br.com.pxt.sap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@Column(length = 9)
	@NotBlank
	private String hostname;

	@ManyToOne(targetEntity=TipoHost.class)
	@JoinColumn(name = "id_tiphost", referencedColumnName = "id")
	private TipoHost tipoHost;

	@ManyToOne(targetEntity=Departamento.class)
	@JoinColumn(name = "id_depto", referencedColumnName = "id")
	private Departamento departamento;

	@Column(name = "utilizador")
	private String utilizador;

	@Column(name = "mac", length = 17)
	@NotBlank
	private String enderecoMac;

	@ManyToOne(targetEntity=SistemaOperacional.class)
	@JoinColumn(name = "id_sisope", referencedColumnName = "id")
	private SistemaOperacional sistemaOperacional;

	@ManyToOne(targetEntity=ArquiteturaSO.class)
	@JoinColumn(name = "id_arquitetso", referencedColumnName = "id")
	private ArquiteturaSO arquiteturaSO;

	@Column(name = "chvlicso", length = 29)
	private String chaveLicenca;

	@OneToOne(targetEntity=MemoriaRam.class)
	private MemoriaRam memoriaRam;

	@OneToOne(targetEntity=Processador.class)
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

	public SistemaOperacional getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
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