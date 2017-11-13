package br.com.pxt.sap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.Departamento;
import br.com.pxt.sap.domain.Host;
import br.com.pxt.sap.repository.HostRepository;

@Controller
@RequestMapping(value="/hosts")
public class HostController {

	@Autowired private HostRepository hostRepo;
	private List<Host> recemAdicionados = new ArrayList<>();

	@GetMapping(value="/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/consulta/hosts");
		mv.addObject("hosts", hostRepo.findAll());
		mv.addObject("departamentos", Departamento.values());
		return mv;
	}

	@GetMapping(value="/novo")
	public ModelAndView prepararFormulario() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novoHost");
		mv.addObject("host", new Host());
		mv.addObject("recemAdicionados", this.recemAdicionados);
		return mv;
	}

	@PostMapping(value="/salvar")
	public String prepararFormulario(@ModelAttribute("host") Host host) {
		hostRepo.save(host);
		return "redirect:/hosts/novo";
	}

	public List<Host> getRecemAdicionados() {
		return recemAdicionados;
	}

	public void setRecemAdicionados(List<Host> recemAdicionados) {
		this.recemAdicionados = recemAdicionados;
	}
}
