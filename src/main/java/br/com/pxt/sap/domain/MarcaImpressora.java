package br.com.pxt.sap.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tmarcaimpressora")
public class MarcaImpressora implements Serializable {

	private static final long serialVersionUID = 1672223534611539967L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	@OneToMany(targetEntity = ModeloImpressora.class)
	private List<ModeloImpressora> modeloImpressora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public List<ModeloImpressora> getModeloImpressora() {
		return modeloImpressora;
	}

	public void setModeloImpressora(List<ModeloImpressora> modeloImpressora) {
		this.modeloImpressora = modeloImpressora;
	}

}
