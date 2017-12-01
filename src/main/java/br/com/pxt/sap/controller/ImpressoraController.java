package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.domain.ModeloImpressora;
import br.com.pxt.sap.repository.ImpressoraRepository;
import br.com.pxt.sap.repository.ModeloImpressoraRepository;
import br.com.pxt.sap.repository.TonnerRepository;
import br.com.pxt.sap.security.Seguranca;

@Controller
@RequestMapping(value="/impressora")
public class ImpressoraController {

	@Autowired private ImpressoraRepository impRepo;
	@Autowired private ModeloImpressoraRepository modeloImpRepo;
	@Autowired private TonnerRepository tonnerRepo;
	@Autowired private Seguranca seguranca;
	
	@GetMapping(value = "/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/impressora/listImpressora");
		
		mv.addObject("usuarioLogado", seguranca.getUsuarioLogado());
		
		mv.addObject("impressoras", impRepo.findAll());
		mv.addObject("modelImp", modeloImpRepo.findAll());
		mv.addObject("tonner", tonnerRepo.findAll());
		
		return mv;
	}
	
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
