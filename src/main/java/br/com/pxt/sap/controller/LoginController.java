package br.com.pxt.sap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pxt.sap.domain.Usuario;
import br.com.pxt.sap.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired UsuarioService usuarioService;
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView mv = new ModelAndView("registration");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView novoUsuario(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView();
		Usuario usuarioExists = usuarioService.findUsuarioByIdentificacaoLogin(usuario.getIdentificacaoLogin());
		if (usuarioExists != null) {
			bindingResult
					.rejectValue("identificacaoLogin", "error.usuario",
							"Login informado já existe!");
		}
		if (bindingResult.hasErrors()) {
			mv.setViewName("registration");
		} else {
			usuarioService.save(usuario);
			mv.addObject("successMessage", "Usuário registrado com sucesso");
			mv.addObject("usuario", new Usuario());
			mv.setViewName("registration");
			
		}
		return mv;
	}
	
}
