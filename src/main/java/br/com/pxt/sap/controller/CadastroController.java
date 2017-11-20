package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.HardDisk;
import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.repository.ArquiteturaSORepository;
import br.com.pxt.sap.repository.DepartamentoRepository;
import br.com.pxt.sap.repository.MemoriaRamRepository;
import br.com.pxt.sap.repository.ProcessadorRepository;
import br.com.pxt.sap.repository.SistemaOperacionalRepository;
import br.com.pxt.sap.repository.TipoHostRepository;

@Controller
@RequestMapping(value="/novo")
public class CadastroController {

	@Autowired private TipoHostRepository tipoHostRepo;
	@Autowired private ArquiteturaSORepository arquiteturaSORepo;
	@Autowired private DepartamentoRepository departamentoRepo;
	@Autowired private SistemaOperacionalRepository sistemaOperacionalRepo;
	@Autowired private MemoriaRamRepository memoriaRamRepo;
	@Autowired private ProcessadorRepository processadorRepo;
	
	@GetMapping
	public ModelAndView carregarObjetos() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novo");
		
		// Objetos para cadastro de Host
		mv.addObject("host", new Host());
		mv.addObject("tphost", tipoHostRepo.findAll());
		mv.addObject("departamento", departamentoRepo.findAll());
		mv.addObject("arqso", arquiteturaSORepo.findAll());
		mv.addObject("sistemaOperacional", sistemaOperacionalRepo.findAll());
		mv.addObject("processador", processadorRepo.findAll());
		mv.addObject("ram", memoriaRamRepo.findAll());
		mv.addObject("hds", HardDisk.values());
		
		// Objetos para cadastro de impressora
		mv.addObject("impressora", new Impressora());
		mv.addObject("departamento", departamentoRepo.findAll());
		
		
		return mv;
	}
}
