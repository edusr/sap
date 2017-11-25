package br.com.pxt.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pxt.sap.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByIdentificacaoLogin(String identificacaoLogin);
}
