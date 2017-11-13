package br.com.pxt.sap.domain;

public enum VersaoSO {

	WINDOWS_XP(1),
	WINDOWS_7_STARTER(2),
	WINDOWS_7_PROFESSIONAL(3),
	WINDOWS_7_HOME_BASIC(4),
	WINDOWS_7_HOME_PREMIUM(5),
	WINDOWS_7_ENTERPRISE(6),
	WINDOWS_7_ULTIMATE(7),
	WINDOWS_8(8),
	WINDOWS_8_1(9),
	WINDOWS_10(10),
	LINUX(11);
	
	public int valor;
	
	VersaoSO(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	@Override
	public String toString() {
		switch (this) {
			case WINDOWS_XP: return "Windows XP";
			case WINDOWS_7_STARTER: return "Windows 7 Starter";
			case WINDOWS_7_PROFESSIONAL: return "Windows 7 Professional";
			case WINDOWS_7_HOME_BASIC: return "Windows 7 Home Basic";
			case WINDOWS_7_HOME_PREMIUM: return "Windows 7 Home Premium";
			case WINDOWS_7_ENTERPRISE: return "Windows 7 Enterprise";
			case WINDOWS_7_ULTIMATE: return "Windows 7 Ultime";
			case WINDOWS_8: return "Windows 8";
			case WINDOWS_8_1: return "Windows 8.1";
			case WINDOWS_10: return "Windows 10";
			case LINUX: return "Linux";
			default:
				return "Versão desconhecida";
		}
		
	}
}
