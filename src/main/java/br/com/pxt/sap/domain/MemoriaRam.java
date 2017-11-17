package br.com.pxt.sap.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tmemram")
public class MemoriaRam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1895156977522700185L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "ram")
	private String memRam;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemRam() {
		return memRam;
	}

	public void setMemRam(String memRam) {
		this.memRam = memRam;
	}

}
