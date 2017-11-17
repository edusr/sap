package br.com.pxt.sap.domain;

public enum VersaoSO1 {

	WINDOWS_XP(1, "Windows XP"),
	WINDOWS_VISTA(2, "Windows XP"),
	WINDOWS_7_PROFESSIONAL(3, "Windows 7 Professional"),
	WINDOWS_8(4, "Windows 8"),
	WINDOWS_8_SINGLE_LANG(5, "Windows 8 Single Language"),
	WINDOWS_8_1(6, "Windows 8.1"),
	WINDOWS_8_1_SINGLE_LANG(7, "Windows 8.1 Single Language"),
	WINDOWS_10(8, "Windows 10"),
	WINDOWS_10_SINGLE_LANG(9, "Windows 10 Single Language"),
	LINUX(10, "Linux");
	
	public int valor;
	public String descricao;

	VersaoSO1(int valor, String descricao) {
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
