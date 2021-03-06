package br.com.pxt.sap.domain;

public enum StatusHost {

	ATIVO(1, "Ativo"),
	EM_MANUTENCAO(2, "Em manutenção");
	
	public int valor;
	public String descricao;

	StatusHost(int valor, String descricao) {
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
