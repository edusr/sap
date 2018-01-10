package br.com.pxt.sap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.domain.ModeloImpressora;
import br.com.pxt.sap.repository.DepartamentoRepository;
import br.com.pxt.sap.repository.ImpressoraRepository;
import br.com.pxt.sap.repository.ModeloImpressoraRepository;
import br.com.pxt.sap.repository.TonnerRepository;
import br.com.pxt.sap.security.Seguranca;

@Controller
@RequestMapping(value="/impressora")
public class ImpressoraController {

	@Autowired private ImpressoraRepository impRepo;
	@Autowired private ModeloImpressoraRepository modeloImpRepo;
	@Autowired private DepartamentoRepository departamentoRepo;
	@Autowired private TonnerRepository tonnerRepo;
	@Autowired private Seguranca seguranca;
	
	@GetMapping(value = "/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/impressora/listImpressora");
		
		List<Impressora> impressoras = impRepo.findAll();
		
		mv.addObject("usuarioLogado", seguranca.getUsuarioLogado());
		
		mv.addObject("impressoras", impressoras);
		mv.addObject("modelImp", modeloImpRepo.findAll());
		mv.addObject("tonner", tonnerRepo.findAll());
		mv.addObject("impressoraSelecionada", impressoras.get(0));
		
		return mv;
	}
	
	@GetMapping(value = "/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Impressora imp) {
		ModelAndView mv = new ModelAndView("pages/impressora/editarImpressora");
		
		// adiciona usuarioLogado
		mv.addObject("usuarioLogado", seguranca.getUsuarioLogado());
		
		mv.addObject("impressora", imp);
		mv.addObject("departamentos", departamentoRepo.findAll());
		mv.addObject("modelosImp", modeloImpRepo.findAll());
		mv.addObject("tonners", tonnerRepo.findAll());
		
		return mv;
	}
	
	@PostMapping(value="/salvar")
	public ModelAndView salvar(Impressora imp, RedirectAttributes attributes) { 
		ModelAndView mv = new ModelAndView("redirect:/novo");
		
		impRepo.save(imp);

		attributes.addFlashAttribute("mensagem", "Impressora salva com sucesso.");
		
		return mv;
	}

	@PostMapping(value="/editar/salvarEdicao")
	public String salvarHostEditado(@ModelAttribute("impressora") Impressora impressora, RedirectAttributes attributes) {
		impRepo.save(impressora);
		attributes.addFlashAttribute("mensagem", "Impressora atualizada com sucesso.");
		return "redirect:/impressora/editar/" + impressora.getId();
	}
	
	@GetMapping(value = "/excluir/{id}")
	public String exlcuir(@PathVariable("id") Impressora imp) {
		impRepo.delete(imp);
		return "redirect:/impressora/consulta";
	}
	
	@PostMapping(value="/modelo/salvar")
	public ModelAndView salvarModelo(ModeloImpressora modeloImpressora, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/novo");
		
		modeloImpRepo.save(modeloImpressora);
		
		attributes.addFlashAttribute("mensagem", "Modelo de impressora salvo com sucesso.");
		
		return mv;
	}

}
