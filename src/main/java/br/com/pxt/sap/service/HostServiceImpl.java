package br.com.pxt.sap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.domain.StatusHost;
import br.com.pxt.sap.repository.HostRepository;

@Service
public class HostServiceImpl implements HostService {

	@Autowired private HostRepository hostRepo;
	
	@Transactional
	@Override
	public Host save(Host host) {
		host.setStatusHost(StatusHost.ATIVO);
		hostRepo.save(host);
		return host;
	}

	@Transactional
	@Override
	public Host remove(Long id) {
		Host hostRemovido = hostRepo.findOne(id);
		hostRepo.delete(id);
		return hostRemovido;
	}
	
	@Transactional
	@Override
	public Host remove(Host host) {
		hostRepo.delete(host);
		return host;
	}

	@Transactional
	@Override
	public void mudaStatusDoHostParaAtivo(Long id) {
		hostRepo.mudaStatusDoHostParaAtivo(id);
	}
	
	@Transactional
	@Override
	public void mudaStatusDoHostParaEmManutencao(Long id) {
		hostRepo.mudaStatusDoHostParaEmManutencao(id);
	}
	
	@Transactional
	@Override
	public Host buscaPorId(Long id) {
		return hostRepo.findOne(id);
	}
	
	@Transactional
	@Override
	public Host buscaPorHostname(String hostname) {
		return hostRepo.findByHostname(hostname);
	}
	
	@Transactional
	@Override
	public List<Host> findAll() {
		return hostRepo.findAll();
	}
	
}