package br.com.pxt.sap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pxt.sap.domain.Tonner;
import br.com.pxt.sap.repository.TonnerRepository;

@Service
public class TonnerServiceImpl implements TonnerService {

	@Autowired private TonnerRepository tonnerRepo;
	
	@Transactional
	@Override
	public Tonner save(Tonner tonner) {
		tonnerRepo.save(tonner);
		return tonner;
	}

}
