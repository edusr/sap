package br.com.pxt.sap.domain;

public enum Departamento {

	TI(1),
	CONTROLADORIA(2),
	JURIDICO(3),
	LOGISTICA(4),
	FINANCEIRO(5),
	RH(6),
	COMERCIAL(7),
	MANUTENCAO(8),
	ARMAZEM(9),
	RESTAURANTE(10),
	DISKCENTER(11),
	CEDOC(12);
	
	
	public int valor;

	Departamento(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		switch (this) {
			case TI: return "TI";
			case CONTROLADORIA: return "Controladoria";
			case JURIDICO: return "Jurídico";
			case LOGISTICA: return "Logística";
			case FINANCEIRO: return "Financeiro";
			case RH: return "RH";
			case COMERCIAL: return "Comercial";
			case MANUTENCAO: return "Manutenção";
			case ARMAZEM: return "Armazém";
			case RESTAURANTE: return "Restaurante";
			case DISKCENTER: return "Disk Center";
			case CEDOC: return "Cedoc";
			
			default:
				return "Setor não informado";
		}
	}
}