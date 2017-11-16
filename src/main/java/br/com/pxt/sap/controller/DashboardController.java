package br.com.pxt.sap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	
}