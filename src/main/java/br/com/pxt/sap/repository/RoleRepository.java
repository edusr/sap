package br.com.pxt.sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pxt.sap.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRole(String role);
}
