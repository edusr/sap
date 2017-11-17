package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.domain.StatusHost;
import br.com.pxt.sap.repository.HostRepository;

@Controller
@RequestMapping(value="/host")
public class HostController {

	@Autowired private HostRepository hostRepo;

	@GetMapping(value="/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/host/listHost");
		mv.addObject("hosts", hostRepo.findAll());
		return mv;
	}

	// Substituido pelo novo cadastro direcioando pelo CadastroController
/*	@GetMapping(value="/novo")
	public ModelAndView prepararFormulario() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novoHost");
		mv.addObject("host", new Host());
		mv.addObject("tphost", TipoHost.values());
		mv.addObject("departamento", Departamento.values());
		mv.addObject("arqso", ArquiteturaSO.values());
		mv.addObject("versao", VersaoSO.values());
		mv.addObject("processador", Processador.values());
		mv.addObject("ram", MemoriaRam.values());
		
		return mv;
	}*/

	@Transactional
	@PostMapping(value="/salvar")
	public String prepararFormulario(@ModelAttribute("host") Host host) {
		host.setStatusHost(StatusHost.ATIVO);
		hostRepo.save(host);
		return "redirect:/novo";
	}
	
}