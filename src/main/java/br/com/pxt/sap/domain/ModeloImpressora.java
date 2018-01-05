package br.com.pxt.sap.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tmodeimpressora")
public class ModeloImpressora implements Serializable {

	private static final long serialVersionUID = 954211485604848804L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_marcaImp", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_modeloImpressoraMarca"))
	private MarcaImpressora marcaImpressora;
	private String modelo;
	@OneToMany(targetEntity = Impressora.class)
	private List<Impressora> impressora;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MarcaImpressora getMarcaImpressora() {
		return marcaImpressora;
	}

	public void setMarcaImpressora(MarcaImpressora marcaImpressora) {
		this.marcaImpressora = marcaImpressora;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Impressora> getImpressora() {
		return impressora;
	}

	public void setImpressora(List<Impressora> impressora) {
		this.impressora = impressora;
	}

}
