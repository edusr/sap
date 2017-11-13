package br.com.pxt.sap.domain;

public enum StatusHost {

	ATIVO(1),
	EM_MANUTENCAO(2);
	
	public int valor;
	
	StatusHost(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		switch (this) {
			case ATIVO: return "Ativo";
			case EM_MANUTENCAO: return "Em manutenção";
				
			default:
				return "Ativo";
		}
	}
}
