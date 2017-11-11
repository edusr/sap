package br.com.pxt.sap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/")
public class DashboardController {

	@GetMapping
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
}