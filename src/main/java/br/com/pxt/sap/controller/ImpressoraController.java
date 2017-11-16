package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.repository.ImpressoraRepository;

@Controller
@RequestMapping(value="/impressora")
public class ImpressoraController {

	@Autowired private ImpressoraRepository impRepo;
	
	// Substituido pelo novo cadastro direcioando pelo CadastroController
/*	@GetMapping(value="/novo")
	public ModelAndView prepararFormulario() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novaImpressora");
		mv.addObject("impressora", new Impressora());
		mv.addObject("departamento", Departamento.values());
		return mv;
	}*/
	
	@PostMapping(value="/salvar")
	public String salvar(@ModelAttribute("impressora") Impressora imp) { 
		impRepo.save(imp);
		return "redirect:/impressora/novo";
	}
}
