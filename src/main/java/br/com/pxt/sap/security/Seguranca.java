package br.com.pxt.sap.security;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.pxt.sap.domain.Usuario;
import br.com.pxt.sap.repository.UsuarioRepository;

@Component
public class Seguranca implements Serializable {

	private static final long serialVersionUID = 8156174771107253600L;

	@Autowired private UsuarioRepository usuarioRepo;

	public Usuario getUsuarioLogado() {
		String idtlogin = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return usuarioRepo.findByIdentificacaoLogin(idtlogin); 
	}
	
}
