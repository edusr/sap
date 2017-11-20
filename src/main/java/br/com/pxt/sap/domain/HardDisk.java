package br.com.pxt.sap.domain;

public enum HardDisk {

	_320GB(1, "320 GB"),
	_500GB(2, "500 GB"),
	_1000GB(3, "1000 GB");
	
	public int valor;
	public String descricao;

	HardDisk(int valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}