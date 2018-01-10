package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pxt.sap.domain.Tonner;
import br.com.pxt.sap.repository.TonnerRepository;
import br.com.pxt.sap.security.Seguranca;
import br.com.pxt.sap.service.TonnerServiceImpl;

@Controller
@RequestMapping(value="/tonner")
public class TonnerController {

	@Autowired private TonnerRepository tonnerRepo;
	@Autowired private TonnerServiceImpl tonnerService;
	@Autowired private Seguranca seguranca;
	
	@GetMapping(value="/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/tonner/listTonner");
		mv.addObject("tonners", tonnerRepo.findAll());
		
		// adiciona usuarioLogado
		mv.addObject("usuarioLogado", seguranca.getUsuarioLogado());
		
		return mv;
	}
	
	@PostMapping(value="/salvar")
	public ModelAndView prepararFormulario(Tonner tonner, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/novo");
		
		tonnerService.save(tonner);
		
		attributes.addFlashAttribute("mensagem", "Tonner salvo com sucesso");
		
		return mv;
	}
}