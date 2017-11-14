package br.com.pxt.sap.domain;

public enum Departamento {

	TI(0, "TI"),
	CONTROLADORIA(1, "Controladoria"),
	JURIDICO(2, "Jurídico"),
	LOGISTICA(3, "Logística"),
	FINANCEIRO(4, "Financeiro"),
	RH(5, "RH"),
	COMERCIAL(6, "Comercial"),
	MANUTENCAO(7, "Manutenção"),
	ARMAZEM(8, "Armazém"),
	RESTAURANTE(9, "Restaurante"),
	DISKCENTER(10, "Disk Center"),
	CEDOC(11, "Cedoc"),
	DIRETORIA(12, "Diretoria");
	
	public int valor;
	public String descricao;

	Departamento(int valor, String descricao) {
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