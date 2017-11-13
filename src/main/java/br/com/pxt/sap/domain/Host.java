package br.com.pxt.sap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String hostname;
	@Column(name = "tpHost")
	private String tipoHost;
	@Column(name = "depto")
	private Departamento departamento;
	@Column(name = "usrResp")
	private String usuarioResponsavel;
	@Column(name = "mac", length = 17)
	private String enderecoMac;
	@Column(name = "sisoperacional")
	private SistemaOperacional sistemaOperacional;
	@Column(name = "status")
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

	public String getTipoHost() {
		return tipoHost;
	}

	public void setTipoHost(String tipoHost) {
		this.tipoHost = tipoHost;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getUsuarioResponsavel() {
		return usuarioResponsavel;
	}

	public void setUsuarioResponsavel(String usuarioResponsavel) {
		this.usuarioResponsavel = usuarioResponsavel;
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

	public StatusHost getStatusHost() {
		return statusHost;
	}

	public void setStatusHost(StatusHost statusHost) {
		this.statusHost = statusHost;
	}

}