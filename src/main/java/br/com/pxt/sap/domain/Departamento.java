package br.com.pxt.sap.domain;

public enum Departamento {

	TI(1, "TI"),
	CONTROLADORIA(2, "Controladoria"),
	JURIDICO(3, "Jurídico"),
	LOGISTICA(4, "Logística"),
	FINANCEIRO(5, "Financeiro"),
	RH(6, "RH"),
	COMERCIAL(7, "Comercial"),
	MANUTENCAO(8, "Manutenção"),
	ARMAZEM(9, "Armazém"),
	RESTAURANTE(10, "Restaurante"),
	DISKCENTER(11, "Disk Center"),
	CEDOC(12, "Cedoc"),
	DIRETORIA(13, "Diretoria");
	
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