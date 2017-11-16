package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.ArquiteturaSO;
import br.com.pxt.sap.domain.Departamento;
import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.domain.Impressora;
import br.com.pxt.sap.domain.MemoriaRam;
import br.com.pxt.sap.domain.Processador;
import br.com.pxt.sap.domain.VersaoSO;
import br.com.pxt.sap.repository.TipoHostRepository;

@Controller
@RequestMapping(value="/novo")
public class CadastroController {

	@Autowired private TipoHostRepository tipoHostRepo;
	
	@GetMapping
	public ModelAndView carregarObjetos() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novo");
		
		// Objetos para cadastro de Host
		mv.addObject("host", new Host());
		mv.addObject("tphost", tipoHostRepo.findAll());
		mv.addObject("departamento", Departamento.values());
		mv.addObject("arqso", ArquiteturaSO.values());
		mv.addObject("versao", VersaoSO.values());
		mv.addObject("processador", Processador.values());
		mv.addObject("ram", MemoriaRam.values());
		
		// Objetos para cadastro de impressora
		mv.addObject("impressora", new Impressora());
		mv.addObject("departamento", Departamento.values());
		
		
		return mv;
	}
}
