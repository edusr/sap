package br.com.pxt.sap.domain;

public enum ArquiteturaSO {

	TRINTA_E_DOIS_BITS(1, "32 bits"),
	SESSENTA_E_QUATRO_BITS(2, "64 bits");
	
	public int valor;
	public String descricao;

	ArquiteturaSO(int valor, String descricao) {
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
