package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.HardDisk;
import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.repository.ArquiteturaSORepository;
import br.com.pxt.sap.repository.DepartamentoRepository;
import br.com.pxt.sap.repository.MemoriaRamRepository;
import br.com.pxt.sap.repository.ProcessadorRepository;
import br.com.pxt.sap.repository.SistemaOperacionalRepository;
import br.com.pxt.sap.repository.TipoHostRepository;
import br.com.pxt.sap.service.HostServiceImpl;

@Controller
@RequestMapping(value="/host")
public class HostController {

	@Autowired private HostServiceImpl hostService;
	@Autowired private TipoHostRepository tipoHostRepo;
	@Autowired private ArquiteturaSORepository arquiteturaSORepo;
	@Autowired private DepartamentoRepository departamentoRepo;
	@Autowired private SistemaOperacionalRepository sistemaOperacionalRepo;
	@Autowired private MemoriaRamRepository memoriaRamRepo;
	@Autowired private ProcessadorRepository processadorRepo;

	@GetMapping(value="/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/host/listHost");
		mv.addObject("hosts", hostService.findAll());
		return mv;
	}

	@PostMapping(value="/salvar")
	public String prepararFormulario(@ModelAttribute("host") Host host) {
		hostService.save(host);
		return "redirect:/novo";
	}
	
	@GetMapping(value="/editar/{hostname}")
	public ModelAndView editarHost(@PathVariable("hostname") String hostname) {
		ModelAndView mv = new ModelAndView("pages/host/editarHost");
		
		mv.addObject("host", hostService.buscaPorHostname(hostname));
		mv.addObject("tphost", tipoHostRepo.findAll());
		mv.addObject("departamento", departamentoRepo.findAll());
		mv.addObject("arqso", arquiteturaSORepo.findAll());
		mv.addObject("sistemaOperacional", sistemaOperacionalRepo.findAll());
		mv.addObject("processador", processadorRepo.findAll());
		mv.addObject("ram", memoriaRamRepo.findAll());
		mv.addObject("hds", HardDisk.values());
		
		return mv;
	}
	
	@PostMapping(value="/editar/salvarEdicao")
	public void salvarHostEditado(@ModelAttribute("host") Host host) {
		
	}
}