package br.com.pxt.sap.domain;

public enum Processador {

	ATOM(1,"Atom"),
	CELERON(2,"Celeron"),
	PENTIUM_I(3,"Pentium I"),
	PENTIUM_II(4,"Pentium II"),
	PENTIUM_III(5,"Pentium III"),
	PENTIUM_IV(6,"Pentium IV"),
	DUO_CORE(7,"Duo Core"),
	QUAD_CORE(8,"Quad Core"),
	CORE_2_DUO(9,"Core 2 Duo"),
	CORE_2_QUAD(10,"Core 2 Quad"),
	CORE_I3(11,"Core i3"),
	CORE_I5(12,"Core i5"),
	CORE_I7(13,"Core i7");
	
	public int valor;
	public String descricao;

	Processador(int valor, String descricao) {
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