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
	private String ip;
	@ManyToOne
	@JoinColumn(name = "id_modeloImp", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_impressoraModelo"))
	private ModeloImpressora modeloImpressora;
	@OneToMany(targetEntity=Departamento.class)
	private List<Departamento> departamento;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public ModeloImpressora getModeloImpressora() {
		return modeloImpressora;
	}

	public void setModeloImpressora(ModeloImpressora modeloImpressora) {
		this.modeloImpressora = modeloImpressora;
	}

	public List<Departamento> getDepartamento() {
		return departamento;
	}

	public void setDepartamento(List<Departamento> departamento) {
		this.departamento = departamento;
	}

}