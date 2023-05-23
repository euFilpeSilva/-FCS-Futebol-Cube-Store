package br.com.loja.fcs.domain.repository;

import br.com.loja.fcs.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query("SELECT u from Usuario u JOIN FETCH u.roles where username = :username ")
    Usuario findByUsernameFetchRoles(@Param("username") String username);
}



