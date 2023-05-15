package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.ennum.RoleName;
import br.com.loja.fcs.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNomeRole(RoleName nomeRole);
}

