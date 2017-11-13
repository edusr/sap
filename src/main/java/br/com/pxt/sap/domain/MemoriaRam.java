package br.com.pxt.sap.domain;

public enum MemoriaRam {

	DOIS(1, "2 GB"),
	QUATRO(2, "4 GB"),
	SEIS(3, "6 GB"),
	OITO(4, "8 GB"),
	DOZE(5, "12 GB"),
	DEZESSEIS(6, "16 GB");
	
	public int valor;
	public String descricao;

	MemoriaRam(int valor, String descricao) {
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