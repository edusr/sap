package br.com.pxt.sap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/hosts")
public class HostController {

	@GetMapping(value="/consulta")
	public ModelAndView construirTabela() {
		ModelAndView mv = new ModelAndView("pages/consulta/hosts");
		return mv;
	}

	@GetMapping(value="/novo")
	public ModelAndView prepararFormulario() {
		ModelAndView mv = new ModelAndView("pages/cadastro/novoHost");
		return mv;
	}
}
