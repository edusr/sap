package br.com.pxt.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pxt.sap.domain.Host;

public interface HostRepository extends JpaRepository<Host, Long>{

	Host findByHostname(String hostname);
	
	@Query("select count(h) from Host h where h.statusHost = 'ATIVO'")
	Long qtdeHostAtivo();
	
	@Query("select count(h) from Host h where h.statusHost = 'EM_MANUTENCAO'")
	Long qtdeHostEmManutencao();
	
	@Query("update Host h set h.statusHost = 'ATIVO' where h.id = ?1")
	void mudaStatusDoHostParaAtivo(Long id);
	
	@Query("update Host h set h.statusHost = 'EM_MANUTENCAO' where h.id = ?1")
	void mudaStatusDoHostParaEmManutencao(Long id);
}