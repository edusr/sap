package br.com.pxt.sap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pxt.sap.domain.Role;
import br.com.pxt.sap.domain.Usuario;
import br.com.pxt.sap.repository.RoleRepository;
import br.com.pxt.sap.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired private UsuarioRepository usuarioRepo;
	@Autowired private RoleRepository roleRepo;
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public Usuario findUsuarioByIdentificacaoLogin(String identificacaoLogin) {
		return usuarioRepo.findByIdentificacaoLogin(identificacaoLogin);
	}

	@Override
	public void save(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuario.setAtivo(true);
		Role usrole = roleRepo.findByRole("CONSULTA");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(usrole)));
		usuarioRepo.save(usuario);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String identificacaoLogin) throws UsernameNotFoundException {
		Usuario user = usuarioRepo.findByIdentificacaoLogin(identificacaoLogin);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getIdentificacaoLogin(), user.getSenha(), user.isAtivo(), true, true, true, authorities);
	}
}
