package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.HardDisk;
import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.domain.ModeloImpressora;
import br.com.pxt.sap.domain.Tonner;
import br.com.pxt.sap.repository.ArquiteturaSORepository;
import br.com.pxt.sap.repository.DepartamentoRepository;
import br.com.pxt.sap.repository.HostRepository;
import br.com.pxt.sap.repository.MarcaImpressoraRepository;
import br.com.pxt.sap.repository.MemoriaRamRepository;
import br.com.pxt.sap.repository.ModeloImpressoraRepository;
import br.com.pxt.sap.repository.ProcessadorRepository;
import br.com.pxt.sap.repository.SistemaOperacionalRepository;
import br.com.pxt.sap.repository.TipoHostRepository;
import br.com.pxt.sap.repository.TonnerRepository;
import br.com.pxt.sap.security.Seguranca;

@Controller
@RequestMapping(value="/novo")
public class CadastroController {

	@Autowired private HostRepository hostRepo;
	@Autowired private TipoHostRepository tipoHostRepo;
	@Autowired private ArquiteturaSORepository arquiteturaSORepo;
	@Autowired private DepartamentoRepository departamentoRepo;
	@Autowired private SistemaOperacionalRepository sistemaOperacionalRepo;
	@Autowired private MemoriaRamRepository memoriaRamRepo;
	@Autowired private ProcessadorRepository processadorRepo;
	@Autowired private MarcaImpressoraRepository marcaImpressoraRepo;
	@Autowired private ModeloImpressoraRepository modeloImpRepo;
	@Autowired private TonnerRepository tonnerRepo;
	@Autowired private Seguranca seguranca;
	
	@GetMapping
	public ModelAndView carregarObjetos() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novo");
		
		// Objetos para cadastro de Host
		mv.addObject("host", new Host());
		mv.addObject("hostsExistentes", hostRepo.findAll());
		mv.addObject("tphost", tipoHostRepo.findAll());
		mv.addObject("departamento", departamentoRepo.findAll());
		mv.addObject("arqso", arquiteturaSORepo.findAll());
		mv.addObject("sistemaOperacional", sistemaOperacionalRepo.findAll());
		mv.addObject("processador", processadorRepo.findAll());
		mv.addObject("ram", memoriaRamRepo.findAll());
		mv.addObject("hds", HardDisk.values());
		
		// Objetos para cadastro de Tonner
		mv.addObject("tonner", new Tonner());
		
		// Objetos para cadastro de impressora
		mv.addObject("impressora", new Impressora());
		mv.addObject("departamento", departamentoRepo.findAll());
		mv.addObject("modelosImp", modeloImpRepo.findAll());
		mv.addObject("tonners", tonnerRepo.findAll());
		
		// Objeto para cadastro de modelo de impressora
		mv.addObject("modimp", new ModeloImpressora());
		mv.addObject("marcasImp", marcaImpressoraRepo.findAll());
		
		// adiciona usuarioLogado
		mv.addObject("usuarioLogado", seguranca.getUsuarioLogado());
		
		return mv;
	}
}
