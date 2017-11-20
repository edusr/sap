package br.com.pxt.sap.service;

import java.util.List;

import br.com.pxt.sap.domain.Host;

public interface HostService {

	Host save(Host host);
	
	Host remove(Long id);
	
	Host remove(Host host);
	
	void mudaStatusDoHostParaAtivo(Long id);
	
	void mudaStatusDoHostParaEmManutencao(Long id);
	
	Host buscaPorId(Long id);
	
	Host buscaPorHostname(String hostname);
	
	List<Host> findAll();
	
}
