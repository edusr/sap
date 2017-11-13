package br.com.pxt.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pxt.sap.domain.Host;

public interface HostRepository extends JpaRepository<Host, Long>{

	Host findByHostname(String hostname);
}
