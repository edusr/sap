package br.com.pxt.sap.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarquiteturaso")
public class ArquiteturaSO implements Serializable {

	private static final long serialVersionUID = -4714730943878524881L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "descarquitt")
	private String descricaoArquitetura;
	@OneToMany(targetEntity=Host.class, mappedBy="arquiteturaSO")
	private List<Host> host;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoArquitetura() {
		return descricaoArquitetura;
	}

	public void setDescricaoArquitetura(String descricaoArquitetura) {
		this.descricaoArquitetura = descricaoArquitetura;
	}

	public List<Host> getHost() {
		return host;
	}

	public void setHost(List<Host> host) {
		this.host = host;
	}

}
