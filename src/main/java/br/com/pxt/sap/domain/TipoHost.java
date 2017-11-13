package br.com.pxt.sap.domain;

public enum TipoHost {

	DESKTOP(1, "Desktop"),
	NOTEBOOK(2, "Notebook"),
	ALL_IN_ONE(3, "All in One");
	
	public int valor;
	public String descricao;

	TipoHost(int valor, String descricao) {
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
