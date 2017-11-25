package br.com.pxt.sap.service;

import br.com.pxt.sap.domain.Usuario;

public interface UsuarioService {

	public Usuario findUsuarioByIdentificacaoLogin(String identificacaoLogin);
	public void save(Usuario usuario);
}
