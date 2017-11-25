package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.domain.ModeloImpressora;
import br.com.pxt.sap.repository.ImpressoraRepository;
import br.com.pxt.sap.repository.ModeloImpressoraRepository;

@Controller
@RequestMapping(value="/impressora")
public class ImpressoraController {

	@Autowired private ImpressoraRepository impRepo;
	@Autowired private ModeloImpressoraRepository modeloImpRepo;
	
	@PostMapping(value="/salvar")
	public String salvar(@ModelAttribute("impressora") Impressora imp) { 
		impRepo.save(imp);
		return "redirect:/novo";
	}

	@PostMapping(value="/modelo/salvar")
	public String salvarModelo(@ModelAttribute("modimp") ModeloImpressora modeloImpressora) { 
		modeloImpRepo.save(modeloImpressora);
		return "redirect:/novo";
	}

}
