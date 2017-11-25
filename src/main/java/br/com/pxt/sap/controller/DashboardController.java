package br.com.pxt.sap.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.domain.Usuario;
import br.com.pxt.sap.repository.HostRepository;
import br.com.pxt.sap.service.UsuarioService;

@Controller
@RequestMapping(value="/home")
public class DashboardController {

	@Autowired private HostRepository hostRepo;
	@Autowired UsuarioService usuarioService;
	
	@GetMapping
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("pages/home/dashboard");
		mv.addObject("qtdTotalHosts", hostRepo.count());
		mv.addObject("qtdHostAtivo", hostRepo.qtdeHostAtivo());
		mv.addObject("qtdHostEmManutencao", hostRepo.qtdeHostEmManutencao());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Usuario usuarioLogado = usuarioService.findUsuarioByIdentificacaoLogin(auth.getName());
		mv.addObject("usuarioLogado", usuarioLogado);
		
		return mv;
	}
	
	@GetMapping(path = "/graficoDeptoHost")
	public @ResponseBody Collection<Host> popularGraficoDeptoHost() {
		return hostRepo.findAll();
	}
}