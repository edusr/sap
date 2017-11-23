package br.com.pxt.sap.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.repository.HostRepository;

@Controller
@RequestMapping(value="/")
public class DashboardController {

	@Autowired private HostRepository hostRepo;
	
	@GetMapping
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("qtdTotalHosts", hostRepo.count());
		mv.addObject("qtdHostAtivo", hostRepo.qtdeHostAtivo());
		mv.addObject("qtdHostEmManutencao", hostRepo.qtdeHostEmManutencao());
		return mv;
	}
	
	@GetMapping(path = "/graficoDeptoHost")
	public @ResponseBody Collection<Host> popularGraficoDeptoHost() {
		return hostRepo.findAll();
	}
}